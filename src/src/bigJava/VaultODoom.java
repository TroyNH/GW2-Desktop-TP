package bigJava;

public class VaultODoom 
{
	double stackOGold;
	double saltiness;
	public VaultODoom(double startinGold, double startinsaltiness)
	{
		stackOGold = startinGold;
		saltiness = startinsaltiness;
	}
	
	public void insertDoubloons(double shininess)
	{
		stackOGold += shininess;
	}
	
	public void claimDoubloons(double shininess)
	{
		stackOGold -= shininess;
	}
	
	public void compoundDoubloons()
	{
		stackOGold += stackOGold * (saltiness/100);
	}
	
	public double yerGold()
	{
		return stackOGold;
	}
}
