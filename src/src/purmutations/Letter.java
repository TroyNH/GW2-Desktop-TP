package purmutations;

public class Letter
{
	char letter;
	
	int index;
	
	public Letter (char a, int b)
	{
		letter = a;
		
		index = b;
	}
	
	public char getLetter ()
	{
		return letter;
	}
	
	public int getIndex ()
	{
		return index;
	}
}
