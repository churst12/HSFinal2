import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class Room1
{
	public int x;
	public int y;
	public boolean visible;
	private BufferedImage bedroomImg;
	private BufferedImage xOptionImg;
	public boolean intro;
	public Room1()
	{
		visible=true;
		
		try
	    {
			bedroomImg = ImageIO.read(new File("Bedroom.png"));
			xOptionImg = ImageIO.read(new File("XOption.png"));
	    } catch (IOException e) {}
			Screen s=new Screen();
	    	
	}
	public void draw(Graphics g)
	{
		
		if(visible)
		{
			g.drawImage(bedroomImg,0,0,null);
			Color calendar=new Color(240,240,255);
			g.setColor(calendar);
			g.fillRect(700,220,100,100);
			Color calendar2=new Color(255,30,30);
			g.setColor(calendar2);
			g.fillRect(700,220,100,20);
			Font cambria=new Font("Cambria", Font.PLAIN, 80);
			g.setColor(Color.black);
			g.setFont(cambria);
			g.drawString(""+GameManager.dayCount,720,300);
			
		}
	}
	
    public boolean checkCollision(int xInput, int yInput, Graphics g)
    {
        
        if( xInput>= 600 && xInput <= 814 )
        {
            g.drawImage(xOptionImg,700,610,null);
			
            
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