package bigJava;

import java.util.Random;
import java.util.Scanner;

public class DiceDiceBabyTwoCold 
{
	public static void main(String args [])
	{
		Scanner inp = new Scanner(System.in);
		int numDoice;
		int sides;
		System.out.println("Number of rolls?");
		numDoice = inp.nextInt();
		System.out.println("Number of sides on dice?");
		sides = inp.nextInt();
		Random rannum = new Random();
		int[] rolltype = new int[sides];
		int[] doice = new int[numDoice];
		for(int n = 0; n < numDoice; n++)
		{
			doice[n] = rannum.nextInt(sides)+1;
			rolltype[doice[n] - 1]++;
		}
		for(int p = 0; p < sides; p++)
		{
			if(p > 0)
			{
				System.out.print(" ");
			}
			System.out.print((p+1) + "'s = " + rolltype[p]);
		}
		inp.close();
	}
	
}
