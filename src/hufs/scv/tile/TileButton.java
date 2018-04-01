package hufs.scv.tile;

import javafx.scene.control.Button;

public class TileButton extends Button {


	private Tile tile = null;
	
	public TileButton(){
		super();
		tile = new Tile();
		this.setGraphic(tile.getImage());
	}
	public TileButton(int row_i, int col_i){
		super();
		tile = new Tile(row_i, col_i);
		this.setGraphic(tile.getImage());
	}
	public TileButton(int row_i, int col_i, boolean isMosaic){
		super();
		tile = new Tile(row_i, col_i, isMosaic);
		this.setGraphic(tile.getImage());
	}
	public TileButton(Tile tile){
		super();
		this.tile = tile;
		this.setGraphic(tile.getImage());
	}
	public Tile getTile() {
		return tile;
	}
	public void setTile(Tile tile) {
		this.tile = tile;
		this.setGraphic(tile.getImage());
	}
	public void setTileMosaic(){
		this.tile.setMosaic();
		this.setGraphic(tile.getImage());
	}
}
