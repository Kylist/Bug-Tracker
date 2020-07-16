package common.Task;

import common.Comment.Comment;
import common.Comment.CommentsOneTaskHold;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import common.Enum.TaskStatus;
import common.Enum.TaskType;


public class Task {
	int ID;
	TaskType type;
	int projectID;
	int sprintID;
	String quickSummary;
	CommentsOneTaskHold comments; 
	int severity;
	TaskStatus status;
	Date reportedDate;
	Date dueDate;
	String fullDescription;
	String toReplicate;
	String suggestion;
	File[] attachedFile= new File[3];
	int assignerID;
	List<Integer> assignees;
	
        public Task (int ID){
            this.ID = ID;
        }
	/////////////////////////Constructor in development/////////////////////////////
	public Task (int ID, TaskType type, String quickSummary, int projectID, int sprintID, int severity, TaskStatus status, Date reportedDate) {
		this.ID = ID;
		this.type = type;
		this.projectID = projectID;
		this.sprintID = sprintID;
		this.quickSummary = quickSummary;
		this.comments = new CommentsOneTaskHold();
		this.severity = severity;
		this.status = status;
		this.reportedDate = reportedDate;
		this.dueDate = null;
		this.fullDescription = quickSummary;
		this.toReplicate = null;
		this.suggestion = null;
		this.attachedFile = null;
		this.assignerID = -1;
		this.assignees = new ArrayList<>();
	}
	
	/////////////////////////Full fledged constructor//////////////////////////////////

	public Task (int ID, String quickSummary, CommentsOneTaskHold comments, int projectID, int sprintID, int severity, TaskStatus status, Date reportedDate, String toReplicate, String fullDescription, String suggestion, Date dueDate, File[] file, int assignerID, List<Integer> assignees) {

		this.ID = ID;
		this.type = TaskType.TASK;
		this.projectID = projectID;
		this.sprintID = sprintID;
		this.quickSummary = quickSummary;
		this.comments = comments;
		this.severity = severity;
		this.status = status;
		this.reportedDate = reportedDate;
		this.dueDate = dueDate;
		this.fullDescription = fullDescription;
		this.toReplicate = toReplicate;
		this.suggestion = suggestion;
		this.attachedFile = file;
		this.assignerID = assignerID;
		this.assignees = assignees;
	}
        //without File file
	public Task (int ID, TaskType type, String quickSummary, CommentsOneTaskHold comments, int projectID, int sprintID, int severity, TaskStatus status, Date reportedDate, Date dueDate, String toReplicate, String fullDescription, String suggestion, File[] file, int assignerID, List<Integer> assignees) {

		this.ID = ID;
		this.type = type;
		this.projectID = projectID;
		this.sprintID = sprintID;
		this.quickSummary = quickSummary;
		this.comments = comments;
		this.severity = severity;
		this.status = status;
		this.reportedDate = reportedDate;
		this.dueDate = dueDate;
		this.fullDescription = fullDescription;
		this.toReplicate = toReplicate;
		this.suggestion = suggestion;
		this.attachedFile = file;
		this.assignerID = assignerID;
		this.assignees = assignees;
	}
	public String getToReplicate() {
		return toReplicate;
	}

	public void setToReplicate(String toReplicate) {
		this.toReplicate = toReplicate;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public int getAssignerID() {
		return assignerID;
	}

	public void setAssignerID(int assignerID) {
		this.assignerID = assignerID;
	}

	public List<Integer> getAssignees() {
		return assignees;
	}

	public void setAssignees(List<Integer> assignees) {
		this.assignees = assignees;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public TaskType getType() {
		return type;
	}

	public void setType(TaskType type) {
		this.type = type;
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public int getSprintID() {
		return sprintID;
	}

	public void setSprintID(int sprintID) {
		this.sprintID = sprintID;
	}

	public String getQuickSummary() {
		return quickSummary;
	}

	public void setQuickSummary(String quickSummary) {
		this.quickSummary = quickSummary;
	}

	public CommentsOneTaskHold getComments() {
		return comments;
	}

	public void setComments(CommentsOneTaskHold comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment comment) {
		this.comments.getComment().add(comment);
	}

	public int getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public Date getReportedDate() {
		return reportedDate;
	}

	public void setReportedDate(Date reportedDate) {
		this.reportedDate = reportedDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public File[] getAttachedFile() {
		return attachedFile;
	}

	public void setAttachedFile(File[] attachedFile) {
		this.attachedFile = attachedFile;
	}
	public void addAssignee(int id) {
		this.assignees.add(id);
	}
}

