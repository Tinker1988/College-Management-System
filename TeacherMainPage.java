
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TeacherMainPage extends JFrame implements ActionListener {

    public class Student {

        String name;
        String course;
        String semester;

        public Student(String name, String course, String semester) {
            this.name = name;
            this.course = course;
            this.semester = semester;

        }

    }

    ImageIcon image = new ImageIcon("ClgLogo.png");
    ImageIcon imagehome = new ImageIcon("collagemainpage.png");

    HashMap<String, ArrayList<Student>> courseEnrollments;

    JPanel contentPanel;
    JComboBox<String> courseDropDown;
    JComboBox<String> studentName;
    JTextArea displayArea;
    JButton addStudents;
    JButton displayStudents;
    JPanel enrollmentpanel;
    JPanel attendancePanel;

    private HashMap<String, String> studentMarks = new HashMap<>();

    TeacherMainPage() {
        courseEnrollments = new HashMap<>();

        // Resize the image
        Image originalImage = image.getImage();
        Image resizedImage = originalImage.getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Dashboard Panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setPreferredSize(new Dimension(160, 800)); // Adjust dimensions
        dashboardPanel.setLayout(new BorderLayout()); // Using BorderLayout for image placement

        // Image of Dashboard
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.TOP);
        imageLabel.setBorder(new EmptyBorder(0, 0, 10, 0));
        dashboardPanel.add(imageLabel, BorderLayout.NORTH); // Add image to the top

        // Panel for Buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS)); // Stack buttons vertically

        String[] buttonNames = {"Home", "Enrollment", "Attendance", "Acadamic Records", "About College", "Log Out"};
        for (String buttonName : buttonNames) {
            JButton button = new JButton(buttonName);
            button.setPreferredSize(new Dimension(160, 50)); // Set button size
            button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
            button.setBorder(new EmptyBorder(5, 5, 5, 5));
            button.setFocusable(false);
            button.setBackground(Color.darkGray);
            button.setForeground(Color.white);
            button.setFont(new Font("Times new Roman", Font.BOLD, 16));
            button.setAlignmentX(CENTER_ALIGNMENT); // Center the button horizontally
            button.setBorder(new EmptyBorder(7, 7, 7, 7)); // Add padding around the button
            if (buttonName.equals("Log Out")) {
                button.setBackground(Color.RED);
                button.setForeground(Color.white);
                button.setFocusable(false);
            }
            button.addActionListener(this);
            buttonsPanel.add(button);
            buttonsPanel.add(Box.createVerticalStrut(10));
        }

        ImageIcon imageprincipal = new ImageIcon("principal.png");
        // Resize the image
        Image originalPrincipalImage = imageprincipal.getImage();
        Image resizedPrincipalImage = originalPrincipalImage.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon resizedPrincipalIcon = new ImageIcon(resizedPrincipalImage);

        JPanel PrinciPanel = new JPanel();
        PrinciPanel.setLayout(new BoxLayout(PrinciPanel, BoxLayout.Y_AXIS));
        PrinciPanel.setBorder(new EmptyBorder(10, 10, 25, 10));
        JLabel PrincipalimagLabel = new JLabel(resizedPrincipalIcon);
        PrincipalimagLabel.setBorder(new LineBorder(Color.DARK_GRAY, 4, true));
        PrincipalimagLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel principaldetaillabel = new JLabel();
        principaldetaillabel.setText("<html><center><b>Principal Dr. Satish R. Devane </b><br>" + "Ph.D., M.E.(Electronics)<br> Email Id: principal@kbtcoe.org");
        principaldetaillabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        PrinciPanel.add(PrincipalimagLabel);
        PrinciPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        PrinciPanel.add(principaldetaillabel);

        // Add buttonsPanel to the dashboardPanel
        dashboardPanel.add(buttonsPanel, BorderLayout.CENTER); // Center-align buttons vertically

        dashboardPanel.add(PrinciPanel, BorderLayout.SOUTH);

        // Center Panel
        JPanel centerPanel = new JPanel(new BorderLayout()); // Use BorderLayout for header and content placement

//Main home image rezize 
        Image originalhomeImage = imagehome.getImage();
        Image resizedhomeImage = originalhomeImage.getScaledInstance(610, 300, Image.SCALE_SMOOTH);
        ImageIcon resizedhomeIcon = new ImageIcon(resizedhomeImage);

        // Header Panel
        JLabel upperheader = new JLabel("<html><center>Teacher Dashboard, Welcome " +" LoginPageTeacher.getUsername()" + "</center></html>");
        upperheader.setFont(new Font("Times new Roman", Font.BOLD, 25));
        upperheader.setHorizontalAlignment(JLabel.CENTER);
        upperheader.setBorder(new EmptyBorder(10, 10, 10, 10)); // Optional: padding for the header
        centerPanel.add(upperheader, BorderLayout.NORTH); // Add header to the top
//content label
        JLabel homelabel = new JLabel(resizedhomeIcon);
        homelabel.setText("<html><center> <font size = 6><b>About Maratha Vidya Prasarak Samaj </b></font><br><br> The Maratha Vidya Prasarak Samaj is one of the most prestigious centers of learning in the State of" + " <br>Maharashtra. It has been over 107 years that it has stood the test of time to become legend of unparalleled" + " <br>stature. History says that the credit for the birth of M.V.P . Samaj goes to the young, enthusiastic and devoted" + " <br>team of social workers and educationists who were inspired by the lives of Mahatma Jyotiba Phule,Savitribai" + "  <br>Phule and Rajashri Shahu Maharaj of Kolhapur. It manages 477 educational institutes  and it is one of the" + " <br> premier organization in the jurisdiction of Savitribai Phule Pune University.At present total strength of student" + " <br>is around 2,00,000. History says that the credit for the birth of M. V. P. Samaj goes to the young, enthusiastic" + " <br>and devoted team of social workers and educationists, Karmaveer Raosaheb Thorat, Bhausaheb Hire, " + " <br> Kakasaheb Wagh,  Annasaheb Murkute & Ganpat Dada More who laid the foundation of the Samaj. Adv. B. G." + " <br> Thakare, Adv. Vitthalrao Hande & Dr. Vasantrao Pawar are major contributor of Samaj. They were the devotees " + " <br>who envisioned a culture and knowledge centric society. The motto of the Samaj is “Bahujan Hitay  Bahujan" + " <br> Sukhay”, for the well being and happiness of the masses to kindle the social cause " + "</center></html>");
//homelabel.setFont(new Font("Times new roman", Font.BOLD,13) );
        homelabel.setHorizontalTextPosition(JLabel.CENTER);
        homelabel.setVerticalTextPosition(JLabel.BOTTOM);

        // Content Panel
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Optional: padding for the content
        contentPanel.add(homelabel);
//contentPanel.add(principal);
        centerPanel.add(contentPanel, BorderLayout.CENTER); // Add content below the header

        // Adding components to the frame
        this.add(dashboardPanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);

        // Frame Setup
        this.setSize(800, 800);
        this.setTitle("Teacher's Dashboard");
        this.setIconImage(image.getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void Home() {

        //Main home image rezize 
        Image originalhomeImage = imagehome.getImage();
        Image resizedhomeImage = originalhomeImage.getScaledInstance(610, 300, Image.SCALE_SMOOTH);
        ImageIcon resizedhomeIcon = new ImageIcon(resizedhomeImage);

        // Header Panel
        JLabel upperheader = new JLabel("<html><center>Teacher Dashboard, Welcome " + "LoginPageTeacher.getUsername()" + "</center></html>");
        upperheader.setFont(new Font("Times new Roman", Font.BOLD, 25));
        upperheader.setHorizontalAlignment(JLabel.CENTER);
        upperheader.setBorder(new EmptyBorder(10, 10, 10, 10)); // Optional: padding for the header

//content label
        JLabel homelabel = new JLabel(resizedhomeIcon);
        homelabel.setText("<html><center> <font size = 6><b>About Maratha Vidya Prasarak Samaj </b></font><br><br> The Maratha Vidya Prasarak Samaj is one of the most prestigious centers of learning in the State of" + " <br>Maharashtra. It has been over 107 years that it has stood the test of time to become legend of unparalleled" + " <br>stature. History says that the credit for the birth of M.V.P . Samaj goes to the young, enthusiastic and devoted" + " <br>team of social workers and educationists who were inspired by the lives of Mahatma Jyotiba Phule,Savitribai" + "  <br>Phule and Rajashri Shahu Maharaj of Kolhapur. It manages 477 educational institutes  and it is one of the" + " <br> premier organization in the jurisdiction of Savitribai Phule Pune University.At present total strength of student" + " <br>is around 2,00,000. History says that the credit for the birth of M. V. P. Samaj goes to the young, enthusiastic" + " <br>and devoted team of social workers and educationists, Karmaveer Raosaheb Thorat, Bhausaheb Hire, " + " <br> Kakasaheb Wagh,  Annasaheb Murkute & Ganpat Dada More who laid the foundation of the Samaj. Adv. B. G." + " <br> Thakare, Adv. Vitthalrao Hande & Dr. Vasantrao Pawar are major contributor of Samaj. They were the devotees " + " <br>who envisioned a culture and knowledge centric society. The motto of the Samaj is “Bahujan Hitay  Bahujan" + " <br> Sukhay”, for the well being and happiness of the masses to kindle the social cause " + "</center></html>");
//homelabel.setFont(new Font("Times new roman", Font.BOLD,13) );
        homelabel.setHorizontalTextPosition(JLabel.CENTER);
        homelabel.setVerticalTextPosition(JLabel.BOTTOM);

        contentPanel.add(homelabel);

    }

    public void EnrollmentOfCourses() {
        enrollmentpanel = new JPanel();
        enrollmentpanel.setPreferredSize(new Dimension(600, 600));
        enrollmentpanel.setBorder(new LineBorder(Color.darkGray, 2));
        enrollmentpanel.setLayout(new BorderLayout());

        // Enrollment section
        String[] semesters = {"Semester 1", "Semester 2", "Semester 3"};
        JComboBox semesterDropDown = new JComboBox<>(semesters);

        String[] courses = {"Data Structures and Algorithm", "Object Oriented Programming", "Logic Design and Computer Organization", "Basics of Computer Network", "Discrete Mathematics"};
        courseDropDown = new JComboBox<>(courses);

        // adding students
        String[] students = {"Khushi", "Sanskruti", "Komal", "Riya"};
        studentName = new JComboBox<>(students);

//upperpanel
        JPanel upperpanel = new JPanel();
        upperpanel.setLayout(new BoxLayout(upperpanel, BoxLayout.Y_AXIS));
        upperpanel.setBorder(new EmptyBorder(15, 25, 15, 25));
        //upperpanel.setBorder(new LineBorder(Color.darkGray, 2));
        JLabel studentheading = new JLabel("Select student name:");
        studentheading.setAlignmentX(Component.CENTER_ALIGNMENT);
        upperpanel.add(studentheading);
        upperpanel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between
        upperpanel.add(studentName);
        upperpanel.add(Box.createRigidArea(new Dimension(0, 10)));
        upperpanel.add(semesterDropDown); // Space between
        enrollmentpanel.add(Box.createRigidArea(new Dimension(0, 10)));
        enrollmentpanel.add(upperpanel, BorderLayout.NORTH);

        //mid panel
        JPanel midpanel = new JPanel();
        midpanel.setLayout(new CardLayout());
        // Panel if Semester one is chosen
        JPanel Sem1 = new JPanel();

        Sem1.setLayout(new BoxLayout(Sem1, BoxLayout.Y_AXIS));
        Sem1.setBorder(new EmptyBorder(0, 25, ABORT, 25));
        JLabel sem1heading = new JLabel("Select the subject and enter the marks ");
        sem1heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] sem1sub = {"Engineering Mathematics 1", "Engineering Chemistry", "Basic Electrical Engineering", "Python & Problem Solving", "System in Mechanics"};
        JComboBox sem1ComboBox = new JComboBox(sem1sub);

        Sem1.add(sem1heading);
        Sem1.add(Box.createRigidArea(new Dimension(0, 5)));
        Sem1.add(sem1ComboBox);
        Sem1.add(Box.createRigidArea(new Dimension(0, 5)));

        // Panel if Semester two is chosen
        JPanel Sem2 = new JPanel();
        Sem2.setLayout(new BoxLayout(Sem2, BoxLayout.Y_AXIS));
        Sem2.setBorder(new EmptyBorder(0, 25, ABORT, 25));
        JLabel sem2heading = new JLabel("Select the subject and enter the marks ");
        sem2heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] sem2sub = {"Engineering Mathematics 2", "Engineering Physics", "Basic Electronics Engineering", "Engineering Mechanics", "Engineering Graphics"};
        JComboBox sem2ComboBox = new JComboBox(sem2sub);

        Sem2.add(sem2heading);
        Sem2.add(Box.createRigidArea(new Dimension(0, 5)));
        Sem2.add(sem2ComboBox);
        Sem2.add(Box.createRigidArea(new Dimension(0, 5)));

        // Panel if Semester three is chosen
        JPanel Sem3 = new JPanel();
        Sem3.setLayout(new BoxLayout(Sem3, BoxLayout.Y_AXIS));
        Sem3.setBorder(new EmptyBorder(0, 25, ABORT, 25));
        JLabel sem3heading = new JLabel("Select the subject and enter the marks ");
        sem3heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] sem3sub = {"Data Structures and Algorithms", "Discrete Mathematics", "Digital Logic Design and Computer Organization", "Object-Oriented Programming (OOP)", "Basics Computer Networks"};
        JComboBox sem3ComboBox = new JComboBox(sem3sub);
        Sem3.add(sem3heading);
        Sem3.add(Box.createRigidArea(new Dimension(0, 5)));
        Sem3.add(sem3ComboBox);
        Sem3.add(Box.createRigidArea(new Dimension(0, 5)));

        // Adding panels to the CardLayout
        midpanel.add(Sem1, "Sem1");
        midpanel.add(Sem2, "Sem2");
        midpanel.add(Sem3, "Sem3");
        // adding courses
        // Add ActionListener to switch panels based on the semester selection
        semesterDropDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) midpanel.getLayout();
                String selectedSemester = (String) semesterDropDown.getSelectedItem();

                switch (selectedSemester) {
                    case "Semester 1":
                        cardLayout.show(midpanel, "Sem1");
                        break;
                    case "Semester 2":
                        cardLayout.show(midpanel, "Sem2");
                        break;
                    case "Semester 3":
                        cardLayout.show(midpanel, "Sem3");
                        break;
                }
            }
        });
        enrollmentpanel.add(midpanel, BorderLayout.CENTER);

        //lower panel
        JPanel lowerPanel = new JPanel();
        lowerPanel.setBorder(new EmptyBorder(0, 25, 20, 25));
        lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.Y_AXIS));
        // lowerPanel.setBorder(new LineBorder(Color.darkGray, 2));

        // add students button
        addStudents = new JButton("Add Student");
        addStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  String selectedcourse = (String) courseDropDown.getSelectedItem();
                String selectedstudent = (String) studentName.getSelectedItem();
                String SEMString = (String) semesterDropDown.getSelectedItem();
                String selectedSubject;
                if (SEMString.equals("Semester 1")) {
                    selectedSubject = (String) sem1ComboBox.getSelectedItem();

                } else if (SEMString.equals("Semester 2")) {
                    selectedSubject = (String) sem2ComboBox.getSelectedItem();

                } else {
                    selectedSubject = (String) sem3ComboBox.getSelectedItem();
                }

                if (!courseEnrollments.containsKey(selectedSubject)) {
                    courseEnrollments.put(selectedSubject, new ArrayList<>());
                }
                int option = JOptionPane.showConfirmDialog(null, "This course requires prerequisites \nIs the student eligible?", "Prerequisites check", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    courseEnrollments.get(selectedSubject).add(new Student(selectedstudent, selectedSubject, SEMString));
                    JOptionPane.showMessageDialog(null, "Student added to " + selectedSubject);
                } else {
                    JOptionPane.showMessageDialog(null, "Student is not added to " + selectedSubject);
                }
            }
        });

        // Create the display area if it doesn't already exist
        if (displayArea == null) {
            displayArea = new JTextArea(20, 45);
            displayArea.setEditable(false);
            displayArea.setBorder(new EmptyBorder(10, 10, 10, 10)); // Optional: padding
            displayArea.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
        }

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Display enrolled students button
        displayStudents = new JButton("Display enrolled students");
        displayStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                displayArea.setText(""); // Clear previous content
                // Populate the display area with enrolled students
                for (String course : courseEnrollments.keySet()) {
                    displayArea.append("Course: " + course + "\n");
                    for (Student student : courseEnrollments.get(course)) {
                        displayArea.append(" - " + student.name + "(Semester- " + student.semester + ")" + "\n");
                    }
                    displayArea.append("\n");
                }
                contentPanel.revalidate(); // Refresh layout
                contentPanel.repaint(); // Repaint the content panel
            }
        });
        addStudents.setAlignmentX(Component.CENTER_ALIGNMENT);
        addStudents.setFocusable(false);
        lowerPanel.add(addStudents);
        lowerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        displayStudents.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayStudents.setFocusable(false);
        lowerPanel.add(displayStudents);
        lowerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        lowerPanel.add(displayArea);
        enrollmentpanel.add(lowerPanel, BorderLayout.SOUTH);

        // Add enrollment panel to contentPanel
        contentPanel.add(enrollmentpanel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public void AttendanceMarking() {
        //Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(600, 600));

        panel.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.DARK_GRAY, 3, true), new EmptyBorder(15, 15, 15, 15)));

        //Selection panel 
        JPanel selectionPanel = new JPanel();
        // selectionPanel.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
        selectionPanel.setLayout(new GridLayout(1, 3));
        // selectionPanel.setBorder(BorderFactory.createCompoundBorder((new EmptyBorder(10, 10, 10, 10)), new LineBorder(null)));

        panel.add(selectionPanel, BorderLayout.NORTH);

        //Displaying comboxes
        JPanel comboboxes = new JPanel();
        comboboxes.setLayout(new BoxLayout(comboboxes, BoxLayout.Y_AXIS));
        comboboxes.setBorder((new EmptyBorder(15, 15, 15, 15)));
        // ComboBoxes to select day, month, and year manually
        String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] years = {"2024", "2025", "2026"};

        JComboBox<String> dayComboBox = new JComboBox<>(days);
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        JComboBox<String> yearComboBox = new JComboBox<>(years);
        // Add components to calendar panel
        JLabel dayHeading = new JLabel("Select the Day:");
        dayHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        comboboxes.add(dayHeading);
        comboboxes.add(dayComboBox);
        comboboxes.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel monthHeading = new JLabel("Select the Month:");
        monthHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        comboboxes.add(monthHeading);
        comboboxes.add(monthComboBox);
        comboboxes.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel yearHeading = new JLabel("Select the Year:");
        yearHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        comboboxes.add(yearHeading);
        comboboxes.add(yearComboBox);
        comboboxes.add(Box.createRigidArea(new Dimension(0, 20)));

        //Courses combobox
        JPanel corsescomboxpanel = new JPanel();
        corsescomboxpanel.setLayout(new BoxLayout(corsescomboxpanel, BoxLayout.Y_AXIS));
        corsescomboxpanel.setBorder(new EmptyBorder(95, 0, 95, 0));
        String[] courses = {"Data Structures and Algorithm", "Object Oriented Programming", "Logic Design and Computer Org.", "Basics of Computer Network", "Discrete Mathematics"};
        JComboBox coursecombo = new JComboBox<>(courses);
        JLabel courseselectionheading = new JLabel("Select the session: ");
        courseselectionheading.setAlignmentX(Component.CENTER_ALIGNMENT);
        corsescomboxpanel.add(courseselectionheading);
        corsescomboxpanel.add(coursecombo);

        //Attendance marking panel
        JPanel attendanceMarking = new JPanel();
        attendanceMarking.setBorder(new EmptyBorder(15, 15, 15, 15));
        attendanceMarking.setLayout(new BoxLayout(attendanceMarking, BoxLayout.Y_AXIS));

        // Create checkboxes for students
        JLabel headingattendance = new JLabel("Mark Attendance: ");
        headingattendance.setAlignmentX(Component.CENTER_ALIGNMENT);
        headingattendance.setFont(new Font("Times new Roman", Font.BOLD, 16));
        attendanceMarking.add(headingattendance);
        attendanceMarking.add(Box.createRigidArea(new Dimension(0, 10)));
        JCheckBox[] studentCheckboxes = new JCheckBox[4];
        String[] students = {"Khushi", "Riya", "Komal", "Sanskruti"};

        for (int i = 0; i < students.length; i++) {
            studentCheckboxes[i] = new JCheckBox(students[i]);
            studentCheckboxes[i].setFont(new Font("Times New Roman", Font.BOLD, 15));
            studentCheckboxes[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            studentCheckboxes[i].setAlignmentY(Component.CENTER_ALIGNMENT);

            attendanceMarking.add(studentCheckboxes[i]);
            attendanceMarking.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        // Button to mark attendance
        JButton markAttendance = new JButton("Mark Attendance");
        markAttendance.setAlignmentX(Component.CENTER_ALIGNMENT);
        attendanceMarking.add(markAttendance);

        //displaying attendance
        JTextArea attendancedisplayArea = new JTextArea(5, 35);
        attendancedisplayArea.setEditable(false);
        attendancedisplayArea.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.DARK_GRAY, 2, true), BorderFactory.createEmptyBorder(15, 15, 15, 15)));

        markAttendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDay = (String) dayComboBox.getSelectedItem();
                String selectedMonth = (String) monthComboBox.getSelectedItem();
                String selectedYear = (String) yearComboBox.getSelectedItem();
                String selectedSession = (String) coursecombo.getSelectedItem();
                StringBuilder attendanceStatus = new StringBuilder("Attendance for  \n " + selectedDay + "/" + selectedMonth + "/" + selectedYear + " for session " + selectedSession + " is recorded !\n");

                // Check the status of each student's checkbox
                for (int i = 0; i < studentCheckboxes.length; i++) {
                    if (studentCheckboxes[i].isSelected()) {
                        attendanceStatus.append(students[i]).append(": Present\n");
                    } else {
                        attendanceStatus.append(students[i]).append(": Absent\n");
                    }
                }

                attendanceStatus.append("");
                attendancedisplayArea.setText(attendanceStatus.toString());
                // Display attendance status in a JLabel or a message box
                JOptionPane.showMessageDialog(null, "Attendance marked for: " + selectedDay + "/" + selectedMonth + "/" + selectedYear);
                contentPanel.revalidate(); // Refresh layout
                contentPanel.repaint(); // Repaint the content panel
            }
        });

        //sectional panel adding elements
        selectionPanel.add(comboboxes);
        selectionPanel.add(corsescomboxpanel);
        selectionPanel.add(attendanceMarking);
        //Sectional panel 2 that is south panel
        JPanel selectionPanel2 = new JPanel();
        selectionPanel2.setLayout(new BorderLayout());
        //selectionPanel2.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
        panel.add(selectionPanel2, BorderLayout.CENTER);

        selectionPanel2.add(attendancedisplayArea, BorderLayout.CENTER);

        contentPanel.add(panel);
        contentPanel.revalidate();
        contentPanel.repaint();

    }

  
    public void AcademicRecords() {
        // Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(600, 600));
        panel.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.DARK_GRAY, 2, true), new EmptyBorder(10, 10, 10, 10)));

        // Selection panel   
        JPanel selectionPanel = new JPanel(new BorderLayout());
        selectionPanel.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
        panel.add(selectionPanel, BorderLayout.NORTH);

        // Selection panel - Details selection
        JPanel detaiPanel = new JPanel();
        detaiPanel.setLayout(new BoxLayout(detaiPanel, BoxLayout.Y_AXIS));
        detaiPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        String[] StudentsSelection = {"Khushi", "Sanskruti", "Riya", "Komal"};
        String[] SemesterSelection = {"Semester 1", "Semester 2", "Semester 3"};
        String[] ExamSelection = {"Insem", "Endsem"};

        JComboBox<String> studentComboBox = new JComboBox<>(StudentsSelection);
        JComboBox<String> SemesterComboBox = new JComboBox<>(SemesterSelection);
        JComboBox<String> ExamComboBox = new JComboBox<>(ExamSelection);

        JLabel StudentHeading = new JLabel("Select Student");
        StudentHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        detaiPanel.add(StudentHeading);
        detaiPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        detaiPanel.add(studentComboBox);
        detaiPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel SemesterJLabel = new JLabel("Select Semester");
        SemesterJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        detaiPanel.add(SemesterJLabel);
        detaiPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        detaiPanel.add(SemesterComboBox);
        detaiPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel ExamJLabel = new JLabel("Select Examination");
        ExamJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        detaiPanel.add(ExamJLabel);
        detaiPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        detaiPanel.add(ExamComboBox);
        detaiPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        selectionPanel.add(detaiPanel, BorderLayout.WEST);

        //SelectionPanel of sub and their marks or grades hehe
