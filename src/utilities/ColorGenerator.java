package utilities;

import javafx.scene.paint.Color;
import java.util.Random;

public class ColorGenerator {
	
	public Color generate() {
		Random rand = new Random();
		Color c = Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
		return c;
	}
}
