
public class OutOfBoundsException extends Exception 
{
	/*
	 * prints the message and exits
	 */
	public OutOfBoundsException(String message)
	{
		System.out.println(message);		
	}
	
	/*
	 * calls constructor with generic message
	 */
	public OutOfBoundsException()
	{
		new OutOfBoundsException("An out of bounds exception occurred.\n");
	}
}