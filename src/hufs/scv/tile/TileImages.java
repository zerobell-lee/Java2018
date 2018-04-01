package hufs.scv.tile;

import hufs.ces.util.ImageUtils;
import javafx.scene.image.Image;

public class TileImages {

	private Image[][] img = null;
	private Image[][] cl = null;
	private int ROWS;
	private int COLS;

	private volatile static TileImages uniqueInstance;
	
	public TileImages(int row, int col){
		ROWS = row;
		COLS = col;
		initialize(row, col);
	}

	public static TileImages getInstance() {
		return uniqueInstance;
	}
	
	private void initialize(int row, int col){
		img = new Image[ROWS][COLS];
		cl = new Image[ROWS][COLS];
		uniqueInstance = this;
	}
	public void setImage(int row_num, int col_num, Image setImg){
		img[row_num][col_num] = setImg;
	}
	public void setMosaic() {
		for (int i=0; i<ROWS; i++) {
			for (int j=0; j<COLS; j++) {
				cl[i][j] = ImageUtils.getOneColorImage(img[i][j].getWidth(), img[i][j].getHeight(), ImageUtils.getAverageColor(img[i][j]));
			}
		}
	}
	Image getImage(int row_num, int col_num, boolean isMosaic) {
		if (isMosaic) {
			return cl[row_num][col_num];
		}
		else {
			return img[row_num][col_num];
		}
	}
}
