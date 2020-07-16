/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout.views.project;

import common.Project.Projecthold;
import common.Project.Project;
import common.Sprint.Sprinthold;
import common.Task.TaskHold;
import common.Team.Userhold;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import layout.views.CalendarWindowViews;
import layout.views.screen.ScreenUI;
import common.User.CurrentUserhold;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author tug70
 */
public class ProjectUICreateUpdate extends javax.swing.JFrame implements PropertyChangeListener {

    DateFormat df = new SimpleDateFormat("MM-dd-yyyy");

    /**
     * Creates new form ProjectUICreate1
     */
    public ProjectUICreateUpdate() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(ProjectUICreateUpdate.class.getResource("/layout/resource/BugTracker.png")));
        initComponents();
        if (!listModel.isEmpty()) {
            listModel.clear();
        }
        this.getSelectedUserList().setModel(listModel);

        this.getErrorText().setVisible(false);
        if (CurrentUserhold.getUser().getAccessRange() < 3) {
            this.getDeleteButton().setVisible(false);
        }
        ScheckCalendarVisisble = false;
        DcheckCalendarVisisble = false;
        createEvents();
    }

    private void createEvents() {
        // TODO Auto-generated method stub
        CalendarWindowViews Scalendar = new CalendarWindowViews();
        CalendarWindowViews Dcalendar = new CalendarWindowViews();
        Scalendar.setUndecorated(true);
        Scalendar.addPropertyChangeListener(this);
        Dcalendar.setUndecorated(true);
        Dcalendar.addPropertyChangeListener(this);

        startDateDate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (ScheckCalendarVisisble == false) {
                    Scalendar.setLocation(startDateDate.getLocationOnScreen().x, (startDateDate.getLocationOnScreen().y + startDateDate.getHeight()));
                    Scalendar.setVisible(true);
                    ScheckCalendarVisisble = true;
                    DcheckCalendarVisisble = false;
                } else {
                    Scalendar.dispose();
                    ScheckCalendarVisisble = false;
                }
            }
        });

        dueDateDate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (DcheckCalendarVisisble == false) {
                    Dcalendar.setLocation(dueDateDate.getLocationOnScreen().x, (dueDateDate.getLocationOnScreen().y + dueDateDate.getHeight()));
                    Dcalendar.setVisible(true);
                    DcheckCalendarVisisble = true;
                    ScheckCalendarVisisble = false;
                } else {
                    Dcalendar.dispose();
                    DcheckCalendarVisisble = false;
                }
            }
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        //get the selected date from the calendar control and set it to the text field
        if (ScheckCalendarVisisble == true) {
            if (event.getPropertyName().equals("selectedDate")) {

                java.util.Calendar cal = (java.util.Calendar) event.getNewValue();

                SselDate = cal.getTime();

                //DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyy");
                String SstrDate = df.format(SselDate);

                startDateDate.setText(SstrDate);
            }

        } else if(DcheckCalendarVisisble==true) {
            if (event.getPropertyName().equals("selectedDate")) {

                java.util.Calendar cal = (java.util.Calendar) event.getNewValue();
                DselDate = cal.getTime();

                //DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyy");
                String SdueDate = df.format(DselDate);

                dueDateDate.setText(SdueDate);

            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        nameString = new javax.swing.JTextField();
        IDint = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        endDateLabel = new javax.swing.JLabel();
        summaryLabel = new javax.swing.JLabel();
        IDLabel = new javax.swing.JLabel();
        teamLabel = new javax.swing.JLabel();
        startDateDate = new javax.swing.JTextField();
        dueDateDate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        summaryString = new javax.swing.JTextArea();
        createUpdateLabel = new javax.swing.JLabel();
        buttonSection = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        teamDropDown = new javax.swing.JComboBox<>();
        errorText = new javax.swing.JLabel();
        listScroll = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        selectedUserList = new javax.swing.JList<>();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bug Tracker 3000 - Create Project");
        setLocation(new java.awt.Point(100, 100));

        IDint.setEditable(false);

        nameLabel.setText("Name:");

        startDateLabel.setText("Start:");

        endDateLabel.setText("End:");

        summaryLabel.setText("Summary:");

        IDLabel.setText("ID:");

        teamLabel.setText("Team:");

        summaryString.setColumns(20);
        summaryString.setRows(5);
        jScrollPane1.setViewportView(summaryString);
  
        createUpdateLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        createUpdateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        createUpdateLabel.setText("CREATE PROJECT");

        submitButton.setText("add");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonSectionLayout = new javax.swing.GroupLayout(buttonSection);
        buttonSection.setLayout(buttonSectionLayout);
        buttonSectionLayout.setHorizontalGroup(
            buttonSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonSectionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addGap(18, 18, 18)
                .addComponent(deleteButton)
                .addGap(6, 6, 6))
        );
        buttonSectionLayout.setVerticalGroup(
            buttonSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonSectionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buttonSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(deleteButton))
                .addContainerGap())
        );

        teamDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        teamDropDown.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                teamDropDownPopupMenuWillBecomeVisible(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                teamDropDownPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        teamDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamDropDownActionPerformed(evt);
            }
        });

        errorText.setForeground(new java.awt.Color(255, 51, 51));
        errorText.setText("error");

        selectedUserList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        selectedUserList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        selectedUserList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedUserListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(selectedUserList);

        listScroll.setViewportView(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel)
                    .addComponent(startDateLabel)
                    .addComponent(endDateLabel)
                    .addComponent(summaryLabel)
                    .addComponent(IDLabel)
                    .addComponent(teamLabel))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IDint, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(teamDropDown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()

                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameString)
                            .addComponent(startDateDate, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(dueDateDate, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(listScroll))
                .addGap(82, 82, 82))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(errorText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(createUpdateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(createUpdateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorText)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nameString, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameLabel))
                                .addGap(40, 40, 40))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(startDateLabel)
                                .addComponent(startDateDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(endDateLabel)
                        .addComponent(dueDateDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(summaryLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IDLabel)
                    .addComponent(IDint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(teamLabel)
                    .addComponent(teamDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(listScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(buttonSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        //TODO handle case of error
        //TODO handle adding user
        //add that new project Object to the projecthold ArrayList
        Project addProject = createProjectFromFields();
        if(addProject.getID()!=-1){
        //TODO refactor this method to make better sense and reduce time complexity
        //check if it's update or not
        boolean updated = false;
        //for updating new project
        for (int i = 0; i < Projecthold.getProjects().size(); i++) {
            if (addProject.getID() == Projecthold.getProjects().get(i).getID()) {
                //replace the project at i
                Projecthold.getProjects().set(i, addProject);
                updated = true;
                break;
            }
        }
        //for inserting new project
        if (addProject.getID() != -1 && updated == false) {
            Projecthold.insert(addProject);
        }
        //rerender the dropdown in screenUI
        ScreenUI.getProjectUI().renderUI();
        //Close the Project create window
        this.dispose();
        }
        else{
            errorText.setText("There's something wrong with your input, please try again");
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        //delete related task
        for (int j = TaskHold.getTaskList().size() - 1; j >= 0; j--) {
            if (TaskHold.getTaskList().get(j).getProjectID() == Integer.parseInt(this.getIDint().getText())) {
                TaskHold.deleteTask(j);
            }
        }
        for (int j = Sprinthold.getSprints().size() - 1; j >= 0; j--) {
            if (Sprinthold.getSprints().get(j).getProjectID() == Integer.parseInt(this.getIDint().getText())) {
                Sprinthold.getSprints().remove(j);
            }
        }
        Projecthold.delete(Projecthold.getProjects().get(Integer.parseInt(this.getIDint().getText()) - 1));
        //rerender the dropdown in screenUI
        ScreenUI.getLayoutUI().refreshAllBoard();
        ScreenUI.getSprintUI().renderUI();
        ScreenUI.getProjectUI().renderUI();
        //Close the Project create window
        this.dispose();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void teamDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamDropDownActionPerformed
        Object selected = this.teamDropDown.getSelectedItem();

        if (selected != null && ProjectUIDropdown.isAllowListEvent()) {
            if (!this.listModel.contains(selected.toString())) {
                this.addList(selected.toString());
            }
        } else {

        }
    }//GEN-LAST:event_teamDropDownActionPerformed

    private void selectedUserListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedUserListMouseClicked
        int selected = this.getSelectedUserList().getSelectedIndex();
        this.removeList(selected);
    }//GEN-LAST:event_selectedUserListMouseClicked

    private void teamDropDownPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_teamDropDownPopupMenuWillBecomeVisible
        ProjectUIDropdown.setAllowListEvent(true);
    }//GEN-LAST:event_teamDropDownPopupMenuWillBecomeVisible

    private void teamDropDownPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_teamDropDownPopupMenuWillBecomeInvisible
        ProjectUIDropdown.setAllowListEvent(false);
    }//GEN-LAST:event_teamDropDownPopupMenuWillBecomeInvisible


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDLabel;
    private javax.swing.JTextField IDint;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel buttonSection;
    private javax.swing.JLabel createUpdateLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField dueDateDate;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JLabel errorText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane listScroll;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameString;
    private javax.swing.JList<String> selectedUserList;
    private javax.swing.JTextField startDateDate;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel summaryLabel;
    private javax.swing.JTextArea summaryString;
    private javax.swing.JComboBox<String> teamDropDown;
    private javax.swing.JLabel teamLabel;
    private boolean ScheckCalendarVisisble;
    private boolean DcheckCalendarVisisble;
    private Date SselDate;
    private Date DselDate;
    // End of variables declaration//GEN-END:variables
    private DefaultListModel<String> listModel = new DefaultListModel<>();

    public Project createProjectFromFields() {
        try {
            //get all the attributes to insert in Project class
            String name = this.getNameString().getText();
            Date startDate = new Date();
            Date dueDate = new Date();
            if (!this.getStartDateDate().getText().isEmpty()) {
                startDate = new SimpleDateFormat("MM-dd-yyyy").parse(this.getStartDateDate().getText());
            }
            if (!this.getDueDateDate().getText().isEmpty()) {
                dueDate = new SimpleDateFormat("MM-dd-yyyy").parse(this.getDueDateDate().getText());
            }
            Date createDate = new Date();
            String summary = this.getSummaryString().getText();
            int ID = Integer.parseInt(this.getIDint().getText());
            //team will store ID of user
            ArrayList<Integer> team = new ArrayList<>();
            for (int i = 0; i < listModel.size(); i++) {
                int userID = Userhold.searchNmeOutputID(listModel.get(i));
                team.add(userID);
            }
            //have to add admin
            if (!team.contains(8)) {
                team.add(8);
            }
            //add the current user who create the project, which is usually PM
            if (!team.contains(CurrentUserhold.getUser().getID())) {
                team.add(CurrentUserhold.getUser().getID());
            }
            Userhold.bublesort(team);

            //add all attribute to a new project Object
            Project addProject = new Project(ID, name, createDate, startDate, dueDate, summary, team);
            return addProject;
        } catch (Exception e) {
            System.out.println(e);
            return new Project(-1);
        }

    }

    public void setUpdateInformation(Project project) {
        this.setIDint(project.getID());
        this.setDueDateDate(project.getDueDate());
        this.setStartDateDate(project.getStartDate());
        this.setSummaryString(project.getSummary());
        this.setNameString(project.getName());

    }

    /**
     * @return the IDint
     */
    public javax.swing.JTextField getIDint() {
        return IDint;
    }

    /**
     * @param IDint the IDint to set
     */
    public void setIDint(int IDint) {
        this.IDint.setText(String.valueOf(IDint));
    }

    /**
     * @return the endDateDate
     */
    public javax.swing.JTextField getDueDateDate() {
        return dueDateDate;
    }

    /**
     * @param endDateDate the endDateDate to set
     */
    public void setDueDateDate(Date endDateDate) {
        this.dueDateDate.setText(df.format(endDateDate));
    }

    /**
     * @return the nameString
     */
    public javax.swing.JTextField getNameString() {
        return nameString;
    }

    /**
     * @param nameString the nameString to set
     */
    public void setNameString(String nameString) {
        this.nameString.setText(nameString);
    }

    /**
     * @return the startDateDate
     */
    public javax.swing.JTextField getStartDateDate() {
        return startDateDate;
    }

    /**
     * @param startDateDate the startDateDate to set
     */
    public void setStartDateDate(Date startDateDate) {
        this.startDateDate.setText(df.format(startDateDate));
    }

    /**
     * @return the summaryString
     */
    public javax.swing.JTextArea getSummaryString() {
        return summaryString;
    }

    /**
     * @param summaryString the summaryString to set
     */
    public void setSummaryString(String summaryString) {
        this.summaryString.setText(summaryString);
    }

    /**
     * @return the teamDropDown
     */
    public javax.swing.JComboBox<String> getTeamDropDown() {
        return teamDropDown;
    }

    /**
     * @param teamDropDown the teamDropDown to set
     */
    public void setTeamDropDown(String teamDropDown) {
        this.teamDropDown.addItem(teamDropDown);
    }

    /**
     * @return the createUpdateLabel
     */
    public javax.swing.JLabel getCreateUpdateLabel() {
        return createUpdateLabel;
    }

    /**
     * @param createUpdateLabel the createUpdateLabel to set
     */
    public void setCreateUpdateLabel(String createUpdateLabel) {
        this.createUpdateLabel.setText(createUpdateLabel);
    }

    /**
     * @return the deleteButton
     */
    public javax.swing.JButton getDeleteButton() {
        return deleteButton;
    }

    /**
     * @param deleteButton the deleteButton to set
     */
    public void setDeleteButton(javax.swing.JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    /**
     * @return the errorText
     */
    public javax.swing.JLabel getErrorText() {
        return errorText;
    }

    /**
     * @param errorText the errorText to set
     */
    public void setErrorText(javax.swing.JLabel errorText) {
        this.errorText = errorText;
    }

    /**
     * @return the submitButton
     */
    public javax.swing.JButton getSubmitButton() {
        return submitButton;
    }

    /**
     * @param submitButton the submitButton to set
     */
    public void setSubmitButton(String submitButton) {
        this.submitButton.setText(submitButton);
    }

    /**
     * @return the listScroll
     */
    public javax.swing.JScrollPane getListScroll() {
        return listScroll;
    }

    /**
     * @param listScroll the listScroll to set
     */
    public void setListScroll(javax.swing.JScrollPane listScroll) {
        this.listScroll = listScroll;
    }

    /**
     * @return the selectedUserList
     */
    public javax.swing.JList<String> getSelectedUserList() {
        return selectedUserList;
    }

    /**
     * @param selectedUserList the selectedUserList to set
     */
    public void setSelectedUserList(javax.swing.JList<String> selectedUserList) {
        this.selectedUserList = selectedUserList;
    }

    public void addList(String add) {
        getListModel().addElement(add);
    }

    public void removeList(int remove) {
        if (remove != -1) {
            getListModel().remove(remove);
        }
    }

    /**
     * @return the listModel
     */
    public DefaultListModel<String> getListModel() {
        return listModel;
    }

    /**
     * @param listModel the listModel to set
     */
    public void setListModel(DefaultListModel<String> listModel) {
        this.listModel = listModel;
    }
}
