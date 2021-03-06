/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout.views.sprint;

import common.Sprint.Sprinthold;
import common.User.CurrentUserhold;
import layout.views.project.ProjectUIDropdown;
import common.Project.Projecthold;
import layout.views.screen.ScreenUI;
import layout.views.setting.SettingUI;

/**
 *
 * @author tug70
 */
public class SprintUIDropdown extends javax.swing.JPanel {

    private static int sprintAccessID = -1;
    private boolean editable = false;

    /**
     * Creates new form UserUIDropdown
     */
    public SprintUIDropdown() {
        initComponents();
        Sprinthold.populateSprinthold();
        this.renderUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sprintDropdown = new javax.swing.JComboBox<>();

        sprintDropdown.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        sprintDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all sprint", "#1", "#2", "#3", "#4" }));
        sprintDropdown.setPreferredSize(new java.awt.Dimension(110, 20));
        sprintDropdown.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                sprintDropdownPopupMenuWillBecomeVisible(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                sprintDropdownPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        sprintDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sprintDropdownActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sprintDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sprintDropdown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sprintDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sprintDropdownActionPerformed
        Object selected = this.getSprintDropdown().getSelectedItem();
        if (editable == true) {
            if (selected == "--all sprint--") {
                SprintUIDropdown.setSprintAccessID(-1);

            } else if (selected == "+ Add sprint") {
                //adding new project
                SprintUICreateUpdate create = new SprintUICreateUpdate();
                //create new int ID that is the next highest number according to the last item in project size()
                int ID = Sprinthold.getSprints().get(Sprinthold.getSprints().size() - 1).getID() + 1;
                create.setIDint(ID);
                create.getDeleteButton().setVisible(false);
                SprintUIDropdown.setSprintAccessID(-1);
                create.setCreateUpdateLabel("Create Sprint");
                create.setSubmitButton("Create");
                create.setVisible(true);
            } else {
                //updating existed project
                for (int i = 0; i < Sprinthold.getSprints().size(); i++) {
                    //check condition of the name of the item and if the project of the sprint match the current chosen project.
                    //this is because some sprint name is identical so the first incident always get taken first
                    if (String.valueOf(Sprinthold.getSprints().get(i).getName()).equals(selected) && ProjectUIDropdown.getProjectAccessID() == Sprinthold.getSprints().get(i).getProjectID()) {
                        //check access range to see if user are allow to edit project--only PM and higher should do this
                        if (CurrentUserhold.getUser().getAccessRange() > 2) {
                            //check if in setting this is changed to true to prevent annoyance
                            if (SettingUI.isSprintEditToggle() == true) {
                                SprintUICreateUpdate update = new SprintUICreateUpdate();
                                update.setUpdateInformation(Sprinthold.getSprints().get(i));
                                update.setCreateUpdateLabel("Update Sprint");
                                update.setSubmitButton("Update");
                                update.setVisible(true);
                            }
                        }
                        SprintUIDropdown.setSprintAccessID(Sprinthold.getSprints().get(i).getID());
                        break;
                    }
                }
            }
            ScreenUI.getLayoutUI().refreshAllBoard();
        }


    }//GEN-LAST:event_sprintDropdownActionPerformed

    private void sprintDropdownPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_sprintDropdownPopupMenuWillBecomeInvisible
        editable = false;
    }//GEN-LAST:event_sprintDropdownPopupMenuWillBecomeInvisible

    private void sprintDropdownPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_sprintDropdownPopupMenuWillBecomeVisible
        editable = true;
    }//GEN-LAST:event_sprintDropdownPopupMenuWillBecomeVisible


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> sprintDropdown;
    // End of variables declaration//GEN-END:variables
    public void renderUI() {
        getSprintDropdown().removeAllItems();
        this.getSprintDropdown().addItem("--all sprint--");
        int projectID = ProjectUIDropdown.getProjectAccessID();

        for (int i = 0; i < Sprinthold.getSprints().size(); i++) {

            //all projecti chosen. No sprint will be render
            if (projectID == -1) {
                break;
            } //display sprint based on project
            else {
                //condition to render only sprint with its projectID align with the project ID
                if (Projecthold.getProjects().get(projectID - 1).getID() == Sprinthold.getSprints().get(i).getProjectID()) {
                    this.getSprintDropdown().addItem(String.valueOf(Sprinthold.getSprints().get(i).getName()));
                }
            }
        }
        //only allow user with access range higher than 2 to create new project (PM and ADMIN)
        if (CurrentUserhold.getUser() != null) {
            if (CurrentUserhold.getUser().getAccessRange() > 2 && ProjectUIDropdown.getProjectAccessID() != -1) {
                this.getSprintDropdown().addItem("+ Add sprint");
            }
        }
    }

    /**
     * @return the sprintAccessID
     */
    public static int getSprintAccessID() {
        return sprintAccessID;
    }

    /**
     * @param aSprintAccessID the sprintAccessID to set
     */
    public static void setSprintAccessID(int aSprintAccessID) {
        sprintAccessID = aSprintAccessID;
    }

    /**
     * @return the sprintDropdown
     */
    public javax.swing.JComboBox<String> getSprintDropdown() {
        return sprintDropdown;
    }

    /**
     * @param sprintDropdown the sprintDropdown to set
     */
    public void setSprintDropdown(javax.swing.JComboBox<String> sprintDropdown) {
        this.sprintDropdown = sprintDropdown;
    }
}
