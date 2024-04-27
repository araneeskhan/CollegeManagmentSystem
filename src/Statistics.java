import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Statistics extends JFrame{
    JButton b1;

    JTextField t1;

    public Statistics(){

        setLayout(new BorderLayout());
        setVisible(true);
        setSize(400,400);

        b1 = new JButton("Statistics");
        t1 = new JTextField();

        MListener m = new MListener();
        b1.addActionListener(m);
        t1.addActionListener(m);
    }
    public class MListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if(e.getActionCommand().equals("Statistics")){
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
                        JOptionPane.showMessageDialog(new JFrame(),"Not Found!");
                    }
                }

            else if(e.getActionCommand().equals("Home")){
                dispose();
                MainAdminFrame m =new MainAdminFrame();
            }
        }
    }

}

