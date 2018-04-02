package hufs.ces.image;

import hufs.ces.util.ImageUtils;
import hufs.scv.tile.*;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.application.*;

public class NxNMosaicButton extends Application {

	private static final int PROWS = 20;

	private TileImages tileImages = new TileImages(PROWS, PROWS);
	private TileButton[][] tileButton = new TileButton[PROWS][PROWS];
	private Image tileImage = null;

	double scrHeight = 500;
	double scrWidth = 500;
	int bwidth = 0;
	int bheight = 0;

	ImageView whiteTile = null;
	
	private GridPane root;

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("NxN Label");

		root = new GridPane();
		root.setPrefHeight(scrHeight);
		root.setPrefWidth(scrWidth);

		initialize();

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

	void initialize(){

		for (int row = 0 ; row < PROWS ; row++ ){
			RowConstraints rc = new RowConstraints();
			rc.setFillHeight(true);
			rc.setVgrow(Priority.ALWAYS);
			root.getRowConstraints().add(rc);
		}
		for (int col = 0 ; col < PROWS; col++ ) {
			ColumnConstraints cc = new ColumnConstraints();
			cc.setFillWidth(true);
			cc.setHgrow(Priority.ALWAYS);
			root.getColumnConstraints().add(cc);
		}

		bwidth = (int)scrWidth/PROWS;
		bheight = (int)scrHeight/PROWS;
		
		tileImage = new Image(getClass().getResourceAsStream("/images/pale-blue-dot.png"));
		
		for (int row=0; row<PROWS; row++){
			for (int col=0; col<PROWS; col++) {
				tileImages.setImage(row, col, ImageUtils.getSubImage(tileImage, bwidth*col, bheight*row, bwidth, bheight));
			}
		}
		tileImages.setMosaic();
		for (int row=0; row<PROWS; row++) {
			for (int col=0; col<PROWS; col++) {
				tileButton[row][col] = new TileButton();
				tileButton[row][col].setTile(new Tile(row, col));
				tileButton[row][col].setPadding(new Insets(0,0,0,0));
				tileButton[row][col].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				tileButton[row][col].setOnAction(e->changeMosaic(e));
				root.add(tileButton[row][col], col, row);
			}
		}

	}
	void changeMosaic(ActionEvent e) {
		TileButton btn = (TileButton)e.getSource();
		btn.setTileMosaic();
	}
}
