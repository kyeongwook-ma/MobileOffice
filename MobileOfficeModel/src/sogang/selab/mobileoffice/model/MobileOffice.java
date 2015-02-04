package sogang.selab.mobileoffice.model;

import com.google.gson.Gson;

import sogang.selab.mobileoffice.model.convertor.IJsonConvertor;
import sogang.selab.mobileoffice.model.device.Device;

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
	
	public static MobileOffice createOfficeBlock(int row, int col) {
		if(instance == null) {
			instance = new MobileOffice(row, col);
			return instance;
		} else {
			return instance;
		}
	}

	public static OfficeBlock getBlock(int xPos, int yPos) {
		return instance.blocks[xPos][yPos];
	}
	
	public static void addDevice(Device d) {
		int pos[] = d.getPosition();
		instance.blocks[pos[0]][pos[1]].addDevice(d);
	}
	
	public static void assignBlock(OfficeBlock block) {
		int xPos = block.x();
		int yPos = block.y();
		instance.blocks[xPos][yPos] = block;
	}
	

	@Override
	public String getJson() {
		return new Gson().toJson(this);
	}
	
	public static String getSerializedJson() {
		return instance.getJson();
	}
	
	public static void printCurrentState() {
		for(int i = 0; i < instance.row; ++i) {
			System.out.println();
			for(int j = 0; j < instance.col; ++j) {
				
				OfficeBlock block = instance.blocks[i][j];
				
				if(block != null)
					System.out.print(block);
			}
		}

	}
}
