package purmutations;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Derange
{
	public Derange (String inp) throws IOException
	{
		//Establish file writer
		FileWriter fw = new FileWriter("C:\\temp_Troy\\PermDerange.out");
		PrintWriter output = new PrintWriter(fw);
		
		//Find loop limit
		Der limit = new Der();
		int temp = limit.de (inp.length());
		
		ArrayList<Letter> input = new ArrayList<Letter>();
		
		for (int c = 0; c < inp.length(); c++)
		{
			Letter let = new Letter (inp.charAt(c), c);
			
			input.add (let);
		}
		
		LinkedList<ArrayList<Letter>> allDer = doMath(input);
		
		Iterator<ArrayList<Letter>> iter = allDer.iterator();
		
		ArrayList<String> finalprint = new ArrayList<String>();
		
		
		while (iter.hasNext())
		{
			ArrayList<Letter> oneDer = iter.next();
			
			for (int j = 0; j < oneDer.size(); j++)
			{
				int indx1 = oneDer.get(j).getIndex();
				int indx2 = input.get(j).getIndex();
				
				if (indx1 == indx2)
				{
					iter.remove();
					break;
				}
			}
		}
		
		for (int l = 0; l < allDer.size(); l++)
		{
			ArrayList<Character> letters = new ArrayList<Character>();
			
			String word = "";
			
			for (int o = 0; o < allDer.get(l).size(); o++)
			{
				letters.add(allDer.get(l).get(o).getLetter());
			}
			
			for (int p = 0; p < letters.size(); p++)
			{
				word += letters.get(p);
			}
			
			finalprint.add(word);
		}
		
		//Print all to text file
		for (int k = 0; k < temp; k++)
		{
			output.println(finalprint.get(k));
		}
		
		//Close file writer
		fw.close();
		output.close();
		
		//Open text file
		Runtime run = Runtime.getRuntime();
		@SuppressWarnings("unused")
		Process proc = run.exec("C:\\Windows\\notepad.exe C:\\temp_Troy\\PermDerange.out");
	}
	
	//Recursion to create derangements
	public static LinkedList<ArrayList<Letter>> doMath (ArrayList<Letter> inp)
	{
		//Create ArrayList to store derangements
		LinkedList<ArrayList<Letter>> words = new LinkedList<ArrayList<Letter>>();
		
		//Base case
		if (inp.size() == 0)
		{
			words.add(inp);
			return words;
		}
		
		//Insert stray letter at every possible position except the one it was in before
		for (int k = 0; k < inp.size(); k++)
		{
			ArrayList<Letter> littleword = new ArrayList<Letter>();
			
			for (int c = 0; c < k; c++)
			{
				littleword.add(inp.get (c));
			}
			
			for (int v = k + 1; v < inp.size(); v++)
			{
				littleword.add(inp.get (v));
			}
			
			LinkedList<ArrayList<Letter>> littlewordperm = doMath(littleword);
			
			for (ArrayList<Letter> j: littlewordperm)
			{
				j.add(0, inp.get(k));
				words.add(j);
			}
		}
		
		return words;
	}
}
