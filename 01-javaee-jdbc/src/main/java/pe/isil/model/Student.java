package pe.isil.model;

public class Student {
    private Integer id;
    private String firstName;
    private String lastNameFather;
    private String lastNameMother;
    private Integer age;

    public Student() {
    }

    public Student(Integer id, String firstName, String lastNameFather, String lastNameMother, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastNameFather = lastNameFather;
        this.lastNameMother = lastNameMother;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNameFather() {
        return lastNameFather;
    }

    public void setLastNameFather(String lastNameFather) {
        this.lastNameFather = lastNameFather;
    }

    public String getLastNameMother() {
        return lastNameMother;
    }

    public void setLastNameMother(String lastNameMother) {
        this.lastNameMother = lastNameMother;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastNameFather='" + lastNameFather + '\'' +
                ", lastNameMother='" + lastNameMother + '\'' +
                ", age=" + age +
                '}';
    }
}
