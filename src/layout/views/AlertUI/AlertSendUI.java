package layout.views.AlertUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import layout.views.project.ProjectUIDropdown;
import layout.views.screen.ScreenUI;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.event.PopupMenuListener;

import common.Alert.Alert;
import common.Alert.AlertHold;
import common.Comment.CommentsOneTaskHold;
import common.Enum.TaskStatus;
import common.Enum.TaskType;
import common.Project.Project;
import common.Project.Projecthold;
import common.Sprint.Sprint;

import common.Team.Userhold;
import common.Ultilities.Utilities;
import common.User.CurrentUserhold;
import common.User.User;
import layout.views.AlertUI.AlertBoardUI;
import layout.views.BoardUI.BoardUI;


import javax.swing.event.PopupMenuEvent;
import java.awt.Toolkit;
import javax.swing.JTextArea;

public class AlertSendUI extends JFrame {

	private JPanel AlertSendPanel;
	private JTextField NameString;
	private JLabel AlertNameLabel;
	private JLabel Message;
	private JLabel ReceiverLabel;
	private JButton SendButton;
	private JScrollPane listScroll;
	private JScrollPane listScroll_1;
	private JList<String> SelectedUserList;
	private JComboBox<ComboItem> teamDropDown;
	private DefaultListModel<String> listModel = new DefaultListModel<>();
	private JTextField IDint;
	private JLabel ProjectAssignBarLabel;
	private JComboBox<ComboItem> ProjectAssignBar;
	private AlertBoardUI alertboardUI;
	private List<User> users;
	int projectID = 1;
	private JTextArea messageString;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AlertSendUI() {
		setTitle("Bug Tracker 3000 - Alert Sending");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AlertSendUI.class.getResource("/layout/resource/BugTracker.png")));
		alertboardUI = new AlertBoardUI();
		initComponent();
		eventHandler();
		if (!listModel.isEmpty()) {
            listModel.clear();
        }
		
	}

	private void eventHandler() {
		// TODO Auto-generated method stub
		SendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		       addAlert();
		        ((JFrame) SendButton.getParent().getParent().getParent().getParent()).dispose();
			}
		}); 
		}
	
	/**
     * @return the teamDropDown
     */
	public javax.swing.JComboBox<ComboItem> getTeamDropDown() {
        return teamDropDown;
    }

    /**
     * @param teamDropDown the teamDropDown to set
     */
    
	public void setTeamDropDown(ComboItem teamDropDown) {
        this.teamDropDown.addItem(teamDropDown);
    }
	
	public DefaultListModel<String> getListModel() {
        return listModel;
    }

    /**
     * @param listModel the listModel to set
     */
    public void setListModel(DefaultListModel<String> listModel) {
        this.listModel = listModel;
    }
    
    public javax.swing.JScrollPane getListScroll() {
        return listScroll_1;
    }

    /**
     * @param listScroll the listScroll to set
     */
    public void setListScroll(javax.swing.JScrollPane listScroll) {
        this.listScroll_1 = listScroll;
    }

    /**
     * @return the selectedUserList
     */
    public javax.swing.JList<String> getSelectedUserList() {
    	return this.SelectedUserList;
    }

    /**
     * @param selectedUserList the selectedUserList to set
     */
    public void setSelectedUserList(javax.swing.JList<String> selectedUserList) {
        this.SelectedUserList = selectedUserList;
    }

	
	public void addList(String add) {
        getListModel().addElement(add);
    }

    public void removeList(int remove) {
        if (remove != -1) {
            getListModel().remove(remove);
        }
    }
    
	private void teamDropDownPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_teamDropDownPopupMenuWillBecomeVisible
        ProjectUIDropdown.setAllowListEvent(true);
    }//GEN-LAST:event_teamDropDownPopupMenuWillBecomeVisible

    private void teamDropDownPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_teamDropDownPopupMenuWillBecomeInvisible
        ProjectUIDropdown.setAllowListEvent(false);
    }//GEN-LAST:event_teamDropDownPopupMenuWillBecomeInvisible
    
    private void teamDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamDropDownActionPerformed
        Object selected = this.teamDropDown.getSelectedItem();

        if (selected != null && ProjectUIDropdown.isAllowListEvent()) {
            if (!this.listModel.contains(selected.toString())) {
                this.addList(selected.toString());
                
            }
        }
        else{
            
        }
    }//GEN-LAST:event_teamDropDownActionPerformed
    private void selectedUserListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedUserListMouseClicked
        int selected = this.getSelectedUserList().getSelectedIndex();
        this.removeList(selected);
    }//GEN-LAST:event_selectedUserListMouseClicked
    
	private void initComponent() {
		setBounds(50, 50, 486, 578);
        
        listScroll = new javax.swing.JScrollPane();
        SelectedUserList = new javax.swing.JList<>();
        teamDropDown = new JComboBox<ComboItem>();
        ProjectAssignBar = new JComboBox<ComboItem>();
         //alertboardUI = new AlertBoardUI();
        SelectedUserList.setModel(listModel);
        teamDropDown.addPopupMenuListener(new PopupMenuListener() {
        	public void popupMenuCanceled(PopupMenuEvent e) {
        	}
        	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
        		teamDropDownPopupMenuWillBecomeInvisible(e);
        	}
        	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
        		teamDropDownPopupMenuWillBecomeVisible(e);
        	}
        });
        SelectedUserList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedUserListMouseClicked(evt);
            }
        });
        List<Project> projects = Projecthold.getProjects();
        
        for (int i = 0; i < projects.size(); i++) {
        	ComboItem x= new ComboItem(projects.get(i).getName(), projects.get(i).getID());
            ProjectAssignBar.addItem(x);
        }

        users = Userhold.getUsers();
        int currentProjID = (int) ((ComboItem) ProjectAssignBar.getSelectedItem()).getValue();
        teamDropDown.removeAllItems();
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < Projecthold.getProjects().get(currentProjID-1).getTeam().size(); j++) {
            	
                if (users.get(i).getID() == Projecthold.getProjects().get(currentProjID-1).getTeam().get(j) ) {
                	teamDropDown.addItem(new ComboItem(users.get(i).getName(), users.get(i).getID()));
                }
            }
        }
        listScroll_1 = new JScrollPane();
        listScroll_1.setViewportView(SelectedUserList);

		
		AlertSendPanel = new JPanel();
		AlertSendPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AlertSendPanel);
		
		AlertNameLabel = new JLabel("Alert Name: ");
		
		NameString = new JTextField();
		NameString.setColumns(10);
		
		Message = new JLabel("Message: ");
		
		ReceiverLabel = new JLabel("Send To: ");
		
		SendButton = new JButton("Send");
		
		
		
		teamDropDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teamDropDownActionPerformed(e);
				
			}
		});
		
		
		
		IDint = new JTextField();
		IDint.setEditable(false);
		IDint.setColumns(10);
		
		ProjectAssignBarLabel = new JLabel("Project");
		
		
		
		ProjectAssignBar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
                for (int j = 0; j < Projecthold.getProjects().size(); j++) {
                	if(Projecthold.getProjects().get(j).getTeam().contains(CurrentUserhold.getUser().getID())) {
                    if (Projecthold.getProjects().get(j).getName().equals(ProjectAssignBar.getSelectedItem().toString())) {
                        projectID = Projecthold.getProjects().get(j).getID();
                        break;
                    }}
                }
                
                int currentProjID = (int) ((ComboItem) ProjectAssignBar.getSelectedItem()).getValue();
                teamDropDown.setModel(new DefaultComboBoxModel<ComboItem>());
                for (int i = 0; i < users.size(); i++) {
                    for (int j = 0; j < Projecthold.getProjects().get(currentProjID-1).getTeam().size(); j++) {
                        if (users.get(i).getID() == Projecthold.getProjects().get(projectID-1).getTeam().get(j)) {
                        	teamDropDown.addItem(new ComboItem(users.get(i).getName(), users.get(i).getID()));
                        }
                    }
                }
			}
		});
		
		messageString = new JTextArea();
		
		JLabel IDLabel = new JLabel("ID:");
		
		GroupLayout gl_AlertSendPanel = new GroupLayout(AlertSendPanel);
		gl_AlertSendPanel.setHorizontalGroup(
			gl_AlertSendPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_AlertSendPanel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_AlertSendPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(SendButton, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_AlertSendPanel.createSequentialGroup()
							.addGroup(gl_AlertSendPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(AlertNameLabel)
								.addComponent(Message, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_AlertSendPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_AlertSendPanel.createSequentialGroup()
									.addGroup(gl_AlertSendPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(ProjectAssignBarLabel)
										.addComponent(ProjectAssignBar, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
									.addGap(39)
									.addGroup(gl_AlertSendPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(ReceiverLabel)
										.addComponent(listScroll_1, 0, 0, Short.MAX_VALUE)
										.addComponent(teamDropDown, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_AlertSendPanel.createSequentialGroup()
									.addComponent(NameString, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(IDLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(IDint, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
								.addComponent(messageString))))
					.addGap(40))
		);
		gl_AlertSendPanel.setVerticalGroup(
			gl_AlertSendPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AlertSendPanel.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_AlertSendPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AlertSendPanel.createSequentialGroup()
							.addComponent(AlertNameLabel)
							.addGap(18)
							.addComponent(Message))
						.addGroup(gl_AlertSendPanel.createSequentialGroup()
							.addGroup(gl_AlertSendPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(NameString, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(IDint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(IDLabel))
							.addGap(18)
							.addComponent(messageString, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addGroup(gl_AlertSendPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_AlertSendPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(ReceiverLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(teamDropDown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_AlertSendPanel.createSequentialGroup()
									.addComponent(ProjectAssignBarLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(ProjectAssignBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(listScroll_1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(SendButton)
					.addGap(24))
		);
		
		
		AlertSendPanel.setLayout(gl_AlertSendPanel);
		
	}
	public Alert createAlertFromFields() {
        try {
            //get all the attributes to insert in Alert class
            String name = this.getNameString().getText();
            String message = this.getmessageString().getText();
            int ID = Integer.parseInt(this.getIDint().getText());
            
            
            //Receiver will store ID of users
            ArrayList<Integer> receiver = new ArrayList<>();
            for(int i=0;i<listModel.size();i++){
                int receiverID=Userhold.searchNmeOutputID(listModel.get(i));
                receiver.add(receiverID);
            }
           
            
            //add the current user who send alert
            if(!receiver.contains(CurrentUserhold.getUser().getID())){
                receiver.add(CurrentUserhold.getUser().getID());
            }
            AlertHold.bublesort(receiver);

            //add all attribute to a new alert Object
            Alert addAlert = new Alert(ID, name, message, receiver);
            return addAlert;
            
        } catch (Exception e) {
            System.out.println(e);
            return new Alert(-1, "nothing", "nothing");
        }

    }

    public void setUpdateInformation(Alert alert) {
    	this.setIDint(alert.getID());
        this.setmessageString(alert.getmessage());
        this.setNameString(alert.getName());

    }
   
  
    /**
     * @return the nameString
     */
    public javax.swing.JTextField getNameString() {
        return NameString;
    }

    /**
     * @param nameString the nameString to set
     */
    public void setNameString(String nameString) {
        this.NameString.setText(nameString);
    }
    
    /**
     * @return the nameString
     */
    public javax.swing.JTextArea getmessageString() {
        return messageString;
    }

    /**
     * @param nameString the nameString to set
     */
    public void setmessageString(String messageString) {
        this.messageString.setText(messageString);
    }
    
    public javax.swing.JTextField getIDint() {
        return IDint;
    }

    /**
     * @param IDint the IDint to set
     */
    public void setIDint(int IDint) {
        this.IDint.setText(String.valueOf(IDint));
    }
    
    public void addAlert() {
        //add task and notify main UI
        ArrayList<Integer> receivers = new ArrayList<>();
        if (listModel.size() == 0) {
        	receivers = Projecthold.getProjects().get((int) ((ComboItem) ProjectAssignBar.getSelectedItem()).getValue() - 1).getTeam();
        } else {
            for (int i = 0; i < listModel.size(); i++) {
                int userID = Userhold.searchNmeOutputID(listModel.get(i));
                receivers.add(userID);
            }
            //have to add admin
            if (!receivers.contains(8)) {
            	receivers.add(8);
            }
            //add the current user who create the project, which is usually PM
            if (!receivers.contains(CurrentUserhold.getUser().getID())) {
            	receivers.add(CurrentUserhold.getUser().getID());
            }
        }

        Alert alert = new Alert(AlertHold.getAlertList().size() + 1,
                NameString.getText(), messageString.getText(), receivers, CurrentUserhold.getUser().getID());
        
        alert.addReceivers((int) ((ComboItem) teamDropDown.getSelectedItem()).getValue());
        AlertHold.addAlert(alert);
        
       if (this.alertboardUI != null) {
            this.alertboardUI.refresh();
            AlertUI.addAlert();
        	
        }
    }
}

class ComboItem {

    private String key;
    private Object value;

    public ComboItem(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public ComboItem(String key, int value) {
        this.key = key;
        this.value = value;
    }

   

    @Override
    public String toString() {
        return key;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}



