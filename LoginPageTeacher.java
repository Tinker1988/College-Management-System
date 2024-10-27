
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class LoginPageTeacher extends JFrame implements ActionListener {

    private static JTextField usernameField;
    private static JPasswordField passwordField;
        ImageIcon image = new ImageIcon("ClgLogo.png");
 JButton loginbutton;

    LoginPageTeacher() {
JPanel MainPanel = new JPanel();
        JLabel usernameLable = new JLabel("Username: ");
        usernameField = new JTextField(20);
        usernameField.setEditable(true);
        usernameField.setPreferredSize(new Dimension(200, 30));
        JLabel passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField(20);
        passwordField.setEditable(true);
         passwordField.setPreferredSize(new Dimension(200, 30));
       loginbutton = new JButton("Login");



        //Designing
        
MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));
        MainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        usernameLable.setAlignmentX(CENTER_ALIGNMENT);
        loginbutton.setBackground(Color.RED);
        loginbutton.setForeground(Color.white);
        loginbutton.setFocusable(false);
        loginbutton.setFocusPainted(false);
        usernameField.setBorder(new LineBorder(Color.GRAY,2,true));
        passwordField.setBorder(new LineBorder(Color.GRAY,2,true));
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        //add components to frame
         MainPanel.add(usernameLable);
        MainPanel.add(usernameField);
        MainPanel.add(passwordLabel);
        MainPanel.add(passwordField);
         MainPanel.add(Box.createVerticalStrut(10)); 
         MainPanel.add(loginbutton);
         loginbutton.addActionListener(this);
        this.add(MainPanel);
        //Frame Setup
        this.setTitle("Teacher Login Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
this.setResizable(false);
this.setIconImage(image.getImage());
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
public static String username;
    public static String password;

    // Static method to return the username
    public static String getUsername() {
        return usernameField.getText();
    }

    public static String getPassword(){
        return new String(passwordField.getPassword());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== loginbutton){
String passwordtext=  getPassword(); // Use getPassword() for JPasswordField
       String usernametext = getUsername();
       String [] correctUsernames = {"Dhiraj Birari"};
       String[] correctPasswords = {"OOP"};
int n = correctUsernames.length;
boolean loginSuccessful = false;
       for(int i =0;i<n;i++){
        if(correctUsernames[i].equals(usernametext) && correctPasswords[i].equals(passwordtext)){
            
            loginSuccessful=true;
            loginbutton.setEnabled(false);
        }
        }
        if(loginSuccessful==true){
JOptionPane.showMessageDialog(null, "Login Successful!");
new TeacherMainPage();
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid Username or Password!");
            new MainPage();
        }
        }

    }

}
