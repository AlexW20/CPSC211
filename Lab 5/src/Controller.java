import java.io.File;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Controller 
{
	public static void main(String[] args) 
	{
		Controller controller = new Controller();
		controller.go();
	}
	
	public void go()
	{
		Scanner input = null;
		File[] folder= getMapFileFromUser();
		for (int j=0; j<folder.length; j++) {
		try {
			input = new Scanner(folder[j]);
		} catch (FileNotFoundException e) {
			System.out.println("Could not read file");
			return;
		}
		
		int numVertices = input.nextInt();
		Graph graph = new Graph(numVertices);
		
		
		input.nextLine();
		
		for (int i = 0; i < numVertices; i++)
		{
			String line = input.nextLine();
			Scanner linescanner = new Scanner(line);
			
			while (linescanner.hasNext())
			{
				graph.addEdge(i, linescanner.nextInt());
			}
			
		}
		graph.Solve(0);
		}
	}
	
	public File [] getMapFileFromUser()
	{
		
		JFileChooser fileChooser = new JFileChooser();

        // Set the JFileChooser to allow directory selection only
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // Show the dialog to choose a directory
        int result = fileChooser.showOpenDialog(null);

        // Check if the user selected a folder
        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected folder
            File selectedFolder = fileChooser.getSelectedFile();
            return selectedFolder.listFiles();

           
            } else {
                System.out.println("The selected folder is not valid.");
            }
     
        
		return null;
    }
	}