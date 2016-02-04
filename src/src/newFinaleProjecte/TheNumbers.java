package newFinaleProjecte;

import java.util.Random;

public class TheNumbers 
{
	Random rand = new Random();
	int max = 0;
	int numnumbers = 0;
	public TheNumbers(int k, int a)
	{
		max = k;
		numnumbers = a;
	}
	
	public int[] AllTheNumbers()
	{
		int six[] = new int[numnumbers];
		for(int k = 0; k < six.length; k++)
		{
			six[k] = rand.nextInt(max) + 1;
		}
		return six;
	}
}
