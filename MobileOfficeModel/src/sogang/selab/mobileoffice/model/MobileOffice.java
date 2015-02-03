package sogang.selab.mobileoffice.model;

import sogang.selab.mobileoffice.model.convertor.IJsonConvertor;

public class MobileOffice implements IJsonConvertor {

	private final int OFFICE_ROW = 4;
	private final int OFFICE_COL = 4;
	
	private OfficeBlock blocks[][] = 
			new OfficeBlock[OFFICE_ROW][OFFICE_COL];

	@Override
	public String getJson() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < OFFICE_ROW; ++i) {
			for(int j = 0; j < OFFICE_COL; ++j) {
				sb.append(blocks[i][j].getJson());
			}
		}

		return sb.toString();
	}
	
	
}
