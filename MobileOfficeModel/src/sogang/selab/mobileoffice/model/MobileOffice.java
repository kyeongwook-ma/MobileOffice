package sogang.selab.mobileoffice.model;

import sogang.selab.mobileoffice.model.convertor.IJsonConvertor;
import sogang.selab.mobileoffice.model.device.Device;

import com.google.gson.Gson;

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

	public static int row() { 

		try {
			if(instance == null)
				throw new Exception("Instantiate office before use it");
			return instance.row; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public static int col() { 
		try {
			if(instance == null)
				throw new Exception("Instantiate office before use it");
			return instance.col; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static OfficeBlock getBlock(int xPos, int yPos) {
		try {
			if(instance == null)
				throw new Exception("Instantiate office before use it");

			return instance.blocks[xPos][yPos];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void addDevice(Device d) {
		try {
			if(instance == null)
				throw new Exception("Instantiate office before use it");

			int pos[] = d.getPosition();

			OfficeBlock block = instance.blocks[pos[0]][pos[1]];

			if(block == null)
				throw new Exception("Empty block");

			instance.blocks[pos[0]][pos[1]].addDevice(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void assignBlock(OfficeBlock block) {
		try {
			if(instance == null)
				throw new Exception("Instantiate office before use it");

			int xPos = block.x();
			int yPos = block.y();
			instance.blocks[xPos][yPos] = block;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public String getJson() {
		return new Gson().toJson(this);
	}

	public static String getSerializedJson() {

		try {
			if(instance == null)
				throw new Exception("Instantiate office before use it");

			return instance.getJson();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}


	public static void printCurrentState() {

		try {
			if(instance == null)
				throw new Exception("Instantiate office before use it");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

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
