package common.Enum;

public enum TaskType {
	TASK("TASK"), BUGREPORT("BUG REPORT"), TESTREQUEST("TEST REQUEST"), NEWFEATURE("NEW FEATURE"), IMPROVEMENT("IMPROVEMENT");
	
	private String type;
	
	TaskType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return this.type;
	}
	
	public static TaskType[] getAllTaskTypes() {
		TaskType[] types = {TASK, BUGREPORT, TESTREQUEST, NEWFEATURE, IMPROVEMENT};
		return types;
	}
}
