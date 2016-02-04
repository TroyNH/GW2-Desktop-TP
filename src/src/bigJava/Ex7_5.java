package bigJava;

import java.math.BigInteger;
import java.util.*;

public class Ex7_5 
{
	public static void main(String args [])
	{
		Scanner inp = new Scanner(System.in);
		System.out.println("Please enter the number of terms you wish to see of the Fibonacci Sequence");
		int term = inp.nextInt();
		BigInteger f1 = BigInteger.valueOf(1);
		BigInteger f2 = BigInteger.valueOf(1);
		BigInteger f3;
		System.out.println("The 1st term is 1");
		System.out.println("The 2nd term is 1");
		System.out.println("The 3rd term is 2");
		for(int n=0; (n+4)<=term; n++)
		{
			f3 = f1.add(f2);
			f1 = f2;
			f2 = f3;
			System.out.println("The " + (n+4) + getSuffix(n+4) + " term is " + f3);
		}
		inp.close();
	}
	public static String getSuffix(int n)
	{
		if((n)>20&&(n)%10==1)
		{
			return "st";
		}
		else if((n)>20&&(n)%10==2)
		{
			return "nd";
		}
		else if((n)>20&&(n)%10==3)
		{
			return "rd";
		}
		else
		{
			return "th";
		}
	}
}
