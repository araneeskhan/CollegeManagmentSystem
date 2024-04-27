

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteFrame extends JFrame{
    JPanel p1,p2;
    JLabel l1,l2;
    JTextField t1;
    JButton b1,b2;
    public DeleteFrame(){

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
        b1 = new JButton("Delete");
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

            if(e.getActionCommand().equals("Delete")){
                String name = t1.getText();
                FileOperations<Student> stuF = new FileOperations<Student>();
                Student s = stuF.searchByName(name,"student.txt");
                if(s!=null){
                    System.out.println(s.toString());
                    String str = s.getName() + "\n"+s.getClg_Id();
                    JOptionPane.showMessageDialog(new JFrame(),"Deleted !\n"+str);
                    stuF.delete(s,"student.txt");
                    dispose();
                    MainAdminFrame m =new MainAdminFrame();
                }
                else{
                    FileOperations<Teacher> teachF = new FileOperations<Teacher>();
                    Teacher t = teachF.searchByName(name,"teacher.txt");
                    if(t!=null){
                        System.out.println(t.toString());
                        String str = t.getName() + "\n"+t.getClg_Id();
                        JOptionPane.showMessageDialog(new JFrame(),"Delete\n"+str);
                        teachF.delete(t,"teacher.txt");
                        dispose();
                        MainAdminFrame m =new MainAdminFrame();
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

