package sogang.selab.mobileoffice.model;

import java.util.ArrayList;

import sogang.selab.mobileoffice.model.convertor.IJsonConvertor;
import sogang.selab.mobileoffice.model.device.AirCon;
import sogang.selab.mobileoffice.model.device.Device;
import sogang.selab.mobileoffice.model.device.ISensing;

import com.google.gson.Gson;

public class OfficeBlock implements IJsonConvertor {

	private Environment env;
	private ArrayList<Device> devices = new ArrayList<Device>();

	private OfficeBlock( Environment env) {
		this.env = env;
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

		public OfficeBlockBuilder() {
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

		public OfficeBlock createOfficeBlock() {
			return new OfficeBlock(this.env);
		}
	}


	@Override
	public String getJson() {
		return new Gson().toJson(this);
	}


}
