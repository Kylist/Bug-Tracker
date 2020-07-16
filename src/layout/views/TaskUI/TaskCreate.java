package layout.views.TaskUI;

import common.Comment.CommentsOneTaskHold;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import common.Enum.TaskStatus;
import common.Enum.TaskType;
import common.Task.Task;
import common.Task.TaskHold;
import common.Ultilities.Utilities;
import layout.views.BoardUI.BoardUI;
import common.Project.Project;
import common.Project.Projecthold;
import common.Sprint.Sprint;
import common.Sprint.Sprinthold;
import common.Team.Userhold;
import common.User.CurrentUserhold;
import common.User.User;

import java.io.File;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import layout.views.CalendarWindowViews;

public class TaskCreate extends JFrame implements PropertyChangeListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public JPanel TaskCreate;
    private BoardUI backlog;
    private JTextField SummaryBox;
    private JComboBox<ComboItem> ProjectAssignBar;
    private JComboBox<Integer> SprintAssignBar;
    private JComboBox<ComboItem> TaskTypeAssignBar;
    private JComboBox<Integer> SeverityAssignBar;
    private JComboBox<ComboItem> AssignedBar;
    private JButton AddFileButton;
    private JTextPane ReplicateBox;
    private JTextPane SuggestionBox;
    private JButton CreateButton;
    private JTextField DueDateBar;
    private JLabel TaskCreateUpdateTitle;
    private JLabel SummaryLabel;
    private JLabel ProjectAssignLabel;
    private JLabel SprintAssignLabel;
    private JLabel TaskTypeAssignLabel;
    private JLabel SeverityAssignLabel;
    private JLabel DescriptionLabel;
    private JLabel ReplicateLabel;
    private JLabel SuggestionLabel;
    private JLabel DueDateAssignLabel;
    private JLabel MemberAssignLabel;
    private JLabel UploadAssignLabel;
    private File[] selectedFile;
    private Date selDate;
    private JLabel error;
    int projectID = 1;
    private DefaultListModel<String> listFileModel;
    private DefaultListModel<String> listAssigneeModel;
    private boolean addTaskSuccess;
    private boolean isAllowListAssigneeEvent;
    private boolean isAllowListFileEvent;
    private boolean checkCalendarVisisble;
    private JTextArea DescriptionBox;
    private JScrollPane listScrollAssignee;
    private JScrollPane listScrollFile;
    private JList<String> listAssignee;
    private JList<String> listFile;
    private List<User> users;

    /**
     * Create the frame.
     */
    public TaskCreate() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        checkCalendarVisisble = false;
        initComponents();
        this.backlog = null;
        createEvents();

    }

    public TaskCreate(BoardUI backlog) {
        checkCalendarVisisble = false;
        this.backlog = backlog;
        initComponents();
        createEvents();

    }

    private void initComponents() {
        addTaskSuccess = false;
        setIconImage(Toolkit.getDefaultToolkit().getImage(TaskCreate.class.getResource("/layout/resource/BugTracker.png")));
        setTitle("Bug Tracker 3000 - Task Create");

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 0, 582, 945);
        TaskCreate = new JPanel();
        TaskCreate.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(TaskCreate);

        TaskCreateUpdateTitle = new JLabel("Task Create");
        TaskCreateUpdateTitle.setHorizontalAlignment(SwingConstants.CENTER);
        TaskCreateUpdateTitle.setFont(new Font("Tahoma", Font.BOLD, 35));

        SummaryLabel = new JLabel("Summary");
        SummaryLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

        SummaryBox = new JTextField();
        SummaryBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        SummaryBox.setColumns(10);

        ProjectAssignBar = new JComboBox<ComboItem>();

        SprintAssignBar = new JComboBox<Integer>();

        TaskTypeAssignBar = new JComboBox<ComboItem>();

        SeverityAssignBar = new JComboBox<Integer>();

        ProjectAssignLabel = new JLabel("Project\r\n");

        SprintAssignLabel = new JLabel("Sprint\r\n");

        TaskTypeAssignLabel = new JLabel("Task Type");

        SeverityAssignLabel = new JLabel("Severity");

        DescriptionLabel = new JLabel("Description");
        DescriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

        ReplicateLabel = new JLabel("Replicate");
        ReplicateLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

        SuggestionLabel = new JLabel("Suggestion\r\n");
        SuggestionLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

        DueDateAssignLabel = new JLabel("Due Date");

        MemberAssignLabel = new JLabel("Assigned To");

        AssignedBar = new JComboBox<ComboItem>();

        UploadAssignLabel = new JLabel("Attach File\r\n");

        AddFileButton = new JButton("Upload");

        ReplicateBox = new JTextPane();

        SuggestionBox = new JTextPane();

        CreateButton = new JButton("Create\r\n");

        DueDateBar = new JTextField();

        DueDateBar.setColumns(10);

        error = new JLabel("");
        error.setForeground(Color.RED);

        isAllowListAssigneeEvent = false;
        isAllowListFileEvent = false;

        /////////////////////////////////////////Populate all parameters/////////////////////////////////
        List<Project> projects = Projecthold.getProjects();

        for (int i = 0; i < projects.size(); i++) {
            ProjectAssignBar.addItem(new ComboItem(projects.get(i).getName(), projects.get(i).getID()));
        }

        users = Userhold.getUsers();
        int currentProjID = (int) ((ComboItem) ProjectAssignBar.getSelectedItem()).getValue();
        AssignedBar.removeAllItems();
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < Projecthold.getProjects().get(currentProjID - 1).getTeam().size(); j++) {
                if (users.get(i).getID() == Projecthold.getProjects().get(currentProjID - 1).getTeam().get(j)) {
                    AssignedBar.addItem(new ComboItem(users.get(i).getName(), users.get(i).getID()));
                }
            }
        }

        List<Sprint> sprints = Sprinthold.getSprints();
        SprintAssignBar.removeAllItems();
        for (int j = 0; j < Projecthold.getProjects().size(); j++) {
            if (Projecthold.getProjects().get(j).getName().equals(ProjectAssignBar.getSelectedItem().toString())) {
                projectID = Projecthold.getProjects().get(j).getID();
                break;
            }
        }
        for (int i = 0; i < sprints.size(); i++) {
            if (sprints.get(i).getProjectID() == projectID) {
                SprintAssignBar.addItem(sprints.get(i).getName());
            }
        }

        int[] severities = Utilities.makeSequence(1, 10);
        for (int i = 0; i < severities.length; i++) {
            SeverityAssignBar.addItem(severities[i]);
        }

        TaskType[] types = TaskType.getAllTaskTypes();
        for (int i = 0; i < types.length; i++) {
            TaskTypeAssignBar.addItem(new ComboItem(types[i].toString(), types[i]));
        }
        //default Duedate, thss is kinda restrictig tho

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            DueDateBar.setText("12-12-2020");
            selDate = sdf.parse("12-12-2020");
        } catch (Exception e) {
            System.out.println("error when create task: " + e);
        }

        selectedFile = new File[3];

        ReplicateBox.setVisible(false);
        SuggestionBox.setVisible(false);
        ReplicateLabel.setVisible(false);
        SuggestionLabel.setVisible(false);

        DescriptionBox = new JTextArea();

        listScrollAssignee = new JScrollPane();
        listScrollAssignee.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        listScrollFile = new JScrollPane();
        listScrollFile.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        // Group Layout
        GroupLayout gl_TaskCreate = new GroupLayout(TaskCreate);
        gl_TaskCreate.setHorizontalGroup(
                gl_TaskCreate.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_TaskCreate.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                .addComponent(error)
                                                .addGap(524))
                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                .addComponent(DescriptionLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(439, Short.MAX_VALUE))
                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                .addComponent(SuggestionLabel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(433, Short.MAX_VALUE))
                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                .addComponent(ReplicateLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(464, Short.MAX_VALUE))
                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                .addComponent(SummaryLabel)
                                                .addContainerGap(481, Short.MAX_VALUE))
                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                .addGroup(gl_TaskCreate.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(ReplicateBox, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                                                        .addComponent(SuggestionBox, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                                                        .addComponent(DescriptionBox, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                                .addGroup(gl_TaskCreate.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(SprintAssignLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(ProjectAssignLabel)
                                                                        .addGroup(gl_TaskCreate.createParallelGroup(Alignment.TRAILING, false)
                                                                                .addComponent(SprintAssignBar, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(ProjectAssignBar, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(172)
                                                                .addGroup(gl_TaskCreate.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(TaskTypeAssignBar, 0, 193, Short.MAX_VALUE)
                                                                        .addComponent(SeverityAssignBar, 0, 193, Short.MAX_VALUE)
                                                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                                                .addComponent(SeverityAssignLabel, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                                                .addGap(103))
                                                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                                                .addComponent(TaskTypeAssignLabel, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                                                                .addGap(73))))
                                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                                .addGroup(gl_TaskCreate.createParallelGroup(Alignment.LEADING)
                                                                        .addGroup(gl_TaskCreate.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(MemberAssignLabel, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                                                                .addGroup(gl_TaskCreate.createSequentialGroup()
                                                                                        .addComponent(AssignedBar, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                                                                        .addGap(67)))
                                                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                                                .addComponent(listScrollAssignee, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(62)))
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addGroup(gl_TaskCreate.createParallelGroup(Alignment.LEADING)
                                                                        .addGroup(gl_TaskCreate.createParallelGroup(Alignment.TRAILING, false)
                                                                                .addComponent(AddFileButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addGroup(Alignment.LEADING, gl_TaskCreate.createSequentialGroup()
                                                                                        .addGap(2)
                                                                                        .addComponent(UploadAssignLabel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
                                                                        .addComponent(listScrollFile, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(6)
                                                                .addGroup(gl_TaskCreate.createParallelGroup(Alignment.TRAILING)
                                                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                                                .addGap(61)
                                                                                .addComponent(DueDateAssignLabel, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                                                                .addGap(57))
                                                                        .addComponent(DueDateBar, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))))
                                                .addContainerGap())
                                        .addGroup(Alignment.TRAILING, gl_TaskCreate.createSequentialGroup()
                                                .addComponent(CreateButton, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(Alignment.TRAILING, gl_TaskCreate.createSequentialGroup()
                                                .addGroup(gl_TaskCreate.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(TaskCreateUpdateTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                                                        .addComponent(SummaryBox, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
                                                .addContainerGap())))
        );
        gl_TaskCreate.setVerticalGroup(
                gl_TaskCreate.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TaskCreateUpdateTitle)
                                .addGap(2)
                                .addComponent(SummaryLabel)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(SummaryBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_TaskCreate.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                .addComponent(TaskTypeAssignLabel)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(TaskTypeAssignBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(19)
                                                .addComponent(SeverityAssignLabel)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(SeverityAssignBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                .addComponent(ProjectAssignLabel)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(ProjectAssignBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(19)
                                                .addComponent(SprintAssignLabel)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(SprintAssignBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(10)
                                .addComponent(DescriptionLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(DescriptionBox, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(ReplicateLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(ReplicateBox, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(SuggestionLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(SuggestionBox, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_TaskCreate.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                .addGap(2)
                                                .addGroup(gl_TaskCreate.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                                .addComponent(UploadAssignLabel)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(AddFileButton)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(listScrollFile, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                                .addComponent(DueDateAssignLabel)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(DueDateBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(25)
                                                                .addComponent(error))))
                                        .addGroup(gl_TaskCreate.createSequentialGroup()
                                                .addComponent(MemberAssignLabel)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(AssignedBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(listScrollAssignee, 0, 0, Short.MAX_VALUE)))
                                .addGap(17)
                                .addComponent(CreateButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        listFile = new JList();
        listFile.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listScrollFile.setViewportView(listFile);

        listAssignee = new JList();
        listAssignee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listScrollAssignee.setViewportView(listAssignee);

        listFileModel = new DefaultListModel<>();
        if (!listFileModel.isEmpty()) {
            listFileModel.clear();
        }
        listFile.setModel(listFileModel);

        listAssigneeModel = new DefaultListModel<>();
        if (!listAssigneeModel.isEmpty()) {
            listAssigneeModel.clear();
        }
        listAssignee.setModel(listAssigneeModel);

        TaskCreate.setLayout(gl_TaskCreate);
    }

    private void createEvents() {
        AddFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //OpenFile() function for GUI only
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                //filter the files
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);
                //if the user clicks on save in Jfilechooser
                if (result == JFileChooser.APPROVE_OPTION) {
                    if (selectedFile[0] == null) {
                        selectedFile[0] = file.getSelectedFile();
                        String path = selectedFile[0].getAbsolutePath();
                        listFileModel.addElement(path);
                    } else if (selectedFile[1] == null) {
                        selectedFile[1] = file.getSelectedFile();
                        String path = selectedFile[1].getAbsolutePath();
                        listFileModel.addElement(path);

                    } else if (selectedFile[2] == null) {
                        selectedFile[2] = file.getSelectedFile();
                        String path = selectedFile[2].getAbsolutePath();
                        listFileModel.addElement(path);
                    }
                } //if the user cancels
                else if (result == JFileChooser.CANCEL_OPTION) {
                    System.out.println("No File Select");
                }
            }

        });

        CreateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Add() function
                if (!errorCheck()) {
                    addTask();
                    if (addTaskSuccess == true) {
                        ((JFrame) CreateButton.getParent().getParent().getParent().getParent()).dispose();
                    } else {
                        error.setText("There's something wrong with your input, please try again");
                    }
                }

            }

        });

        ProjectAssignBar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Sprint> sprints = Sprinthold.getSprints();
                SprintAssignBar.removeAllItems();

                for (int j = 0; j < Projecthold.getProjects().size(); j++) {
                    if (Projecthold.getProjects().get(j).getName().equals(ProjectAssignBar.getSelectedItem().toString())) {
                        projectID = Projecthold.getProjects().get(j).getID();
                        break;
                    }
                }
                for (int i = 0; i < sprints.size(); i++) {
                    if (sprints.get(i).getProjectID() == projectID) {

                        SprintAssignBar.addItem(sprints.get(i).getName());
                    }
                }
                int currentProjID = (int) ((ComboItem) ProjectAssignBar.getSelectedItem()).getValue();
                AssignedBar.setModel(new DefaultComboBoxModel<ComboItem>());
                for (int i = 0; i < users.size(); i++) {
                    for (int j = 0; j < Projecthold.getProjects().get(currentProjID - 1).getTeam().size(); j++) {
                        if (users.get(i).getID() == Projecthold.getProjects().get(projectID - 1).getTeam().get(j)) {
                            AssignedBar.addItem(new ComboItem(users.get(i).getName(), users.get(i).getID()));
                        }
                    }
                }

            }
        });

        TaskTypeAssignBar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object taskTypeSelected = TaskTypeAssignBar.getSelectedItem();
                String test = taskTypeSelected.toString();
                if (test.equals("BUG REPORT")) {

                    ReplicateBox.setVisible(true);
                    SuggestionBox.setVisible(true);
                    ReplicateLabel.setVisible(true);
                    SuggestionLabel.setVisible(true);
                } else {
                    ReplicateBox.setVisible(false);
                    SuggestionBox.setVisible(false);
                    ReplicateLabel.setVisible(false);
                    SuggestionLabel.setVisible(false);
                }
            }
        }
        );

        CalendarWindowViews calendar = new CalendarWindowViews();
        calendar.setUndecorated(true);
        calendar.addPropertyChangeListener(this);

        DueDateBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (checkCalendarVisisble == false) {
                    calendar.setLocation(DueDateBar.getLocationOnScreen().x, (DueDateBar.getLocationOnScreen().y + DueDateBar.getHeight()));
                    calendar.setVisible(true);
                    checkCalendarVisisble = true;
                } else {
                    calendar.dispose();
                    checkCalendarVisisble = false;
                }

            }
        });

        AssignedBar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object selected = AssignedBar.getSelectedItem();
                String selectedassignee = selected.toString();
                if (selectedassignee != "" && isAllowListAssigneeEvent) {
                    if (!listAssigneeModel.contains(selectedassignee)) {
                        listAssigneeModel.addElement(selected.toString());
                    }
                }
            }
        });
        AssignedBar.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                isAllowListAssigneeEvent = true;
            }

            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                isAllowListAssigneeEvent = false;
            }

            public void popupMenuCanceled(PopupMenuEvent e) {
            }
        });

        listAssignee.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selected = listAssignee.getSelectedIndex();
                if (selected != -1) {
                    listAssigneeModel.remove(selected);
                }
            }
        });
        listFile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selected = listFile.getSelectedIndex();
                if (selected != -1) {
                    listFileModel.remove(selected);
                    selectedFile[selected] = null;
                }

            }
        });

    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        //get the selected date from the calendar control and set it to the text field
        if (event.getPropertyName().equals("selectedDate")) {

            java.util.Calendar cal = (java.util.Calendar) event.getNewValue();
            selDate = cal.getTime();
            DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyy");
            String strDate = dateFormat.format(selDate);
            DueDateBar.setText(strDate);
        }
    }

    public boolean errorCheck() {
        if (Utilities.compareWithTodayDate(selDate) < 0) {
            error.setText("Due date must be after today's date!");
            return true;
        }
        if (CurrentUserhold.getUser() == null) {
            error.setText("You must log in to add new task!");
            return true;
        }
        return false;
    }

    public void addTask() {
        try {
            //add task and notify main UI
            ArrayList<Integer> assignees = new ArrayList<>();
            if (listAssigneeModel.size() == 0) {
                assignees = Projecthold.getProjects().get((int) ((ComboItem) ProjectAssignBar.getSelectedItem()).getValue() - 1).getTeam();
            } else {
                for (int i = 0; i < listAssigneeModel.size(); i++) {
                    int userID = Userhold.searchNmeOutputID(listAssigneeModel.get(i));
                    assignees.add(userID);
                }
                //have to add admin
                if (!assignees.contains(8)) {
                    assignees.add(8);
                }
                //add the current user who create the project, which is usually PM
                if (!assignees.contains(CurrentUserhold.getUser().getID())) {
                    assignees.add(CurrentUserhold.getUser().getID());
                }
            }

            Task task = new Task(TaskHold.getTaskList().size() + 1, (TaskType) ((ComboItem) TaskTypeAssignBar.getSelectedItem()).getValue(),
                    SummaryBox.getText(), new CommentsOneTaskHold(), (int) ((ComboItem) ProjectAssignBar.getSelectedItem()).getValue(),
                    (int) SprintAssignBar.getSelectedItem(), (int) SeverityAssignBar.getSelectedItem(),
                    TaskStatus.ONNEW, Utilities.getCurrentDate(), selDate, ReplicateBox.getText(),
                    DescriptionBox.getText(), SuggestionBox.getText(), selectedFile,
                    CurrentUserhold.getUser().getID(), assignees);

            task.addAssignee((int) ((ComboItem) AssignedBar.getSelectedItem()).getValue());
            TaskHold.addTask(task);
            if (this.backlog != null) {
                this.backlog.refresh();
            }
            addTaskSuccess = true;

        } catch (Exception e) {
            addTaskSuccess = false;
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

    public ComboItem(String key, TaskType value) {
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
