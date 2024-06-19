package New;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    private static ArrayList<Person> person_list= new ArrayList<>();

    private String Name ;
    private String CNIC;
    private int Age;
    private String Gender;
    Scanner sc = new Scanner(System.in);

    // Constructors
    public Person() {
        
    }
    public Person(String Name, String CNIC, int Age, String Gender) {
        this.CNIC = CNIC;
        this.Name = Name;
        this.Age = Age;
        this.Gender = Gender;
    }
    // Methods

    public void AddPerson(Person per)
    {
        person_list.add(per);
        System.out.println("\n\u001B[1mPerson has been added successfully\n\u001B[0m");
    }
    
    public int GetTotalPerson() {
        int TotalPerson = 0 ;
        for(Person per : person_list){
            TotalPerson ++;
        }
        return TotalPerson;
    }

    public Person SearchPerson(String cnic) {
        for(Person per: person_list){
            if(per.CNIC.equals(cnic)){
                return per;
            }
        }
        return null;
    }

    public void ShowAllPerson()
    {
        for(Person per : person_list){
            System.out.println("Name : " + per.Name + "\nCNIC : " + per.CNIC + "\nGender : " + per.Gender + "\nAge : " + per.Age +"\n");
        }
    }

    public void DeletePerson(String CNIC) {
        Person per = SearchPerson(CNIC);
        if(per != null){
            person_list.remove(per);
            System.out.println("\n\u001B[1mPerson has been deleted successfully\u001B[0m");
        }
        else
        {
            System.out.println("\n\u001B[1mPerson not found\u001B[0m");
        }
    }

    public void updatePerson(String cnic, String updatedField, String newValue) {
        Person per = SearchPerson(CNIC);
        if(per != null){
            switch (updatedField.toLowerCase()) {
                case "name":
                    per.Name = newValue;
                    break;
                case "age":
                    per.Age = Integer.parseInt(newValue);
                    break;
                case "gender":
                    per.Gender = newValue;
                    break;
                default:
                    System.out.println("Invalid field specified for update.");
                    return;
            }
            int index = person_list.indexOf(per);
            person_list.set(index, per);
            System.out.println("\n\u001B[1mInformation updated successfully\u001B[0m");
        }
    }

    public void StoreIntoFile(){
        File file = new File("C:\\Users\\HP G6\\IdeaProjects\\BMS\\src\\New\\files\\PersonFile.txt");
        try (FileWriter writer = new FileWriter(file, false)) {
            for (Person per : person_list) {
                String line = per.Name + "," + per.CNIC + "," + per.Age + "," + per.Gender;
                writer.write(line + "\n");
            }
            writer.close();
        } 
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void GetDataFromFile(){
        person_list = new ArrayList<>();
        File file = new File("C:\\Users\\HP G6\\IdeaProjects\\BMS\\src\\New\\files\\PersonFile.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] data  = line.split(",");
                Person per = new Person(data[0], data[1], Integer.parseInt(data[2]), data[3]);
                person_list.add(per);
            }
            sc.close();
        } 
        catch (FileNotFoundException e) {
            
        }
    }

    @Override
    public String toString() {
        return "\nName :" + Name + "\nAge :" + Age + "\nGender :" + Gender + "\nCNIC :" + CNIC;
    }




    // Getters And Setters
    public String getCNIC() {
        return CNIC;
    }


    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }


    public String getName() {
        return Name;
    }


    public void setName(String Name) {
        this.Name = Name;
    }


    public int getAge() {
        return Age;
    }


    public void setAge(int Age) {
        this.Age = Age;
    }


    public String getGender() {
        return Gender;
    }


    public void setGender(String Gender) {
        this.Gender = Gender;
    }
}
