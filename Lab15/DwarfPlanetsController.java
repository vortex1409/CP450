import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

/***
 * Michael Dorfman
 * CP450 - OOP Java
 * Lab 15 - JavaFX UI
 * 01/03/2018
 */
public class DwarfPlanetsController
{
   @FXML
   private ImageView dwarfPlanetsImageView;

   @FXML
   private Label discoveredByLabel;

   @FXML
   private Label dateOfDiscoveryLabel;

   @FXML
   private Label orbitPeriodLabel;

   @FXML
   private Label lengthOfDayLabel;

   @FXML
   private Label namedAfterLabel;

   @FXML
   private ToggleGroup dwarfPlanetsToggleGroup;

   @FXML
   private RadioButton ceresRadioButton;

   @FXML
   private RadioButton erisRadioButton;

   @FXML
   private RadioButton haumeaRadioButton;

   @FXML
   private RadioButton makemakeRadioButton;

   @FXML
   private RadioButton plutoRadioButton;

   private Image ceresImage;
   private Image erisImage;
   private Image haumeaImage;
   private Image makemakeImage;
   private Image plutoImage;

   // Load the image files in the intialize method
   public void initialize()
   {
      ceresImage = new Image("Ceres.png");
      erisImage = new Image("Eris.png");
      haumeaImage = new Image("Haumea.png");
      makemakeImage = new Image("MakeMake.png");
      plutoImage = new Image("Pluto.png");
   }

   // Event listener for the ceresRadioButton
   public void ceresRadioButtonListener()
   {

      if (ceresRadioButton.isSelected())
      {
         dwarfPlanetsImageView.setImage(ceresImage);
         discoveredByLabel.setText("Giuseppe Piazzi");
         dateOfDiscoveryLabel.setText("January 1, 1801");
         orbitPeriodLabel.setText("4.60 Earth Years");
         lengthOfDayLabel.setText("9.07 Hours");
         namedAfterLabel.setText("The Roman Goddess of corn and harvests");
      }
   }

   // Event listener for the erisRadioButton
   public void erisRadioButtonListener()
   {

      if (erisRadioButton.isSelected())
      {
         dwarfPlanetsImageView.setImage(erisImage);
         discoveredByLabel.setText("Brown, Trujillo, and Rabinowitz");
         dateOfDiscoveryLabel.setText("October 21, 2003");
         orbitPeriodLabel.setText("561.37 Earth Years");
         lengthOfDayLabel.setText("25.90 Hours");
         namedAfterLabel.setText("The ancient Greek goddess of discord and strife");
      }
   }

   // Event listener for the haumeaRadioButton
   public void haumeaRadioButtonListener()
   {

      if (haumeaRadioButton.isSelected())
      {
         dwarfPlanetsImageView.setImage(haumeaImage);
         discoveredByLabel.setText("Sierra Nevada Observatory");
         dateOfDiscoveryLabel.setText("March 7, 2003");
         orbitPeriodLabel.setText("281.93 Earth Years");
         lengthOfDayLabel.setText("3.91 Hours");
         namedAfterLabel.setText("The Hawaiian goddess of childbirth and fertility");
      }

   }

   // Event listener for the makemakeRadioButton
   public void makemakeRadioButtonListener()
   {

      if (makemakeRadioButton.isSelected())
      {
         dwarfPlanetsImageView.setImage(makemakeImage);
         discoveredByLabel.setText("Brown, Trujillo, and Rabinowitz");
         dateOfDiscoveryLabel.setText("March 31, 2005");
         orbitPeriodLabel.setText("305.34 Earth Years");
         lengthOfDayLabel.setText("22.48 Hours");
         namedAfterLabel.setText("The Rapanui god of fertility");
      }
   }

   // Event listener for the plutoRadioButton
   public void plutoRadioButtonListener()
   {

      if (plutoRadioButton.isSelected())
      {
         dwarfPlanetsImageView.setImage(plutoImage);
         discoveredByLabel.setText("Clyde Tombaugh");
         dateOfDiscoveryLabel.setText("February 18 1930");
         orbitPeriodLabel.setText("247.92 Earth Years");
         lengthOfDayLabel.setText("153.29 Hours");
         namedAfterLabel.setText("The ancient Greek god of the underworld");
      }
   }
}