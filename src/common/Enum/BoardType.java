package common.Enum;

public enum BoardType {
	BACKLOG("BACKLOG"), TAKEN("TAKEN"), ONGOING("ONGOING"), FINISH("FINISH");
	
	private String type;
	
	BoardType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return this.type;
	}
}
