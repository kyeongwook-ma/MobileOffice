package sogang.selab.mobileoffice.model.device;

import sogang.selab.mobileoffice.model.MobileOffice;


public abstract class Device implements ISensing {
	protected int xPos, yPos, length, breadth;
	protected double performance;
	protected double discountRate;
	protected double cost;
	
	protected void incrementCost(double cost) {
		this.cost += cost;
	}
	
	public double getCost() {
		return cost;
	}
	
	public Device(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		MobileOffice.getBlock(xPos, yPos).addDevice(this);
	}
	
	
	protected int distance(int srcX, int srcY, int dstX, int dstY) {
		return java.lang.Math.max(
				java.lang.Math.abs(srcX - dstX), 
				java.lang.Math.abs(srcY - dstY));
	}
	
}
