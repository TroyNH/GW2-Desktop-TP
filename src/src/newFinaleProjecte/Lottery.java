package newFinaleProjecte;

import java.math.BigInteger;
import java.util.*;

public class Lottery 
{
	public static void main(String args [])
	{
		Scanner inp = new Scanner(System.in);
		BigInteger days = BigInteger.valueOf(0);
		int max = 4; //maximum value of lottery numbers.
		int numnumbers = 6; //number of numbers to select and generate.
		int yournums[] = new int[numnumbers]; //stores the values of the selected numbers.
		int allthenums[] = new int[numnumbers]; //stores the values of the randomly generated numbers.
		TheNumbers thenums = new TheNumbers(max, numnumbers); 
		Boolean doesmatch = false;
		System.out.println("Please enter your six preferred lottery numbers between 1 and " + max + ".");
		for(int k = 0; k < yournums.length; k++)
		{
			yournums[k] = inp.nextInt();
			if(yournums[k] > max || yournums[k] < 1)
			{
				System.out.println("That number is not valid, please enter a valid number.");
				k--;
			}
		}
		while(!doesmatch)
		{
			for(int j = 0; j < yournums.length; j++)
			{
				System.out.print(yournums[j] + " ");
			}
			System.out.print("/ ");
			for(int j = 0; j < yournums.length; j++)
			{
				allthenums[j] = thenums.AllTheNumbers()[j];
				System.out.print(allthenums[j] + " ");
				if(j == yournums.length - 1)
				{
					System.out.print("\t Day " + days + ".");
					System.out.print("\n");
				}
			}
			for(int k = 0; k < yournums.length; k++)
			{
				if(yournums[k] == allthenums[k])
				{
					doesmatch = true;
				}
				else
				{
					doesmatch = false;
					break;
				}
			}
			days = days.add(BigInteger.valueOf(1));
		}
		System.out.println("Congratulations, your numbers have been selected.");
		inp.close();
	}
}
