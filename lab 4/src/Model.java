public class Model {
	

	private boolean hasKey = false;
	private boolean hasStopwatch = false;


	private StateType currentState = StateType.Entrance;
	

	public StateType getCurrentState() {
		return currentState;
	}

	
	public void setCurrentState(StateType currentState) {
		this.currentState = currentState;
	}

	public boolean getHasKey() {
		return hasKey;
	}

	public void setHasKey(boolean hasKey) {
		this.hasKey = hasKey;
	}

	public boolean getHasStopwatch() {
		return hasStopwatch;
	}

	public void setHasStopwatch(boolean hasStopwatch) {
		this.hasStopwatch = hasStopwatch;
	}
	
	
}