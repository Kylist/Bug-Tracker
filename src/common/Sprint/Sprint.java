/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.Sprint;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author tug70
 */
public class Sprint {

    private int ID;
    private int name;
    private String duration;
    private int projectID;

    public Sprint(int ID) {
        this.ID = ID;
    }

    public Sprint(int ID, int name, String duration, int projectID) {
        this.ID = ID;
        this.name = name;
        this.duration = duration;
        this.projectID = projectID;
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
    public int getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(int name) {
        this.name = name;
    }

    /**
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return the projectID
     */
    public int getProjectID() {
        return projectID;
    }

    /**
     * @param projectID the projectID to set
     */
    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public static Sprint getSprintFromDatabase(int num) {
        Sprint sprintGet = new Sprint(-1, -1, "", -1);
        JSONParser jsonParser = new JSONParser();

        try {

            Class cls = Class.forName("common.Sprint.Sprint");
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

                //get the sprint aray
                JSONArray sprintObject = (JSONArray) obj.get("sprint");
                //get the sprint at sprint array of "num" position
                JSONObject sprint = (JSONObject) sprintObject.get(num);
                //get all fields
                int ID = ((Long) sprint.get("id")).intValue();
                int name = ((Long) sprint.get("name")).intValue();
                String duration = (String) sprint.get("duration");
                int projectID = ((Long) sprint.get("_projectID")).intValue();
                sprintGet = new Sprint(ID, name, duration, projectID);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sprintGet;
    }

    public static int getSizeFromDatabase() {
        int sprintNumber = 0;
        JSONParser jsonParser = new JSONParser();
        try {
            Class cls = Class.forName("common.Sprint.Sprint");
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
                JSONArray sprintObject = (JSONArray) obj.get("sprint");
                sprintNumber = sprintObject.size();

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sprintNumber;
    }

}
