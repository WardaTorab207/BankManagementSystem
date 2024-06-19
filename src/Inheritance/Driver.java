package Inheritance;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n---------------Enter Faculty Details:---------------------");
            System.out.print("Enter your Name: ");
            String facultyName = scanner.nextLine();
            System.out.print("Enter Address: ");
            String facultyAddress = scanner.nextLine();
            System.out.print("Enter Employee Number: ");
            int facultyNumber = scanner.nextInt();
            System.out.print("Enter Base Pay: ");
            double facultyPay = scanner.nextDouble();
            System.out.print("Enter House Rent Percentage: ");
            double facultyHouseRent = scanner.nextDouble();
            System.out.print("Enter Medical Allowance Percentage: ");
            double facultyMedicalAllow = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter Designation: ");
            String facultyDesignation = scanner.nextLine();
            System.out.print("Enter Department: ");
            String facultyDepartment = scanner.nextLine();
            System.out.print("Enter Years of Education: ");
            int facultyYearsOfEducation = scanner.nextInt();

            // Create an object of the "Faculty" class using a parameterized constructor
            Faculty faculty = new Faculty(facultyName, facultyAddress, facultyNumber, facultyPay, facultyHouseRent,
                    facultyMedicalAllow, facultyDesignation, facultyDepartment, facultyYearsOfEducation);

            faculty.calcSalary();

            System.out.println("\n-------------------------Faculty Details--------------------------");
            System.out.println("Name: " + faculty.name);
            System.out.println("Address: " + faculty.address);
            System.out.println("Employee Number: " + faculty.Emp_no);
            System.out.println("Designation: " + faculty.designation);
            System.out.println("Department: " + faculty.department);
            System.out.println("Years of Education: " + faculty.year_of_education);
            System.out.println("Faculty Salary: " + faculty.pay);


            scanner.close();
        }

}
