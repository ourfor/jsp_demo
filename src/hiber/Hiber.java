package hiber;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistry;

public class Hiber {
    public static void main(String args[]){
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).getBootstrapServiceRegistry();

        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        StudentsEntity student = new StudentsEntity();
        student.setStudentNo(2000L);
        student.setStudentName("小明");
        student.setSage((short)17);
        student.setMajor("计算机科学");
        session.save(student);

        System.out.println("插入学生成功");
        tx.commit();
        session.close();
        factory.close();

    }
}
