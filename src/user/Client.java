package user;
import student.Student;
import java.util.List;

public class Client {
    public static void main(String args[]){
        ConnectDBSingleton test = ConnectDBSingleton.getIns();
        List<Student> students = test.getStudents();
        for(Student student:students){
            System.out.printf("%s\t",student.getId());
            System.out.printf("%s\t",student.getName());
            System.out.printf("%s\t\n",student.getAge());
        }
        test.ModifyDB("update info set Name=\"杜甫\",Age=22,QQ=94567 where SID=20170215;");
        students = test.getStudents();
        for(Student student:students){
            System.out.printf("%s\t",student.getId());
            System.out.printf("%s\t",student.getName());
            System.out.printf("%s\t\n",student.getAge());
        }
    }
}
