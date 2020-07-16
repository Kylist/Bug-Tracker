/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout.views.LogInUI;

import common.Alert.AlertHold;
import common.Team.Userhold;
import common.User.CurrentUserhold;
import common.User.User;
import layout.views.AlertUI.AlertUI;
import layout.views.screen.ScreenUI;
import java.awt.Toolkit;



/**
 *
 * @author tug70
 */
public class LogInUI extends javax.swing.JFrame {

    /**
     * Creates new form LogInUI
     */
    public LogInUI() {
    	setTitle("Bug Tracker 3000 - Log In");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(LogInUI.class.getResource("/layout/resource/BugTracker.png")));
        initComponents();
        this.getErrorLabel().setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogInLabel = new javax.swing.JLabel();
        emailString = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        emailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();
        PasswordString = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LogInLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LogInLabel.setText("Log in");

        submitButton.setText("submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        emailLabel.setText("email:");

        passwordLabel.setText("password:");

        errorLabel.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText("Error");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(LogInLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(emailLabel)
                                .addGap(18, 18, 18)
                                .addComponent(emailString, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(passwordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PasswordString, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(70, Short.MAX_VALUE))
            .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LogInLabel)
                .addGap(2, 2, 2)
                .addComponent(errorLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailString, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordString, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addGap(18, 18, 18)
                .addComponent(submitButton)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        String email = this.getEmailString().getText();
        String password = String.valueOf(this.getPasswordString().getPassword());

        if (!email.equals("") && !password.equals("")) {
            this.setErrorLabel(this.getEmailString().getText() + " " + String.valueOf(this.getPasswordString().getPassword()));
            if (CurrentUserhold.logInhUser(email, password) == true) {
                User user = Userhold.search(email);
                CurrentUserhold.setUser(user);
                ScreenUI.renderUI();
                ScreenUI.getUserUI().getAuthentication().setText("Log out");
                //reload task?
                ScreenUI.getLayoutUI().refreshAllBoard();
                ScreenUI.getUserUI().renderUI();
                //ScreenUI.getUserUI().setVisible(true);
                AlertUI alert = new AlertUI();
                for (int i = 0; i< AlertHold.getAlertList().size(); i++ ) {
                if (AlertHold.getAlertList().get(i).getReceivers().contains(CurrentUserhold.getUser().getID())) {
                alert.setVisible(true);
                }else {
                	alert.setVisible(false);
                }}
                this.dispose();
            } else {
                getErrorLabel().setVisible(true);
                this.setErrorLabel("Email or password not in database or not match");
            }
        } else {
            getErrorLabel().setVisible(true);
            this.setErrorLabel("Email or password must both be filled to continue");
        }
    }//GEN-LAST:event_submitButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogInUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogInLabel;
    private javax.swing.JPasswordField PasswordString;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailString;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the PasswordString
     */
    public javax.swing.JPasswordField getPasswordString() {
        return PasswordString;
    }

    /**
     * @param PasswordString the PasswordString to set
     */
    public void setPasswordString(String PasswordString) {
        this.PasswordString.setText(PasswordString);
    }

    /**
     * @return the emailString
     */
    public javax.swing.JTextField getEmailString() {
        return emailString;
    }

    /**
     * @param emailString the emailString to set
     */
    public void setEmailString(String emailString) {
        this.emailString.setText(emailString);
    }

    /**
     * @return the errorLabel
     */
    public javax.swing.JLabel getErrorLabel() {
        return errorLabel;
    }

    /**
     * @param errorLabel the errorLabel to set
     */
    public void setErrorLabel(String errorLabel) {
        this.errorLabel.setText(errorLabel);
    }

    /**
     * @return the submitButton
     */
    public javax.swing.JButton getSubmitButton() {
        return submitButton;
    }

}
