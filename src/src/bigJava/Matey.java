package bigJava;

public class Matey 
{
	String Name;
	int weeklyPlunder;
	public Matey(String name, int weeklyplunder)
	{
		Name = name;
		weeklyPlunder = weeklyplunder;
	}
	
	public String whatsyername()
	{
		return Name;
	}
	
	public int whatsyerplunder()
	{
		return weeklyPlunder;
	}
}
