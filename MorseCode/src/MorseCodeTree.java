/**
*@author Shawn Bearam Jr
*/

import java.util.*;

public class MorseCodeTree extends Object implements LinkedConverterTreeInterface<String>
{
	protected TreeNode<String> root;
	MorseCodeTree()
	{
		buildTree();
	}
	
	public TreeNode<String> getRoot()
	{
		return this.root;
	}
	
	public void setRoot(TreeNode<String> newNode)
	{
		this.root = new TreeNode<String>(newNode);
	}
	
	public void insert(String code, String letter)
	{
		if(root != null)
		{
			addNode(this.root, code, letter);
		}
		
	}
	
	public void addNode(TreeNode<String> root, String code, String letter)
	{
		if(code.length() == 1)
		{
			switch(code.charAt(0))
			{
				case '.': root.leftN = new TreeNode<String>(letter);
				case '-': root.rightN = new TreeNode<String>(letter);
			}
		}
		else
		{
			if(code.charAt(0) == '.')
			{
				addNode(root.leftN, code.substring(1), letter);
			}
			else if(code.charAt(0) == '-')
			{
				addNode(root.rightN, code.substring(1), letter);
			}
		}
	}
	
	public String fetch(String code)
	{
		//System.out.println("Fetch: " + fetchNode(this.root,code));
		return fetchNode(this.root, code);
	}
	
	public String fetchNode(TreeNode<String> root, String code)
	{
		//System.out.println("Code: " + code);
		if(code.length() == 1)
		{
			switch (code.charAt(0))
			{
				case '.': 
					//System.out.println("Letter: " + root.leftN.getData());
					return root.leftN.getData();
				case '-': 
					//System.out.println("Letter: " + root.rightN.getData());
					return root.rightN.getData();
			}
		}
		else if(code.length() > 1)
		{
			if(code.charAt(0) == '.')
			{
				return fetchNode(root.leftN, code.substring(1));
			}
			else if(code.charAt(0) == '-')
			{
				return fetchNode(root.rightN, code.substring(1));
			}
		}
		return "";
		
	}
	
	public MorseCodeTree delete(String data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	
	public MorseCodeTree update() throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	
	public void buildTree()
	{
		root = new TreeNode<String>("");
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
		
	}
	
	public ArrayList<String> toArrayList()
	{
		ArrayList<String> list = new ArrayList<>();
		LNRoutputTraversal(this.root, list);
		return list;
	}
	
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list)
	{
		if(root == null)
		{
			return;
		}
		else if(root.leftN == null && root.rightN == null)
		{
			list.add(root.data);
			return;
		}
		else
		{
			if(root.leftN != null)
			{
				LNRoutputTraversal(root.leftN, list);
				list.add(root.data);
			}
			
			if(root.rightN != null && root.rightN.data != "f" && root.rightN.data != "l")
			{
				LNRoutputTraversal(root.rightN, list);
			}
		}
		return;
	}
}
