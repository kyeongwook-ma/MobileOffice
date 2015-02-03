package sogang.selab.mobileoffice.model;

import sogang.selab.mobileoffice.model.convertor.IJsonConvertor;

public class MobileOffice implements IJsonConvertor {

	private int row;
	private int col;
	
	private static MobileOffice instance;
	
	private OfficeBlock blocks[][];

	private MobileOffice(int row, int col) {
		blocks = new OfficeBlock[row][col];
		this.row = row;
		this.col = col;
	}
	
	public static MobileOffice createMobileOffice(int row, int col) {
		if(instance == null) {
			instance = new MobileOffice(row, col);
			return instance;
		} else {
			return instance;
		}
	}

	@Override
	public String getJson() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < row; ++i) {
			for(int j = 0; j < col; ++j) {
				sb.append(blocks[i][j].getJson());
			}
		}

		return sb.toString();
	}
	
	public static OfficeBlock getBlock(int xPos, int yPos) {
		return instance.blocks[xPos][yPos];
	}
	
	public static void setBlock(int xPos, int yPos, OfficeBlock block) {
		instance.blocks[xPos][yPos] = block;
	}
	
	
}
