# Unit 5 - Personal Narrative / Interest Animation

## Introduction

Images are often used to portray our personal experiences and interests. We also use image filters and effects to change or enhance the mood of an image. When combined into collages and presentations, these images tell a story about who we are and what is important to us. Your goal is to create an animation using The Theater and Scene API that consists of images of your personal experiences and/or interests. In this animation, you will incorporate data related to these experiences and/or interests that can be organized in a 2D array, and use image filters and effects to change or enhance the mood of your images.
## Requirements

Use your knowledge of object-oriented programming, two-dimensional (2D) arrays, and algorithms to create your personal narrative collage or animation:
- **Write Scene subclasses** – Create two Scene subclasses: either two core parts of your personal life, or two components of a personal interest. Each class must contain a constructor and private instance variable with data related to the scene
- **Create at least two 2D arrays** – Create at least two 2D arrays to store the data that will make up your visualization.
Implement algorithms – Implement one or more algorithms that use loops and logic that operate on the data in your 2D arrays.
- **Create a visualization** – Create an animation that conveys the story of the data by illustrating the patterns or relationships in the data.
- **Image Filters** – Utilize the image filters created in this unit (and possible new filters) that show a personal flare to the images used in your animation.
- **Document your code** – Use comments to explain the purpose of the methods and code segments and note any preconditions and postconditions.

## UML Diagram

<img width="790" height="455" alt="image" src="https://github.com/user-attachments/assets/776bbf68-cab5-4f56-80b1-044af49fdb3f" />

## Video

<img width="310" height="312" alt="image" src="https://github.com/user-attachments/assets/0b8e7941-a235-4e6e-87cd-8c1c51b88602" />


https://www.youtube.com/shorts/7vCdLCIBiz4

## Story Description

The story my animation showcases is my favorite pokemon, and my opinions on those pokemon of why I like them. The 2D arrays in my code are images[][] and opinions [][]. images[][] is a 2d array of imageFilter objects each containing the image of a pokemon and their type, this 2d array essentially stores the image of the pokemon along with it's corresponding type to be displayed in the story. Opinions[][] is a 2d array that stores String of the pokemons name, type, and my opinion on the pokemon, it's used to store the previously mentioned Strings so drawText will be able to display text on my story using the Strings from the 2d array.

## Image Filter Analysis

Choose at least 2 filters used in your animation to explain how the pixels are modified. If you created a new image filter that was not one of the ones from this unit, make sure to explain and analyze that filter(s) before choosing ones that came from this unit.

The amplifyBlue image filter loops through each pixel, and for each pixel, the method decreases the red value by 50 and increased the blue value by 75. Then the new values are stored into new variables such as newBlue, newGreen (green isn't altered), and newRed. To make sure the new colors don't surpass the 255 threshold, a conditional statement checks if the newValue is above 255, and if it is, the color's value is set to 255. Afterwards, the colors are applied to the current pixel to make the blue pop more.

The sharpen image filter loops through each pixel, and for each pixel, the method starts at row and column 1 along with the arrays length-1 to stay in bounds. The method uses the top left adjacent pixel to compare it to the current colors of the current pixel, using this comparison, a new average variable is made by combining the differences in each color from the comparison, then dividing by the amount of colors. This average variable will then decide the strength of how much a color will darken or lighten, leading to the "sharpened" effect that will then be applied onto the current pixel.
