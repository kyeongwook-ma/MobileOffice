package sogang.selab.mobileoffice.model.device;

import sogang.selab.mobileoffice.model.Environment;
import sogang.selab.mobileoffice.model.MobileOffice;

public class Light extends Device {
	
	
	public Light(int xPos, int yPos) {
		super(xPos, yPos);
	}
	
	public void on(int duration) {
		
		final int ON_COST = 20;
		final double ON_TEMP_PERF = 0.15;
		final double ON_BRIGHT_PERF = 0.3;
		
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
		final double OFF_BRIGHT_PERF = 0.3;
		for(int i=0; i<this.length; i++) {
			for(int j=0; j<this.breadth; j++) {	
				int dist = distance(xPos, yPos, i, j);
				Environment env = MobileOffice.getBlock(i, j).env();
				env.changeBrighteness(-1 * ((OFF_BRIGHT_PERF - dist) * discountRate));
			}
		}	
	}
	


}
