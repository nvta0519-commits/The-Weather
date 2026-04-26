import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import weather.Period;

import java.util.ArrayList;

public class ThreeDayScene extends WeatherSceneTemplate{
    @Override
    //Creates the title of 3-Day weather
    protected void addTitle(VBox root) {
        TextField title = new TextField("3-Day Forecast");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        title.setEditable(false);
        title.setAlignment(Pos.CENTER);

        HBox box = new HBox(title);
        box.setAlignment(Pos.CENTER);

        root.getChildren().add(box);
    }

    @Override
    protected void addContent(VBox root, ArrayList<Period> forecast) {
        //checking every 2 periods, each count is collecting day and night information
        for (int i = 0; i < 6 && i < forecast.size() - 1; i += 2) {
            //receive the data from forcast
            ForecastAdapter a = new PeriodAdapter(forecast.get(i));
            ForecastAdapter b = new PeriodAdapter(forecast.get(i+1));

            //check if it is day or night information
            ForecastAdapter day = a.isDay() ? a : b;
            ForecastAdapter night = a.isDay() ? b : a;

            //create the VBox to hold information
            VBox dayBox = createBox("Day", day);
            dayBox.setStyle("-fx-border-color: black; -fx-padding: 10; -fx-background-color: lightyellow;");
            VBox nightBox = createBox("Night", night);
            nightBox.setStyle("-fx-border-color: black; -fx-padding: 10; -fx-background-color: lightgray;");

            //HBox for alignment of previously created VBoxs
            HBox row = new HBox(20, dayBox, nightBox);
            row.setAlignment(Pos.CENTER);

            //what is the name of day (Friday, Saturday, etc)
            TextField title = new TextField(day.getName());
            title.setEditable(false);

            //put each set of information together
            VBox container = new VBox(5, title, row);
            container.setAlignment(Pos.CENTER);
            container.setStyle("-fx-border-color: black;");

            root.getChildren().add(container);
        }
    }

    private VBox createBox(String label, ForecastAdapter data) {
        //Information which will be shown: day, image, temperature, description, wind speed, and wind direction
        TextField l = new TextField(label);
        l.setEditable(false);
        ImageView icon = new ImageView(new Image(data.getIcon(), 50, 50, true, true));
        TextField t = new TextField(data.getTemp());
        TextField ws = new TextField(data.getWindSpeed());
        TextField wd = new TextField(data.getWindDirection());

        //for each textfield make it not editable and centered
        for (TextField tf : new TextField[]{l,t,ws,wd}) {
            tf.setEditable(false);
            tf.setAlignment(Pos.CENTER);
        }

        //connect each through a VBox
        VBox box = new VBox(5, l, icon, t, ws, wd);
        box.setAlignment(Pos.CENTER);
        box.setStyle("-fx-border-color: black; -fx-padding: 10;");

        return box;
    }

    @Override
    protected void addButton(VBox root) {
        //button to go back to the Today's forecast
        Button back = new Button("←");
        back.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        root.getChildren().add(back);
    }
}
