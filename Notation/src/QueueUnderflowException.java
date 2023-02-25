
public class QueueUnderflowException extends Exception
{
	public QueueUnderflowException()
	{
		super("The queue is empty");
	}
}