// Selection panel main for design
        JPanel SelctionmaiPanel = new JPanel();
        SelctionmaiPanel.setLayout(new BorderLayout());

        // Subject Selection panel where the subjects will be selected as per the panels
        JPanel Selectionpanel2 = new JPanel();
        Selectionpanel2.setLayout(new CardLayout());
        Selectionpanel2.setBorder(new EmptyBorder(15, 15, 15, 15));

        // GPA Grade Selection
        String[] gradeOptions = {"O", "A+", "A", "B+", "B", "C", "F"}; // Define the grades
        JComboBox<String> sem1GradeComboBox = new JComboBox<>(gradeOptions);
        JComboBox<String> sem2GradeComboBox = new JComboBox<>(gradeOptions);
        JComboBox<String> sem3GradeComboBox = new JComboBox<>(gradeOptions);// Panel if Semester one is chosen
        JPanel Sem1 = new JPanel();
        Sem1.setLayout(new BoxLayout(Sem1, BoxLayout.Y_AXIS));
        JLabel sem1heading = new JLabel("Select the subject and Grade");
        sem1heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] sem1sub = {"Engineering Mathematics 1", "Engineering Chemistry", "Basic Electrical Engineering", "Python & Problem Solving", "System in Mechanics"};
        JComboBox<String> sem1ComboBox = new JComboBox<>(sem1sub);
        Sem1.add(sem1heading);
        Sem1.add(Box.createRigidArea(new Dimension(0, 5)));
        Sem1.add(sem1ComboBox);
        Sem1.add(Box.createRigidArea(new Dimension(0, 5)));
        Sem1.add(sem1GradeComboBox); // Add Grade ComboBox for Semester 1
        Sem1.add(Box.createRigidArea(new Dimension(0, 5)));

        // Panel if Semester two is chosen
        JPanel Sem2 = new JPanel();
        Sem2.setLayout(new BoxLayout(Sem2, BoxLayout.Y_AXIS));
        JLabel sem2heading = new JLabel("Select the subject and Grade");
        sem2heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] sem2sub = {"Engineering Mathematics 2", "Engineering Physics", "Basic Electronics Engineering", "Engineering Mechanics", "Engineering Graphics"};
        JComboBox<String> sem2ComboBox = new JComboBox<>(sem2sub);
        Sem2.add(sem2heading);
        Sem2.add(Box.createRigidArea(new Dimension(0, 5)));
        Sem2.add(sem2ComboBox);
        Sem2.add(Box.createRigidArea(new Dimension(0, 5)));
        Sem2.add(sem2GradeComboBox); // Add Grade ComboBox for Semester 2
        Sem2.add(Box.createRigidArea(new Dimension(0, 5)));

        // Panel if Semester three is chosen
        JPanel Sem3 = new JPanel();
        Sem3.setLayout(new BoxLayout(Sem3, BoxLayout.Y_AXIS));
        JLabel sem3heading = new JLabel("Select the subject and Grade");
        sem3heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] sem3sub = {"Data Structures and Algorithms", "Discrete Mathematics", "Digital Logic Design and Computer Organization", "Object-Oriented Programming (OOP)", "Basics Computer Networks"};
        JComboBox<String> sem3ComboBox = new JComboBox<>(sem3sub);
        Sem3.add(sem3heading);
        Sem3.add(Box.createRigidArea(new Dimension(0, 5)));
        Sem3.add(sem3ComboBox);
        Sem3.add(Box.createRigidArea(new Dimension(0, 5)));
        Sem3.add(sem3GradeComboBox); // Add Grade ComboBox for Semester 3
        Sem3.add(Box.createRigidArea(new Dimension(0, 5)));

        // Adding panels to the CardLayout
        Selectionpanel2.add(Sem1, "Sem1");
        Selectionpanel2.add(Sem2, "Sem2");
        Selectionpanel2.add(Sem3, "Sem3");

        // Add ActionListener to switch panels based on the semester selection
        SemesterComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) Selectionpanel2.getLayout();
                String selectedSemester = (String) SemesterComboBox.getSelectedItem();

                switch (selectedSemester) {
                    case "Semester 1":
                        cardLayout.show(Selectionpanel2, "Sem1");
                        break;
                    case "Semester 2":
                        cardLayout.show(Selectionpanel2, "Sem2");
                        break;
                    case "Semester 3":
                        cardLayout.show(Selectionpanel2, "Sem3");
                        break;
                }
            }
        });
        // Adding components to the main selection panel 
        SelctionmaiPanel.add(Selectionpanel2, BorderLayout.NORTH);

        //button panel below slectionpanel 2
        JPanel buttoPanel = new JPanel();
        //buttoPanel.setLayout(new BoxLayout(buttoPanel, BoxLayout.Y_AXIS));
        buttoPanel.setBorder(new EmptyBorder(10, 15, 15, 15));

 // New TextField for entering marks
        JTextField marksField = new JTextField(5);
        JButton addMarksAndGradeButton = new JButton("Add Marks & Grade");
        JButton displayButton = new JButton("Display SGPA & Marks");

        addMarksAndGradeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addMarksAndGradeButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        displayButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        buttoPanel.add(new JLabel("Select the subject and Enter marks:")); // Instruction above marks input
        marksField.setBorder(new LineBorder(Color.darkGray, 1, true));
        buttoPanel.add(marksField); // Add marks input field
        buttoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttoPanel.add(addMarksAndGradeButton); // Add button for adding marks and grades
        buttoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttoPanel.add(displayButton); // Display button for marks and GPA



        //adding selection panel to main panel
        selectionPanel.add(SelctionmaiPanel, BorderLayout.CENTER);
         SelctionmaiPanel.add(buttoPanel, BorderLayout.CENTER);




        // Display Area
        JPanel DisplayPanel = new JPanel();
        DisplayPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
    
        JTextArea DisplayArea = new JTextArea(21, 57);
        DisplayArea.setBorder(new LineBorder(Color.darkGray, 2, true));
        DisplayArea.setEditable(false);
        DisplayPanel.add(DisplayArea);
    
        // Store to hold marks and grades
        List<Integer> marksList = new ArrayList<>();
        List<String> gradesList = new ArrayList<>();
        
        // Add marks and grades to the list on button click
        addMarksAndGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marksText = marksField.getText();
                String selectedGrade = (String) (SemesterComboBox.getSelectedItem().equals("Semester 1") ? sem1GradeComboBox.getSelectedItem() : SemesterComboBox.getSelectedItem().equals("Semester 2") ? sem2GradeComboBox.getSelectedItem() : sem3GradeComboBox.getSelectedItem());
                if (marksText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the marks.", "Input Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        int marks = Integer.parseInt(marksText);
                        marksList.add(marks); // Store marks
                        gradesList.add(selectedGrade); // Store selected grade
    
                        JOptionPane.showMessageDialog(null, "Marks and Grade added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        marksField.setText(""); // Clear the input field
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid marks. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    
        // Display total GPA only if all grades are entered
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (marksList.size() != gradesList.size()) {
                    JOptionPane.showMessageDialog(null, "Please ensure marks and grades are entered for all subjects.", "Incomplete Data", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Calculate total GPA
                double totalGPA = 0;
                for (String grade : gradesList) {
                    switch (grade) {
                        case "O":
                            totalGPA += 10;
                            break;
                        case "A+":
                            totalGPA += 9;
                            break;
                        case "A":
                            totalGPA += 8;
                            break;
                        case "B+":
                            totalGPA += 7;
                            break;
                        case "B":
                            totalGPA += 6;
                            break;
                        case "C":
                            totalGPA += 5;
                            break;
                        case "F":
                            totalGPA += 0;
                            break;
                    }
                }
                 String selectedSubject;
                if (sem1ComboBox.equals("Semester 1")) {
                    selectedSubject = (String) sem1ComboBox.getSelectedItem();

                } else if (sem2ComboBox.equals("Semester 2")) {
                    selectedSubject = (String) sem2ComboBox.getSelectedItem();

                } else {
                    selectedSubject = (String) sem3ComboBox.getSelectedItem();
                }
                // GPA Calculation
                double finalGPA = totalGPA / gradesList.size();
                DisplayArea.append("Displaying GPA and Marks for " + studentComboBox.getSelectedItem() + "\n ");
                for (int i = 0; i < marksList.size(); i++) {
                    DisplayArea.append("Marks: " + marksList.get(i) + "  Grade: " + gradesList.get(i) +"\n" );
                }
                DisplayArea.append("\nTotal GPA: " + finalGPA);
            }
        });
         panel.add(DisplayPanel, BorderLayout.CENTER);
        contentPanel.setVisible(true);
        contentPanel.add(panel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static ImageIcon resizeImageIcon(ImageIcon originalIcon, int newWidth, int newHeight) {
        // Get the original image
        Image originalImage = originalIcon.getImage();

        // Resize the image
        Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        // Return the resized ImageIcon
        return new ImageIcon(resizedImage);
    }

    public void AboutCollege() {

        JLabel heading = new JLabel("Our Source Of Inspiration");
        heading.setFont(new Font("Times New Roman", Font.BOLD, 20));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        heading.setAlignmentY(Component.CENTER_ALIGNMENT);
        //Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 5, 5));
        panel.setPreferredSize(new Dimension(600, 600));
        panel.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));

        // Upper panel
        JPanel upperpanel = new JPanel();
        upperpanel.setPreferredSize(new Dimension(200, 200));
        upperpanel.setLayout(new GridLayout(1, 3, 5, 5));
        upperpanel.setBorder(new EmptyBorder(4, 4, 2, 4));
        panel.add(upperpanel);

// First image panel
        JPanel first = new JPanel();
        first.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        JPanel firstPanelname = new JPanel();
        first.setLayout(new BoxLayout(first, BoxLayout.Y_AXIS));
        ImageIcon firstImageIcon = new ImageIcon("first.png");
        JLabel firstimage = new JLabel(resizeImageIcon(firstImageIcon, 120, 120));
        firstimage.setBorder(new LineBorder(Color.DARK_GRAY, 5, true));
        JPanel firstPanelimage = new JPanel();
        JLabel firstnameLabel = new JLabel("<html><center>Late. Karmaveer <br>Raosaheb Thorat</center></html>");
        firstPanelname.add(firstnameLabel);
        first.add(firstPanelname);
        firstPanelimage.add(firstimage);
        first.add(firstPanelimage);
        upperpanel.add(first);

// Second image panel
        JPanel second = new JPanel();
        second.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        JPanel secondPanelname = new JPanel();
        second.setLayout(new BoxLayout(second, BoxLayout.Y_AXIS));
        ImageIcon secondImageIcon = new ImageIcon("second.png");
        JLabel secondimage = new JLabel(resizeImageIcon(secondImageIcon, 120, 120));
        secondimage.setBorder(new LineBorder(Color.DARK_GRAY, 5, true));
        JPanel secondPanelimage = new JPanel();
        JLabel secondnameLabel = new JLabel("<html><center>Late. Karmaveer <br>Ganpat dada More</center></html>");
        secondPanelname.add(secondnameLabel);
        second.add(secondPanelname);
        secondPanelimage.add(secondimage);
        second.add(secondPanelimage);
        upperpanel.add(second);

// Third image panel
        JPanel third = new JPanel();
        third.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        JPanel thirdPanelname = new JPanel();
        third.setLayout(new BoxLayout(third, BoxLayout.Y_AXIS));
        ImageIcon thirdImageIcon = new ImageIcon("third.png");
        JLabel thirdimage = new JLabel(resizeImageIcon(thirdImageIcon, 120, 120));
        thirdimage.setBorder(new LineBorder(Color.DARK_GRAY, 5, true));
        JPanel thirdPanelimage = new JPanel();
        JLabel thirdnameLabel = new JLabel("<html><center>Late. Karmaveer <br>D.R. Bhosale</center></html>");
        thirdPanelname.add(thirdnameLabel);
        third.add(thirdPanelname);
        thirdPanelimage.add(thirdimage);
        third.add(thirdPanelimage);
        upperpanel.add(third);

// Center panel
        JPanel centerpanel = new JPanel();
        centerpanel.setLayout(new GridLayout(1, 3, 5, 5));
        centerpanel.setPreferredSize(new Dimension(200, 200));
        centerpanel.setBorder(new EmptyBorder(4, 4, 2, 4));
        panel.add(centerpanel);

// Fourth image panel
        JPanel fourth = new JPanel();
        fourth.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        JPanel fourthPanelname = new JPanel();
        fourth.setLayout(new BoxLayout(fourth, BoxLayout.Y_AXIS));
        ImageIcon fourthImageIcon = new ImageIcon("fourth.png");
        JLabel fourthimage = new JLabel(resizeImageIcon(fourthImageIcon, 120, 120));
        fourthimage.setBorder(new LineBorder(Color.DARK_GRAY, 5, true));
        JPanel fourthPanelimage = new JPanel();
        JLabel fourthnameLabel = new JLabel("<html><center>Late. Karmaveer <br>Kakasaheb Wagh</center></html>");
        fourthPanelname.add(fourthnameLabel);
        fourth.add(fourthPanelname);
        fourthPanelimage.add(fourthimage);
        fourth.add(fourthPanelimage);
        centerpanel.add(fourth);

// Fifth image panel
        JPanel fifth = new JPanel();
        fifth.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        JPanel fifthPanelname = new JPanel();
        fifth.setLayout(new BoxLayout(fifth, BoxLayout.Y_AXIS));
        ImageIcon fifthImageIcon = new ImageIcon("fifth.png");
        JLabel fifthimage = new JLabel(resizeImageIcon(fifthImageIcon, 120, 120));
        fifthimage.setBorder(new LineBorder(Color.DARK_GRAY, 5, true));
        JPanel fifthPanelimage = new JPanel();
        JLabel fifthnameLabel = new JLabel("<html><center>Late. Karmaveer <br>Bhausaheb Hire</center></html>");
        fifthPanelname.add(fifthnameLabel);
        fifth.add(fifthPanelname);
        fifthPanelimage.add(fifthimage);
        fifth.add(fifthPanelimage);
        centerpanel.add(fifth);

// Sixth image panel
        JPanel sixth = new JPanel();
        sixth.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        JPanel sixthPanelname = new JPanel();
        sixth.setLayout(new BoxLayout(sixth, BoxLayout.Y_AXIS));
        ImageIcon sixthImageIcon = new ImageIcon("sixth.png");
        JLabel sixthimage = new JLabel(resizeImageIcon(sixthImageIcon, 120, 120));
        sixthimage.setBorder(new LineBorder(Color.DARK_GRAY, 5, true));
        JPanel sixthPanelimage = new JPanel();
        JLabel sixthnameLabel = new JLabel("<html><center>Late. Karmaveer <br>Annasaheb Murkute</center></html>");
        sixthPanelname.add(sixthnameLabel);
        sixth.add(sixthPanelname);
        sixthPanelimage.add(sixthimage);
        sixth.add(sixthPanelimage);
        centerpanel.add(sixth);

// Lower panel
        JPanel lowerpanel = new JPanel();
        lowerpanel.setLayout(new GridLayout(1, 3, 5, 5));
        lowerpanel.setPreferredSize(new Dimension(200, 200));
        lowerpanel.setBorder(new EmptyBorder(4, 4, 2, 4));
        panel.add(lowerpanel); // Correctly add lowerpanel here

// Seventh image panel
        JPanel seventh = new JPanel();
        seventh.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        JPanel seventhPanelname = new JPanel();
        seventh.setLayout(new BoxLayout(seventh, BoxLayout.Y_AXIS));
        ImageIcon seventhImageIcon = new ImageIcon("seventh.png");
        JLabel seventhimage = new JLabel(resizeImageIcon(seventhImageIcon, 120, 120));
        seventhimage.setBorder(new LineBorder(Color.DARK_GRAY, 5, true));
        JPanel seventhPanelimage = new JPanel();
        JLabel seventhnameLabel = new JLabel("<html><center>Late. Karmaveer <br>Adv. Baburao Thakare</center></html>");
        seventhPanelname.add(seventhnameLabel);
        seventh.add(seventhPanelname);
        seventhPanelimage.add(seventhimage);
        seventh.add(seventhPanelimage);
        lowerpanel.add(seventh);

// Eighth image panel
        JPanel eighth = new JPanel();
        eighth.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        JPanel eighthPanelname = new JPanel();
        eighth.setLayout(new BoxLayout(eighth, BoxLayout.Y_AXIS));
        ImageIcon eighthImageIcon = new ImageIcon("eigth.png");
        JLabel eighthimage = new JLabel(resizeImageIcon(eighthImageIcon, 120, 120));
        eighthimage.setBorder(new LineBorder(Color.DARK_GRAY, 5, true));
        JPanel eighthPanelimage = new JPanel();
        JLabel eighthnameLabel = new JLabel("<html><center>Late. Karmaveer <br>Adv. Vitthalrao Hande</center></html>");
        eighthPanelname.add(eighthnameLabel);
        eighth.add(eighthPanelname);
        eighthPanelimage.add(eighthimage);
        eighth.add(eighthPanelimage);
        lowerpanel.add(eighth);

// Ninth image panel
        JPanel nineth = new JPanel();
        nineth.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        JPanel ninethPanelname = new JPanel();
        nineth.setLayout(new BoxLayout(nineth, BoxLayout.Y_AXIS));
        ImageIcon ninethImageIcon = new ImageIcon("nineth.png");
        JLabel ninethimage = new JLabel(resizeImageIcon(ninethImageIcon, 120, 120));
        ninethimage.setBorder(new LineBorder(Color.DARK_GRAY, 5, true));
        JPanel ninethPanelimage = new JPanel();
        JLabel ninethnameLabel = new JLabel("<html><center>Late. Karmaveer <br>Dr. Vasantrao Pawar</center></html>");
        ninethPanelname.add(ninethnameLabel);
        nineth.add(ninethPanelname);
        ninethPanelimage.add(ninethimage);
        nineth.add(ninethPanelimage);
        lowerpanel.add(nineth);

        // Adding to contentPanel
        contentPanel.add(heading);
        contentPanel.add(panel);
        contentPanel.revalidate();
        contentPanel.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String buttontext = source.getText();
        if (buttontext.equals("Home")) {
            contentPanel.removeAll();
            Home();
            contentPanel.revalidate();
            contentPanel.repaint();

        }
        if (buttontext.equals("Enrollment")) {
            contentPanel.removeAll();
            EnrollmentOfCourses();
        }
        if (buttontext.equals("Attendance")) {
            contentPanel.removeAll();
            AttendanceMarking();
        }
        if (buttontext.equals("Acadamic Records")) {
            contentPanel.removeAll();
            AcademicRecords();
        }
        if (buttontext.equals("About College")) {
            contentPanel.removeAll();
            AboutCollege();
        }
        if (buttontext.equals("Log Out")) {
            dispose();
            new MainPage();
        }
    }

    public static void main(String[] args) {

        new TeacherMainPage();
    }
}
