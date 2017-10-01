import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Character
{
	int x=10;
	int y=340;
	int width=200;
	int height=70;
	public boolean visible;
	private BufferedImage characterLeftImg;
	private BufferedImage characterRightImg;
	private BufferedImage hatImg;
	private BufferedImage glassesImg;
	private BufferedImage glasses2Img;
	private BufferedImage shoesImg;
	public boolean hat=false;
	public boolean glasses=false;
	public boolean direction=false;
	public boolean shoes=false;
	public int fast=0;
	
	public Character()
	{
		visible=true;
		
		try
	    {
			characterLeftImg = ImageIO.read(new File("CharacterLeft.png"));
			characterRightImg = ImageIO.read(new File("CharacterRight.png"));
			hatImg = ImageIO.read(new File("TopHat.png"));
			glassesImg = ImageIO.read(new File("Glasses.png"));
			glasses2Img = ImageIO.read(new File("Glasses2.png"));
			shoesImg = ImageIO.read(new File("Shoes.png"));
	    } catch (IOException e) {}
		
	    	
	}
	public Character(int xi,int yi)
	{
		x=xi;
		y=yi;
	}
	public void draw(Graphics g,ArrayList<Items> list)
	{
		
		if(visible)
		{
			if(direction)
			{
				g.drawImage(characterRightImg,x,y,null);
			}
			else if(direction==false)
			{
				g.drawImage(characterLeftImg,x,y,null);
			}
			
			for(int i=0; i<list.size(); i++)
			{
				int hi=list.get(i).draw(g,direction,x,y);
			}
			
		}
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).getNum()==2)
			{
				this.addShoes();
			}
			
		}
	}
	
    public int checkCollision(int xInput, int yInput,Graphics g)
    {
        
        if( xInput>= x && xInput <= x + width )
        {
            if( yInput>= y+200 && yInput <= y+200 + height )
            {
				//g.drawImage(,x,y+200,null);
			
                return 3;
            }
			
        }
 
     
        //otherwise return false as the default case.
        return -1;
    }
	public void setFalse()
	{
		visible=false;
	}
	public void moveLeft()
	{
		x-=5+fast;
		direction=false;
	}
	public void moveRight()
	{
		x+=5+fast;
		direction=true;
	}
	public boolean getVisible()
	{
		return visible;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setX(int xi)
	{
		x=xi;
	}
	public void setY(int yi)
	{
		y=yi;
	}
	public void addHat()
	{
		hat=true;
	}
	public void addGlasses()
	{
		glasses=true;
	}
	public void addShoes()
	{
		shoes=true;
		fast=3;
	}
	public boolean getHat()
	{
		return hat;
	}
	
	
	
}