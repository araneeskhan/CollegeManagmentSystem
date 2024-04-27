import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class StatisticsFiling {

    public void readPreMedStu() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.txt"));
            while (true) {
                Student s = (Student) ois.readObject();
                if(s.getD().getDep_name().equalsIgnoreCase("Pre_Medical")){
                    System.out.println(s.toString());
                    System.out.println();
                }
//                System.out.println(s.toString());
//                System.out.println();
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

    public void readPreEngStu() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.txt"));
            while (true) {
                Student s = (Student) ois.readObject();
                if(s.getD().getDep_name().equalsIgnoreCase("Pre_Engineering")){
                    System.out.println(s.toString());
                    System.out.println();
                }
//                System.out.println(s.toString());
//                System.out.println();
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

    public void readIcsStu() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.txt"));
            while (true) {
                Student s = (Student) ois.readObject();
                if(s.getD().getDep_name().equalsIgnoreCase("ICS")){
                    System.out.println(s.toString());
                    System.out.println();
                }
//                System.out.println(s.toString());
//                System.out.println();
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