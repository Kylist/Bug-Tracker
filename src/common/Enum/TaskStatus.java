package common.Enum;

public enum TaskStatus {
	ONNEW("ONNEW"), ONTAKEN("ONTAKEN"), ONGOING("ONGOING"), ONREVIEW("ONREVIEW"), ONFINISH("ONFINISH");

	private String status;
	
	TaskStatus(String status) {
		this.status = status;
	}
	
	public String toString() {
		return this.status;
	}
}
