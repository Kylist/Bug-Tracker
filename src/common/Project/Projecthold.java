/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.Project;

import java.util.ArrayList;

/**
 *
 * @author tug70
 */
public class Projecthold {

    private static ArrayList<Project> projects;

    public Projecthold() {

    }

    //insert
    //TODO sort as insert
    public static void insert(Project new_project) {
        projects.add(new_project);
    }

    //update
    public static void update(int index, Project new_project) {
        Projecthold.projects.set(index, new_project);
    }
    // bubble sort by ID, smallest to head(0), biggest to tail(n)
    //TODO expand to sort by other attribute
    //this work first try lol
    public static void bublesort() {
        for (int i = 0; i < projects.size() - 1; i++) {
            for (int j = 0; j < projects.size() - i - 1; j++) {
                if (projects.get(j).getID() > projects.get(j + 1).getID()) {

                    //exchange the 2 ID of the adjacent projects
                    int tempID = projects.get(j).getID();
                    projects.get(j).setID(projects.get(j + 1).getID());
                    projects.get(j + 1).setID(tempID);

                    //exchange the 2 projects next to each other 
                    Project tempProject = projects.get(j);
                    update(j, projects.get(j + 1));
                    update((j + 1), tempProject);
                }
            }
        }
    }

    // delete
    public static void delete(Project new_project) {
        Projecthold.projects.remove(new_project);
    }

    // deleteAll
    public static void deleteAll() {
        Projecthold.projects.clear();
    }

    /**
     * @return the projects
     */
    public static ArrayList<Project> getProjects() {
        return Projecthold.projects;
    }

    /**
     * @param projects the projects to set
     */
    public static void setProjects(ArrayList<Project> projects) {
        Projecthold.projects = projects;
    }

    public static void populateProjecthold() {

        int size = Project.getSizeFromDatabase();
        //have to declare new array, populate that array then push it back to the static array since this work. 
        //This is probably having something to do with not declaring new ArrayList<>() at the top
        ArrayList<Project> projectList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            projectList.add(Project.getProjectFromDatabase(i));
        }
        Projecthold.setProjects(projectList);
    }

    public static boolean searchByID(int ID) {
        boolean doesContain = false;
        for (int i = 0; i < Projecthold.getProjects().size(); i++) {
            if (Projecthold.getProjects().get(i).getID() == ID) {
                doesContain = true;
                break;
            }
        }
        return doesContain;
    }

}
