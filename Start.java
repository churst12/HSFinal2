import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Start
{
	int x=800;
	int y=30;
	int width=200;
	int height=70;
	public boolean visible;
	private BufferedImage menuImg;
	private BufferedImage cntrlImg;
	private BufferedImage cntrl2Img;
	private BufferedImage startImg;
	private BufferedImage start2Img;
	private BufferedImage optionsImg;
	private BufferedImage options2Img;
	private BufferedImage characterLeftImg;
	private BufferedImage characterRightImg;
	
	public Start()
	{
		visible=true;
		
		try
	    {
	    	menuImg = ImageIO.read(new File("Startpage.png"));
	    	cntrlImg = ImageIO.read(new File("Controls.png"));
	    	cntrl2Img = ImageIO.read(new File("Controls2.png"));
	    	startImg = ImageIO.read(new File("Start.png"));
	    	start2Img = ImageIO.read(new File("Start2.png"));
	    	optionsImg = ImageIO.read(new File("Options.png"));
	    	options2Img = ImageIO.read(new File("Options2.png"));
			characterLeftImg = ImageIO.read(new File("CharacterLeft2.png"));
			characterRightImg = ImageIO.read(new File("CharacterRight2.png"));
	    } catch (IOException e) {}
		
	    	
	}
	public void draw(Graphics g)
	{
		if(visible)
		{
			g.drawImage(menuImg,0,0,null);
			g.drawImage(startImg,x,y,null);
			g.drawImage(cntrlImg,x,y+100,null);
			//g.drawImage(optionsImg,x,y+200,null);
			g.drawImage(characterRightImg,500,10,null);
			g.drawImage(characterLeftImg,450,10,null);
			g.drawImage(characterRightImg,500,220,null);
			g.drawImage(characterLeftImg,450,220,null);
			g.drawImage(characterRightImg,600,10,null);
			g.drawImage(characterLeftImg,550,10,null);
			g.drawImage(characterRightImg,600,220,null);
			g.drawImage(characterLeftImg,550,220,null);
			g.drawImage(characterRightImg,700,10,null);
			g.drawImage(characterLeftImg,650,10,null);
			g.drawImage(characterRightImg,700,220,null);
			g.drawImage(characterLeftImg,650,220,null);
			
		}
	}
	
    public int checkCollision(int xInput, int yInput,Graphics g)
    {
        
        if( xInput>= x && xInput <= x + width )
        {
			//START BUTTON
            if( yInput>= y && yInput <= y + height )
            {
				g.drawImage(start2Img,x,y,null);
			
                return 1;
            }
			//CONTROLS BUTTON
            if( yInput>= y+100 && yInput <= y+100 + height )
            {
				g.drawImage(cntrl2Img,x,y+100,null);
			
                return 2;
            }
			
			
        }
 
     
        //otherwise return false as the default case.
        return -1;
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