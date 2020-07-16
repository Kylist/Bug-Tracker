/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout.views.setting;

/**
 *
 * @author tug70
 */
public class SettingUI extends javax.swing.JPanel {
    private static boolean ProjectEditToggle;
    private static boolean SprintEditToggle;
    private static boolean TeamEditToggle;
    private static boolean SendEmailToggle;
    /**
     * Creates new form settingUI
     */
    public SettingUI() {
        initComponents();
        ProjectEditToggle=false;
        SprintEditToggle=false;
        TeamEditToggle=false;
        SendEmailToggle=false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editSprint = new javax.swing.JToggleButton();
        editTeam = new javax.swing.JToggleButton();
        sendEmailToggle = new javax.swing.JToggleButton();
        editProject = new javax.swing.JToggleButton();

        setPreferredSize(new java.awt.Dimension(190, 50));

        editSprint.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        editSprint.setSelected(true);
        editSprint.setText("edit sprint");
        editSprint.setPreferredSize(new java.awt.Dimension(85, 20));
        editSprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSprintActionPerformed(evt);
            }
        });

        editTeam.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        editTeam.setSelected(true);
        editTeam.setText("edit team");
        editTeam.setPreferredSize(new java.awt.Dimension(85, 20));
        editTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTeamActionPerformed(evt);
            }
        });

        sendEmailToggle.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        sendEmailToggle.setSelected(true);
        sendEmailToggle.setText("send Email");
        sendEmailToggle.setPreferredSize(new java.awt.Dimension(85, 20));
        sendEmailToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendEmailToggleActionPerformed(evt);
            }
        });

        editProject.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        editProject.setSelected(true);
        editProject.setText("edit project");
        editProject.setPreferredSize(new java.awt.Dimension(85, 20));
        editProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProjectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editSprint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendEmailToggle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editTeam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editSprint, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendEmailToggle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editSprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSprintActionPerformed
       setSprintEditToggle(!isSprintEditToggle());
    }//GEN-LAST:event_editSprintActionPerformed

    private void editTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTeamActionPerformed
        setTeamEditToggle(!isTeamEditToggle());
    }//GEN-LAST:event_editTeamActionPerformed

    private void sendEmailToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendEmailToggleActionPerformed
        setSendEmailToggle(!isSendEmailToggle());
    }//GEN-LAST:event_sendEmailToggleActionPerformed

    private void editProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProjectActionPerformed
        setProjectEditToggle(!isProjectEditToggle());
    }//GEN-LAST:event_editProjectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton editProject;
    private javax.swing.JToggleButton editSprint;
    private javax.swing.JToggleButton editTeam;
    private javax.swing.JToggleButton sendEmailToggle;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the ProjectEditToggle
     */
    public static boolean isProjectEditToggle() {
        return ProjectEditToggle;
    }

    /**
     * @param aProjectEditToggle the ProjectEditToggle to set
     */
    public static void setProjectEditToggle(boolean aProjectEditToggle) {
        ProjectEditToggle = aProjectEditToggle;
    }

    /**
     * @return the SprintEditToggle
     */
    public static boolean isSprintEditToggle() {
        return SprintEditToggle;
    }

    /**
     * @param aSprintEditToggle the SprintEditToggle to set
     */
    public static void setSprintEditToggle(boolean aSprintEditToggle) {
        SprintEditToggle = aSprintEditToggle;
    }

    /**
     * @return the TeamEditToggle
     */
    public static boolean isTeamEditToggle() {
        return TeamEditToggle;
    }

    /**
     * @param aTeamEditToggle the TeamEditToggle to set
     */
    public static void setTeamEditToggle(boolean aTeamEditToggle) {
        TeamEditToggle = aTeamEditToggle;
    }

    /**
     * @return the SendEmailToggle
     */
    public static boolean isSendEmailToggle() {
        return SendEmailToggle;
    }

    /**
     * @param aSendEmailToggle the SendEmailToggle to set
     */
    public static void setSendEmailToggle(boolean aSendEmailToggle) {
        SendEmailToggle = aSendEmailToggle;
    }
}
