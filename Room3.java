import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class Room3
{
	public int x;
	public int y;
	public boolean visible;
	private BufferedImage roomImg;
	private BufferedImage room2Img;
	private BufferedImage xOptionImg;
	public boolean intro;
	public boolean doorClose=true;
	public Room3()
	{
		visible=true;
		
		try
	    {
			roomImg = ImageIO.read(new File("Room3.png"));
			
			xOptionImg = ImageIO.read(new File("XOption.png"));
	    } catch (IOException e) {}
			Screen s=new Screen();
			
	}
	
	public void draw(Graphics g)
	{
		
		if(visible)
		{
			g.drawImage(roomImg,0,0,null);
			
			
		}
	}
	
    public void checkCollisionX(int xInput, int yInput, Graphics g)
    {
        
        if( xInput>= 330 && xInput<=340)
        {
            g.drawImage(xOptionImg,360,610,null);
        }
    }
    public boolean checkCollision(int xInput, int yInput, Graphics g)
    {
        
        if( xInput>=340 && doorClose)
        {
			return true;
        }
		
 
     
        //otherwise return false as the default case.
        return false;
    }
    public boolean checkCollision2(int xInput, int yInput, Graphics g)
    {
        
        if( xInput<=426 && doorClose)
        {
			return true;
        }
		System.out.println("Door: "+doorClose);
 
     
        //otherwise return false as the default case.
        return false;
    }
	
	public void setFalse()
	{
		visible=false;
	}
	public void setIntro(boolean c)
	{
		intro=c;
	}
	public boolean getIntro()
	{
		return intro;
	}
	public boolean getVisible()
	{
		return visible;
	}
	public void setDoor(boolean c)
	{
		doorClose=c;
	}
	
	
	
	
}