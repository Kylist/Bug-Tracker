package common.Task;

import common.Comment.CommentsOneTaskHold;
import java.util.List;
import java.util.ArrayList;
import common.Enum.BoardType;
import common.Enum.TaskStatus;
import common.Enum.TaskType;
import common.Ultilities.Utilities;
import java.io.File;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TaskHold {

    private static List<Task> taskList = new ArrayList<>();
    private static List<Task> emptyTaskList = new ArrayList<>();

    private static int currentNewTaskListID = 0;

    /////////////////strictly for loading now////////////////////////////
    public static void loadTask() {

        getTaskList().clear();
        
        try {
    	    JSONArray tasks = Utilities.readFile("task");
        		
            for (Object taskObj : tasks) {
                JSONObject task = (JSONObject) taskObj;
                int userID = Long.valueOf((long) task.get("id")).intValue();

                List<Integer> assigneeIDs = new ArrayList<>();
                JSONArray assigneeFromDB = (JSONArray) task.get("assigneeIDs");
                if (assigneeFromDB != null) {
                    for (int i = 0; i < assigneeFromDB.size(); i++) {
                        assigneeIDs.add(((Long) assigneeFromDB.get(i)).intValue());
                    }
                }

                //get the comment
                CommentsOneTaskHold commentHold = new CommentsOneTaskHold();
                //this is because we can't access to the curent position of the current task. So use ID-1 as a replacement

                commentHold.populateCommentsOneTakHold(userID);
               File[] file = new File[3];
                
                //create a new task for adding
                Task new_task = new Task(
                        userID,
                        TaskType.valueOf((String) task.get("taskType")),
                        (String) task.get("quickSummary"),
                        commentHold,
                        Long.valueOf((long) task.get("projectID")).intValue(),
                        Long.valueOf((long) task.get("sprintID")).intValue(),
                        Long.valueOf((long) task.get("severity")).intValue(),
                        TaskStatus.valueOf((String) task.get("taskStatus")),
                        Utilities.stringToDate((String) task.get("dateCreated")),
                        Utilities.stringToDate((String) task.get("dateDue")),
                        "",
                        (String) task.get("fullDescription"),
                        "",
                        file,
                        Long.valueOf((long) task.get("assignerID")).intValue(),
                        assigneeIDs
                );
                getTaskList().add(new_task);
            }
            // }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getTaskHoldSizeFromDatabase() {
        try {
            JSONArray tasks = Utilities.readFile("task");
            return tasks.size();
        } catch (Exception e) {
            return -1;
        }
    }

    ////////////////////////////////end of new addition//////////////////////////////////////////////
    public static void loadEmptyTask() {
        getEmptyTaskList().add(new Task(0, TaskType.BUGREPORT, "there is no user record", -1, -1, 10, TaskStatus.ONNEW, new Date()));
        getEmptyTaskList().add(new Task(1, TaskType.BUGREPORT, "there is no user record. Log in to see projects", -1, -1, 10, TaskStatus.ONTAKEN, new Date()));
        getEmptyTaskList().add(new Task(2, TaskType.BUGREPORT, "there is no user record. Log in to see projects", -1, -1, 10, TaskStatus.ONGOING, new Date()));
        getEmptyTaskList().add(new Task(3, TaskType.BUGREPORT, "Admin email: anon@anon.anon", -1, -1, 10, TaskStatus.ONFINISH, new Date()));
    }

    public static void addTask(Task task) {
        getTaskList().add(task);
    }

    public static void deleteTask(int id) {
        getTaskList().remove(id);
    }

    public static List<Task> filter(BoardType type) {
        List<Task> ret = new ArrayList<>();
        switch (type) {
            case BACKLOG:
                for (int i = 0; i < getTaskList().size(); i++) {
                    if (getTaskList().get(i).getStatus() == TaskStatus.ONNEW || getTaskList().get(i).getStatus() == TaskStatus.ONREVIEW) {
                        ret.add(getTaskList().get(i));
                    }
                }
                break;
            case TAKEN:
                for (int i = 0; i < getTaskList().size(); i++) {
                    if (getTaskList().get(i).getStatus() == TaskStatus.ONTAKEN) {
                        ret.add(getTaskList().get(i));
                    }
                }
                break;
            case ONGOING:
                for (int i = 0; i < getTaskList().size(); i++) {
                    if (getTaskList().get(i).getStatus() == TaskStatus.ONGOING) {
                        ret.add(getTaskList().get(i));
                    }
                }
                break;
            case FINISH:
                for (int i = 0; i < getTaskList().size(); i++) {
                    if (getTaskList().get(i).getStatus() == TaskStatus.ONFINISH) {
                        ret.add(getTaskList().get(i));
                    }
                }
                break;
        }
        return ret;
    }

    /**
     * @return the taskList
     */
    public static List<Task> getTaskList() {
        return taskList;
    }

    /**
     * @param aTaskList the taskList to set
     */
    public static void setTaskList(List<Task> aTaskList) {
        taskList = aTaskList;
    }

    /**
     * @return the emptyTaskList
     */
    public static List<Task> getEmptyTaskList() {
        return emptyTaskList;
    }

    /**
     * @param aEmptyTaskList the emptyTaskList to set
     */
    public static void setEmptyTaskList(List<Task> aEmptyTaskList) {
        emptyTaskList = aEmptyTaskList;
    }
}
