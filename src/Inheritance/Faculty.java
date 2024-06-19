package Inheritance;

public class Faculty extends Employee{
    protected String designation;
    protected String department;
    protected int year_of_education;

    public Faculty(String name, String address,int number, double pay, double house_rent, double medical_allow, String designation, String department, int year_of_education) {
        super(name, address,number, pay, house_rent, medical_allow);
        this.designation = designation;
        this.department = department;
        this.year_of_education = year_of_education;
    }

    public Faculty() {
        super();
        this.designation = "";
        this.department = "";
        this.year_of_education = 0;
    }
    @Override
    public void calcSalary( )
    {
        super.calcSalary();
       if(this.year_of_education == 16)
       {
           this.pay += 1500;
       }
       else if(this.year_of_education == 18)
       {
           this.pay +=  2000;
       }
       else
       {
           this.pay +=  3000;
       }
    }
}
