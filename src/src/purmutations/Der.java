package purmutations;

import java.util.ArrayList;

public class Der
{
	public int de (int x)
	{
		ArrayList<Integer> d = new ArrayList<Integer>();
		
		d.add (0);
		d.add (1);
		
		for (int k = 2; k < x; k++)
		{
			d.add (k * (d.get (k - 1) + d.get (k - 2)));
		}
		
		return d.get (x - 1);
	}
}
