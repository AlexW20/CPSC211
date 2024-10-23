public class Test {

    
    public void testGetWidth() {
       
        int width = 7;
        int height = 4;
        Maze maze = new Maze(width, height);
        
   
        int result = maze.getWidth();
        
       
        if (result != width) {
            fail("Incorrect Width");
        }
    }

    
    public void testGetHeight() {
       
        int width = 7;
        int height = 4;
        Maze maze = new Maze(width, height);
        
      
        int result = maze.getHeight();
        
     
        if (result != height) {
            fail("Incorrect Height");
        }
    }

    
    public void testPath() {
      
        int width = 7;
        int height = 4;
        Maze maze = new Maze(width, height);
        char[][] layout = {
                {'#', '#', '#', '#', '#', '#','#'},
                {'#', ' ', '#', ' ', '#', ' ','#'},
                {'#', ' ', ' ', ' ', '#', ' ','#'},
                {'#', '#', '#', '#', '#', '#','#'},
                
        };

        for (int row = 0; row < layout.length; row++) {
            for (int col = 0; col < layout[0].length; col++) {
                maze.set(layout[row][col], row, col);
            }
        }

        int startRow = 1;
        int startCol = 1;
        int endRow = 1;
        int endCol = 3;
        String expectedResult = "1,1-1,2-1,3";

       
        String result = maze.solve(startRow, startCol, endRow, endCol);

      
        if (!expectedResult.equals(result)) {
            fail("Incorrect result");
        }
    }

   
    public void testSolvePath2() {
       
        int width = 7;
        int height = 4;
        Maze maze = new Maze(width, height);
        char[][] layout = {
        		{'#', '#', '#', '#', '#', '#','#'},
                {'#', ' ', '#', ' ', '#', ' ','#'},
                {'#', ' ', ' ', ' ', '#', ' ','#'},
                {'#', '#', '#', '#', '#', '#','#'},
        };

        for (int row = 0; row < layout.length; row++) {
            for (int col = 0; col < layout[0].length; col++) {
                maze.set(layout[row][col], row, col);
            }
        }

        int startRow = 1;
        int startCol = 1;
        int endRow = 3;
        int endCol = 3;

       
        String result = maze.solve(startRow, startCol, endRow, endCol);

        
        if (result == null) {
            fail("No Path");
        }
    }

    
    public void testImpossible() {
       
        int width = 7;
        int height = 4;
        Maze maze = new Maze(width, height);
        char[][] layout = {
        		{'#', '#', '#', '#', '#', '#','#'},
                {'#', ' ', '#', ' ', '#', ' ','#'},
                {'#', ' ', ' ', ' ', '#', ' ','#'},
                {'#', '#', '#', '#', '#', '#','#'},
        };

        for (int row = 0; row < layout.length; row++) {
            for (int col = 0; col < layout[0].length; col++) {
                maze.set(layout[row][col], row, col);
            }
        }

        int startRow = 1;
        int startCol = 1;
        int endRow = 0;
        int endCol = 0;
 
        String result = maze.solve(startRow, startCol, endRow, endCol);

      
        if (result != null) {
            fail("Got a path");
        }
    }

   
    public void testReturnToStart() {
        
        int width = 7;
        int height = 4;
        Maze maze = new Maze(width, height);
        char[][] layout = {
        		{'#', '#', '#', '#', '#', '#','#'},
                {'#', ' ', '#', ' ', '#', ' ','#'},
                {'#', ' ', ' ', ' ', '#', ' ','#'},
                {'#', '#', '#', '#', '#', '#','#'},
        };

        for (int row = 0; row < layout.length; row++) {
            for (int col = 0; col < layout[0].length; col++) {
                maze.set(layout[row][col], row, col);
            }
        }

        int startRow = 1;
        int startCol = 1;

     
        String result = maze.solve(startRow, startCol, startRow, startCol);

        if (!result.equals("1,1")) {
            fail("Did not end up at 1,1");
        }
    }


	private void fail(String string) {
		
		
	}
}