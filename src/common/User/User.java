/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.User;

import common.Enum.Role;
import common.Task.TaskHold;
import common.Project.Project;
import common.Project.Projecthold;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author tug70
 */
public class User {

    private int ID;
    private Role role;
    private String profilePic;
    private String name;
    private String email;
    private String password;
    private int accessRange;
    private TaskHold taskhold;
    private Projecthold projecthold;

    public User(int ID) {
        this.ID = ID;
    }

    public User(int ID, Role role, String name, String profilePic, String email, String password, int accessRange) {
        this.ID = ID;
        this.role = role;
        this.name = name;
        this.profilePic = profilePic;
        this.email = email;
        this.password = password;
        this.accessRange = accessRange;
    }

    public User(int ID, Role role, String name, String profilePic, String email, String password, int accessRange, Projecthold projecthold, TaskHold taskhold) {
        this.ID = ID;
        this.role = role;
        this.profilePic = profilePic;
        this.name = name;
        this.email = email;
        this.password = password;
        this.accessRange = accessRange;
        this.projecthold = projecthold;
        this.taskhold = taskhold;
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
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @return the profilePic
     */
    public String getProfilePic() {
        return profilePic;
    }

    /**
     * @param profilePic the profilePic to set
     */
    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the accessRange
     */
    public int getAccessRange() {
        return accessRange;
    }

    /**
     * @param accessRange the accessRange to set
     */
    public void setAccessRange(int accessRange) {
        this.accessRange = accessRange;
    }

    /**
     * @return the TaskHold
     */
    public TaskHold getTaskhold() {
        return taskhold;
    }

    /**
     * @param taskhold the TaskHold to set
     */
    public void setTaskhold(TaskHold taskhold) {
        this.taskhold = taskhold;
    }

    /**
     * @return the projecthold
     */
    public Projecthold getProjecthold() {
        return projecthold;
    }

    /**
     * @param projecthold the projecthold to set
     */
    public void setProjecthold(Projecthold projecthold) {
        this.projecthold = projecthold;
    }

    public void insertProjectHold(Project project) {
        this.projecthold.insert(project);
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

    public static User getUserFromDatabase(int num) {
        User userGet = new User(-1, Role.DEVELOPER, "", "", "", "", -1);
        JSONParser jsonParser = new JSONParser();
        try {

            Class cls = Class.forName("common.User.User");
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

                //get the user aray
                JSONArray userObject = (JSONArray) obj.get("user");
                //get the user at user array of "num" position
                JSONObject user = (JSONObject) userObject.get(num);

                //get all fields
                int ID = ((Long) user.get("id")).intValue();
                Role role = Role.valueOf((String) user.get("role"));
                String profilePic = (String) user.get("image");
                String name = (String) user.get("name");
                String email = (String) user.get("email");
                String password = (String) user.get("password");
                int accessRange = ((Long) user.get("accessRange")).intValue();
                JSONArray projecthold = (JSONArray) user.get("_projects");
                JSONArray taskhold = (JSONArray) user.get("_tasks");

                //TODO rethink about having projecthold and taskhold
                userGet = new User(ID, role, name, profilePic, email, password, accessRange);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return userGet;
    }

    public static int getSizeFromDatabase() {
        int userNumber = 0;
        JSONParser jsonParser = new JSONParser();
        try {
            Class cls = Class.forName("common.User.User");
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
                //FileReader reader = new FileReader("src/resources/database.json");

                //Read JSON file
                JSONObject obj = (JSONObject) jsonParser.parse(responseStrBuilder.toString());
                //get the project aray
                JSONArray userObject = (JSONArray) obj.get("user");
                userNumber = userObject.size();

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return userNumber;
    }

}
