/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.Comment;

import common.Task.TaskHold;
import java.util.ArrayList;

/**
 *
 * @author tug70
 */
public class CommentsAllHold {


    private static ArrayList<Comment> allCommentHold;

    public static void populateCommentsAllHold() {
        int taskSize = TaskHold.getTaskHoldSizeFromDatabase();
        //have to declare new array, populate that array then push it back to the static array since this work. 
        //This is probably having something to do with not declaring new ArrayList<>() at the top
        ArrayList<Comment> commentAllList = new ArrayList<>();
        if (taskSize != -1) {
            for (int i = 0; i < taskSize; i++) {
                int commentSizeOfTask = Comment.getSizeCommentsOfOneTaskFromDatabase(i);
                if (commentSizeOfTask != 0) {
                    for (int j = 0; j < commentSizeOfTask; j++) {
                        Comment comment = Comment.getCommentFromDatabase(i, j);
                        commentAllList.add(comment);

                    }
                }

            }
        }
        CommentsAllHold.setAllCommentHold(commentAllList);
    }

    /**
     * @return the allCommentHold
     */
    public static ArrayList<Comment> getAllCommentHold() {
        return allCommentHold;
    }

    /**
     * @param aAllCommentHold the allCommentHold to set
     */
    public static void setAllCommentHold(ArrayList<Comment> aAllCommentHold) {
        allCommentHold = aAllCommentHold;
    }
}
