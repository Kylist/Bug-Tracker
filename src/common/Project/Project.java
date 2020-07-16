/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.Project;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author tug70
 */
public class Project {

    private int ID;
    private String name;
    private Date createDate;
    private Date startDate;
    private Date dueDate;
    private String summary;
    private ArrayList<Integer> team;

    public Project() {
    }

    ;
    public Project(int projectID) {
        this.ID = projectID;
    }

    public Project(int projectID, String projectName, Date createDate, Date startDate, Date dueDate, String summary, ArrayList<Integer> team) {
        this.ID = projectID;
        this.name = projectName;
        this.createDate = createDate;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.summary = summary;
        this.team = team;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    //TODO get the size of JSONArray instead of num like this
    public static Project getProjectFromDatabase(int num) {
        Project projectGet = new Project(-1, "", new Date(), new Date(), new Date(), "", new ArrayList<>());
        JSONParser jsonParser = new JSONParser();
        try {
            Class cls = Class.forName("common.Project.Project");
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

                //get the project aray
                JSONArray projectObject = (JSONArray) obj.get("project");
                //get the project at project array of "num" position
                JSONObject project = (JSONObject) projectObject.get(num);

                //get all fields
                int projectID = ((Long) project.get("id")).intValue();
                String projectName = (String) project.get("name");
                Date createDate = new SimpleDateFormat("MM-dd-yyyy").parse((String) project.get("createDate"));
                Date startDate = new SimpleDateFormat("MM-dd-yyyy").parse((String) project.get("startDate"));
                Date dueDate = new SimpleDateFormat("MM-dd-yyyy").parse((String) project.get("dueDate"));
                String summary = (String) project.get("summary");
                //populate array of user ID for the project
                JSONArray dbTeam = (JSONArray) project.get("_team");
                int size = dbTeam.size();
                ArrayList<Integer> team = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    team.add(((Long) dbTeam.get(i)).intValue());
                }
                projectGet = new Project(projectID, projectName, createDate, startDate, dueDate, summary, team);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return projectGet;
    }

    public static int getSizeFromDatabase() {
        int projectNumber = 0;
        JSONParser jsonParser = new JSONParser();
        try {
            Class cls = Class.forName("common.Project.Project");
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
                //get the project aray
                JSONArray projectObject = (JSONArray) obj.get("project");
                projectNumber = projectObject.size();

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return projectNumber;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the team
     */
    public ArrayList<Integer> getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(ArrayList<Integer> team) {
        this.team = team;
    }

}
