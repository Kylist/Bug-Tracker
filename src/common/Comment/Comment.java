/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.Comment;

import common.Enum.TaskStatus;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author tug70
 */
public class Comment {

    private int taskID;
    private int commentID;
    private Date date;
    private int commenterID;
    private TaskStatus taskStatus;
    private String comment;

    public Comment() {
    }

    public Comment(int taskID, int commentID, int commenterID, TaskStatus taskStatus, String comment, Date date) {
        this.taskID = taskID;
        this.commentID = commentID;
        this.date = date;
        this.commenterID = commenterID;
        this.taskStatus = taskStatus;
        this.comment = comment;
    }

    //TODO get the size of JSONArray instead of num like this
    public static Comment getCommentFromDatabase(int taskPosition, int commentPosition) {
        Comment commentGet = new Comment(-1, -1, -1, TaskStatus.ONNEW, "", new Date());
        JSONParser jsonParser = new JSONParser();
        try {

            Class cls = Class.forName("common.Comment.Comment");
            // returns the ClassLoader object assosiated with this Class
            ClassLoader cLoader = cls.getClassLoader();
            InputStream inputStream = cLoader.getResourceAsStream("resources/database.json");
            if (inputStream != null) {
                BufferedReader streamReader = new BufferedReader(
                        new InputStreamReader(inputStream, "UTF-8"));
                StringBuilder responseStrBuilder = new StringBuilder();

                String inputStr;
                while ((inputStr = streamReader.readLine()) != null) {
                    responseStrBuilder.append(inputStr);
                }

                //Read JSON file
                JSONObject obj = (JSONObject) jsonParser.parse(responseStrBuilder.toString());

                //get the comment aray
                JSONArray taskArray = (JSONArray) obj.get("task");
                JSONObject currentTaskObject = (JSONObject) taskArray.get(taskPosition);
                JSONArray currentCommentArray = (JSONArray) currentTaskObject.get("comment");
                JSONObject currentCommentObject = (JSONObject) currentCommentArray.get(commentPosition);

                //get all fields
                int taskID = ((Long) currentCommentObject.get("taskID")).intValue();
                int commentID = ((Long) currentCommentObject.get("commentID")).intValue();
                int commenterID = ((Long) currentCommentObject.get("commenterID")).intValue();
                TaskStatus taskStatus = TaskStatus.valueOf((String) currentCommentObject.get("taskStatus"));
                String comment = (String) currentCommentObject.get("comment");
                Date date = new SimpleDateFormat("MM-dd-yyyy").parse((String) currentCommentObject.get("commentDate"));
                commentGet = new Comment(taskID, commentID, commenterID, taskStatus, comment, date);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return commentGet;
    }

    public static int getSizeCommentsOfOneTaskFromDatabase(int num) {
        int projectNumber = 0;
        JSONParser jsonParser = new JSONParser();
        try {
            Class cls = Class.forName("common.Comment.Comment");
            // returns the ClassLoader object assosiated with this Class
            ClassLoader cLoader = cls.getClassLoader();
            InputStream inputStream = cLoader.getResourceAsStream("resources/database.json");
            if (inputStream != null) {
                BufferedReader streamReader = new BufferedReader(
                        new InputStreamReader(inputStream, "UTF-8"));
                StringBuilder responseStrBuilder = new StringBuilder();
                String inputStr;
                while ((inputStr = streamReader.readLine()) != null) {
                    responseStrBuilder.append(inputStr);
                }

                //Read JSON file
                JSONObject obj = (JSONObject) jsonParser.parse(responseStrBuilder.toString());
                //get the comment aray
                JSONArray taskObjects = (JSONArray) obj.get("task");
                JSONObject currentTaskObject = (JSONObject) taskObjects.get(num);
                JSONArray currentCommentObjects = (JSONArray) currentTaskObject.get("comment");
                projectNumber = currentCommentObjects.size();

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return projectNumber;
    }

    public static int getAllCommentSizeFromDatabase() {
        int projectNumber = 0;
        JSONParser jsonParser = new JSONParser();
        try {
            Class cls = Class.forName("common.Comment.Comment");
            // returns the ClassLoader object assosiated with this Class
            ClassLoader cLoader = cls.getClassLoader();
            InputStream inputStream = cLoader.getResourceAsStream("resources/database.json");
            if (inputStream != null) {
                BufferedReader streamReader = new BufferedReader(
                        new InputStreamReader(inputStream, "UTF-8"));
                StringBuilder responseStrBuilder = new StringBuilder();
                String inputStr;
                while ((inputStr = streamReader.readLine()) != null) {
                    responseStrBuilder.append(inputStr);
                }

                //Read JSON file
                JSONObject obj = (JSONObject) jsonParser.parse(responseStrBuilder.toString());
                //get the comment aray
                JSONArray taskObjects = (JSONArray) obj.get("task");
                for (int i = 0; i < taskObjects.size(); i++) {
                    JSONObject currentTaskObject = (JSONObject) taskObjects.get(i);
                    JSONArray currentCommentObjects = (JSONArray) currentTaskObject.get("comment");
                    if (currentCommentObjects.size() > 0) {
                        projectNumber = projectNumber + currentCommentObjects.size();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return projectNumber;
    }

    /**
     * @return the taskID
     */
    public int getTaskID() {
        return taskID;
    }

    /**
     * @param taskID the taskID to set
     */
    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    /**
     * @return the commentID
     */
    public int getCommentID() {
        return commentID;
    }

    /**
     * @param commentID the commentID to set
     */
    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the commenterID
     */
    public int getCommenterID() {
        return commenterID;
    }

    /**
     * @param commenterID the commenterID to set
     */
    public void setCommenterID(int commenterID) {
        this.commenterID = commenterID;
    }

    /**
     * @return the taskStatus
     */
    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    /**
     * @param taskStatus the taskStatus to set
     */
    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
