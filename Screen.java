import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.lang.Object;
import java.util.ArrayList;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Screen extends JPanel
{

	private BufferedImage buffered;
	private BufferedImage bgImg;
	private ArrayList<Berries> blist;
	int hi2=1;
	Input input;
	Graphics gBuff;
	public boolean controlmenu=false;
	Room1 r1;
	Room2 r2;
	Room3 r3;
	Room4 r4;
	Room5 r5;
	Room6 r6;
	Room7 r7;
	Room8 r8;
	Character character;
	public boolean character2=true;
	public boolean movable; 
	public boolean r1computer=false;
	int hi=0;
	int hi3=1;
	int hi4=1;
	int hi5=1;
	int hi6=1;
	int hi7=1;
	int hi8=1;
	int hi16=1;
	int hi17=1;
	int hi10=0;
	int hi11=0;
	int hi14=0;
	int hi15=0;
	int hi20=0;
	public boolean hi12=true;
	public boolean hi13=true;
	public boolean addhat=false;
	public boolean addglasses=false;
	public boolean addshoes=false;
	String password2="";
	String password3="";
	String password4="";
	String password5="";
	String password6="";
	String inputValue;
	boolean newDay=true;
	
	public boolean r5talk=false;
	public boolean character21;
	public boolean character12;
	public boolean character23;
	public boolean character32;
	public boolean character34;
	public boolean character43;
	public boolean character45;
	public boolean character54;
	public boolean character56;
	public boolean character65;
	public boolean character67;
	public boolean character76;
	public boolean character78;
	public boolean character87;
	
	private boolean startMenu;
	private boolean room1;
	private boolean room2;
	private boolean room3;
	private boolean room4;
	private boolean shop=false;
	private boolean shoproom4;
	private boolean casino=false;
	private boolean casinoroom4;
	private boolean room5;
	private boolean room6;
	private boolean room7;
	private boolean room8;
	private boolean r1intro=true;
	
	private BufferedImage room3Img;
	private BufferedImage shopImg;
	private BufferedImage casinoImg;
	private BufferedImage controlMenuImg;
	private BufferedImage backImg;
	private BufferedImage back2Img;
	
	public boolean ctrue=false;
	public boolean atrue=false;
	public boolean strue=false;
	public boolean dtrue=false;
	public boolean qtrue=false;
	public boolean wtrue=false;
	public boolean etrue=false;
	public boolean ttrue=false;
	
	public boolean momWord=false;
	
	private int debugCount=0;
	ArrayList<Items> list=new ArrayList<Items>();
	
	public Screen()
    {
		input=new Input(this);
		setFocusable(true);
		startMenu=true;
		this.playSound();
		try
	    {
			room3Img = ImageIO.read(new File("Room3(2).png"));
			controlMenuImg = ImageIO.read(new File("ControlsMenu.png"));
			shopImg = ImageIO.read(new File("Shop.png"));
			casinoImg = ImageIO.read(new File("Gambling.png"));
			backImg = ImageIO.read(new File("Back.png"));
			back2Img = ImageIO.read(new File("Back2.png"));
	    } catch (IOException e) {}
	}
	public Dimension getPreferredSize() 
    {
        //Sets the size of the panel
        return new Dimension(1000,700);
    }
     
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        //Create Buffered
        if( buffered == null )
        {
            buffered = (BufferedImage)(createImage( getWidth(), getHeight() ) );
        }
		//System.out.println("count : "+(debugCount++)+"Movable : "+movable);
        //Create a temporary graphics buffered to draw
        gBuff = buffered.createGraphics();
		gBuff.drawRect(0,0,1000,700);
		if(startMenu)
		{
			Start s=new Start();
			s.draw(gBuff);
			int option=s.checkCollision(Input.x,Input.y,gBuff);
			
			if(option==1 && Input.clicked)
			{
				room1=true;
				character=new Character();
				startMenu=false;
			}
			if(option==2 && Input.clicked)
			{
				controlmenu=true;
				startMenu=false;
			}
		}
		if(controlmenu)
		{
			gBuff.drawImage(controlMenuImg,0,0,null);
			gBuff.drawImage(backImg,800,210,null);
			if(Input.x>805 && Input.x<950 && Input.y>217 && Input.y<280)
			{
				gBuff.drawImage(back2Img,800,210,null);
			}
			if(Input.x>805 && Input.x<950 && Input.y>217 && Input.y<280 && Input.clicked)
			{
				controlmenu=false;
				startMenu=true;
			}
		}
		if(Input.keyboard[80] && hi12==true)
		{
			hi12=false;
			hi11=0;
			hi10=1;
			try{
				password3 = JOptionPane.showInputDialog("Cheat Code:");
				if(password3 == null){
					password3="";
				}
			}
			catch (NumberFormatException e)
			{
			    System.err.println("Error: Invalid Input!");
			    JOptionPane.showMessageDialog(null, "Error: Invalid Input!",  
			    "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(password3.equals("moneyadd") && hi11==0)
		{
			hi11=1;
			GameManager.addMoney(100);
		}
		if(password3.equals("moneyadd") && hi11==0)
		{
			hi11=1;
			GameManager.addMoney(100);
		}
		if(Input.keyboard[80]==false)
		{
			hi12=true;
		}
		///////////////////////////////////////////
		///////////////    ROOM 1    //////////////
		if(room1)
		{
			if(hi4==1){
				hi4=0;
				r1=new Room1();
			}
			r1.draw(gBuff);
			character.draw(gBuff,list);
			if(r1intro)
			{
				movable=false;
				this.drawNarrator(gBuff);
				Font arial30=new Font("Arial", Font.PLAIN, 30);
				gBuff.setColor(Color.black);
				gBuff.setFont(arial30);
				gBuff.drawString("Hmmmm..last night was crazy..I cant seem to remember anything",30,30);
				gBuff.drawString("about my life..lets see if I logged it in my computer       [c] to continue",30,60);
				if(Input.keyboard[67])
				{
					r1intro=false;
					movable=true;
				}
				
			}
			
			boolean r1collision=r1.checkCollision(character.getX(),character.getY(),gBuff);
			if(r1collision && Input.keyboard[88])
			{
				
				
				if(r1computer)
				{
					this.drawNarrator(gBuff);
					Font arial30=new Font("Arial", Font.PLAIN, 30);
					gBuff.setColor(Color.black);
					gBuff.setFont(arial30);
					gBuff.drawString("Talk to your mother in the next room to collect your daily allowance...",30,30);
					gBuff.drawString("every day is 3 minutes in real time",30,60);
					movable=true;
				}
				
				if(hi==0)
				{
					System.out.println("Show Dialog");
					hi=1;
					try{
						password2 = JOptionPane.showInputDialog("Password: MVHS Mascot");
						if(password2 == null){
							password2="";
							movable=true;
							hi=0;
						}
					}
					catch (NumberFormatException e)
					{
					    System.err.println("Error: Invalid Input!");
					    JOptionPane.showMessageDialog(null, "Error: Invalid Input!",  
					    "Error", JOptionPane.ERROR_MESSAGE);
					}
					System.out.println(password2);
					if(password2.equals(""))
					{
						movable=true;
					}
					if((password2.equals("Spartans")) || password2.equals("Spartan") || password2.equals("spartan") || password2.equals("spartans"))
					{
						r1computer=true;
					}
					
				}
			}
			if(character.getX()>990)
			{
				room2=true;
				room1=false;
				character12=true;
			}
			if(character21)
			{
				character.setX(990);
				character.setY(340);
				character21=false;
			}
		}
		///////////////////////////////////////////////////
		/////////////////////   ROOM 2   //////////////////
		if(room2)
		{
			if(character12)
			{
				momWord=true;
				character.setX(10);
				character.setY(340);
				character12=false;
			}
			if(character32)
			{
				momWord=true;
				character.setX(990);
				character.setY(340);
				character32=false;
			}
			if(hi3==1){
				hi3=0;
					r2=new Room2();
			}
			r2.draw(gBuff);
			character.draw(gBuff,list);
			boolean r2collision=r2.checkCollision(character.getX(),character.getY(),gBuff);
			if(newDay)
			{
				momWord=false;
			}
			if(r2collision && Input.keyboard[88])
			{
				movable=false;
				this.drawNarrator(gBuff);
				Font arial30=new Font("Arial", Font.PLAIN, 30);
				gBuff.setColor(Color.black);
				gBuff.setFont(arial30);
				if(momWord==false)
				{
					gBuff.drawString("Here is your daily allowance...spend it wisely",30,30);
					gBuff.drawString("maybe you should head out to the store",30,60);
				}
				if(newDay)
				{
					
					GameManager.addMoney(30);
					newDay=false;
				}
				if(newDay==false && momWord )
				{
					gBuff.drawString("Greedy little boy! I already gave you your",30,30);
					gBuff.drawString("allowance!",30,60);
				}
				movable=true;
				
			}
			
			if(character.getX()<10)
			{
				character21=true;
				room1=true;
				room2=false;
			}
			if(character.getX()>990)
			{
				character23=true;
				room3=true;
				room2=false;
			}
		}
		
		//////////////////////////////////////////////////////////////
		///////////////////////    ROOM 3      ///////////////////////
		if(room3)
		{
			if(character23)
			{
				character.setX(10);
				character.setY(340);
				character23=false;
			}
			if(character43)
			{
				character.setX(990);
				character.setY(340);
				character43=false;
			}
			if(hi2==1)
			{
				hi2=0;
				r3=new Room3();
			}
			r3.draw(gBuff);
			character.draw(gBuff,list);
		
			gBuff.drawImage(room3Img,448,315,null);
		
			
			if(character.getX()<10)
			{
				character32=true;
				room2=true;
				room3=false;
			}
			if(character.getX()>990)
			{
				character34=true;
				room4=true;
				room3=false;
			}
		}
		
		///////////////////////////////////////////////////
		/////////////////////   ROOM 4   //////////////////
		if(room4)
		{
			if(shoproom4)
			{
				character.setX(420);
				character.setY(340);
				shoproom4=false;
			}
			if(shoproom4)
			{
				character.setX(880);
				character.setY(340);
				casinoroom4=false;
			}
			if(character34)
			{
				character.setX(10);
				character.setY(340);
				character34=false;
			}
			if(character54)
			{
				character.setX(990);
				character.setY(340);
				character54=false;
			}
			if(hi5==1){
				hi5=0;
					r4=new Room4();
			}
			r4.draw(gBuff);
			character.draw(gBuff,list);
			
			boolean r4collision1=r4.checkCollision1(character.getX(),character.getY(),gBuff);
			
			if(r4collision1 && Input.keyboard[88])
			{
				shop=true;
				room4=false;
			}
			
			
			if(character.getX()<10)
			{
				character43=true;
				room3=true;
				room4=false;
			}
			if(character.getX()>990)
			{
				character45=true;
				room5=true;
				room4=false;
			}
		}
		/////////////// SHOP ////////////////////
		if(shop)
		{
			gBuff.drawImage(shopImg,0,0,null);
			Font arial30=new Font("Arial", Font.PLAIN, 30);
			gBuff.setColor(Color.white);
			gBuff.setFont(arial30);
			gBuff.drawString("[c] to exit shop          press the assigned number to buy the item",50,650);
			gBuff.drawString("TopHat : $20 [1]",150,200);
			gBuff.drawString("Hypnotizing Glasses : $30 [2]",470,200);
			gBuff.drawString("Speed Shoes : $40 [4]",470,460);
			if(Input.keyboard[67])
			{
				shop=false;
				shoproom4=true;
				room4=true;
			}
			if(Input.keyboard[49] && addhat==false)
			{
				if(GameManager.money>=20)
				{
					TopHat hat=new TopHat();
					list.add(hat);
					GameManager.subtractMoney(20);
				}
				else{
					gBuff.setColor(Color.green);
					gBuff.drawString("NOT ENOUGH MONEY",50,490);
				}
				addhat=true;
			}
			if(Input.keyboard[50] && addglasses==false)
			{
				if(GameManager.money>=30)
				{
					System.out.println("HIHHIHHIHIHIHII");
					Glasses glasses=new Glasses();
					list.add(glasses);
					GameManager.subtractMoney(30);
				}
				else{
					gBuff.setColor(Color.green);
					gBuff.drawString("NOT ENOUGH MONEY",50,490);
				}
				addglasses=true;
			}
			if(Input.keyboard[52] && addshoes==false)
			{
				if(GameManager.money>=40)
				{
					Shoes shoes=new Shoes();
					list.add(shoes);
					GameManager.subtractMoney(40);
				}
				else{
					gBuff.setColor(Color.green);
					gBuff.drawString("NOT ENOUGH MONEY",50,490);
				}
				addshoes=true;
			}
		}
		
		
		
		///////////////////////////////////////////////////
		/////////////////////   ROOM 5   //////////////////
		if(room5)
		{
			if(character45)
			{
				character.setX(10);
				character.setY(340);
				character45=false;
			}
			if(character56)
			{
				character.setX(990);
				character.setY(340);
				character56=false;
			}
			if(hi6==1){
				hi6=0;
					r5=new Room5();
			}
			r5.draw(gBuff);
			character.draw(gBuff,list);
			
			boolean r5collision=r5.checkCollision(character.getX(),character.getY(),gBuff);
			Font arial30=new Font("Arial", Font.PLAIN, 30);
			gBuff.setColor(Color.black);
			gBuff.setFont(arial30);
			if(r5collision==false)
			{
				ctrue=false;
				atrue=false;
				strue=false;
				dtrue=false;
				qtrue=false;
				wtrue=false;
				etrue=false;
				hi13=true;
			}
			if(r5collision)
			{
				this.drawNarrator(gBuff);
				gBuff.setColor(Color.black);
				gBuff.drawString("Ill need $40 for my knowledge...you also need to pass my special quiz",30,30);
				gBuff.drawString("[c] to pay up   [v] to spit in his face   [b] to politely decline",30,60);
				if((Input.keyboard[67] && GameManager.money>=40) || ctrue)
				{
					ctrue=true;
					if(hi13==true)
					{
						GameManager.subtractMoney(40);
						hi13=false;
					}
					this.drawNarrator(gBuff);
					gBuff.setColor(Color.black);
					gBuff.drawString("Alright...thanks for the money...first question is: What is 9+10?",30,30);
					gBuff.drawString("[a] 255   [s] 21   [d] 19",30,60);
					if(Input.keyboard[65] || atrue)
					{
						atrue=true;
						this.drawNarrator(gBuff);
						gBuff.setColor(Color.black);
						gBuff.drawString("You are not worthy of my knowledge...",30,30);
					}
					if(Input.keyboard[83] || strue)
					{
						strue=true;
						this.drawNarrator(gBuff);
						gBuff.setColor(Color.black);
						gBuff.drawString("Kids these days...please leave",30,30);
					}
					if(Input.keyboard[68] || dtrue)
					{
						dtrue=true;
						this.drawNarrator(gBuff);
						gBuff.setColor(Color.black);
						gBuff.drawString("CORRECT! ok next...: How does one fly?",30,30);
						gBuff.drawString("[q] drink Red Bull  [w] buy Air Jordans   [e] buy a plane ticket",30,60);
						if(Input.keyboard[81] || qtrue)
						{
							qtrue=true;
							this.drawNarrator(gBuff);
							gBuff.setColor(Color.black);
							gBuff.drawString("Some people believe everything...get away from me",30,30);
						}
						if(Input.keyboard[87] || wtrue)
						{
							wtrue=true;
							this.drawNarrator(gBuff);
							gBuff.setColor(Color.black);
							gBuff.drawString("Grow up and open your eyes this is the real world kid",30,30);
						}
						if(Input.keyboard[69] || etrue)
						{
							etrue=true;
							this.drawNarrator(gBuff);
							gBuff.setColor(Color.black);
							gBuff.drawString("CORRECT! ok you passed..the password to my buddy is: Turnip",30,30);
						}
					}
				}
				if(Input.keyboard[67] && GameManager.money<40)
				{
					this.drawNarrator(gBuff);
					gBuff.setColor(Color.black);
					gBuff.drawString("Sorry you dont have enough money for me...",30,30);
				}
				if(Input.keyboard[86])
				{
					this.drawNarrator(gBuff);
					gBuff.setColor(Color.black);
					gBuff.drawString("*he punches you and takes the rest of your money*",30,30);
					GameManager.subtractMoney(GameManager.money);
				}
				if(Input.keyboard[66])
				{
					this.drawNarrator(gBuff);
					gBuff.setColor(Color.black);
					gBuff.drawString("ok when you want my knowledge let me know",30,30);
				}
			}
			
			
			
			if(character.getX()<10)
			{
				character54=true;
				room4=true;
				room5=false;
			}
			if(character.getX()>990)
			{
				character56=true;
				room6=true;
				room5=false;
			}
		}
		//////////////// rooom 6 ////////////////////////////////
		///////////////////////////////////////////////////////
		if(room6)
		{
			if(character56)
			{
				character.setX(10);
				character.setY(340);
				character56=false;
			}
			if(character76)
			{
				character.setX(990);
				character.setY(340);
				character76=false;
			}
				
			if(hi7==1){
				hi7=0;
					r6=new Room6();
			}
			r6.draw(gBuff);
			character.draw(gBuff,list);
			
			boolean r6collision=r6.checkCollision(character.getX(),character.getY(),gBuff);
			Font arial30=new Font("Arial", Font.PLAIN, 30);
			gBuff.setColor(Color.black);
			gBuff.setFont(arial30);
			if(r6collision==false)
			{
				ctrue=false;
				atrue=false;
				strue=false;
				dtrue=false;
				qtrue=false;
				wtrue=false;
				etrue=false;
				hi13=true;
				hi14=0;
			}
			if(r6collision)
			{
				this.drawNarrator(gBuff);
				gBuff.setColor(Color.black);
				gBuff.drawString("I only talk to people dressed nicely with the password...",30,30);
				gBuff.drawString("[c] to enter password   [v] to spit in his face   [b] to politely decline",30,60);
				int hatcorrect=0;
				for(int i=0; i<list.size(); i++)
				{
					if(list.get(i).getNum()==1)
					{
						hatcorrect=1;
					}
					
				}
				if(Input.keyboard[67] && hi14==0)
				{
					hi14=1;
					try{
						password4 = JOptionPane.showInputDialog("Password:");
						if(password4 == null){
							password4="";
						}
					}
					catch (NumberFormatException e)
					{
						System.err.println("Error: Invalid Input!");
						JOptionPane.showMessageDialog(null, "Error: Invalid Input!",  
							"Error", JOptionPane.ERROR_MESSAGE);
					}
					hatcorrect=1;
				}
				if((Input.keyboard[67] && hatcorrect==1 && password4.equals("Turnip")) || ctrue)
				{
					
					ctrue=true;
					
					this.drawNarrator(gBuff);
					gBuff.setColor(Color.black);
					gBuff.drawString("Alright...nice hat!...first question is: What is 9+0*2?",30,30);
					gBuff.drawString("[a] 18   [s] 9   [d] 11",30,60);
					if(Input.keyboard[65] || atrue)
					{
						atrue=true;
						this.drawNarrator(gBuff);
						gBuff.setColor(Color.black);
						gBuff.drawString("You are not worthy of my knowledge...",30,30);
					}
					if(Input.keyboard[68] || strue)
					{
						dtrue=true;
						this.drawNarrator(gBuff);
						gBuff.setColor(Color.black);
						gBuff.drawString("Kids these days...please leave",30,30);
					}
					if(Input.keyboard[83] || dtrue)
					{
						strue=true;
						this.drawNarrator(gBuff);
						gBuff.setColor(Color.black);
						gBuff.drawString("CORRECT! ok next...: Kanye West or Leo Messi?",30,30);
						gBuff.drawString("[q] Kanye is da best#win  [w] I dont care   [e] Leo",30,60);
						if(Input.keyboard[81] || qtrue)
						{
							qtrue=true;
							this.drawNarrator(gBuff);
							gBuff.setColor(Color.black);
							gBuff.drawString("Some people believe everything...get away from me",30,30);
						}
						if(Input.keyboard[87] || wtrue)
						{
							wtrue=true;
							this.drawNarrator(gBuff);
							gBuff.setColor(Color.black);
							gBuff.drawString("Grow up and open your eyes this is the real world kid",30,30);
						}
						if(Input.keyboard[69] || etrue)
						{
							etrue=true;
							this.drawNarrator(gBuff);
							gBuff.setColor(Color.black);
							gBuff.drawString("CORRECT! ok you passed..the password to my buddy is: Carrot",30,30);
						}
					}
				}
				if(Input.keyboard[67] && !password4.equals("Turnip"))
				{
					this.drawNarrator(gBuff);
					gBuff.setColor(Color.black);
					gBuff.drawString("Sorry you dont have enough money for me...",30,30);
				}
				if(Input.keyboard[86])
				{
					this.drawNarrator(gBuff);
					gBuff.setColor(Color.black);
					gBuff.drawString("*he punches you and takes the rest of your money*",30,30);
					GameManager.subtractMoney(GameManager.money);
				}
				if(Input.keyboard[66])
				{
					this.drawNarrator(gBuff);
					gBuff.setColor(Color.black);
					gBuff.drawString("ok when you want my knowledge let me know",30,30);
				}
			}
			
			
			
			if(character.getX()<10)
			{
				character65=true;
				room5=true;
				room6=false;
			}
			if(character.getX()>990)
			{
				character67=true;
				room7=true;
				room6=false;
			}
		}
		
		//////////////// rooom 7 ////////////////////////////////
		///////////////////////////////////////////////////////
		if(room7)
		{
			if(character67)
			{
				character.setX(10);
				character.setY(340);
				character67=false;
			}
			if(character87)
			{
				character.setX(990);
				character.setY(340);
				character87=false;
			}
				
			if(hi16==1){
				hi16=0;
					r7=new Room7();
			}
			r7.draw(gBuff);
			character.draw(gBuff,list);
			
			boolean r7collision=r7.checkCollision(character.getX(),character.getY(),gBuff);
			Font arial30=new Font("Arial", Font.PLAIN, 30);
			gBuff.setColor(Color.black);
			gBuff.setFont(arial30);
			if(r7collision==false)
			{
				ctrue=false;
				atrue=false;
				strue=false;
				dtrue=false;
				qtrue=false;
				wtrue=false;
				etrue=false;
				hi13=true;
				hi14=0;
			}
			if(r7collision)
			{
				this.drawNarrator(gBuff);
				gBuff.setColor(Color.black);
				gBuff.drawString("I only talk to people with the password...",30,30);
				gBuff.drawString("[c] to enter password   [v] to spit in his face   [b] to politely decline",30,60);
	
				if(Input.keyboard[67] && hi15==0)
				{
					hi15=1;
					try{
						password5 = JOptionPane.showInputDialog("Password:");
						if(password5 == null){
							password5="";
						}
					}
					catch (NumberFormatException e)
					{
						System.err.println("Error: Invalid Input!");
						JOptionPane.showMessageDialog(null, "Error: Invalid Input!",  
							"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				if((Input.keyboard[67] && password5.equals("Carrot")) || ctrue)
				{
					
					ctrue=true;
					
					this.drawNarrator(gBuff);
					gBuff.setColor(Color.black);
					gBuff.drawString("Alright...first question is: What is a mouse?",30,30);
					gBuff.drawString("[a] mammal   [s] reptile   [d] rat",30,60);
					if(Input.keyboard[83] || strue)
					{
						strue=true;
						this.drawNarrator(gBuff);
						gBuff.setColor(Color.black);
						gBuff.drawString("You are not worthy of my knowledge...",30,30);
					}
					if(Input.keyboard[68] || dtrue)
					{
						dtrue=true;
						this.drawNarrator(gBuff);
						gBuff.setColor(Color.black);
						gBuff.drawString("Kids these days...please leave",30,30);
					}
					if(Input.keyboard[65] || atrue)
					{
						atrue=true;
						this.drawNarrator(gBuff);
						gBuff.setColor(Color.black);
						gBuff.drawString("CORRECT! ok next...: What is Durian?",30,30);
						gBuff.drawString("[q] an animal  [w] a fruit   [e] an ore",30,60);
						if(Input.keyboard[81] || qtrue)
						{
							qtrue=true;
							this.drawNarrator(gBuff);
							gBuff.setColor(Color.black);
							gBuff.drawString("Some people believe everything...get away from me",30,30);
						}
						if(Input.keyboard[69] || etrue)
						{
							etrue=true;
							this.drawNarrator(gBuff);
							gBuff.setColor(Color.black);
							gBuff.drawString("Grow up and open your eyes this is the real world kid",30,30);
						}
						if(Input.keyboard[87] || wtrue)
						{
							wtrue=true;
							this.drawNarrator(gBuff);
							gBuff.setColor(Color.black);
							gBuff.drawString("CORRECT! ok you passed..I know someone who knows",30,30);
							gBuff.drawString("what happened...tell him Jared sent you",30,60);
						}
					}
				}
				if(Input.keyboard[67] && !password5.equals("Carrot"))
				{
					this.drawNarrator(gBuff);
					gBuff.setColor(Color.black);
					gBuff.drawString("Sorry you dont have enough money for me...",30,30);
				}
				if(Input.keyboard[86])
				{
					this.drawNarrator(gBuff);
					gBuff.setColor(Color.black);
					gBuff.drawString("*he punches you and takes the rest of your money*",30,30);
					GameManager.subtractMoney(GameManager.money);
				}
				if(Input.keyboard[66])
				{
					this.drawNarrator(gBuff);
					gBuff.setColor(Color.black);
					gBuff.drawString("ok when you want my knowledge let me know",30,30);
				}
			}
			
			
			
			if(character.getX()<10)
			{
				character76=true;
				room6=true;
				room7=false;
			}
			if(character.getX()>990)
			{
				character78=true;
				room8=true;
				room7=false;
			}
		}
		
		////////////////////////////////////////////////
		//////////////ROOM 8 ///////////////////////
		if(room8)
		{
			if(character78)
			{
				character.setX(10);
				character.setY(340);
				character78=false;
			}
			
				
			if(hi17==1){
				hi17=0;
					r8=new Room8();
			}
			r8.draw(gBuff);
			character.draw(gBuff,list);
			
			boolean r8collision=r8.checkCollision(character.getX(),character.getY(),gBuff);
			Font arial30=new Font("Arial", Font.PLAIN, 30);
			gBuff.setColor(Color.black);
			gBuff.setFont(arial30);
			if(r8collision==false)
			{
				ctrue=false;
				atrue=false;
				strue=false;
				dtrue=false;
				qtrue=false;
				wtrue=false;
				etrue=false;
				hi13=true;
				hi14=0;
				ttrue=false;
			}
			if(r8collision)
			{
				this.drawNarrator(gBuff);
				gBuff.setColor(Color.black);
				gBuff.drawString("Who sent you!?",30,30);
				gBuff.drawString("[c] to enter name   [v] to spit in his face   [b] to politely decline",30,60);
	
				if(Input.keyboard[67] && hi20==0)
				{
					hi20=1;
					try{
						password6 = JOptionPane.showInputDialog("Password:");
						if(password6 == null){
							password6="";
						}
					}
					catch (NumberFormatException e)
					{
						System.err.println("Error: Invalid Input!");
						JOptionPane.showMessageDialog(null, "Error: Invalid Input!",  
							"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				if((Input.keyboard[67] && password6.equals("Jared")) || ctrue)
				{
					
					ctrue=true;
					
					this.drawNarrator(gBuff);
					gBuff.setColor(Color.black);
					gBuff.drawString("If you get these I will tell you your past...:what is 1+1?",30,30);
					gBuff.drawString("[a] 2   [s] 1   [d] 3",30,60);
					if(Input.keyboard[83] || strue)
					{
						strue=true;
						this.drawNarrator(gBuff);
						gBuff.setColor(Color.black);
						gBuff.drawString("You are not worthy of my knowledge...",30,30);
					}
					if(Input.keyboard[68] || dtrue)
					{
						dtrue=true;
						this.drawNarrator(gBuff);
						gBuff.setColor(Color.black);
						gBuff.drawString("Kids these days...please leave",30,30);
					}
					if(Input.keyboard[65] || atrue)
					{
						atrue=true;
						this.drawNarrator(gBuff);
						gBuff.setColor(Color.black);
						gBuff.drawString("CORRECT! ok next...: How do you peel a banana",30,30);
						gBuff.drawString("[q] chop it up  [w] upside down   [e] peel the top",30,60);
						if(Input.keyboard[81] || qtrue)
						{
							qtrue=true;
							this.drawNarrator(gBuff);
							gBuff.setColor(Color.black);
							gBuff.drawString("Some people believe everything...get away from me",30,30);
						}
						if(Input.keyboard[69] || etrue)
						{
							etrue=true;
							this.drawNarrator(gBuff);
							gBuff.setColor(Color.black);
							gBuff.drawString("Grow up and open your eyes this is the real world kid",30,30);
						}
						if(Input.keyboard[87] || wtrue)
						{
							wtrue=true;
							this.drawNarrator(gBuff);
							gBuff.setColor(Color.black);
							gBuff.drawString("CORRECT! ok you passed..Here is your past..",30,30);
							gBuff.drawString("[t] to continue",30,60);
							if(Input.keyboard[84] || ttrue)
							{
								ttrue=true;
								this.drawNarrator(gBuff);
								gBuff.setColor(Color.black);
								gBuff.drawString("You fell asleep and are still dreaming...thats why I",30,30);
								gBuff.drawString("look like this... [y] to continue",30,60);
								boolean ytrue=true;
								if(Input.keyboard[89] || ytrue)
								{
									ytrue=true;
									gBuff.fillRect(0,0,1000,700);
									gBuff.setColor(Color.white);
									gBuff.drawString("THE END.",350,300);
								}
							}
							
						}
					}
				}
				if(Input.keyboard[67] && !password6.equals("Jared"))
				{
					this.drawNarrator(gBuff);
					gBuff.setColor(Color.black);
					gBuff.drawString("Sorry you dont have enough money for me...",30,30);
				}
				if(Input.keyboard[86])
				{
					this.drawNarrator(gBuff);
					gBuff.setColor(Color.black);
					gBuff.drawString("*he punches you and takes the rest of your money*",30,30);
					GameManager.subtractMoney(GameManager.money);
				}
				if(Input.keyboard[66])
				{
					this.drawNarrator(gBuff);
					gBuff.setColor(Color.black);
					gBuff.drawString("ok when you want my knowledge let me know",30,30);
				}
			}
			
			
			
			if(character.getX()<10)
			{
				character87=true;
				room7=true;
				room8=false;
			}
			
		}
		
		
		
		
		
		
		///////////////////////////////////////////////////
		//////////////////////////////////////////////////
		Font arial30=new Font("Arial", Font.PLAIN, 30);
		gBuff.setColor(Color.black);
		gBuff.setFont(arial30);
		if(startMenu==false && controlmenu==false)
		{
			gBuff.drawString("$"+GameManager.money,10,160);
		}
		if(Input.keyboard[72])
		{
			GameManager.subtractMoney(1000);
			GameManager.addDay(1);
			
		} 
     	if(Input.keyboard[39] && movable) {
			character.moveRight(); 
			System.out.println("Character X: "+character.getX());
			System.out.println("Character Y: "+character.getY());
		}
		if(Input.keyboard[37] && movable){
			System.out.println("Left");
		    character.moveLeft();
			System.out.println("Character X: "+character.getX());
			System.out.println("Character Y: "+character.getY());
		}
		//draw the buffered image
        g.drawImage(buffered, 0, 0, null);
 
    } 
	public void drawNarrator(Graphics g)
	{
		Color bubble=new Color(219,233,255);
		g.setColor(bubble);
		g.fillOval(0,0,150,100);
		g.fillOval(75,0,150,100);
		g.fillOval(150,0,150,100);
		g.fillOval(225,0,150,100);
		g.fillOval(300,0,150,100);
		g.fillOval(375,0,150,100);
		g.fillOval(450,0,150,100);
		g.fillOval(525,0,150,100);
		g.fillOval(600,0,150,100);
		g.fillOval(675,0,150,100);
		g.fillOval(750,0,150,100);
		g.fillOval(825,0,150,100);
	}
	public void playSound()
	    {
          
	         try
	         {
	            URL url = this.getClass().getClassLoader().getResource("thermo.wav");
	            Clip clip = AudioSystem.getClip();
	            clip.open(AudioSystem.getAudioInputStream(url));
	            clip.start();
	         }
	         catch (Exception exc)
	         {
	             exc.printStackTrace(System.out);
	         }
	    }
	 public void animate()
    {
        int count = 0;
		
        //wait for .01 second
		while(true){
			try 
			{
				 Thread.sleep(5);
			} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
			}
				//System.out.println("Count: "+count);
			if(count/40000 ==1 && startMenu==false)
			{
				GameManager.dayCount++;
				newDay=true;
				count=0;
			}
			if(startMenu==false)
			{
				count++;
			}
				
			//repaint the graphics drawn
			repaint();
		}
		
	}
	
}