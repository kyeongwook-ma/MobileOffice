package sogang.selab.mobileoffice.model;

import java.util.ArrayList;

import sogang.selab.mobileoffice.model.convertor.IJsonConvertor;
import sogang.selab.mobileoffice.model.device.Device;

import com.google.gson.Gson;

public class OfficeBlock implements IJsonConvertor {

	private Environment env;
	private ArrayList<Device> devices = new ArrayList<Device>();
	private int xPos, yPos;

	private OfficeBlock(int xPos, int yPos, Environment env) {

		try {
			this.xPos = xPos;
			this.yPos = yPos;
			this.env = env;

			if(xPos > MobileOffice.row() || yPos > MobileOffice.col()) {
				throw new Exception("out of office row or col");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int x() {
		return xPos;
	}

	public int y() {
		return yPos;
	}

	public Environment env() {
		return env;
	}

	public void setEnvironment(Environment env) {
		this.env = env;
	}

	void addDevice(Device device) {
		devices.add(device);
	}

	void removeDevice(Device device) {
		devices.remove(device);
	}

	public <T> T getDevice(Class<T> t) {
		for(Device d : devices) {
			if(d.getClass().equals(t))
				return (T) d;
		}
		return null;
	}

	public static class OfficeBlockBuilder {

		private Environment env;
		private int xPos, yPos;

		public OfficeBlockBuilder() {
			this.env = new Environment();
		}

		public OfficeBlockBuilder xPos(int xPos) {
			this.xPos = xPos;
			return this;
		}

		public OfficeBlockBuilder yPos(int yPos) {
			this.yPos = yPos;
			return this;
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

		public OfficeBlock createOfficeBlock() {
			return new OfficeBlock(this.xPos, this.yPos, this.env);
		}
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(env.toString());

		sb.append("devices : \n");
		for(Device d : devices) {
			sb.append(d.toString());
		}

		return sb.toString();
	}

	@Override
	public String getJson() {
		return new Gson().toJson(this);
	}


}
