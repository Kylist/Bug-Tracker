/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout.views.project;

import javax.swing.*;

/**
 *
 * @author tug70
 */
public class NewClass extends JFrame{
    private JList<String> countryList;
    public NewClass() {
        //create the model and add elements
        DefaultListModel<String> listModel = new DefaultListModel<>();
        //create the list
        countryList = new JList<>(listModel);
        add(countryList);
        listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");
        listModel.addElement("Canada");
        listModel.addElement("Denmark");
        listModel.addElement("France");
        listModel.addElement("Great Britain");
        listModel.addElement("Japan");
 
        ;
         
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JList Example");       
        this.setSize(200,200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NewClass();
            }
        });
    } 
}
