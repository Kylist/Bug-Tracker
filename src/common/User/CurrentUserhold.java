/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.User;


import common.Team.Userhold;

/**
 *
 * @author tug70
 */
public class CurrentUserhold {
    private static User user;

    /**
     * @return the user
     */
    public static User getUser() {
        return user;
    }

    /**
     * @param aUser the user to set
     */
    public static void setUser(User aUser) {
        user = aUser;
    }
    public static boolean logInhUser(String email, String password){
        boolean credential=false;
        for(int i=0; i<Userhold.getUsers().size();i++){
            if(email.equals(Userhold.getUsers().get(i).getEmail())&&password.equals(Userhold.getUsers().get(i).getPassword())){
                credential=true;
                break;
            }
        }
        return credential;
    }
}
