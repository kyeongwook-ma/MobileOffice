package sogang.selab.mobileoffice.model.device;

import sogang.selab.mobileoffice.model.Environment;
import sogang.selab.mobileoffice.model.MobileOffice;

public class AirCon extends Device {

	public AirCon(int xPos, int yPos) {
		super(xPos, yPos);
	}

	public void dehumidify(int duration) {
		final int DEHUMIDIFY_COST = 20;
		final double DEHUMIDIFY_HUMID_PERF = 0.5;

		incrementCost(DEHUMIDIFY_COST);
		for(int i=0; i<this.length; i++) {
			for(int j=0; j<this.breadth; j++) {	
				int dist = distance(xPos, yPos, i, j);
				Environment env = MobileOffice.getBlock(i, j).env();
				env.changeHumidity(-1 * ((DEHUMIDIFY_HUMID_PERF - dist) * discountRate) * duration);
			}
		}
	}

	public void warm(int duration) {
		final int WARM_COST = 30;
		final double WARM_TEMP_PERF = 0.4;

		incrementCost(WARM_COST);
		for(int i=0; i<this.length; i++) {
			for(int j=0; j<this.breadth; j++) {	
				int dist = distance(xPos, yPos, i, j);
				Environment env = MobileOffice.getBlock(i, j).env();
				env.changeTemperature(((WARM_TEMP_PERF - dist) * discountRate) * duration);
			}
		}
	}

	public void cool(int duration) {
		final int COOL_COST = 40;
		final double COOL_TEMP_PERF = 0.6;

		incrementCost(COOL_COST);
		for(int i=0; i<this.length; i++) {
			for(int j=0; j<this.breadth; j++) {	
				int dist = distance(xPos, yPos, i, j);
				Environment env = MobileOffice.getBlock(i, j).env();
				env.changeTemperature(-1 * ((COOL_TEMP_PERF - dist) * discountRate) * duration);
			}
		}
	}

	public void off() {

	}

	@Override
	public void notifyChange(int elapsedTime) {

	}


}
