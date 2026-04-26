import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import weather.Period;

import java.util.ArrayList;

public abstract class WeatherSceneTemplate {
    //the build method to build the scene
    public VBox build(ArrayList<Period> forecast) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: lightblue;");

        addTitle(root);
        addContent(root, forecast);
        addButton(root);

        return root;
    }

    //create the title of the scene
    protected abstract void addTitle(VBox root);
    //creates what unique information and details will be provided in scene
    protected abstract void addContent(VBox root, ArrayList<Period> forecast);
    //creates what buttons does the scene haveD
    protected abstract void addButton(VBox root);
}
