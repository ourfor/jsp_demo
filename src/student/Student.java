package student;

public class Student {
    private int id;
    private String name;
    private int age;
    private int qq;

    public Student() {
    }

    public Student(int id, String name, int age, int qq) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.qq = qq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }
}
