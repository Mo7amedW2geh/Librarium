package GUI;

import static utils.ImageUtility.*;

import java.awt.image.BufferedImage;
import java.util.Objects;

public class Assets {

    public static BufferedImage addBookImage = scaleImage(Objects.requireNonNull(loadImage("/books/Add_Book_Image.png")), 160, 200);

}
