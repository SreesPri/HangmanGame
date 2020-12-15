package game;

public class MenuInputException extends RuntimeException 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MenuInputException()
    {
    	System.out.println("Give a valid input(1-3):  ");
    }
}
