import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainPage extends JFrame implements ActionListener{

    ImageIcon image = new ImageIcon("ClgLogo.png");
    JLabel label = new JLabel();
    JButton button1 = new JButton("Teacher");
 //   JButton button2 = new JButton("Student");

    MainPage() {
        // Image section
        Image originalImage = image.getImage();
        Image resizedImage = originalImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Resize the image
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Label section
        label.setFont(new Font(" Times New Roman", Font.BOLD, 18));
        label.setIcon(resizedIcon);
        label.setText("<html><center>" + "<br/>Maratha Vidya Prasarak Samaj's, Karmaveer Adv.<br>Baburao Ganpatrao Thakare College of <br>Engineering, Nashik </center></html>");
        label.setIconTextGap(5);
        label.setHorizontalTextPosition(JLabel.CENTER); // Text position relative to the image
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Padding above and below the label
// Panel for buttons to align them vertically, one below the other
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Vertical stack for buttons
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center the button horizontally
      //  button2.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center the button horizontally

        button1.setPreferredSize(new Dimension(200, 60));  // Set button size'
        button1.setFont(new Font(" Times New Roman", Font.PLAIN,25));
        button1.setBackground(Color.gray);
       // button2.setBackground(Color.gray);
        button1.setForeground(Color.white);
      //  button2.setForeground(Color.white);
        button1.setFocusable(false);
      //  button2.setFocusable(false);
       // button2.setFont(new Font(" Times New Roman", Font.PLAIN,25));
      //  button2.setPreferredSize(new Dimension(200, 60));

        // Add buttons to button panel
        buttonPanel.add(button1);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between buttons
        //buttonPanel.add(button2);
        button1.addActionListener(this);
    //    button2.addActionListener(this);
       
        // Main panel to vertically stack the label and button panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Stack label and buttons vertically
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0)); // Add some padding for aesthetics
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Center label
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center buttons

        // Add components to the main panel
        mainPanel.add(label);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Space between label and buttons
        mainPanel.add(buttonPanel);

        // Frame setup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setTitle("KBTCOE Portal");
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);                   // Center the frame on screen
        this.setIconImage(image.getImage());
        this.setResizable(false);
        this.add(mainPanel); // Add main panel to frame
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==button1 ){
       SwingUtilities.invokeLater(LoginPageTeacher::new);
        dispose();
       }
      // else{
     //  SwingUtilities.invokeLater(LoginPageStudent::new);
     //  dispose();
//}
    }
}
