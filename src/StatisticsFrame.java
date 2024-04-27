import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StatisticsFrame extends JFrame{

    JButton b1,b2,b3;
    JPanel p1,p2,p3;
    JLabel l1;
    public StatisticsFrame(){

        setSize(400,400);
        setLayout(new BorderLayout());
        setVisible(true);

        p1 =  new JPanel();
        l1 = new JLabel("STATISTICS");
        p1.setLayout(new FlowLayout());
        p1.add(l1);
        add(p1,BorderLayout.NORTH);

        p2 = new JPanel();

        b1 = new JButton("Pre Medical Students");
        b2 = new JButton("Engineering Students");
        b3 = new JButton("ICS students");

        p2.setLayout(new GridLayout(4,2));
        MyListener m = new MyListener();
        b1.addActionListener(m);
        b2.addActionListener(m);
        b3.addActionListener(m);

        p2.add(b1);p2.add(b2);p2.add(b3);
        add(p2,BorderLayout.CENTER);

        p3 = new JPanel();
        p3.setLayout(new FlowLayout());

        add(p3,BorderLayout.SOUTH);
    }

    public class MyListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if(e.getActionCommand().equalsIgnoreCase("Pre Medical Students")){
                dispose();
                StatisticsFiling s = new StatisticsFiling();
                s.readPreMedStu();


            }
            else if(e.getActionCommand().equalsIgnoreCase("Engineering Students")){
                dispose();
                StatisticsFiling s = new StatisticsFiling();
                s.readPreEngStu();

            }
            else if(e.getActionCommand().equalsIgnoreCase("ICS students")){
                dispose();
                StatisticsFiling s = new StatisticsFiling();
                s.readIcsStu();
            }

        }
    }
}