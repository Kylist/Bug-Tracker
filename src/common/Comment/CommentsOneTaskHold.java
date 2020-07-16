/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.Comment;

import java.util.ArrayList;

public class CommentsOneTaskHold {

    private ArrayList<Comment> comment;

    public CommentsOneTaskHold(ArrayList<Comment> comment) {
        this.comment = comment;
    }

    public CommentsOneTaskHold() {
    }

    //without static, this need an instance
    public void populateCommentsOneTakHold(int taskNum) {
        ArrayList<Comment> commentList = new ArrayList<>();
        //for reseting purpose
        setComment(commentList);
        if (!CommentsAllHold.getAllCommentHold().isEmpty()) {
            int size = CommentsAllHold.getAllCommentHold().size();
            //have to declare new array, populate that array then push it back to the static array since this work. 
            //This is probably having something to do with not declaring new ArrayList<>() at the top
            for (int i = 0; i < size; i++) {
                if (CommentsAllHold.getAllCommentHold().get(i).getTaskID() == taskNum) {
                    commentList.add(CommentsAllHold.getAllCommentHold().get(i));
                }
            }
            setComment(commentList);
        }
    }

    /**
     * @return the comment
     */
    public ArrayList<Comment> getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(ArrayList<Comment> comment) {
        this.comment = comment;
    }
}
