package sogang.selab.mobileoffice.model.device;

import sogang.selab.mobileoffice.model.Environment;
import sogang.selab.mobileoffice.model.MobileOffice;

public class Stand extends Device {

	public Stand(int xPos, int yPos) {
		super(xPos, yPos);
	}
	
	public void on(int duration) {

		final int ON_COST = 3;
		final double ON_TEMP_PERF = 0.1;
		final double ON_BRIGHT_PERF = 0.5;

		incrementCost(ON_COST);
		for(int i=0; i<this.length; i++) {
			for(int j=0; j<this.breadth; j++) {	
				int dist = distance(xPos, yPos, i, j);
				Environment env = MobileOffice.getBlock(i, j).env();
				env.changeTemperature(((ON_TEMP_PERF - dist) * discountRate) * duration);
				env.changeBrighteness(((ON_BRIGHT_PERF - dist) * discountRate) * duration);
			}
		}	

	}

	public void off() {
		final double OFF_BRIGHT_PERF = 0.5;
		for(int i=0; i<this.length; i++) {
			for(int j=0; j<this.breadth; j++) {	
				int dist = distance(xPos, yPos, i, j);
				Environment env = MobileOffice.getBlock(i, j).env();
				env.changeBrighteness(-1 * ((OFF_BRIGHT_PERF - dist) * discountRate));
			}
		}	
	}
	@Override
	public void notifyChange(int elapsedTime) {
		// TODO Auto-generated method stub

	}
}
