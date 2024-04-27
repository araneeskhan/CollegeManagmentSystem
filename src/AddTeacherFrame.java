

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarEntry;

public class AddTeacherFrame extends JFrame {

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b1,b2;

    public AddTeacherFrame(){

        setSize(400,400);
        setLayout(new GridLayout(11,2));
        setVisible(true);

        int x = (int) (Math.random() * 10) + 20;

        FileOperations fo = new FileOperations();
        Person id1 = fo.verifyCollegeID("student.txt",String.valueOf(x));
        Person id2 = fo.verifyCollegeID("teacher.txt",String.valueOf(x));

        while(id1!=null && id2!=null){
            x = (int) (Math.random() * 10) + 20;
        }

        l1 = new JLabel("Name");
        l2 = new JLabel("age");
        l3 = new JLabel("Clg_Id");
        l4 = new JLabel("House");
        l5 = new JLabel("Street");
        l10= new JLabel("City");
        l6 = new JLabel("DOB");
        l8 = new JLabel("Degree");
        l9 = new JLabel("Teaching Experience");

        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(String.valueOf(x));
        t3.disable();
        t4 = new JTextField(20);
        t5 = new JTextField(20);
        t10 = new JTextField(20);
        t6 = new JTextField(20);
        t8 = new JTextField(20);
        t9 = new JTextField(20);

        b1 = new JButton("Submit");
        b2 = new JButton("Home");


        MyListener m = new MyListener();
        b1.addActionListener(m);
        b2.addActionListener(m);
        add(l1);add(t1);
        add(l2);add(t2);
        add(l3);add(t3);
        add(l4);add(t4);
        add(l5);add(t5);
        add(l10);add(t10);
        add(l6);add(t6);
        add(l8);add(t8);
        add(l9);add(t9);
        add(b1);add(b2);
    }

    public class MyListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if(e.getActionCommand().equals("Submit")){

                String name= t1.getText();
                String age = t2.getText();
                String id = t3.getText();
                String house  = t3.getText();
                String street = t4.getText();
                String city = t10.getText();
                String dob = t6.getText();
                String degree = t8.getText();
                String exp = t9.getText();
                String username = id;
                String pass = id;
                int day = Integer.parseInt(dob.substring(0,2));
                int month = Integer.parseInt(dob.substring(3,5));
                int year= Integer.parseInt(dob.substring(6,10));

                Teacher t = new Teacher(name,age,id,new Address(house,street,city),
                        new Date(day,month,year),degree,exp,new Login(username,pass));
                System.out.println(t.toString());
                FileOperations fo = new FileOperations();
                fo.writeToFile(t,"teacher.txt");
                JOptionPane.showMessageDialog(new JFrame(),"Successfully Added!");
                dispose();
                MainAdminFrame m = new MainAdminFrame();
            }
            else if(e.getActionCommand().equals("Home")){
                dispose();
                MainAdminFrame m = new MainAdminFrame();
            }
        }
    }
}
