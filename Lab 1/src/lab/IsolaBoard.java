package lab;

public class IsolaBoard
{
    private BoardSpace [][] board = new BoardSpace [7][7];
    private BoardSpace lastPlayer = BoardSpace.Player1;
    
    public IsolaBoard ()
    {
        createBoard(7, 7);
    }

    public IsolaBoard (int width, int height)
    {
        createBoard(width, height);
    }
    
    public int getWidth ()
    {
        return board[0].length;
    }
    
    public int getHeight ()
    {
        return board.length;
    }
    
    public BoardSpace get (int row, int column)
    {
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length)
            return null;
        
        return board[row][column];
    }
    
    public BoardPosition findPosition(BoardSpace what)
    {
        for (int row = 0; row < board.length; row++)
            for (int column = 0; column < board[0].length; column++)
                if (board[row][column] == what)
                    return new BoardPosition(row, column);;
        
        return null;
    }
    
    public void movePlayer (BoardSpace which, BoardPosition newPosition)
    {
       
        if (which != BoardSpace.Player1 && which != BoardSpace.Player2)
            return;
        
      
        if (illegalBoardPosition(newPosition.getRow(), newPosition.getColumn()))
            return;
        
      
        BoardPosition position = findPosition(which);
      
        if (board[newPosition.getRow()][newPosition.getColumn()] != BoardSpace.Available)
            return;
        
        if (Math.abs(position.getRow() - newPosition.getRow()) > 1 || Math.abs(position.getColumn() - newPosition.getColumn()) > 1)
            return;
        
     
        lastPlayer = which;
        board[position.getRow()][position.getColumn()] = BoardSpace.Missing;
        board[newPosition.getRow()][newPosition.getColumn()] = which;
    }
    
    public BoardSpace checkWinner ()
    {
       
        BoardPosition position1 = findPosition(BoardSpace.Player1);
        BoardPosition position2 = findPosition(BoardSpace.Player2);
        boolean player1Isolated = positionIsIsolated(position1);
        boolean player2Isolated = positionIsIsolated(position2);

        if (player1Isolated && ! player2Isolated)
            return BoardSpace.Player2;
        
        if (player2Isolated && ! player1Isolated)
            return BoardSpace.Player1;
        
        if (player1Isolated && player2Isolated)
            return lastPlayer;
        
        return BoardSpace.Available;
    }

    private void createBoard (int width, int height)
    {
        board = new BoardSpace[height][width];
        
        for (int row = 0; row < height; row++)
            for (int column = 0; column < width; column++)
                board[row][column] = BoardSpace.Available;

       
        int startColumn = width/2;
        
        board[0][startColumn] = BoardSpace.Player1;
        board[height-1][startColumn] = BoardSpace.Player2;
    }
    
    private boolean positionIsIsolated (BoardPosition position)
    {
        for (int row = position.getRow()-1; row <= position.getRow()+1; row++)
            for (int column = position.getColumn()-1; column <= position.getColumn()+1; column++)
            {
               
                if (illegalBoardPosition(row, column))
                    continue;
                
              
                if (row == position.getRow() && column == position.getColumn())
                    continue;
                
               
                if (board[row][column] == BoardSpace.Available)
                    return false;
            }
        
        return true;
    }
    
    private boolean illegalBoardPosition (int row, int column)
    {
        return (row < 0 || row >= board.length || column < 0 || column >= board[0].length);
    }
}