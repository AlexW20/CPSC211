package lab;

public class Main {


	public static void main(String[] args) {
		Main m = new Main ();
		m.go();
		
		
		

	}
	
	
	public void go ()
	{
		GameController c = new GameController();
		c.start();
		IsolaBoard board = new IsolaBoard();
		BoardView view = new BoardView(board);
		ReplayController r = new ReplayController();
		r.replay();
		
		
		view.display();
	}

}