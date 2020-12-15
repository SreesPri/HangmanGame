
package game;
import java.util.Random;
import java.util.Scanner;


public class Hangman {
	private int option;
	String[] word = {"dubai","japan","qatar","syria","india"};
	
	public void showMenu()
	{

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------Menu--------------");
		System.out.println("1.Play");
		System.out.println("2.Instructions");
		System.out.println("3.Exit");
		System.out.println("\n Choose the option: ");
		
		option=0;
		try {
		      option = sc.nextInt();
		    }
		catch(RuntimeException e) 
		{
			System.out.println("Enter a valid input(1-3): ");
			showMenu();
		}
		
		switch(option) 
		{
		   
		case 1: playGame();
	    		break;
		case 2: instructionGame();
				break;
		case 3: exitGame();
				break;
		
		default: System.out.println("Incorrect Option");
				  showMenu();
				  break;
		}
	}
	
	private void exitGame() {
		   System.out.println("Exit Game method invoked");
		   System.exit(0);
		
	}

	private void instructionGame() {
		   System.out.println("Instructions of Game method invoked");
		
	}

	@SuppressWarnings({ "unused", "resource" })
	public void playGame()
	{
      System.out.println("Play Game method invoked");
      
      int len,i,count = 0,rnd, flag=0;
      String choice,temp;
      
      Random rd = new Random();
      Scanner input = new Scanner(System.in);
      rnd  = rd.nextInt(10);
      len = word(rnd).length;
      char[] newString = new char[len];
      
      StringBuffer wrgString = new StringBuffer();
      
      for(int j=0;j<len;j++) 
      {
    	  System.out.println(" _  ");
      }
      System.out.println();
      do {
    	    flag = 0;
    	    System.out.print("\n Enter your guess: ");
    	    
    	    try {
    	    		String ch = input.nextLine().toLowerCase();
    	    		if(ch.length() != 1)
    	    		{
    	    			throw new WrongInputException();
    	    		}
    	    		count++;
    	         for(i=0;i<len;i++) 
    	         {
    	    	   if(word[rnd].charAt(i) == ch.charAt(0))
    	    	   {
    	    		 newString[i] = word[rnd].charAt(i);
    	    		 flag=1;
    	    	   }
    	         }
    	    
    	         if(flag==0) 
    	        {
    	    	  flag=1;
    	    	  wrgString.append(ch + ",");
    	    	  System.out.println("\n Misses: " + wrgString);
    	        }
    	         
    	    	  System.out.println(newString);
    	    	  temp = new String(newString);
    	    	
    	    	  if(word[rnd].equals(temp))
    	    	   {
    	    		 System.out.println("-----Congrats------ :) You Won!!!");
    	    		 System.out.println("Play Again? (y/n): ");
    	    		 choice= input.nextLine();
    	    		 
    	    		     if(choice.equalsIgnoreCase("y"))
    	    		     {
    	    		    	 playGame();
    	    		    	 rnd  = rd.nextInt(25);
    	    		         len = word(rnd).length;
    	    		         char[] newString1 = new char[len];
    	    		     }
    	    		     else
    	    		     {
    	    		    	 showMenu();
    	    		     }
    	    	}
    	    	
    	    }
    	    catch(WrongInputException e)
    	    {
    	    	flag=1;
    	    }
      }
      while(flag != 0);
      
    }


	private String[] word(int rnd) {
		return word;
	}

	public static void main(String[] args) {
		Hangman hg = new Hangman();
		hg.showMenu();
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}
}