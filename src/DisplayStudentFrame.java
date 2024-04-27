
import javax.swing.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.jar.JarEntry;

public class DisplayStudentFrame extends JFrame {

    public DisplayStudentFrame()
    {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.txt"));
            while (true) {
                Student s = (Student) ois.readObject();
                System.out.println(s.toString());
                JOptionPane.showMessageDialog(new JFrame(), s.toString());
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
