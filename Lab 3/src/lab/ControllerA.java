package lab;

public class ControllerA {
    private Model model;
    private View view;
    private ControllerB red;
    private ControllerB black;

    
    public ControllerA(Model model, View view) {
        this.model = model;
        this.view = view;
        this.red = new ControllerB('R', model, view);
        this.black = new ControllerB('B', model, view);
    }

    
   
    public void startGame() {
        boolean gameIsRunning = true;

        while (gameIsRunning) {
            view.drawBoard();
            boolean yesPeek = true;
       while (yesPeek) {
        if (view.askForPeek()) {
        	int[] peekCoordinates = view.askForPeekCoordinates();
            int row = peekCoordinates[0];
            int col = peekCoordinates[1];
            model.peek(row, col);
            view.drawStack(row, col);
        }
        else {
        	yesPeek = false;
        }
       }
            
         
            while (!black.move()) {
                
            }
            
         
            if (model.checkForWinner('B')) {
                System.out.println("Black wins!");
                break;
            }

            view.drawBoard();

           
            while (!red.move()) {
               
            }

           
            if (model.checkForWinner('R')) {
                System.out.println("Red wins!");
                break;
            }
        }

        view.close();
    }
}