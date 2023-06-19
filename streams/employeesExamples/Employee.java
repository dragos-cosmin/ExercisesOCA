package org.example.streams.employeesExamples;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author dragos.cosmin
 **/
public class Employee {
    private String givenName;
    private String surName;
    private int age;
    private Gender gender;
    private Role role;
    private String dept;
    private LocalDate startDate;
    private double salary;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String code;

    private Employee(){
        super();
    }

    private Employee(Builder builder){
        givenName=builder.givenName;
        surName=builder.surName;
        age= builder.age;
        gender=builder.gender;
        role=builder.role;
        dept= builder.dept;
        startDate =builder.startDate;
        salary= builder.salary;
        email= builder.email;
        phone= builder.phone;
        address= builder.address;
        city= builder.city;
        state= builder.state;
        code= builder.code;
    }

    public static int sortBySalary(Employee a,Employee b){
        Double s1=a.salary;
        Double s2=b.salary;
        return s1.compareTo(s2);
    }

    public static List<Employee> createShortList(){
        List<Employee> people=new ArrayList<>();
        people.add(
                new Builder()
                        .givenName("Bob")
                        .surName("Baker")
                        .age(23)
                        .gender(Gender.MALE)
                        .role(Role.STAFF)
                        .dept("Eng")
                        .startDate(LocalDate.of(2013,1,10))
                        .salary(40_000)
                        .email("bob.baker@example.com")
                        .phone("201-121-4678")
                        .address("44 4th St.")
                        .city("Smallville")
                        .state("KS")
                        .code("12333")
                        .build()
        );
        people.add(
                new Builder()
                        .givenName("Jane")
                        .surName("Doe")
                        .age(25)
                        .gender(Gender.FEMALE)
                        .role(Role.STAFF)
                        .dept("Sales")
                        .startDate(LocalDate.of(2011,7,14))
                        .salary(45_000)
                        .email("jane.doe@example.com")
                        .phone("202-123-4678")
                        .address("33 3rd St.")
                        .city("Smallville")
                        .state("KS")
                        .code("12333")
                        .build()
        );
        people.add(
                new Builder()
                        .givenName("John")
                        .surName("Doe")
                        .age(28)
                        .gender(Gender.MALE)
                        .role(Role.MANAGER)
                        .dept("Eng")
                        .startDate(LocalDate.of(2007,3,1))
                        .salary(65_000)
                        .email("john.doer@example.com")
                        .phone("202-123-4678")
                        .address("33 3rd St.")
                        .city("Smallville")
                        .state("KS")
                        .code("12333")
                        .build()
        );
        people.add(
                new Builder()
                        .givenName("James")
                        .surName("Johnson")
                        .age(45)
                        .gender(Gender.MALE)
                        .role(Role.MANAGER)
                        .dept("Eng")
                        .startDate(LocalDate.of(1999,5,1))
                        .salary(85_000)
                        .email("james.johnsonr@example.com")
                        .phone("333-456-1233")
                        .address("201 2nd St.")
                        .city("BrainTree")
                        .state("CO")
                        .code("11111")
                        .build()
        );
        people.add(
                new Builder()
                        .givenName("Jenny")
                        .surName("Bean")
                        .age(31)
                        .gender(Gender.FEMALE)
                        .role(Role.STAFF)
                        .dept("Sales")
                        .startDate(LocalDate.of(2012,3,8))
                        .salary(53_000)
                        .email("jenny98e@example.com")
                        .phone("215-123-4698")
                        .address("158 8th St.")
                        .city("BigValley")
                        .state("CO")
                        .code("235689")
                        .build()
        );
        people.add(
                new Builder()
                        .givenName("John")
                        .surName("McGreg")
                        .age(42)
                        .gender(Gender.MALE)
                        .role(Role.MANAGER)
                        .dept("IT")
                        .startDate(LocalDate.of(2005,7,25))
                        .salary(80_000)
                        .email("john.mcg@example.com")
                        .phone("211-528-4678")
                        .address("11 3rd St.")
                        .city("SunnyPlace")
                        .state("CO")
                        .code("235878")
                        .build()
        );

        return people;

    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Role getRole() {
        return role;
    }

    public String getDept() {
        return dept;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCode() {
        return code;
    }

    public String getSummary(){
        return
                "Name: "+givenName+" "+surName+
                        " Role: "+role+
                        " Dept: "+dept+
                        " St: "+state+
                        " Salary: "+salary;
    }

    public void print(){
        System.out.println(
                "\nName: " + givenName + " "+surName +"\n" +
                        " Age: " + age +"\n" +
                        " Gender: " + gender +"\n" +
                        " Role: " + role +"\n" +
                        " Dept: " + dept +"\n" +
                        " Start date: " + startDate +"\n" +
                        " Salary: " + salary +"\n" +
                        " email: " + email +"\n" +
                        " Phone: " + phone +"\n" +
                        " Address: " + address +"\n" +
                        " City: " + city +"\n" +
                        " State: " + state +"\n" +
                        " Code: " + code + "\n"
        );
    }

    public void printSummary(){
        System.out.printf(
                "Name: "+givenName+" "+surName+
                        " Role: "+role+
                        " Dept: "+dept+
                        " St: "+state+
                        " Salary: $%,9.2f %n",salary
        );
    }

    public void printLambda(Consumer<Employee> cons){
        cons.accept(this);
    }

    @Override
    public String toString() {
        return "Name: " + givenName + " "+surName +
                " Age: " + age +
                " Gender: " + gender +
                " Role: " + role +
                " Dept: " + dept +
                " Start date: " + startDate +
                " Salary: " + salary +
                " email: " + email +
                " Phone: " + phone +
                " Address: " + address +
                " City: " + city +
                " State: " + state +
                " Code='" + code + "\n";
    }

    static class Builder{
        private String givenName="";
        private String surName="";
        private int age=0;
        private Gender gender=Gender.FEMALE;
        private Role role=Role.STAFF;
        private String dept="";
        private LocalDate startDate =LocalDate.of(1,1,1);
        private double salary=0;
        private String email="";
        private String phone="";
        private String address="";
        private String city="";
        private String state="";
        private String code="";

        public Builder givenName(String givenName){
            this.givenName=givenName;
            return this;
        }

        public Builder surName(String surName){
            this.surName=surName;
            return this;
        }

        public Builder age(int age){
            this.age=age;
            return this;
        }

        public Builder gender(Gender gender){
            this.gender=gender;
            return this;
        }

        public Builder role(Role role){
            this.role=role;
            return this;
        }
        public Builder dept(String dept){
            this.dept=dept;
            return this;
        }

        public Builder startDate(LocalDate startDate){
            this.startDate =startDate;
            return this;
        }

        public Builder salary(double salary){
            this.salary=salary;
            return this;
        }

        public Builder email(String email){
            this.email=email;
            return this;
        }

        public Builder phone(String phone){
            this.phone=phone;
            return this;
        }

        public Builder address(String address){
            this.address=address;
            return this;
        }

        public Builder city(String city){
            this.city=city;
            return this;
        }

        public Builder state(String state){
            this.state=state;
            return this;
        }

        public Builder code(String code){
            this.code=code;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }

    }
}
