

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SearchFrame extends JFrame{

    JPanel p1,p2,p3;
    JButton b1,b2;
    JLabel l1;
    JTextField t1;

    public SearchFrame(){

        // Panel 1 to enter name for search
        setLayout(new BorderLayout());
        setVisible(true);
        setSize(600,600);
        p1 = new JPanel();

        l1 = new JLabel("Enter Name: ");
        t1 = new JTextField(40);
        p1.setLayout(new FlowLayout());
        p1.add(l1);p1.add(t1);
        add(p1,BorderLayout.NORTH);

        p2 = new JPanel();
        b1 = new JButton("Search");
        b2 = new JButton("Home");
        MListener m = new MListener();
        b1.addActionListener(m);
        b2.addActionListener(m);
        p2.setLayout(new FlowLayout());
        p2.add(b1);p2.add(b2);
        add(p2,BorderLayout.CENTER);

    }

    public class MListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if(e.getActionCommand().equals("Search")){
                String name = t1.getText();
                FileOperations<Student> stuF = new FileOperations<Student>();
                Student s = stuF.searchByName(name,"student.txt");
                if(s!=null){
                    System.out.println(s.toString());
                    JOptionPane.showMessageDialog(new JFrame(),"Found!");
                    dispose();
                    ShowStudentData show = new ShowStudentData(s);
                }
                else{
                    FileOperations<Teacher> teachF = new FileOperations<Teacher>();
                    Teacher t = teachF.searchByName(name,"teacher.txt");
                    if(t!=null){
                        System.out.println(t.toString());
                        JOptionPane.showMessageDialog(new JFrame(),"Found!");
                        dispose();
                        ShowTeacherFrame tech  = new ShowTeacherFrame(t);
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(),"Not Found!");
                    }
                }
            }
            else if(e.getActionCommand().equals("Home")){
                dispose();
                MainAdminFrame m =new MainAdminFrame();
            }
        }
    }

}

