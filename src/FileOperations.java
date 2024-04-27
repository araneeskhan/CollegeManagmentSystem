
import java.io.*;
import java.util.ArrayList;
public class FileOperations<T extends  Person>{

    public void writeToFile(T person, String fileName){
        ObjectOutputStream oos;

        try {
            File f = new File(fileName);

            if(f.exists()){
                oos = new MyObjectOutputStream(new FileOutputStream(f,true));
            }
            else{
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(person);
            oos.close();
        }
        catch(IOException e){
        }
        finally{
            // oos.close();
        }
    }

    public ArrayList<Teacher> readTeacher(){
        ArrayList<Teacher> arr = new ArrayList<>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher.txt"));
            while(true){

                Teacher s = (Teacher) ois.readObject();
                System.out.println(s.toString());
                arr.add(s);
            }
        }
        catch(EOFException e){

        }
        catch(ClassNotFoundException e){

        }
        catch(IOException e){

        }
        finally{
        }
        return arr;
    }

    public ArrayList<T> readFromFile(String fileName){
        ArrayList<T> arr = new ArrayList<>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            while(true){

                T s = (T) ois.readObject();
                System.out.println(s.toString());
                arr.add(s);
            }
        }
        catch(EOFException e){

        }
        catch(ClassNotFoundException e){

        }
        catch(IOException e){

        }
        finally{
        }
        return arr;
    }

    public T searchByName(String str,String fileName){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            while(true) {

                T s = (T)ois.readObject();

                if (s.getName().equalsIgnoreCase(str)) {
                    System.out.println(s.toString());
                    System.out.println("-----------------------------------");
                    return (T) s;
                }
            }
        }
        catch(ClassNotFoundException e){
            System.out.println("Class not found");
        }
        catch(EOFException e){
            return null;
        }
        catch(IOException e){
        }
        return null;
    }

    public void delete(T person,String fileName){
        // read all the data and store it into a arraylist
        ArrayList<T> arr = new ArrayList<T>();

        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            while(true){

                T s = (T)ois.readObject();
                arr.add(s);
            }
        }
        catch(ClassNotFoundException e){
            System.out.println("Problem in delete function: ClassNotFoundException");
        }
        catch(FileNotFoundException e){
            System.out.println("Problem in delete function: FileNotFoundException");
        }
        catch(IOException e){

        }

        // search the arraylist for the student name and delete that student from list
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).getClg_Id().equalsIgnoreCase(person.getClg_Id())){
                arr.remove(i);
            }
        }

        // write the updated version back to the file
        try{
            ObjectOutputStream oos;

            // the first student object should be written with a header and append mode should not be true
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(arr.get(0));

            for(int i=1;i<arr.size();i++){
                oos = new MyObjectOutputStream(new FileOutputStream(fileName,true));
                oos.writeObject(arr.get(i));
            }
            oos.close();
        }
        catch(IOException e){
            System.out.println("Problem in delete function");
        }
    }

//    public void updateAttendance(T person,String fileName,String attendance){
//
//        ArrayList<T> arr = new ArrayList<T>();
//        // save all the data in array list
//        try{
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
//            while(true){
//                T s = (T)ois.readObject();
//                arr.add(s);
//            }
//        }
//        catch(ClassNotFoundException e){
//            System.out.println("Class not found");
//        }
//        catch( FileNotFoundException e){
//            System.out.println("File not found");
//        }
//        catch(IOException e){
//        }
//
//        // search the array list with that name and update  gpa
//        for(int i =0;i<arr.size();i++){
//            if(person instanceof Student){
//                if(arr.get(i).getClg_Id().equalsIgnoreCase(person.getClg_Id())){
//                    Student stu = (Student)arr.get(i);
//                    arr.set(i, (T) stu);
//                }
//
//                else if(person instanceof Teacher){
//                    if(arr.get(i).getClg_Id().equalsIgnoreCase(person.getClg_Id())){
//                        Teacher teacher = (Teacher)arr.get(i);
//                        arr.set(i,(T)teacher);
//                    }
//                }
//            }
//        }
//        //now write all the data in arraylist onto the file
//        try{
//            ObjectOutputStream oos;
//
//            oos = new ObjectOutputStream(new FileOutputStream(fileName));
//            oos.writeObject(arr.get(0));
//
//            for(int i=1;i<arr.size();i++){
//                oos = new MyObjectOutputStream(new FileOutputStream(fileName,true));
//                oos.writeObject(arr.get(i));
//            }
//            oos.close();
//        }
//        catch(IOException e){
//            System.out.println("Problem in update");
//        }
//    }

    public T verifyCollegeID(String fileName, String id){

        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            while(true){
                if(fileName.equalsIgnoreCase("student.txt")){
                    Student s = (Student) ois.readObject();
                    if(s.getClg_Id().equalsIgnoreCase(id)){
                        return (T)s;
                    }
                }
                else if(fileName.equalsIgnoreCase("teacher.txt")){
                    Teacher s = (Teacher) ois.readObject();
                    if(s.getClg_Id().equalsIgnoreCase(id)){
                        return (T)s;
                    }
                }
            }
        }
        catch(ClassNotFoundException e){
            System.out.println("Class not found");
        }
        catch(EOFException e){
        }
        catch(IOException e){
        }
        finally{
        }
        return null;
    }

    // update the whole file
    public void updateFile(String fileName,ArrayList<T> arr){
        try{
            ObjectOutputStream oos;

            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(arr.get(0));

            for(int i=1;i<arr.size();i++){
                oos = new MyObjectOutputStream(new FileOutputStream(fileName,true));
                oos.writeObject(arr.get(i));
            }
            oos.close();
        }
        catch(IOException e){
            System.out.println("Problem in update");
        }
    }

//    public void updateStudentAssign(T person,String fileName,boolean assigned){
//
//        if(person instanceof Student){
//            ArrayList<T> arr = new ArrayList<T>();
//            // save all the data in array list
//            try{
//                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
//                while(true){
//                    T s = (T)ois.readObject();
//                    arr.add(s);
//                }
//            }
//            catch(ClassNotFoundException e){
//                System.out.println("Class not found");
//            }
//            catch( FileNotFoundException e){
//                System.out.println("File not found");
//            }
//            catch(IOException e){
//            }
//
//            // search the array list with that name and update  gpa
//            for(int i =0;i<arr.size();i++){
//                if(arr.get(i).getClg_Id().equalsIgnoreCase(person.getClg_Id())){
//                    Student stu = (Student)arr.get(i);
//                    stu.setAssigned(assigned);
//                    arr.set(i, (T) stu);
//                }
//            }
//            //now write all the data in arraylist onto the file
//            try{
//                ObjectOutputStream oos;
//
//                oos = new ObjectOutputStream(new FileOutputStream(fileName));
//                oos.writeObject(arr.get(0));
//
//                for(int i=1;i<arr.size();i++){
//                    oos = new MyObjectOutputStream(new FileOutputStream(fileName,true));
//                    oos.writeObject(arr.get(i));
//                }
//                oos.close();
//            }
//            catch(IOException e){
//                System.out.println("Problem in update");
//            }
//        }
//    }
}