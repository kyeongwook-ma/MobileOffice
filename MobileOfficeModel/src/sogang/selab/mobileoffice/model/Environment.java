package sogang.selab.mobileoffice.model;

public class Environment {
	private int row, col;
	private boolean isOccupied, hasWindow;
	private double temperature, humidity, brightness;
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public boolean isOccupied() {
		return isOccupied;
	}
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	public boolean isHasWindow() {
		return hasWindow;
	}
	public void setHasWindow(boolean hasWindow) {
		this.hasWindow = hasWindow;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public double getBrightness() {
		return brightness;
	}
	public void setBrightness(double brightness) {
		this.brightness = brightness;
	}
	
}
