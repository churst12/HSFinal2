public class GameManager
{
	public static int dayCount=0;
	public static int money=0;
	
	private GameManager()
	{
		
	}
	public static int getDay()
	{
		return dayCount;
	}
	public static int getMoney()
	{
		return money;
	}
	public static void reset()
	{
		dayCount=0;
	}
	public static void addMoney(int x)
	{
		money=money+x;
	}
	public static void subtractMoney(int x)
	{
		money=money-x;
	}
	public static void addDay(int x)
	{
		dayCount=dayCount+x;
	}
}
