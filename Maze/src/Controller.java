import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Controller {
	
	private List<Integer[]> coordinates = new ArrayList<>();
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.go();
	}
	
	public void go () {
		
		File file = getMazeFileFromUser();
		
		if (file == null) {
			System.out.println("Did not select the file");
			return;
		}
		
	    
	    Maze maze = readMazeFromFile(file);
	    
	    if (maze != null) {
	    	View view = new View(maze);
	    	view.drawMaze();
	    	
	    	for (Integer[] pair : coordinates) {
	    		int startrow = pair[0];
	    		int startcol = pair[1];
	    		int endrow = pair[2];
	    		int endcol = pair[3];
	    		
	    		String result = maze.solve(startrow, startcol, endrow, endcol);
	    		
	    		if (result != null) {
	    			
	    			System.out.println(result);
	    		}
	    		else {
	    			System.out.println("Impossible");
	    		}
	    		
	    	}
	    }
	    
	    
	    
	}
	
	public Maze readMazeFromFile (File file) {
		
		Maze maze = null;
		
		
		try (Scanner scanner = new Scanner(file)) {
			
	
			int width = scanner.nextInt();
			int height = scanner.nextInt();
			scanner.nextLine();
			
			maze = new Maze (height, width);
		
		for (int row = 0; row < height; row++) {
			String line = scanner.nextLine();
			for (int column = 0; column < width; column++) {
				char character = line.charAt(column);
				
				maze.set(character, row, column);
		
			}
		}
		
		
		
		while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().trim().split(" ");
            if (parts.length == 4) {
                int startrow = Integer.parseInt(parts[0]);
                int startcol = Integer.parseInt(parts[1]);
                int endrow = Integer.parseInt(parts[2]);
                int endcol = Integer.parseInt(parts[3]);
                coordinates.add(new Integer[]{startrow, startcol, endrow, endcol});
			
				}
			
		}
		
		}
		catch (FileNotFoundException e) {
			System.out.println(file.getName() + "not found.");
		}
		
		return maze;
		
		
	}
	
	public File getMazeFileFromUser() {
		
		JFileChooser chooser = new JFileChooser();
		
	    int returnVal = chooser.showOpenDialog(null);
	    
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	            return chooser.getSelectedFile();        
	    }
		return null;
	}
}

	    
	    
