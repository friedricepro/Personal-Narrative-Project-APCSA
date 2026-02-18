import org.code.theater.*;
import org.code.media.*;

public class PokemonScene extends Scene {

  /** Instance Variables */
  private ImageFilter[][] images;
  public static final int SAMPLE_RATE = 44100; //variable used to play sound
  /** Constructor */
  public PokemonScene(ImageFilter [][] images) {
this.images = images;
  }

  /**
   * Top-level drawScene method which will draw the whole animation
   */
  public void drawScene() {
    playBackgroundTrack(14); //Video is 14 seconds so audio played is 14 seconds
    drawIntroScene();
    drawAllPokemon();
  }

  // other methods...

  /*
  draws a pokemon by creating an imageFilter object
  using the 2d arrays index, then applies filter
  before drawig it
  */
  public void drawPokemon(int row){
  /* uses row as a parameter because each 
    row reprsents a pokemons look, and type */
 ImageFilter icon = images[row][0];
   ImageFilter pokemon = images[row][1];
    icon.amplifyBlue();
    pokemon.applySepia();
    drawImage (icon, 2, 100, 200);
    drawImage (pokemon, 200, 100, 190);
  }

  /*
 Method that draws all the pokemon using 
 drawPokemon method and sets captions
  */
  public void drawAllPokemon(){
  for (int row = 0; row < images.length; row++){
    clear("white");
    setTextHeight(25);
    setTextColor("black");
    drawText("Fav Pokemon #" +(row + 1), 100, 50);
    drawPokemon(row);
    pause(1);
  }
  }

  /*
  Method that draws the introduction screen 
  by customizing text then displaing images
  with imageFIlters applied to them
  */
   public void drawIntroScene() {
    clear("white");
    
    setTextHeight(40);
    setTextColor("Black");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    
    drawText("Welcome to Tims", 25, 50);
    drawText("Top 5 Pokemon!", 40, 80);

    ImageFilter logo = new ImageFilter("pokeball.png");
    ImageFilter logo2 = new ImageFilter("pika.png");
    logo.makeNegative();
    logo2.colorShift(100);
    drawImage(logo, 10, 120, 200);
    drawImage(logo2, 200, 150, 165);
    pause(1.0);
  }

  /*
  Methods that plays the background track
  Was taken from unit 4 Abstract Art Project
  Creator's Credit : Mr Aiello
  */
   public void playBackgroundTrack(int numSeconds) {
    double[] audio = SoundLoader.read("lkoliks-upbeat-energetic-background-music-337963-(1).wav");
    // just play the first numSeconds
    double[] clip = createClip(audio, 0, numSeconds);
    playSound(clip);
  }

  /**
   * Creates an audio clip from a given start time to a end time
   */
  public static double[] createClip(double[] sound, int start, int end) {
    int startIndex = start * SAMPLE_RATE;
    int endIndex = end * SAMPLE_RATE;
    
    double[] newSound = new double[endIndex - startIndex];

    int index = 0;
    
    while (startIndex < endIndex) {
      newSound[index] = sound[startIndex];
      startIndex++;
      index++;
    }

    return newSound;
  }
  
/*
Helper method used to count the 
amount of images in the 2d array
*/
  public int countImages(){
  int count = 0;
for (int r = 0; r < images.length; r++){
  for (int c = 0; c < images[0].length; c++){
  count++;
 }
 }
  return count;
}
  
}
