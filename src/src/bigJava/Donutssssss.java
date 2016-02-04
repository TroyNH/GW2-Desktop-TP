package bigJava;

import java.util.*;

public class Donutssssss 
{
	public static void main(String args [])
	{
		Scanner inp = new Scanner(System.in);
		int[] name = new int[20];
		double a = 0, b = 0, c = 0, d = 0;
		for(int n = 0; n < 20; n++)
		{
			System.out.println("Student " + (n+1) + "'s rating?");
			name[n] = inp.nextInt();
			if(name[n] < 1||name[n] > 4)
			{
				System.out.println("That is not a valid rating.");
				n--;
			}
		}
		for(int k:name)
		{
			if(k == 1)
			{
				a++;
			}
			else if(k == 2)
			{
				b++;
			}
			else if(k == 3)
			{
				c++;
			}
			else if(k == 4)
			{
				d++;
			}
		}
		System.out.println("Vote Percentage: 1's = " + Math.round((a / 20) * 100) + "% 2's = " + Math.round((b / 20) * 100) + "% 3's = " + Math.round((c / 20) * 100) + "% 4's = " + Math.round((d / 20) * 100) + "%");
		inp.close();
	}
}
