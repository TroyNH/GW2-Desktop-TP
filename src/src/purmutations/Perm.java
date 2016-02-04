package purmutations;

//This simply calculates the number of permutations so it knows how many print commands to issue
public class Perm
{
	public int per (int x)
	{
		int j = x;
		
		for (int k = 1; k < x; k++)
		{
			j = j * (x - k);
		}
		
		return j;
	}
}
