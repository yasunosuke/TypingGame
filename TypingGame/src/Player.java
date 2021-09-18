
public class Player {
	private final String name;
	private boolean isCompleted;
	private int presentStage;
	
	public Player(String name, boolean isCompleted, int presentStage) {
		super();
		this.name = name;
		this.isCompleted = isCompleted;
		this.presentStage = presentStage;
	}

	public String getName() {
		return name;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public int getPresentStage() {
		return presentStage;
	}

	public void setPresentStage(int presentStage) {
		this.presentStage = presentStage;
	}
	
	
}
