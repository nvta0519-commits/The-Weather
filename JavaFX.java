import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import weather.Period;
import weather.WeatherAPI;

import java.util.ArrayList;

public class JavaFX extends Application {
	TextField temperature,weather;

	public static void main(String[] args) {
		launch(args);
	}


	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		ArrayList<Period> forecast = WeatherAPI.getForecast("LOT",77,70);
		if (forecast == null){
			throw new RuntimeException("Forecast did not load");
		}
		TodayScene todayBuilder = new TodayScene();
		ThreeDayScene threeBuilder = new ThreeDayScene();

		VBox scene1Layout = todayBuilder.build(forecast);
		scene1Layout.setAlignment(Pos.CENTER);
		VBox scene2Layout = threeBuilder.build(forecast);

		Scene scene1 = new Scene(scene1Layout, 450, 400);
		Scene scene2 = new Scene(scene2Layout, 450, 800);

		Button toThree = (Button) scene1Layout.getChildren().get(scene1Layout.getChildren().size()-1);
		Button back = (Button) scene2Layout.getChildren().get(scene2Layout.getChildren().size()-1);

		toThree.setOnAction(e -> primaryStage.setScene(scene2));
		back.setOnAction(e -> primaryStage.setScene(scene1));

		primaryStage.setScene(scene1);
		primaryStage.show();

	}

}
