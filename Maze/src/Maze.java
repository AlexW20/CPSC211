public class Maze {
	
	private int width;
	private int height;
	private char [][] maze;
	
	
	public Maze (int height, int width) {
		
		this.width = width;
		this.height = height;
		maze = new char[height][width];
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void set(char character, int row, int column) {
		
		maze[row][column] = character;
		
	}
	
	public char get (int row, int col) {
		return maze[row][col];
	}
	
	private boolean validMove (int row, int col) {
		if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length) {
			return false;
		}
		return maze[row][col] != '#' && maze[row][col] != '.';
	}
	public String solve (int startrow, int startcol, int endrow, int endcol) {
		
		
		
		
		if (startrow == endrow && startcol == endcol) {
			return startrow + "," + startcol;
		}
		
		
		char crumb = maze[startrow][startcol];
		maze[startrow][startcol] = '.';
		
		View v = new View(this);
		System.out.println();
		v.drawMaze();
		
		String result = null;
		
		
		if (validMove(startrow, startcol + 1)) {
			result = solve(startrow, startcol + 1, endrow, endcol);
			if (result != null) {
				maze[startrow][startcol] = crumb;
				return startrow + "," + startcol + "-" + result;
			}
		}
		
		
		if (validMove(startrow + 1, startcol)) {
			result = solve(startrow + 1, startcol, endrow, endcol);
			if (result!= null) {
				maze[startrow][startcol] = crumb;
				return startrow + "," + startcol + "-" + result;
			}
		}
		
		
		if (validMove(startrow, startcol - 1)) {
			result = solve(startrow, startcol - 1, endrow, endcol);
			if (result!= null) {
				maze[startrow][startcol] = crumb;
				return startrow + "," + startcol + "-" + result;
			}
		}
		
		
		if (validMove(startrow - 1, startcol)) {
			result = solve(startrow - 1, startcol, endrow, endcol);
			if (result!= null) {
				maze[startrow][startcol] = crumb;
				return startrow + "," + startcol + "-" + result;
			}
		}
		
		maze[startrow][startcol] = crumb;
		
		return null;
	}
    }
	