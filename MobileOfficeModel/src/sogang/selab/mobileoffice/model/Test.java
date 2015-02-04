package sogang.selab.mobileoffice.model;

import sogang.selab.mobileoffice.model.OfficeBlock.OfficeBlockBuilder;
import sogang.selab.mobileoffice.model.device.AirCon;

public class Test {

	public static void main(String[] args) {
		
		MobileOffice.createOfficeBlock(4, 4);
		
		OfficeBlock ob = new OfficeBlockBuilder().xPos(0).yPos(3).
				brightness(3).createOfficeBlock();
		
		MobileOffice.assignBlock(ob);
		
		MobileOffice.addDevice(new AirCon(0, 3));
	}

}
