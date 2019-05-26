package hiber;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students", schema = "dbo", catalog = "web")
public class StudentsEntity {
    private long id;
    private Long studentNo;
    private String studentName;
    private Short sage;
    private String major;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "student_no")
    public Long getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Long studentNo) {
        this.studentNo = studentNo;
    }

    @Basic
    @Column(name = "student_name")
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "sage")
    public Short getSage() {
        return sage;
    }

    public void setSage(Short sage) {
        this.sage = sage;
    }

    @Basic
    @Column(name = "major")
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsEntity that = (StudentsEntity) o;
        return id == that.id &&
                Objects.equals(studentNo, that.studentNo) &&
                Objects.equals(studentName, that.studentName) &&
                Objects.equals(sage, that.sage) &&
                Objects.equals(major, that.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentNo, studentName, sage, major);
    }
}
