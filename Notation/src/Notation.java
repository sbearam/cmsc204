import java.util.*;

public class Notation extends Object
{
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException
	{
		MyStack<String> myStack = new MyStack<String>();
		char[] newPostfix = postfixExpr.toCharArray();
		char currChar = ' ';
		//double evaluated = 0;
		String firstValue = " ";
		String secondValue = " ";
		double firstV = 0;
		double secondV = 0;
		double result = 0;
		try
		{
			for(int i = 0; i < newPostfix.length; i++)
			{
				currChar = newPostfix[i];
				if(currChar == ' ')
				{
					continue;
				}
				if(!isOp(currChar) || currChar == '(')
				{
					myStack.push(String.valueOf(currChar));
				}
				if(isOp(currChar))
				{
					if(myStack.size() < 2)
					{
						throw new InvalidNotationFormatException();
					}
					else
					{
						secondValue = myStack.pop();
						firstValue = myStack.pop();
						if(currChar == '*')
						{
							firstV = Double.parseDouble(firstValue);
							secondV = Double.parseDouble(secondValue);
							result = firstV * secondV;
							myStack.push(Double.toString(result));
						}
						if(currChar == '/')
						{
							firstV = Double.parseDouble(firstValue);
							secondV = Double.parseDouble(secondValue);
							result = firstV / secondV;
							myStack.push(Double.toString(result));
						}
						if(currChar == '+')
						{
							firstV = Double.parseDouble(firstValue);
							secondV = Double.parseDouble(secondValue);
							result = firstV + secondV;
							myStack.push(Double.toString(result));
						}
						if(currChar == '-')
						{
							firstV = Double.parseDouble(firstValue);
							secondV = Double.parseDouble(secondValue);
							result = firstV - secondV;
							myStack.push(Double.toString(result));
						}
						
					}
				}
			}
			if(myStack.size() > 1)
			{
				throw new InvalidNotationFormatException();
			}
		}
		catch(StackOverflowException | StackUnderflowException e)
		{
			e.getMessage();
		}
		return result;
	}
	
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException
	{
		char[] newPostfix = postfix.toCharArray();
		String finalConversion = " ";
		String operatorFound = " ";
		String currTop = " ";
		char currChar = ' ';
		MyStack<String> myStack = new MyStack<String>();
		//MyQueue<String> myQueue = new MyQueue<String>();
		try
		{
			for(int i = 0; i < newPostfix.length; i++)
			{
				currChar = newPostfix[i];
				if(currChar == ' ')
				{
					continue;
				}
				if(!isOp(currChar))
				{
					myStack.push(String.valueOf(currChar));
				}
				if(isOp(currChar))
				{
					if(myStack.size() < 2)
					{
						throw new InvalidNotationFormatException();
					}
					else
					{
						currTop = myStack.pop();
						operatorFound = "(" + myStack.pop() + currChar + currTop + ")";
						myStack.push(operatorFound);
					}
				}
			}
			if(myStack.size() > 1)
			{
				throw new InvalidNotationFormatException();
			}
			finalConversion = myStack.toString();
		}
		catch(StackOverflowException | StackUnderflowException e)
		{
			e.getMessage();
		}
		return finalConversion;
	}
	
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException
	{
		char[] newInfix = infix.toCharArray();
		String finalConversion = " ";
		MyStack<String> myStack = new MyStack<String>();
		MyQueue<String> myQueue = new MyQueue<String>();
		char currChar = ' ';
		try
		{
			for(int i = 0; i < newInfix.length; i++)
			{
				currChar = newInfix[i];
				if(currChar == ' ')
				{
					continue;
				}
				if(!isOp(currChar) && !isParen(currChar))
				{
					myQueue.enqueue(String.valueOf(currChar));
				}
				if(isParen(currChar))
				{
					if(currChar == '(')
					{
						myStack.push(String.valueOf(currChar));
					}
					else if(currChar == ')')
					{
						while(!(myStack.isEmpty()) && !(myStack.top().equals("(")))
						{
							myQueue.enqueue(myStack.pop());
						}
						if(myStack.isEmpty() || !(myStack.top().equals("(")))
						{
							throw new InvalidNotationFormatException();
						}
						if(!(myStack.isEmpty()) && (myStack.top().equals("(")))
						{
							myStack.pop();
						}
						
					}
					
				}
				if(isOp(currChar))
				{
					if(multOdiv(currChar))
					{
						if(!myStack.isEmpty())
						{
							while(myStack.top().equals("/") || myStack.top().equals("*"))
							{
								myQueue.enqueue(myStack.pop());
							}
						}
						myStack.push(String.valueOf(currChar));
					}
					else if(addOsub(currChar))
					{
						if(!myStack.isEmpty())
						{
							while(myStack.top().equals("+") || myStack.top().equals("-") || myStack.top().equals("*") || myStack.top().equals("/"))
							{
								myQueue.enqueue(myStack.pop());
							}
						}
						myStack.push(String.valueOf(currChar));
						//System.out.println(myQueue);
					}
				}
				//System.out.println("Before: " + myQueue);
								//System.out.println(myQueue);
			}
			while(!myStack.isEmpty() && !myStack.top().equals("("))
			{
				myQueue.enqueue(myStack.pop());
			}

			finalConversion = myQueue.toString();
		}
		catch(QueueOverflowException | StackOverflowException | StackUnderflowException e)
		{
			e.getMessage();
		}
		return finalConversion;
	}
	
	public static boolean isOp(char op)
	{
		switch(op)
		{
			case '+':
				return true;
			case '-':
				return true;
			case '*':
				return true;
			case '/':
				return true;
			default:
				return false;
		}
	}
	
	public static boolean addOsub(char op)
	{
		switch(op)
		{
			case '+':
				return true;
			case '-':
				return true;
			default:
				return false;
		}
	}
	
	public static boolean isParen(char op)
	{
		switch(op)
		{
			case '(':
				return true;
			case ')':
				return true;
			default:
				return false;
		}
	}
	
	public static boolean multOdiv(char op)
	{
		switch(op)
		{
			case '*':
				return true;
			case '/':
				return true;
			default:
				return false;
		}
	}
}
