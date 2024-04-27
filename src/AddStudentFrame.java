
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentFrame extends JFrame{

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    JButton b1,b2;
    JComboBox combo;
    JRadioButton j1,j2;
    ButtonGroup group;

    public AddStudentFrame(){

        setSize(400,400);
        setLayout(new GridLayout(14,2));
        setVisible(true);

        int x = (int) (Math.random() * 10) + 50;

        FileOperations<Student> foStu = new FileOperations();
        FileOperations<Teacher> foT = new FileOperations<Teacher>();

        Person id1 = foStu.verifyCollegeID("student.txt",String.valueOf(x));
        Person id2 = foT.verifyCollegeID("teacher.txt",String.valueOf(x));


        while(id1 != null && id2 != null){
            x = (int) (Math.random() * 10) + 50;
        }

        l1 = new JLabel("Name");
        l2 = new JLabel("College ID");
        l3 = new JLabel("Age");
        l4 = new JLabel("House# ");
        l11 = new JLabel("Street# ");
        l12 = new JLabel("City ");
        l5 = new JLabel("DOB xx/xx/xxxx");
        l6 = new JLabel("Father Name ");
        l7 = new JLabel("Matric marks ");
        l8 = new JLabel("Previous Education ");
        l9 = new JLabel("Department ");
        l13 = new JLabel();
        String[] str = {"ICS","Pre_Medical","Pre_Engineering"};
        combo = new JComboBox(str);
        l10 = new JLabel("Current Class");
        j1 = new JRadioButton("1st Year");
        j2 = new JRadioButton("2nd Year");
        group = new ButtonGroup();
        group.add(j1); group.add(j2);

        t1 = new JTextField(20);
        t3 = new JTextField(20);
        t2 = new JTextField(String.valueOf(x));

        t4 = new JTextField(20);
        t11 = new JTextField(20);
        t12 = new JTextField(20);
        t5 = new JTextField(20);
        t6 = new JTextField(20);
        t7 = new JTextField(20);
        t8 = new JTextField(20);
        b1 = new JButton("Submit");
        b2 = new JButton("Home");

        MyListener m = new MyListener();
        b1.addActionListener(m);
        b2.addActionListener(m);
        add(l1);add(t1);
        add(l2);add(t2);
        add(l3);add(t3);
        add(l4);add(t4);
        add(l11);add(t11);
        add(l12);add(t12);
        add(l5);add(t5);
        add(l6);add(t6);
        add(l7);add(t7);
        add(l8);add(t8);
        add(l9);
        add(combo);
        add(l10);add(l13);
        add(j1);add(j2);
        add(b1);add(b2);
    }

    public class MyListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if(e.getActionCommand().equals("Submit")){

                String name = t1.getText();
                String id = t2.getText();
                String age = t3.getText();
                String house = t4.getText();
                String street = t11.getText();
                String city = t12.getText();
                String dob = t5.getText();
                String father = t6.getText();
                double matricMarks = Double.parseDouble(t7.getText());
                String edu = t8.getText();
                String deptName =(String) combo.getSelectedItem();
                String currClass = "";

                if(j1.isSelected()){
                    currClass = "1st Year";
                }
                else if(j2.isSelected()){
                    currClass = "2nd Year";
                }

                // initially username and password are college ID student and teachers can change it after
                String username = id;
                String pass = id;

                int day = Integer.parseInt(dob.substring(0,2));
                int month = Integer.parseInt(dob.substring(3,5));
                int year= Integer.parseInt(dob.substring(6,10));

                Student s = new Student(name,age,id,new Address(street,house,city),
                        new Date(day,month,year),father,matricMarks,
                        edu, currClass,new Department(deptName),
                        new Login(username,pass));

                s.allocate_Courses();

                FileOperations fo = new FileOperations();
                fo.writeToFile(s,"student.txt");
                JOptionPane.showMessageDialog(new JFrame(),"Successfully Added!");
                dispose();
                MainAdminFrame a = new MainAdminFrame();
            }
            else if(e.getActionCommand().equals("Home")){
                dispose();
                MainAdminFrame m = new MainAdminFrame();
            }
        }
    }
}
