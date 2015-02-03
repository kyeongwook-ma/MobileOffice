package sogang.selab.mobileoffice.model.device;

import sogang.selab.mobileoffice.model.Environment;
import sogang.selab.mobileoffice.model.MobileOffice;

public class AirCon extends Device {


	public AirCon(int xPos, int yPos) {
		super(xPos, yPos);
	}

	private final int DEHUMIDIFY_COST = 20;
	private final int WARM_COST = 30;
	private final int COOL_COST = 40;
	
	private final double HEATING_PERF = 0.4;
	private final double DRY_PERF = 0.5;
	private final double COOLING_PERF = 0.6;


	public void dehumidify(int duration) {
		incrementCost(DEHUMIDIFY_COST);
		for(int i=0; i<this.length; i++) {
			for(int j=0; j<this.breadth; j++) {	
				int dist = distance(xPos, yPos, i, j);
				Environment env = MobileOffice.getBlock(i, j).env();
				//env.changeTemperature(((HEATING_PERF - dist) * discountRate) * elapsedTime);
				//env.changeHumidity(((DRY_PERF - dist) * discountRate) * elapsedTime);
			}
		}
	}

	public void warm(int duration) {
		incrementCost(WARM_COST);
		for(int i=0; i<this.length; i++) {
			for(int j=0; j<this.breadth; j++) {	
				int dist = distance(xPos, yPos, i, j);
				Environment env = MobileOffice.getBlock(i, j).env();
				//env.changeTemperature(((heatingP - dist) * discountRate) * elapsedTime);
				//env.changeHumidity(((dryP - dist) * discountRate) * elapsedTime);
			}
		}
	}

	public void cool(int duration) {
		incrementCost(COOL_COST);
		for(int i=0; i<this.length; i++) {
			for(int j=0; j<this.breadth; j++) {	
				int dist = distance(xPos, yPos, i, j);
				Environment env = MobileOffice.getBlock(i, j).env();
				//env.changeTemperature(((heatingP - dist) * discountRate) * elapsedTime);
				//env.changeHumidity(((dryP - dist) * discountRate) * elapsedTime);
			}
		}
	}

	public void off() {

	}

	@Override
	public void notifyChange(int elapsedTime) {

	}
}
