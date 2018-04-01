package hufs.scv.tile;

import javafx.scene.image.ImageView;

public class Tile {
	
	private boolean isMosaic = false;
	private int row_i;
	private int col_i;
	private TileImages tileImages = TileImages.getInstance();

	public Tile(){
		this(0, 0);
	}
	public Tile(int row_i, int col_i){
		this(row_i, col_i, false);
	}
	public Tile(int row_i, int col_i, boolean isMosaic){
		this.row_i = row_i;
		this.col_i = col_i;
		this.isMosaic = isMosaic;
	}
	public ImageView getImage(){
		return new ImageView(tileImages.getImage(row_i, col_i, isMosaic));
	}
	public void setMosaic() {
		isMosaic = !isMosaic;
	}
	public boolean getMosaic() {
		return isMosaic;
	}
}
