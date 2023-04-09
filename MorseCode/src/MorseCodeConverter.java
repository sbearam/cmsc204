/**
*@author Shawn Bearam Jr
*/

import java.util.*;
import java.io.*;

public class MorseCodeConverter extends Object
{
	protected static MorseCodeTree mTree = new MorseCodeTree();

	public static String printTree()
	{
		ArrayList<String> tree = mTree.toArrayList();
		String fTree = "";
		for(String letter: tree)
		{
			fTree += letter + " ";
		}
		return fTree.trim();
	}
	
	public static String convertToEnglish(String code)
	{
		String m2E = "";
		String[] words;
		String[] letters;
		words = code.split("/");
		for(String word : words)
		{
			//System.out.println(word);
			letters = word.split(" ");
			for(String letter: letters)
			{
				//System.out.println("Letter # " + l + ": " + letters[l]);
				m2E = m2E + mTree.fetch(letter);
			}
			m2E += " ";
			//System.out.println("English: " + m2E);
		}
		return m2E.trim();
		
	}
	
	public static String convertToEnglish(File codeFile) throws FileNotFoundException
	{
		String code = "";
		String[] words;
		String[] letters;
		try
		{
			Scanner fileReader = new Scanner(codeFile);
			words = fileReader.nextLine().split("/");
			for(String word: words)
			{
				letters = word.split(" ");
				for(String letter: letters)
				{
					code += mTree.fetch(letter);
				}
				code += " ";
				fileReader.close();
			}
		}catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		
		return code.trim();
		
	}
}
