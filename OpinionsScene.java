import org.code.theater.*;
import org.code.media.*;

public class OpinionsScene extends Scene {

  /** Instance Variables */
    private ImageFilter[][] images;
    private String[][] opinions;

  /** Constructor */
  public OpinionsScene(ImageFilter[][] images, String [][] opinions) {
this.images = images;
this.opinions = opinions;

  }

  /**
   * Top-level drawScene method which will draw the whole animation
   */
  public void drawScene() {
    drawTransition();
    drawAllOpinions();
    drawTransition2();
  }

  // other methods...

  /*
  Method that creates imageFilter object then
  applies filter, drawing the image afterwards. 
  Then draws the text using the opinions 2d array
  to create a screen with the pokemon and captions
  */
  public void drawOpinions(int row){
   ImageFilter icon = images[row][0];
   ImageFilter pokemon = images[row][1];
    icon.sharpen();
    pokemon.adjustContrast(2);
    drawImage (icon, 10, 15, 150);
    drawImage (pokemon, 200, 15, 150);

    setTextColor("black");
   setTextStyle(Font.MONO, FontStyle.BOLD);
   setTextHeight(22);

    drawText(opinions[row][0], 20, 275);
    drawText(opinions[row][1], 20, 300);
    drawText(opinions[row][2], 20, 375);
  }

/*
Method that uses drawOpinions 
to draw every opinion by using a for loop
*/
  public void drawAllOpinions(){
    for (int row = 0; row < opinions.length; row++){
      clear("white");
      drawOpinions(row);
      pause(1);
    }
  }
  
/*
Method that draws the transition screen
between drawing pokemon to drawing opinions
*/
public void drawTransition(){
   setTextColor("black");
   setTextStyle(Font.MONO, FontStyle.BOLD);
   setTextHeight(22);
  clear("white");
  drawText("Opinions On Each Pokemon!", 50, 200);
  pause(1.5);
}

/*
Method that draws the closing screen
*/
public void drawTransition2(){
   setTextColor("black");
   setTextStyle(Font.MONO, FontStyle.BOLD);
   setTextHeight(22);
  clear("white");
  drawText("The End!", 150, 200);
  pause(1.5);
}

/*
Helper method used to count the
number of opinions in the Opinions
2d array
  */
public int countOpinions(){
  int count = 0;
for (int r = 0; r < opinions.length; r++){
  for (int c = 0; c < opinions[0].length; c++){
  count++;
 }
 }
  return count;
}
  
}
  
