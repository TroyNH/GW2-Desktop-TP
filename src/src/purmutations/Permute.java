package purmutations;

import java.io.*;
import java.util.ArrayList;

public class Permute
{

	public Permute (String inp) throws IOException
	{
		//Establish file writer
		FileWriter fw = new FileWriter("C:\\temp_Troy\\PermDerange.out");
		PrintWriter output = new PrintWriter(fw);
		
		//Find loop limit
		Perm limit = new Perm();
		int temp = limit.per(inp.length());
		
		ArrayList<String> allPerm = doMath(inp);
		
		//Print all to text file
		for (int k = 0; k < temp; k++)
		{
			output.println(allPerm.get(k));
		}
		
		//Close file writer
		fw.close();
		output.close();
		
		//Open text file
		Runtime run = Runtime.getRuntime();
		@SuppressWarnings("unused")
		Process proc = run.exec("C:\\Windows\\notepad.exe C:\\temp_Troy\\PermDerange.out");	
	}

	//Recursion to create permutations
	public static ArrayList<String> doMath (String inp)
	{
		//Create ArrayList to store permutations of any size
		ArrayList<String> words = new ArrayList<String>();
		
		//Base case
		if (inp.length() == 0)
		{
			words.add(inp);
			return words;
		}
		
		//Insert stray letter at every possible position in the already permuted word. RECURSION!!! 
		for (int k = 0; k < inp.length(); k++)
		{
			String littleword = inp.substring(0, k) + inp.substring(k + 1);
			
			ArrayList<String> littlewordperm = doMath(littleword);
			
			for (String j: littlewordperm)
			{
				words.add(inp.charAt(k) + j);
			}
		}
		
		return words;
	}
}
