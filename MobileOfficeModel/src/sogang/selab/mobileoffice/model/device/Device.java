package sogang.selab.mobileoffice.model.device;

import sogang.selab.mobileoffice.model.MobileOffice;



public abstract class Device {
	
	protected int xPos, yPos, length, breadth;
	protected double performance;
	protected double discountRate;
	protected double cost;
	
	public Device(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		
		if(xPos > MobileOffice.row() || yPos > MobileOffice.col()) {
			try {
				throw new Exception("out of office row or col");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	void incrementCost(double cost) {
		this.cost += cost;
	}
	
	public double getCost() {
		return cost;
	}
	
	public int[] getPosition() {
		return new int[] { xPos, yPos };
	}
	
	int distance(int srcX, int srcY, int dstX, int dstY) {
		return java.lang.Math.max(
				java.lang.Math.abs(srcX - dstX), 
				java.lang.Math.abs(srcY - dstY));
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
	
}
