import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  /** Instance Variables */
  
  /** Constructor */
  public ImageFilter(String fileName) {
    super(fileName);
  }

   public void sharpen() {
    Pixel[][] pixels = getImagePixels();

    // traverse starting at (1,1), stop 1 less to not go out of bounds
    for (int row = 1; row < pixels.length - 1; row++) {
      for (int col = 1; col < pixels[0].length - 1; col++) {
        Pixel currentPixel = pixels[row][col];
        // determine the avg RGB difference between the current pixel and the pixel
        // to the topLeft (row - 1, col - 1)
        int redDiff = currentPixel.getRed() - pixels[row - 1][col - 1].getRed();
        int greenDiff = currentPixel.getGreen() - pixels[row - 1][col - 1].getGreen();
        int blueDiff = currentPixel.getBlue() - pixels[row - 1][col - 1].getBlue();
        int averageDiff = (redDiff + greenDiff + blueDiff) / 3;
        // add the avg differnce
        int newRed = currentPixel.getRed() + averageDiff;
        int newGreen = currentPixel.getGreen() + averageDiff;
        int newBlue = currentPixel.getBlue() + averageDiff;
        // force RGB to no exceed 255
        if (newRed > 255) {
          newRed = 255;
        }
        if (newGreen > 255) {
          newGreen = 255;
        }
        if (newBlue > 255) {
          newBlue = 255;
        }
        // update RBG values
        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }

    public void makeNegative() {
    Pixel[][] pixels = getPixelsFromImage();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();

        int newRed = (255 - currentRed);
        int newGreen = (255 - currentGreen); 
        int newBlue = (255 - currentBlue);

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }

    public void colorShift(int value) {
    Pixel[][] pixels = getPixelsFromImage();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();

        int newRed =  value + currentRed;
        int newGreen = value + currentGreen;
        int newBlue =  value + currentBlue;

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }
  
    public void adjustContrast(int multiplier) {
    Pixel[][] pixels = getPixelsFromImage();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();

        int newRed = multiplier * currentRed;
        int newGreen = multiplier * currentGreen;
        int newBlue = multiplier * currentBlue;

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }
  
   public void mirrorVertical() {
    Pixel[][] pixels = getPixelsFromImage();
    
    for (int col = 0; col < pixels[0].length / 2; col++) {
     for (int row = 0; row < pixels.length; row++) {
        Pixel currentPixel = pixels[row][col];
        Pixel rightPixel = pixels[row][pixels[0].length - 1 - col];
       
  
        int newRed = rightPixel.getRed();
        int newGreen = rightPixel.getGreen();
        int newBlue = rightPixel.getBlue();

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }

    public void applySepia() {
    Pixel[][] pixels = getPixelsFromImage();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();

        int newRed = (int)((0.393 * currentRed) + (0.769 * currentGreen) + (0.189 * currentBlue));
        int newGreen = (int)((0.349 * currentRed) + (0.686 * currentGreen) + (0.168 * currentBlue));
        int newBlue = (int)((0.272 * currentRed) + (0.534 * currentGreen) + (0.131 * currentBlue));

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }
// I custom made this method to change colors to blue/amplify already existing blue
    public void amplifyBlue() {
    Pixel[][] pixels = getPixelsFromImage();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        int currentRed = currentPixel.getRed() - 50;
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue() + 75;

        if (currentRed < 0){
          currentRed = 0;
        }
        if (currentBlue > 255){
          currentBlue = 255;
        }


        currentPixel.setRed(currentRed);
        currentPixel.setGreen(currentGreen);
        currentPixel.setBlue(currentBlue);
      }
    }
  }
  
}
