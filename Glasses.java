import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Glasses extends Items
{
	private BufferedImage hatImg;
	private BufferedImage glassesImg;
	private BufferedImage glasses2Img;
	private BufferedImage shoesImg;
	public Glasses()
	{
		
		
		
		try
	    {
			glassesImg = ImageIO.read(new File("Glasses.png"));
			glasses2Img = ImageIO.read(new File("Glasses2.png"));
			
	    } catch (IOException e) {}
		
	    	
	}
	@Override
	public int draw(Graphics g,boolean direction,int x,int y)
	{
		if(direction)
		{
			g.drawImage(glasses2Img,x+34,y+60,null);
		}
		if(direction==false)
		{
			g.drawImage(glassesImg,x+50,y+60,null);
		}
		return 1;
	}
	public int getNum()
	{
		return 0;
	}
}