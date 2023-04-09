/**
*@author Shawn Bearam Jr
*/

public class TreeNode<T> extends Object
{
	protected T data = null;
	protected TreeNode<T> leftN;
	protected TreeNode<T> rightN;
	
	TreeNode(T dataNode)
	{
		this.data = dataNode;
		leftN = null;
		rightN = null;
	}
	
	TreeNode(TreeNode<T> node)
	{
		leftN = new TreeNode(node.leftN.data);
		rightN = new TreeNode(node.rightN.data);
		this.data = node.data;
	}
	
	public T getData()
	{
		return this.data;
	}
}
