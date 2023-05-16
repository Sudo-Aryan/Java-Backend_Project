import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("This is a Console Application that does CRUD operations...\nBuilt on a simple Java application with connection to MySQL DB 8.0.33 using JDBC 8.0.11 by Aryan Halwai\n");
        while(true){
            System.out.println("Press 1 to Insert Data");
            System.out.println("Press 2 to Delete Data");
            System.out.println("Press 3 to Retrieve Data");
            System.out.println("Press 4 to Update Data");
            System.out.println("Press Any letter to Exit Application\n");

            int choice;
            try {
                choice = Integer.parseInt(read.readLine());
            } catch (NumberFormatException e){
                System.out.print("Thanks for using my app!!!");
                break;
            }
                switch (choice) {
                    case 1 -> { //add Student data
                        Student student = Student.studentInfo(read);

                        boolean ans = StudentDao.insert(student);

                        if (ans) System.out.println("The student data was inserted successfully........");
                        else System.out.println("Something went wrong........");
                    }
                    case 2 -> { //Delete student data
                        System.out.println("Enter the Student Id: ");
                        int sid = Integer.parseInt(read.readLine());

                        boolean ans1 = StudentDao.delete(sid);

                        if (ans1) System.out.println("The student data was deleted successfully........");
                        else System.out.println("Something went wrong........");
                    }
                    case 3 -> //Display data
                            StudentDao.display();
                    case 4 -> { //Update data
                        System.out.println("Enter the Student Id: ");
                        int stid = Integer.parseInt(read.readLine());

                        Student student = Student.studentInfo(read);

                        boolean update = StudentDao.update(student, stid);

                        if (update) System.out.println("The student data was updated successfully........");
                        else System.out.println("Something went wrong........");
                    }
                    default -> {
                        System.out.println("\nEnter the Valid choice!!!!!\n");
                    }
                }
        }
    }
}
