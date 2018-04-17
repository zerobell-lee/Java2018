package hufs.ces.clock;

import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import java.util.TimeZone;


public class AppleClockWithLabel extends BorderPane {

	protected AppleClockPane acpane;
	private Label clockLabel;
	private TimeZone tz;
	
	public AppleClockWithLabel(String labelstr) {
		acpane = new AppleClockPane();
		clockLabel = new Label(labelstr);
		clockLabel.setFont(new Font(30));
		tz = TimeZone.getTimeZone(labelstr);
		
		acpane.setTimeZone(tz);
		
		setTop(clockLabel);
		setAlignment(clockLabel, Pos.TOP_CENTER);
		setCenter(acpane);
	}
	
}
