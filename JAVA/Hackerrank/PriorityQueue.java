import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
/*
 * Create the Student and Priorities classes here.
 
 */
 class Student{
    
    private int id;
    private String name;
    private double cgpa;
    
    Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    public int getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public double getCGPA(){
        return this.cgpa;
    }
    
 }
 
 class Priorities {
    List<Student> getStudents(List<String> events){
        PriorityQueue<Integer> pq = new PriorityQueue<>(11,new Comparator1<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (Double.compare(s2.getCGPA(), s1.getCGPA()) != 0) {
                    return Double.compare(s2.getCGPA(), s1.getCGPA());
                } else if (!s1.getName().equals(s2.getName())) {
                    return s1.getName().compareTo(s2.getName());
                } else {
                    return Integer.compare(s1.getID(), s2.getID());
                }
        }
    });

        for (String event : events) {
            String[] parts = event.split(" ");
            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                pq.add(new Student(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                pq.poll();
            }
        }

        List<Student> students = new ArrayList<>();
        while (!pq.isEmpty()) {
            students.add(pq.poll());
        }
        return students;
    }
 }


public class PriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
