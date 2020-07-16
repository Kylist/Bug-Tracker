/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import javax.swing.SwingUtilities;
import layout.views.screen.ScreenUI;

/**
 *
 * @author tug70
 */
public class MainTest {

    public static void main(String args[]) {
        /*Projecthold projects = new Projecthold();
        TaskHold tasks = new TaskHold();
        User dev = new User(2, Role.DEVELOPER, "chump", "lol", "deve@gmail.com", "dunnt", 2, projects, tasks);
        Project webber = new Project(9, "webber", new Date(), new Date(), new Date(), "strick", new ArrayList<>());
        //System.out.println(dev.getID());

        dev.setID(8);
        CurrentUserhold.setUser(User.getUserFromDatabase(7));**/
        /*CommentsAllHold.populateCommentsAllHold();
        TaskHold.loadTask();*/
        
        //System.out.println("from main test "+CommentsAllHold.getAllCommentHold().size());
        //can't print before insert, there's nothing there. TODO need to find a way so that thí is not null
        //System.out.println(dev.getProjecthold().getProjects().get(0).getProjectID());
        

        ScreenUI screen = new ScreenUI();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                screen.displayJFrame();
            }
        });

    }

}
