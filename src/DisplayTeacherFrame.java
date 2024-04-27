
import javax.swing.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class DisplayTeacherFrame extends JFrame {

    public DisplayTeacherFrame()
    {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher.txt"));
            while (true) {
                Teacher t = (Teacher) ois.readObject();
                System.out.println(t.toString());
                JOptionPane.showMessageDialog(new JFrame(), t.toString());
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("warning");
        } catch (EOFException e) {
            return;
        } catch (IOException e) {
            System.out.println("?");
        } finally {

        }
    }
}
