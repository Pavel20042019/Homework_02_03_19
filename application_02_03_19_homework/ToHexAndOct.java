package application_02_03_19_homework;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class ToHexAndOct extends Application {
	public ToHexAndOct () {
	}
	public String toHex (String sn) {
		if (sn.length () == 1 && sn.charAt (0) == '0')
			return "0";
		int n = 0, i = 0;
		boolean sign = false;
		if (sn.charAt (0) == '-') {
			sign = true;
			++ i;
		}	
		for (; i < sn.length (); ++ i) {
			n *= 10;
			n += sn.charAt (i) - '0';
		}
		String new_sn = "";
		int remainder;
		while (n > 0) {
			remainder = n % 16;
			if (remainder < 10)
				new_sn = (char) ('0' + remainder) + new_sn;
			else
				new_sn = (char) ('A' + remainder - 10) + new_sn;
			n /= 16;
		}
		if (sign)
			new_sn = '-' + new_sn;
		return new_sn;
	}
	public String toOct (String sn) {
		if (sn.length () == 1 && sn.charAt (0) == '0')
			return "0";
		int n = 0, i = 0;
		boolean sign = false;
		if (sn.charAt (0) == '-') {
			sign = true;
			++ i;
		}	
		for (; i < sn.length (); ++ i) {
			n *= 10;
			n += sn.charAt (i) - '0';
		}
		String new_sn = "";
		while (n > 0) {
			new_sn = (char) ('0' + n % 8) + new_sn;
			n /= 8;
		}
		if (sign)
			new_sn = '-' + new_sn;
		return new_sn;
	}
	public void start (Stage stage) throws Exception {
		try {
			TextField number = new TextField ();
			number.setFont (new Font ("Arial", 20));
			number.setStyle ("-fx-text-inner-color: black;");
			Button hex = new Button ("To hex"), oct = new Button ("To oct");
			hex.setFont (new Font ("Arial", 20));
			hex.setStyle ("-fx-text-inner-color: black;");
			oct.setFont (new Font ("Arial", 20));
			oct.setStyle ("-fx-text-inner-color: black;");
			Text new_number = new Text ();
			new_number.setFont (new Font ("Arial", 20));
			new_number.setStyle ("-fx-text-inner-color: black;");
			hex.setOnAction (new EventHandler <ActionEvent> () {
			    public void handle (ActionEvent e) {
			    	new_number.setText (toHex (number.getText ()));
			    }
			});
			oct.setOnAction (new EventHandler <ActionEvent> () {
			    public void handle (ActionEvent e) {
			    	new_number.setText (toOct (number.getText ()));
			    }
			});
			HBox buttons = new HBox ();
			buttons.getChildren ().addAll (hex, oct);
			VBox root = new VBox ();
			root.getChildren ().addAll (number, buttons, new_number);
			root.setStyle ("-fx-background-color: white;");
			stage.setScene (new Scene (root, 400, 400));
			stage.show ();
		}
		catch (Exception e) {
		}
	}
	public static void main (String [] args) {
		launch (args);
	}
}