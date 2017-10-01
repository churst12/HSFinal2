import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class TopHat extends Items
{
	private BufferedImage hatImg;
	private BufferedImage glassesImg;
	private BufferedImage glasses2Img;
	private BufferedImage shoesImg;
	public TopHat()
	{
		
		
		try
	    {
			hatImg = ImageIO.read(new File("TopHat.png"));
	    } catch (IOException e) {}
		
	    	
	}
	@Override
	public int draw(Graphics g,boolean direction,int x,int y)
	{
		if(direction)
		{
			g.drawImage(hatImg,x+30,y,null);
		}
		if(direction==false)
		{
			g.drawImage(hatImg,x+50,y,null);
		}
		return 1;
	}
	public int getNum()
	{
		return 1;
	}
}