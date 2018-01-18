import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/***
 * Michael Dorfman
 * CP450 - OOP Java
 * Lab 15 - JavaFX UI
 * 01/03/2018
 */

public class DwarfPlanets extends Application
{

   /***
    * Starts and Loads the Application
    * Builds the UI and shows the UI
    * @param stage Stage
    * @throws Exception
    */
   public void start(Stage stage) throws Exception
   {
      Parent parent = FXMLLoader.load(getClass().getResource("DwarfPlanets.fxml"));
      Scene scene = new Scene(parent);
      stage.setTitle("Dwarf Planets");
      stage.setScene(scene);
      stage.show();
   }

   /***
    * Main Method
    * Launch the application
    * @param args Arguments
    */
   public static void main(String[] args)
   {
      launch(args);
   }
}