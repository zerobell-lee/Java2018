package hufs.ces.clock;

import javafx.scene.layout.BorderPane;

public class AppleDoubleClockPane extends BorderPane {
	
	private AppleClockWithLabel pane1;
	private AppleClockWithLabel pane2;
	
	public AppleDoubleClockPane(String labelstr) {
		pane1 = new AppleClockWithLabel("Asia/Seoul");
		pane2 = new AppleClockWithLabel(labelstr);
		
		pane1.setPrefWidth(400);
		pane2.setPrefWidth(400);
		
		setLeft(pane1);
		setRight(pane2);
	}
	
	public void refresh() {
		pane1.acpane.setCurrentTime();
		pane2.acpane.setCurrentTime();
	}

}
