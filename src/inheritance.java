import java.util.Arrays;

class Person{
    protected String name;
    protected int year_of_birth;

    public Person(String name, int year_of_birth) {
        this.name = name;
        this.year_of_birth = year_of_birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", year_of_birth=" + year_of_birth +
                '}';
    }
}
class Student extends Person{
    protected int enrolled_semester;
    protected String Student_ID;


    public Student(String name, int year_of_birth, int enrolled_semester, String student_ID) {
        super(name, year_of_birth);
        this.enrolled_semester = enrolled_semester;
        Student_ID = student_ID;
    }
    public void Display(){
        System.out.println("enrolled_semester=" + enrolled_semester +
                ", Student_ID='" + Student_ID + '\'' +
                ", name='" + name + '\'' +
                ", year_of_birth=" + year_of_birth);
    }

    @Override
    public String toString() {
        return "Student{" +
                "enrolled_semester=" + enrolled_semester +
                ", Student_ID='" + Student_ID + '\'' +
                ", name='" + name + '\'' +
                ", year_of_birth=" + year_of_birth +
                '}';
    }
}
abstract class Employee extends Person{
    protected String employee_ID;
    protected int joining_year;
    protected String job_title;
    abstract void cal_pay();
    public Employee(String name, int year_of_birth, String employee_ID, int joining_year, String job_title) {
        super(name, year_of_birth);
        this.employee_ID = employee_ID;
        this.joining_year = joining_year;
        this.job_title = job_title;
    }

    @Override
    public String toString() {
        return
                "employee_ID='" + employee_ID + '\'' +
                        ", joining_year=" + joining_year +
                        ", job_title='" + job_title + '\'' +
                        ", name='" + name + '\'' +
                        ", year_of_birth=" + year_of_birth ;
    }
}
class Administration extends Employee{
    protected int years_of_service;
    protected int rate_per_year=5000;
    protected int pay;
    @Override
    void cal_pay() {
        years_of_service=2023-joining_year;
        pay=years_of_service*rate_per_year;
        System.out.println("Pay: "+pay);
    }
    public void setJobTitle(){
        this.job_title=job_title;
    }
    public String getJobTitle(){
        return job_title;
    }
    public Administration(String name, int year_of_birth, String employee_ID, int joining_year, String job_title) {
        super(name, year_of_birth, employee_ID, joining_year, job_title);
    }

    @Override
    public String toString() {
        return "Administration{" +
                "employee_ID='" + employee_ID + '\'' +
                ", joining_year=" + joining_year +
                ", job_title='" + job_title + '\'' +
                ", name='" + name + '\'' +
                ", year_of_birth=" + year_of_birth +
                '}';
    }
}
class Faculty extends Employee{
    protected  String[] List_of_CourseID;
    protected int years_of_service;
    protected int rate_per_year=5000;
    protected int pay;

    public Faculty(String name, int year_of_birth, String employee_ID, int joining_year, String job_title) {
        super(name, year_of_birth, employee_ID, joining_year, job_title);
    }

    public void setCourseList( String[] List_of_CourseID){
        this.List_of_CourseID=List_of_CourseID;
    }
    public  String[] getCourseList(){
        return List_of_CourseID;
    }

    @Override
    void cal_pay() {
        years_of_service=2023-joining_year;
        pay=years_of_service*rate_per_year;
        System.out.println("Pay :"+pay);
    }

    @Override
    public String toString() {
        return
                " employee_ID=" + employee_ID + '\'' +
                        " joining_year=" + joining_year +
                        " job_title=" + job_title + '\'' +
                        " name=" + name + '\'' +
                        " year_of_birth=" + year_of_birth ;
    }
}
public class inheritance {
    public static void main(String[] args) {
        Student student1 = new Student("WARDA MIRZA", 2004, 2, "STU1");
        Student student2 = new Student("MEMONA SAEED", 1933, 4, "STU2");
        Student student3 = new Student("ZUNAIRA SAEED", 2002, 1, "STU3");

        Administration adminStaff = new Administration("SIR ALI HAMMAD", 1985, "ADMIN1", 2002, "Admin");

        Faculty teacher1 = new Faculty("SIR AFEEF OBAID",1995,"TEACHER1",2008,"Teacher");
        Faculty teacher2 = new Faculty("MAM DARAKSHAN",2001,"TEACHER2",2012,"Teacher");

        System.out.println("----------- STUDENT DATA---------------");
        student1.Display();
        System.out.println(student1.toString());
        System.out.println();
        student2.Display();
        System.out.println(student2.toString());
        System.out.println();
        student3.Display();
        System.out.println(student3.toString());
        System.out.println();

        System.out.println("------------- ADMIN STAFF DATA -------------");
        System.out.println(adminStaff.toString());
        adminStaff.cal_pay();
        System.out.println();

        System.out.println("---- TEACHER DATA ----");
        System.out.println(teacher1.toString());
        teacher1.cal_pay();
        teacher1.setCourseList(new String[]{"COURSE1", "COURSE2", "COURSE3"});
        System.out.println(Arrays.toString(teacher1.getCourseList()));
        System.out.println();
        System.out.println(teacher2.toString());
        teacher2.cal_pay();
        teacher2.setCourseList(new String[]{"COURSE4", "COURSE5", "COURSE6"});
        System.out.println(Arrays.toString(teacher1.getCourseList()));
    }
}