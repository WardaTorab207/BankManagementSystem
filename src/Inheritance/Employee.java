package Inheritance;

public class Employee extends Person{
    protected int  Emp_no;
    protected double pay;
    protected double house_rent;
    protected double medical_allow;

    public Employee(String name, String address,int Emp_no, double pay, double house_rent, double medical_allow) {
        super(name, address);
        this.Emp_no=Emp_no ;
        this.pay = pay;
        this.house_rent = house_rent;
        this.medical_allow = medical_allow;
    }

    public Employee() {
    }
    public void calcSalary( )
    {
       this.pay =  (pay)/(1+(house_rent)+(medical_allow));
        System.out.println("----------------------------------------------");
        System.out.println("NET PAY : "+this.pay);
    }
}
