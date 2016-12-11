package utilities;

import javafx.scene.paint.Color;
import java.util.Random;

public class ColorGenerator {
	
	//Creates a Color object with a random RGB value
	public Color generate() {
		Random rand = new Random();
		Color c = Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
		return c;
	}
}
