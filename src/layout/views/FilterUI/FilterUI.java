package layout.views.FilterUI;

import common.Enum.BoardType;
import common.Task.TaskHold;
import common.Team.Userhold;
import common.Ultilities.Utilities;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import layout.views.BoardUI.BoardUI;
import layout.views.screen.ScreenUI;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import layout.views.CalendarWindowViews;
import layout.views.TaskUI.TaskCardUI;

public class FilterUI extends JFrame implements PropertyChangeListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public JPanel FilterViews;
    public JLabel lblNewLabel;
    public JRadioButton summaryRadioButton;

    public JRadioButton reportDateRadioButton;

    public JRadioButton dueDateRadioButton;

    public JRadioButton severityRadioButton;

    public JButton FilterButton;
    private JRadioButton taskIDRadionButton;
    private JTextField summaryString;
    private JTextField IDint;
    private JComboBox severityInt;
    private JRadioButton assignerIDRadioButton;
    private JComboBox assignerIDint;
    private JRadioButton assigneeIDRadioButton;
    private JComboBox assigneeIDint;
    private JTextField reportedDateDate;
    private JTextField dueDateDate;
    private JButton resetButton;
    private boolean ScheckCalendarVisisble;
    private boolean DcheckCalendarVisisble;
    private Date SselDate;
    private Date DselDate;
    private DateFormat df = new SimpleDateFormat("MM-dd-yyyy");

    /**
     * Create the frame.
     *
     * @return
     */
    public FilterUI(BoardUI board) {

        initComponents();
        createEvents(board);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ScheckCalendarVisisble = false;
        DcheckCalendarVisisble = false;

    }

    private void initComponents() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(FilterUI.class.getResource("/layout/resource/BugTracker.png")));
        setTitle("Bug Tracker 3000 - Filter Options\r\n");
        setResizable(false);

        setBounds(50, 50, 380, 560);
        FilterViews = new JPanel();
        FilterViews.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(FilterViews);

        lblNewLabel = new JLabel("Filter Options");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));

        summaryRadioButton = new JRadioButton("Summary");
        reportDateRadioButton = new JRadioButton("Report Date");
        dueDateRadioButton = new JRadioButton("Due Date");
        severityRadioButton = new JRadioButton("Severity");
        assignerIDRadioButton = new JRadioButton("Assigned From");
        assigneeIDRadioButton = new JRadioButton("Assigned To");

        FilterButton = new JButton("filter");

        resetButton = new JButton("reset");

        taskIDRadionButton = new JRadioButton("Task ID");

        summaryString = new JTextField();
        summaryString.setColumns(10);

        IDint = new JTextField();
        IDint.setColumns(10);

        severityInt = new JComboBox();
        int[] severities = Utilities.makeSequence(1, 10);
        for (int i = 0; i < severities.length; i++) {
            severityInt.addItem(severities[i]);
        }

        assignerIDint = new JComboBox();
        assigneeIDint = new JComboBox();
        for (int i = 0; i < Userhold.getUsers().size(); i++) {
            assignerIDint.addItem(new ComboItem(Userhold.getUsers().get(i).getName(), Userhold.getUsers().get(i).getID()));
            assigneeIDint.addItem(new ComboItem(Userhold.getUsers().get(i).getName(), Userhold.getUsers().get(i).getID()));
        }

        reportedDateDate = new JTextField();
        reportedDateDate.setText(Utilities.getDateString(new Date()));
        reportedDateDate.setColumns(10);

        dueDateDate = new JTextField();
        dueDateDate.setText(Utilities.getDateString(new Date()));
        dueDateDate.setColumns(10);

        GroupLayout gl_FilterViews = new GroupLayout(FilterViews);
        gl_FilterViews.setHorizontalGroup(
                gl_FilterViews.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_FilterViews.createSequentialGroup()
                                .addGroup(gl_FilterViews.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_FilterViews.createSequentialGroup()
                                                .addGap(125)
                                                .addGroup(gl_FilterViews.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(severityInt, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(severityRadioButton)
                                                        .addComponent(dueDateDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(reportDateRadioButton)
                                                        .addComponent(taskIDRadionButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_FilterViews.createSequentialGroup()
                                                                .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                                                .addGap(112))
                                                        .addComponent(summaryRadioButton)
                                                        .addGroup(gl_FilterViews.createParallelGroup(Alignment.TRAILING, false)
                                                                .addComponent(IDint, Alignment.LEADING)
                                                                .addComponent(summaryString, Alignment.LEADING))
                                                        .addGroup(gl_FilterViews.createParallelGroup(Alignment.TRAILING, false)
                                                                .addComponent(dueDateRadioButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(reportedDateDate, Alignment.LEADING))
                                                        .addGroup(gl_FilterViews.createParallelGroup(Alignment.TRAILING, false)
                                                                .addComponent(assigneeIDint, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(assignerIDRadioButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(assignerIDint, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(assigneeIDRadioButton)))
                                        .addGroup(Alignment.TRAILING, gl_FilterViews.createSequentialGroup()
                                                .addContainerGap(158, Short.MAX_VALUE)
                                                .addComponent(FilterButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        gl_FilterViews.setVerticalGroup(
                gl_FilterViews.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_FilterViews.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel)
                                .addGap(18)
                                .addComponent(summaryRadioButton)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(summaryString, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(3)
                                .addComponent(taskIDRadionButton)
                                .addGap(1)
                                .addComponent(IDint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(6)
                                .addComponent(reportDateRadioButton)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(reportedDateDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(dueDateRadioButton)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(dueDateDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(severityRadioButton)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(severityInt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(assignerIDRadioButton)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(assignerIDint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(6)
                                .addComponent(assigneeIDRadioButton)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(assigneeIDint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(59)
                                .addGroup(gl_FilterViews.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(FilterButton)
                                        .addComponent(resetButton))
                                .addContainerGap())
        );
        FilterViews.setLayout(gl_FilterViews);

    }

    private void createEvents(BoardUI board) {
        FilterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //summary
                if (summaryRadioButton.isSelected()) {
                    if (board.getBoard().getType() == BoardType.BACKLOG) {
                        for (int i = board.getComponentCount() - 1; i >= 0; i--) {
                            TaskCardUI cardo = (TaskCardUI) board.getComponent(i);
                            if (!cardo.getTask().getQuickSummary().contains(summaryString.getText())) {
                                board.remove(cardo); 
                                ScreenUI.getLayoutUI().getBacklog().setNumOfCardDisplay(ScreenUI.getLayoutUI().getBacklog().getNumOfCardDisplay()-1);
                            }
                        }

                    } else if (board.getBoard().getType() == BoardType.FINISH) {
                        for (int i = board.getComponentCount() - 1; i >= 0; i--) {
                            TaskCardUI cardo = (TaskCardUI) board.getComponent(i);
                            if (!cardo.getTask().getQuickSummary().contains(summaryString.getText())) {
                                board.remove(cardo); 
                                ScreenUI.getLayoutUI().getFinish().setNumOfCardDisplay(ScreenUI.getLayoutUI().getBacklog().getNumOfCardDisplay()-1);
                            }
                        }
                    }
                }
                //task ID
                if (taskIDRadionButton.isSelected()) {
                    String taskID = IDint.getText();
                    int taskIDInt = Integer.parseInt(taskID);
                    if (board.getBoard().getType() == BoardType.BACKLOG) {
                        for (int i = board.getComponentCount() - 1; i >= 0; i--) {
                            TaskCardUI cardo = (TaskCardUI) board.getComponent(i);
                            if (cardo.getTask().getID() != taskIDInt) {
                                board.remove(cardo); 
                                ScreenUI.getLayoutUI().getBacklog().setNumOfCardDisplay(ScreenUI.getLayoutUI().getBacklog().getNumOfCardDisplay()-1);
                            }
                        }

                    } else if (board.getBoard().getType() == BoardType.FINISH) {
                        for (int i = board.getComponentCount() - 1; i >= 0; i--) {
                            TaskCardUI cardo = (TaskCardUI) board.getComponent(i);
                            if (cardo.getTask().getID() != taskIDInt) {
                                board.remove(cardo); 
                                ScreenUI.getLayoutUI().getFinish().setNumOfCardDisplay(ScreenUI.getLayoutUI().getBacklog().getNumOfCardDisplay()-1);
                            }
                        }

                    }
                }
                //severity
                if (severityRadioButton.isSelected()) {
                    String sev = severityInt.getSelectedItem().toString();
                    int sevInt = Integer.parseInt(sev);
                    if (board.getBoard().getType() == BoardType.BACKLOG) {
                        for (int i = board.getComponentCount() - 1; i >= 0; i--) {
                            TaskCardUI cardo = (TaskCardUI) board.getComponent(i);
                            if (cardo.getTask().getSeverity() != sevInt) {
                                board.remove(cardo); 
                                ScreenUI.getLayoutUI().getBacklog().setNumOfCardDisplay(ScreenUI.getLayoutUI().getBacklog().getNumOfCardDisplay()-1);
                            }
                        }

                    } else if (board.getBoard().getType() == BoardType.FINISH) {
                        for (int i = board.getComponentCount() - 1; i >= 0; i--) {
                            TaskCardUI cardo = (TaskCardUI) board.getComponent(i);
                            if (cardo.getTask().getSeverity() != sevInt) {
                                board.remove(cardo); 
                                ScreenUI.getLayoutUI().getFinish().setNumOfCardDisplay(ScreenUI.getLayoutUI().getBacklog().getNumOfCardDisplay()-1);
                            }
                        }

                    }
                }
                //report Date
                if (reportDateRadioButton.isSelected()) {
                    String rep = reportedDateDate.getText();
                    Date repDate = null;
                    try {
                        repDate = Utilities.stringToDate(rep);
                    } catch (ParseException parseception) {
                        System.out.println("bad date format" + parseception);
                    }
                    if (repDate != null) {
                        if (board.getBoard().getType() == BoardType.BACKLOG) {
                            for (int i = board.getComponentCount() - 1; i >= 0; i--) {
                                TaskCardUI cardo = (TaskCardUI) board.getComponent(i);
                                if (cardo.getTask().getReportedDate() != repDate) {
                                    board.remove(cardo); 
                                    ScreenUI.getLayoutUI().getBacklog().setNumOfCardDisplay(ScreenUI.getLayoutUI().getBacklog().getNumOfCardDisplay()-1);
                                }
                            }

                        } else if (board.getBoard().getType() == BoardType.FINISH) {
                            for (int i = board.getComponentCount() - 1; i >= 0; i--) {
                                TaskCardUI cardo = (TaskCardUI) board.getComponent(i);
                                if (cardo.getTask().getReportedDate() != repDate) {
                                    board.remove(cardo); 
                                    ScreenUI.getLayoutUI().getFinish().setNumOfCardDisplay(ScreenUI.getLayoutUI().getBacklog().getNumOfCardDisplay()-1);
                                }
                            }
                        }
                    }
                }
                //due Date
                if (dueDateRadioButton.isSelected()) {
                    String due = dueDateDate.getText();
                    Date duDate = null;
                    try {
                        duDate = Utilities.stringToDate(due);
                    } catch (ParseException parseception) {
                        System.out.println("bad date format" + parseception);
                    }
                    if (duDate != null) {
                        if (board.getBoard().getType() == BoardType.BACKLOG) {
                            for (int i = board.getComponentCount() - 1; i >= 0; i--) {
                                TaskCardUI cardo = (TaskCardUI) board.getComponent(i);
                                if (cardo.getTask().getDueDate() != duDate) {
                                    board.remove(cardo); 
                                    ScreenUI.getLayoutUI().getBacklog().setNumOfCardDisplay(ScreenUI.getLayoutUI().getBacklog().getNumOfCardDisplay()-1);
                                }
                            }

                        } else if (board.getBoard().getType() == BoardType.FINISH) {
                            for (int i = board.getComponentCount() - 1; i >= 0; i--) {
                                TaskCardUI cardo = (TaskCardUI) board.getComponent(i);
                                if (cardo.getTask().getDueDate() != duDate) {
                                    board.remove(cardo); 
                                    ScreenUI.getLayoutUI().getFinish().setNumOfCardDisplay(ScreenUI.getLayoutUI().getBacklog().getNumOfCardDisplay()-1);
                                }
                            }
                        }
                    }
                }
                //assign from
                if (assignerIDRadioButton.isSelected()) {
                    int assignerID = (int) ((ComboItem) assignerIDint.getSelectedItem()).getValue();
                    if (board.getBoard().getType() == BoardType.BACKLOG) {
                        for (int i = board.getComponentCount() - 1; i >= 0; i--) {
                            TaskCardUI cardo = (TaskCardUI) board.getComponent(i);
                            if (cardo.getTask().getAssignerID() != assignerID) {
                                board.remove(cardo); 
                                ScreenUI.getLayoutUI().getBacklog().setNumOfCardDisplay(ScreenUI.getLayoutUI().getBacklog().getNumOfCardDisplay()-1);
                            }
                        }

                    } else if (board.getBoard().getType() == BoardType.FINISH) {
                        for (int i = board.getComponentCount() - 1; i >= 0; i--) {
                            TaskCardUI cardo = (TaskCardUI) board.getComponent(i);
                            if (cardo.getTask().getAssignerID() != assignerID) {
                                board.remove(cardo); 
                                ScreenUI.getLayoutUI().getFinish().setNumOfCardDisplay(ScreenUI.getLayoutUI().getBacklog().getNumOfCardDisplay()-1);
                            }
                        }

                    }
                }
                //assign to
                if (assigneeIDRadioButton.isSelected()) {
                    int assigneeID = (int) ((ComboItem) assigneeIDint.getSelectedItem()).getValue();
                    if (board.getBoard().getType() == BoardType.BACKLOG) {
                        for (int i = board.getComponentCount() - 1; i >= 0; i--) {
                            TaskCardUI cardo = (TaskCardUI) board.getComponent(i);
                            if (!cardo.getTask().getAssignees().contains(assigneeID)) {
                                board.remove(cardo); 
                                ScreenUI.getLayoutUI().getBacklog().setNumOfCardDisplay(ScreenUI.getLayoutUI().getBacklog().getNumOfCardDisplay()-1);
                            }
                        }

                    } else if (board.getBoard().getType() == BoardType.FINISH) {
                        for (int i = board.getComponentCount() - 1; i >= 0; i--) {
                            TaskCardUI cardo = (TaskCardUI) board.getComponent(i);
                            if (!cardo.getTask().getAssignees().contains(assigneeID)) {
                                board.remove(cardo); 
                                ScreenUI.getLayoutUI().getFinish().setNumOfCardDisplay(ScreenUI.getLayoutUI().getBacklog().getNumOfCardDisplay()-1);
                            }
                        }

                    }
                }
                if (ScreenUI.getLayoutUI().getBacklog().getNumOfCardDisplay() < 4) {
                    ScreenUI.getLayoutUI().getOnBacklogPanel().setViewportView(null);
                    ScreenUI.getLayoutUI().getOnBacklogPanel().setColumnHeaderView(ScreenUI.getLayoutUI().getBacklog());
                }
                else if(ScreenUI.getLayoutUI().getFinish().getNumOfCardDisplay() < 4) {
                    ScreenUI.getLayoutUI().getOnBacklogPanel().setViewportView(null);
                    ScreenUI.getLayoutUI().getOnFinishPanel().setColumnHeaderView(ScreenUI.getLayoutUI().getFinish());
                }
            }
        });
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (board.getBoard().getType() == BoardType.BACKLOG) {
                    //ScreenUI.getLayoutUI().setBacklog(new BoardUI(BoardType.BACKLOG));
                    ScreenUI.getLayoutUI().getBacklog().refresh();
                } else if (board.getBoard().getType() == BoardType.FINISH) {
                    //ScreenUI.getLayoutUI().setFinish(new BoardUI(BoardType.FINISH));
                    ScreenUI.getLayoutUI().getFinish().refresh();
                }
            }
        });
        // TODO Auto-generated method stub
        CalendarWindowViews Scalendar = new CalendarWindowViews();
        CalendarWindowViews Dcalendar = new CalendarWindowViews();
        Scalendar.setUndecorated(true);
        Scalendar.addPropertyChangeListener(this);
        Dcalendar.setUndecorated(true);
        Dcalendar.addPropertyChangeListener(this);

        reportedDateDate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (ScheckCalendarVisisble == false) {
                    Scalendar.setLocation(reportedDateDate.getLocationOnScreen().x, (reportedDateDate.getLocationOnScreen().y + reportedDateDate.getHeight()));
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
            System.out.println("shere");
            if (event.getPropertyName().equals("selectedDate")) {

                java.util.Calendar cal = (java.util.Calendar) event.getNewValue();

                SselDate = cal.getTime();
                String SstrDate = df.format(SselDate);

                reportedDateDate.setText(SstrDate);
            }

        } else if (DcheckCalendarVisisble == true) {
            if (event.getPropertyName().equals("selectedDate")) {

                java.util.Calendar cal = (java.util.Calendar) event.getNewValue();
                DselDate = cal.getTime();
                String SdueDate = df.format(DselDate);

                dueDateDate.setText(SdueDate);

            }
        }
    }
}
///////////////////////////To be revised/////////////////////////

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
