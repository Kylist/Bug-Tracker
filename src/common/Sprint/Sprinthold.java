/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.Sprint;

import java.util.ArrayList;

/**
 *
 * @author tug70
 */
public class Sprinthold {
    private static ArrayList<Sprint> sprints;
    
    public Sprinthold(){
    }
    
   
    public static void populateSprinthold(){
        ArrayList<Sprint> sprintList=new ArrayList<>();
        for(int i=0; i<Sprint.getSizeFromDatabase(); i++){
            sprintList.add(Sprint.getSprintFromDatabase(i));
        }
        Sprinthold.setSprints(sprintList);
    }
    /**
     * @return the sprints
     */
    public static ArrayList<Sprint> getSprints() {
        return Sprinthold.sprints;
    }

    /**
     * @param sprints the sprints to set
     */
    public static void setSprints(ArrayList<Sprint> sprints) {
        Sprinthold.sprints = sprints;
    }
        //insert
    //TODO sort as insert
     public static void insert(Sprint new_user){
        Sprinthold.sprints.add(new_user);
    }
    //update
    public static void update(int index, Sprint new_user){
        Sprinthold.sprints.set(index, new_user);
    }
    // bubble sort by ID, smallest to head(0), biggest to tail(n)
    //TODO expand to sort by other attribute
    public static void bublesort(){
        for(int i=0;i<sprints.size()-1;i++){
            for(int j=0;j<sprints.size()-i-1;j++){
                if(sprints.get(j).getID()>sprints.get(j+1).getID()){
                    
                    //exchange the 2 ID of the adjacent sprints
                    int tempID=sprints.get(j).getID();
                    sprints.get(j).setID(sprints.get(j+1).getID());
                    sprints.get(j+1).setID(tempID);
                    
                    //exchange the 2 sprints next to each other 
                    Sprint tempSprint=sprints.get(j);
                    update(j, sprints.get(j+1));
                    update((j+1), tempSprint);
                }
            }
        }
    }
    // delete
    public static void delete(Sprint new_user){
        Sprinthold.sprints.remove(new_user);
    }
    
    // deleteAll
    public static void deleteAll(){
        Sprinthold.sprints.clear();
    }
}
