package sogang.selab.mobileoffice.model;

import com.google.gson.Gson;

import sogang.selab.mobileoffice.model.convertor.IJsonConvertor;

public class OfficeBlock implements IJsonConvertor {

	private Environment env;
	
	
	
	public Environment getEnv() {
		return env;
	}


	public void setEnv(Environment env) {
		this.env = env;
	}


	public static class OfficeBlockBuilder {
		
		private Environment env;
		private int xPos, yPos;
		
		public OfficeBlockBuilder(int xPos, int yPos) {
			this.xPos = xPos;
			this.yPos = yPos;
			this.env = new Environment();
		}
		
		public OfficeBlockBuilder temperature(double temperature) {
			this.env.setTemperature(temperature);
			return this;
		}
		
		public OfficeBlockBuilder humidity(double humidity) {
			this.env.setHumidity(humidity);
			return this;
		}
		
		public OfficeBlockBuilder brightness(double brightness) {
			this.env.setBrightness(brightness);
			return this;
		}
		
		public OfficeBlockBuilder hasWindow(boolean hasWindow) {
			this.env.setHasWindow(hasWindow);
			return this;
		}
		
		public OfficeBlockBuilder isOccupied(boolean isOccupied) {
			this.env.setOccupied(isOccupied);
			return this;
		}
		
		
		
		
		
		
		
	}


	@Override
	public String getJson() {
		return new Gson().toJson(this);
	}
	
	
	
}
