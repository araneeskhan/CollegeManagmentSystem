import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainAdminFrame extends JFrame{

    JButton b1,b2,b3,b5,b6,b7,b8,b9;
    JPanel p1,p2,p3;
    JLabel l1;
    public MainAdminFrame(){

        setSize(400,400);
        setLayout(new BorderLayout());
        setVisible(true);

        p1 =  new JPanel();
        l1 = new JLabel("ADMIN");
        p1.setLayout(new FlowLayout());
        p1.add(l1);
        add(p1,BorderLayout.NORTH);

        p2 = new JPanel();

        b1 = new JButton("Add Student");
        b2 = new JButton("Add Teacher");
        b3 = new JButton("Delete");

        b5 = new JButton("Search");
        b6 = new JButton("Display Students");
        b7 = new JButton("Display Teachers");
        b9 = new JButton("Statistics");
        b8 = new JButton("Log Out");

        p2.setLayout(new GridLayout(4,2));

        MyListener m = new MyListener();

        b1.addActionListener(m);
        b2.addActionListener(m);
        b3.addActionListener(m);
        b5.addActionListener(m);
        b6.addActionListener(m);
        b7.addActionListener(m);
        b8.addActionListener(m);
        b9.addActionListener(m);

        p2.add(b1);p2.add(b2);p2.add(b3);
        p2.add(b5);p2.add(b5);p2.add(b6);p2.add(b7);p2.add(b9);
        add(p2,BorderLayout.CENTER);

        p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        p3.add(b8);
        add(p3,BorderLayout.SOUTH);
    }

    public class MyListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if(e.getActionCommand().equalsIgnoreCase("Add Student")){
                dispose();
                AddStudentFrame add = new AddStudentFrame();
            }
            else if(e.getActionCommand().equalsIgnoreCase("Add Teacher")){
                dispose();
                AddTeacherFrame add= new AddTeacherFrame();
            }
            else if(e.getActionCommand().equalsIgnoreCase("Search")){
                dispose();
                SearchFrame s = new SearchFrame();
            }
            else if(e.getActionCommand().equalsIgnoreCase("Delete")){
                dispose();
                DeleteFrame d = new DeleteFrame();

            } else if (e.getActionCommand().equalsIgnoreCase("Display Students")) {
                dispose();
                DisplayStudentFrame s = new DisplayStudentFrame();

            }
            else if (e.getActionCommand().equalsIgnoreCase("Display Teachers")) {
                dispose();
                DisplayTeacherFrame t = new DisplayTeacherFrame();
            }
            else if (e.getActionCommand().equalsIgnoreCase("Statistics")) {
                dispose();
                DisplayCourses d = new DisplayCourses();
            }
            else if(e.getActionCommand().equalsIgnoreCase("Log Out")){
                dispose();
                LoginFrame m = new LoginFrame();
            }

        }
    }
}

