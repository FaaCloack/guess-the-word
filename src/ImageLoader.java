//import java.awt.Graphics2D;
//import java.awt.GraphicsConfiguration;
import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader{	
	public BufferedImage loadImage(String fnm) throws IOException{ //carga la imagen utilizando el metodo read() de ImageIO
		BufferedImage im =  ImageIO.read(getClass().getResource(fnm) );
	    return im;
	}
}

