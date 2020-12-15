package game;

public class WrongInputException extends RuntimeException
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	WrongInputException()
    {
    	System.out.println("Enter a letter: ");
    }
}
