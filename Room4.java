import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class Room4
{
	public int x;
	public int y;
	public boolean visible;
	private BufferedImage roomImg;
	private BufferedImage xOptionImg;
	public boolean intro;
	public Room4()
	{
		visible=true;
		
		try
	    {
			roomImg = ImageIO.read(new File("Room4.png"));
			xOptionImg = ImageIO.read(new File("XOption.png"));
	    } catch (IOException e) {}
			Screen s=new Screen();
	    	
	}
	
	public void draw(Graphics g)
	{
			g.drawImage(roomImg,0,0,null);
	}
	
    public boolean checkCollision1(int xInput, int yInput, Graphics g)
    {
        
        if( xInput>= 320 && xInput <= 530 )
        {
            g.drawImage(xOptionImg,420,610,null);
			
            
			return true;
        }
 
     
        //otherwise return false as the default case.
        return false;
    }
    public boolean checkCollision2(int xInput, int yInput, Graphics g)
    {
        
        if( xInput>= 780 && xInput <= 989 )
        {
           // g.drawImage(xOptionImg,880,610,null);
			
			return true;
        }
 
     
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
	
}