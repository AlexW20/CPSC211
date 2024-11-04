package lab;

public class Main {

	public static void main(String[] args) {
		Main m = new Main ();
		m.go();

	}
	
	public void go () {
		Model model = new Model();
		View view = new View(model);
		ControllerA controller = new ControllerA(model, view);
		controller.startGame();
	}

}