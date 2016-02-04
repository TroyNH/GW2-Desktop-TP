package bigJava;

public class Ex3_1 
{
	public static void main(String args[])
	{
		VaultODoom gold= new VaultODoom(1000, 10);
		for(int i = 0; i<5; i++)
		{
			gold.compoundDoubloons();
		}
		System.out.println("YARRR, ye have " + (int)gold.stackOGold + " doubloons remainin'!");
	}
}