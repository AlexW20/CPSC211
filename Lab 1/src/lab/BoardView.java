package lab;

public class BoardView {
	
	IsolaBoard board;

	
	public BoardView(IsolaBoard b) {
		
		board = b;
	}

	
	public void display() {
		
		drawBoard();
		
		
	}
	
	
	private void drawBoard() {
		for (int row = 0; row < 7; row++) {
			for (int col = 0; col < 7; col++) {
				
				BoardSpace s = board.get(row, col);
				if (s == BoardSpace.Available) {
					System.out.print("-");
				}
				else if (s == BoardSpace.Player1) {
					System.out.print("1");
				}
				else if (s == BoardSpace.Player2) {
					System.out.print("2");
				}
				else if (s == BoardSpace.Missing) {
					System.out.print(" ");
				}
				else {
					System.out.print("ER");
				}
			}
			System.out.println();
		}
	}}