package layout.views.SwitchBoardPopUp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import common.Enum.TaskStatus;
import common.Project.Projecthold;
import common.Task.Task;
import common.User.CurrentUserhold;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import layout.views.BoardUI.BoardUI;
import layout.views.screen.ScreenUI;


public class SwitchBoardPopUp extends JPopupMenu {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel moveLabel;
	JMenuItem onNew;
	JMenuItem onTaken;
	JMenuItem ongoing;
	JMenuItem onReview;
	JMenuItem onFinish;
	private Task task;
	BoardUI parentBoard;
	
    public SwitchBoardPopUp(Task task, BoardUI parentBoard) {
    	this.task = task;
    	this.parentBoard = parentBoard;
    	moveLabel = new JLabel("Change status to:");
    	onNew = new JMenuItem("ON NEW");
    	onTaken = new JMenuItem("ON TAKEN");
    	ongoing = new JMenuItem("ONGOING");
    	onReview = new JMenuItem("ON REVIEW");
    	onFinish = new JMenuItem("ON FINISH");
    	onNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(task.getStatus()!=TaskStatus.ONNEW) {
					task.setStatus(TaskStatus.ONNEW);
                                        task.setAssignees(new ArrayList<>(Projecthold.getProjects().get(task.getProjectID()-1).getTeam()));
					ScreenUI.getLayoutUI().refreshAllBoard();
				}
			}
    		
    	});
    	onTaken.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(task.getStatus()!=TaskStatus.ONTAKEN) {
					task.setStatus(TaskStatus.ONTAKEN);
                                        task.setAssignees(new ArrayList<>(Arrays.asList(CurrentUserhold.getUser().getID(), 8)));
					ScreenUI.getLayoutUI().refreshAllBoard();
				}
			}
    		
    	});
    	ongoing.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(task.getStatus()!=TaskStatus.ONGOING) {
					task.setStatus(TaskStatus.ONGOING);
                                        task.setAssignees(new ArrayList<>(Arrays.asList(CurrentUserhold.getUser().getID(), 8)));
					ScreenUI.getLayoutUI().refreshAllBoard();
				}
			}
    		
    	});
    	onReview.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(task.getStatus()!=TaskStatus.ONREVIEW) {
					task.setStatus(TaskStatus.ONREVIEW);
                                        task.setAssignees(new ArrayList<>(Projecthold.getProjects().get(task.getProjectID()-1).getTeam()));
					ScreenUI.getLayoutUI().refreshAllBoard();
				}
			}
    		
    	});
    	onFinish.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(task.getStatus()!=TaskStatus.ONFINISH) {
					task.setStatus(TaskStatus.ONFINISH);
                                        task.setAssignees(new ArrayList<>(Projecthold.getProjects().get(task.getProjectID()-1).getTeam()));
					ScreenUI.getLayoutUI().refreshAllBoard();
				}
			}
    		
    	});
    	
    	add(moveLabel);
    	add(onNew);
    	add(onTaken);
    	add(ongoing);
    	add(onReview);
    	add(onFinish);
    }
}