package sogang.selab.mobileoffice.model.device;

import sogang.selab.mobileoffice.model.Environment;
import sogang.selab.mobileoffice.model.MobileOffice;

public class Humidifier extends Device {

	public Humidifier(int xPos, int yPos) {
		super(xPos, yPos);
		// TODO Auto-generated constructor stub
	}
	public void on(int duration) {

		final int ON_COST = 6;
		final double ON_HUMID_PERF = 0.4;

		incrementCost(ON_COST);
		for(int i=0; i<this.length; i++) {
			for(int j=0; j<this.breadth; j++) {	
				int dist = distance(xPos, yPos, i, j);
				Environment env = MobileOffice.getBlock(i, j).env();
				env.changeTemperature(((ON_HUMID_PERF - dist) * discountRate) * duration);
			}
		}	

	}

	public void off() {
	
	}
}
