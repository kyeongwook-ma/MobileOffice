import sogang.selab.mobileoffice.model.MobileOffice;
import sogang.selab.mobileoffice.model.OfficeBlock;
import sogang.selab.mobileoffice.model.OfficeBlock.OfficeBlockBuilder;
import sogang.selab.mobileoffice.model.device.AirCon;


public class Test {

	public static void main(String[] args) {

		MobileOffice office = MobileOffice.createMobileOffice(4, 4);
		
		OfficeBlock block01 = new OfficeBlockBuilder()
				.brightness(3)
				.humidity(1)
				.createOfficeBlock();
		MobileOffice.setBlock(0, 0, block01);
		
		
		AirCon aircon = new AirCon(0, 0);
		
		AirCon airconInst = MobileOffice.getBlock(0, 0).getDevice(AirCon.class);
	}

}
