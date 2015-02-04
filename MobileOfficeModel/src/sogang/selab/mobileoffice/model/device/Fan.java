package sogang.selab.mobileoffice.model.device;

import sogang.selab.mobileoffice.model.Environment;
import sogang.selab.mobileoffice.model.MobileOffice;

public class Fan extends Device {

	public Fan(int xPos, int yPos) {
		super(xPos, yPos);
	}

	public void on(int duration) {

		final int ON_COST = 3;
		final double ON_TEMP_PERF = 0.3;

		incrementCost(ON_COST);
		for(int i=0; i<this.length; i++) {
			for(int j=0; j<this.breadth; j++) {	
				int dist = distance(xPos, yPos, i, j);
				Environment env = MobileOffice.getBlock(i, j).env();
				env.changeTemperature(-1 * ((ON_TEMP_PERF - dist) * discountRate) * duration);
			}
		}	

	}

	public void off() {
		final double OFF_TEMP_PERF = 0.3;
		
		for(int i=0; i<this.length; i++) {
			for(int j=0; j<this.breadth; j++) {	
				int dist = distance(xPos, yPos, i, j);
				Environment env = MobileOffice.getBlock(i, j).env();
				env.changeBrightness(((OFF_TEMP_PERF - dist) * discountRate));
			}
		}	
	}
	
	
}
