import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // Create any 2D arrays & variables to be passed as parameters to constructor
    ImageFilter[][] images = {
      // row 0 - normal type pokemon
      { new ImageFilter("normal-Icon.png"), new ImageFilter("Ditto.png") },
      // row 1 - ground type pokemon
      { new ImageFilter("ground.png"), new ImageFilter("Diglett.png") },
      // row 2 - psychic type pokemon
      { new ImageFilter("psychic.png"), new ImageFilter("Mew.png") },
      // row 3 - water type pokemon
      { new ImageFilter	("watericon.png"), new ImageFilter("Lapras.png") },
      // row 4 - dragon type pokemon
      { new ImageFilter("dragonIcon.png"), new ImageFilter("Dragonite.png") },
    };
      
    String [][] opinions = {
      {"Type: Normal", "Name: Ditto", "Funny Blob and Cool Shiny"},
      {"Type: Ground", "Name: Diglett", "Looks Bald and Funny"},
      {"Type: Psychic", "Name: Mew", "Cute and I Like the Shiny"},
      {"Type: Water", "Name: Lapras", "Love the Color and Design"},
      {"Type: Dragon", "Name: Dragonite", "Carried Me In Every Game"},
    };
    
    
    // Instantiate Scene subclass objects
    PokemonScene scenePoke = new PokemonScene(images);
    OpinionsScene sceneOpin = new OpinionsScene(images, opinions);
    
    // Call drawScene methods in each subclass
    scenePoke.drawScene();
    sceneOpin.drawScene();
    
    // Play scenes in Theater, in order of arguments
    Theater.playScenes(scenePoke, sceneOpin);
    
  }
}
