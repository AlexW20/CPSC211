package lab;

public class ControllerB {
    public char color; 
    private Model model;
    private View view;

    
    public ControllerB(char color, Model model, View view) {
        this.color = color;
        this.model = model;
        this.view = view;
    }

    
    
    public boolean move() {
        System.out.println();
    	System.out.println("Player " + color + ", enter your turn.");
        int[] move = view.askForMove(color);

        
        if (model.movePiece(move[0], move[1], move[2], move[3])) {
            return true;
        } else {
            System.out.println("Invalid move. Enter your move again.");
            return false; 
        }
    }
    
    public char getColor() {
        return color;
    }

}