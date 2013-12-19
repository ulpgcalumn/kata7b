package kata.pkg7b;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {

    public static BufferedImage load(String filename){
        try {
            return ImageIO.read(new File(filename));
        } catch (IOException ex) {
            return null;
        }
    }
}
