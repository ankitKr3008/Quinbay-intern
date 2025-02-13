import java.util.Date;

public class Employee {
    private String id;
    private String name;
    private int age;
    private Date dateOfJoining;

    public Employee(String id, String name, int age, Date dateOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

}

public class Main {
    public static void main(String[] args) {
        MyList<Employee> employeeList = new MyList<>();
        employeeList.add(new Employee("QuinEmp01", "Ankit", 23, new Date()));
        employeeList.add(new Employee("QuinEmp02", "Adarsh", 24, new Date()));
        employeeList.add(new Employee("QuinEmp03", "Rohit", 29, new Date()));
        employeeList.add(new Employee("QuinEmp04", "Shahil", 22, new Date()));
        
        System.out.println("Employee at index 1: " + employeeList.get(1));
        employeeList.deleteByIndex(3);
        System.out.println("Size after deletion: " + employeeList.size());
    }
}

