import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowStudentData extends JFrame{

    JPanel p1,p2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22;

    JButton b1;

    public ShowStudentData(Student s){

        setLayout(new BorderLayout());
        setVisible(true);
        setSize(600,600);
        p1 = new JPanel();
        l1 = new JLabel("Name");
        l2= new JLabel(s.getName());
        l3 = new JLabel("CollegeID");
        l4 = new JLabel(s.getClg_Id());
        l5 = new JLabel("Age");
        l6 = new JLabel(s.getAge());
        l7 = new JLabel("Address");
        l8 = new JLabel(s.getAddress().toString());
        l9 = new JLabel("DOB (xx/xx/xxxx)");
        l10 = new JLabel(s.getDate_of_birth().toString());
        l11 = new JLabel("Father Name");
        l12 = new JLabel(s.getFather_Name());
        l13 = new JLabel("Matric Marks");
        l14 = new JLabel(String.valueOf(s.getMatric_Marks()));
        l15 = new JLabel("Previous Education");
        l16 = new JLabel(s.getPrev_Edu_Background());
        l17 = new JLabel("Department Name");
        l18 = new JLabel(s.getD().getDep_name());
        l19 = new JLabel("Current Class");
        l20 = new JLabel(s.getCurrent_Class());
        l21 = new JLabel("Fees");
        l22 = new JLabel(String.valueOf(s.getAmount()));

        p1.setLayout(new GridLayout(11,2));
        p1.add(l1);p1.add(l2);
        p1.add(l3);p1.add(l4);
        p1.add(l5);p1.add(l6);
        p1.add(l7);p1.add(l8);
        p1.add(l9);p1.add(l10);
        p1.add(l11);p1.add(l12);
        p1.add(l13);p1.add(l14);
        p1.add(l15);p1.add(l16);
        p1.add(l17);p1.add(l18);
        p1.add(l19);p1.add(l20);
        p1.add(l21);p1.add(l22);
        add(p1,BorderLayout.CENTER);

        p2 = new JPanel();
        b1 = new JButton("Home");
        MListener m = new MListener();
        b1.addActionListener(m);
        p2.setLayout(new FlowLayout());
        p2.add(b1);
        add(p2,BorderLayout.SOUTH);

    }


    public class MListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if(e.getActionCommand().equals("Home")){
                dispose();
                MainAdminFrame m = new MainAdminFrame();
            }

        }
    }

}