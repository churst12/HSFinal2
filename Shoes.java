import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Shoes extends Items
{
	private BufferedImage hatImg;
	private BufferedImage glassesImg;
	private BufferedImage glasses2Img;
	private BufferedImage shoesImg;
	public Shoes()
	{
		
		
		try
	    {
			shoesImg = ImageIO.read(new File("Shoes.png"));
	    } catch (IOException e) {}
		
	    	
	}
	@Override
	public int draw(Graphics g,boolean direction,int x,int y)
	{
		if(direction)
		{
			g.drawImage(shoesImg,x+45,y+342,null);
		}
		if(direction==false)
		{
			g.drawImage(shoesImg,x+55,y+342,null);
		}
		return 1;
	}
	public int getNum()
	{
		return 2;
	}
	
}