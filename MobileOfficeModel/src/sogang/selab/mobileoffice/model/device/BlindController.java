package sogang.selab.mobileoffice.model.device;

import sogang.selab.mobileoffice.model.Environment;
import sogang.selab.mobileoffice.model.MobileOffice;

public class BlindController extends Device {

	public BlindController(int xPos, int yPos) {
		super(xPos, yPos);
	}

	public void up(int duration) {

		final int UP_COST = 5;
		final double UP_TEMP_PERF = 0.2;
		final double UP_BRIGHT_PERF = 0.3;

		incrementCost(UP_COST);
		for(int i=0; i<this.length; i++) {
			for(int j=0; j<this.breadth; j++) {	
				int dist = distance(xPos, yPos, i, j);
				Environment env = MobileOffice.getBlock(i, j).env();
				env.changeTemperature(((UP_TEMP_PERF - dist) * discountRate) * duration);
				env.changeBrighteness(((UP_BRIGHT_PERF - dist) * discountRate) * duration);

			}
		}	

	}

	public void down() {
		
		final int DOWN_COST = 5;
		final double DOWN_TEMP_PERF = 0.3;
		
		incrementCost(DOWN_COST);
		for(int i=0; i<this.length; i++) {
			for(int j=0; j<this.breadth; j++) {	
				int dist = distance(xPos, yPos, i, j);
				Environment env = MobileOffice.getBlock(i, j).env();
				env.changeBrighteness(-1 * ((DOWN_TEMP_PERF - dist) * discountRate));
			}
		}	
	}
		

}
