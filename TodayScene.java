import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import weather.Period;

import java.util.ArrayList;

public class TodayScene extends WeatherSceneTemplate{
    @Override
    //Creates the title of Today's weather
    protected void addTitle(VBox root) {
        TextField title = new TextField("Today's Weather");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        title.setEditable(false);
        title.setAlignment(Pos.CENTER);

        HBox box = new HBox(title);
        box.setAlignment(Pos.CENTER);

        root.getChildren().add(box);
    }

    @Override
    protected void addContent(VBox root, ArrayList<Period> forecast) {
        //receive the data from forcast
        ForecastAdapter a = new PeriodAdapter(forecast.get(0));
        ForecastAdapter b = new PeriodAdapter(forecast.get(1));

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

        root.getChildren().add(row);
    }

    private VBox createBox(String label, ForecastAdapter data) {
        //Information which will be shown: day, image, temperature, description, wind speed, wind direction, and precipitation
        TextField l = new TextField(label);
        l.setEditable(false);
        ImageView icon = new ImageView(new Image(data.getIcon(), 50, 50, true, true));
        TextField t = new TextField(data.getTemp());
        TextField d = new TextField(data.getDesc());
        TextField ws = new TextField(data.getWindSpeed());
        TextField wd = new TextField(data.getWindDirection());
        TextField p = new TextField(data.getPrecip());

        //for each textfield make it not editable and centered
        for (TextField tf : new TextField[]{l,t,d,ws,wd,p}) {
            tf.setEditable(false);
            tf.setAlignment(Pos.CENTER);
        }

        //connect each through a VBox
        VBox box = new VBox(5, l, icon, t, d, ws, wd, p);
        box.setAlignment(Pos.CENTER);
        box.setStyle("-fx-border-color: black; -fx-padding: 10;");

        return box;
    }

    @Override
    protected void addButton(VBox root) {
        //button to go to the 3-day forecast
        Button btn = new Button("3-Day Forecast");
        root.getChildren().add(btn);
    }
}
