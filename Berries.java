import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Berries
{
	public int x;
	public int y;
	public int width=13;
	public int height=17;
	public boolean visible;
	private BufferedImage berryImg;
	
	public Berries(int xi, int yi)
	{
		visible=true;
		x=xi;
		y=yi;
		try
	    {
	    	berryImg = ImageIO.read(new File("berry.png"));
	    } catch (IOException e) {}
		
	
		
	}
	public void draw(Graphics g)
	{
		if(visible)
		{
			g.drawImage(berryImg,x,y,null);
		}
	}
    public boolean checkCollision(int xInput, int yInput, int widthInput, int heightInput)
    {
        //Make sure the xInput and yInput with its dimensions are  within the space 
        //of the target. 
         
        //Hint: Start with just checking the x positions, then move the y.
         
        //Checks the x positions for collision
        if( xInput + widthInput >= x && xInput <= x + width )
        {
            //Check the y positions for collision 
            if( yInput + heightInput >= y && yInput <= y + height )
            {
                return true;
            }
        }
 
     
        //otherwise return false as the default case.
        return false;
    }
	public void setFalse()
	{
		visible=false;
	}
	public boolean getVisible()
	{
		return visible;
	}
}