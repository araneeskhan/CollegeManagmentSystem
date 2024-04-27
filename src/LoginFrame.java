import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame{
    private JTextField t1;
    private JTextField t2;
    private JButton b1;

    private JLabel l1;
    private JLabel l2;
    private JLabel l3;

//    private JLabel image;

    public LoginFrame(){

        setSize(400,400);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(255, 255, 255));
        setVisible(true);


//      The layer that is used to hold object is Content Pane.

        l1 = new JLabel("College Management System");

        l1.setFont(new Font("Times New Roman", Font.BOLD, 22));
        l1.setBounds(62, 32, 283, 52);
        getContentPane().add(l1);

        l2 = new JLabel("Username");
        l2.setFont(new Font("Times New Roman", Font.BOLD, 17));
        l2.setBounds(46, 138, 93, 14);
        getContentPane().add(l2);

        l3 = new JLabel("Password");
        l3.setFont(new Font("Times New Roman", Font.BOLD, 17));
        l3.setBounds(46, 191, 103, 14);
        getContentPane().add(l3);

        t1 = new JTextField();
        t1.setBounds(199, 132, 146, 20);
        getContentPane().add(t1);

        t2 = new JTextField();
        t2.setBounds(199, 185, 146, 20);
        getContentPane().add(t2);

        b1 = new JButton("Login");
        b1.setBounds(146, 272, 89, 23);
        getContentPane().add(b1);

//       image = new JLabel(new ImageIcon("college.jpeg"));
//       getContentPane().add(image);


        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String username = t1.getText();
                String password = t2.getText();

                if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin123")) {
                    JOptionPane.showMessageDialog(new JFrame(),"Logged in Successfully !");
                    dispose();
                    MainAdminFrame a = new MainAdminFrame();
                }
                else
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Incorrect Username/Password");
                }
            }
        });

    }
}