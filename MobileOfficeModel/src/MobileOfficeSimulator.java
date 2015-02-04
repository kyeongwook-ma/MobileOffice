import sogang.selab.mobileoffice.model.MobileOffice;
import sogang.selab.mobileoffice.model.OfficeBlock;
import sogang.selab.mobileoffice.model.OfficeBlock.OfficeBlockBuilder;
import sogang.selab.mobileoffice.model.device.AirCon;


public class MobileOfficeSimulator {

	public static void main(String[] args) {
		

		/* create mobile office block 4 by 4 */
		MobileOffice.createOfficeBlock(4, 4);
		
		/* instantiate with environment */
		OfficeBlock block = new OfficeBlockBuilder()
				.xPos(0).yPos(0)
				.brightness(60)
				.humidity(55)
				.temperature(25)
				.createOfficeBlock();
	
		MobileOffice.assignBlock(block);
		
		MobileOffice.printCurrentState();
	
		/* instantiate device & assign to mobile office */
		AirCon aircon = new AirCon(0 , 0);
		MobileOffice.addDevice(aircon);
		
		/* operate device in duration time */
		aircon.cool(3);
	
		MobileOffice.printCurrentState();
		
		System.out.println(MobileOffice.getSerializedJson());
	}

}
