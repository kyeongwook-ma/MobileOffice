package sogang.selab.mobileoffice.model.device;



public abstract class Device implements ISensing {
	protected int xPos, yPos, length, breadth;
	protected double performance;
	protected double discountRate;
	protected double cost;
	
	public Device(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
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
	
}
