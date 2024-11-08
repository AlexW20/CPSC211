package lab;

import java.util.Scanner;
import java.io.File;



public class ReplayController {
 private IsolaBoard b;
 private BoardView v;   
 private Scanner scnr;  

 
 public ReplayController() {
     b = new IsolaBoard(); 
     v = new BoardView(b);  
 }

 
    public void replay() {
    	try {
            
            scnr = new Scanner(new File("game.dat"));
    	}
        	catch (Exception e) {
        		System.out.println("Cannot find file");
        		return;
            
        }
    	BoardSpace activePlayer = BoardSpace.Player1;
    	
    
    
   
    while (scnr.hasNextLine()) {
    	String cardinal = scnr.nextLine();
        System.out.println(activePlayer + " moved " + cardinal);
        v.display();
        BoardPosition currentPosition = b.findPosition(activePlayer);
        BoardPosition nextPosition = getNextPosition(currentPosition, cardinal);
        	
        if (nextPosition != null) {
        	b.movePlayer(activePlayer, nextPosition);
        	
        }
       
            BoardSpace winner = b.checkWinner();
            if (winner != BoardSpace.Available) {
                
                System.out.println("Player " + (winner == BoardSpace.Player1 ? "1" : "2") + " wins!");
                break;
            }  
            
            
            activePlayer = (activePlayer == BoardSpace.Player1) ? BoardSpace.Player2 : BoardSpace.Player1;
            
            try
            {
          
            Thread.sleep(1000);
            } catch (Exception e)
            {
           
            }
        
       
        }
        scnr.close();
    }
    
    




private BoardPosition getNextPosition(BoardPosition currentPosition, String cardinal) {
    int row = currentPosition.getRow();
    int col = currentPosition.getColumn();

    if (cardinal.equals("N")) {
    	row = row - 1;
    }
    else if (cardinal.equals("NE")) {
    	row = row - 1;
    	col = col + 1;
    }
    else if (cardinal.equals("E")) {
    	col = col + 1;
    }
    else if (cardinal.equals("SE")) {
    	row = row + 1;
    	col = col + 1;
    }
    else if (cardinal.equals("S")) {
    	row = row + 1;
    }
    else if (cardinal.equals("SW")) {
    	row = row + 1;
    	col = col - 1;
    }
    else if (cardinal.equals("W")) {
    	col = col - 1;
    }
    else if (cardinal.equals("NW")) {
    	row = row - 1;
    	col = col - 1;
    }
    else {
    	return null;
    }

    
    return (row >= 0 && row < b.getHeight() && col >= 0 && col < b.getWidth())
            ? new BoardPosition(row, col) : null;
}}

