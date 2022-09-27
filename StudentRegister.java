
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author prath
 */
public class StudentRegister {
    public static final String NAME_ORDER ="by name";
    public static final String CODE_ORDER ="by code";
    
    HashMap<String,Student> s;
    HashMap<String, Course> c;
    ArrayList<Attainment> at;
   

    public StudentRegister() {
        s = new HashMap<>();
        c = new HashMap<>();
        at = new ArrayList<>();
    }
    public ArrayList<Student> getStudents()
    {
        ArrayList<Student> sortedStudents = new ArrayList<>(s.values());
        sortedStudents.sort((a,b)->a.name.compareTo(b.name));
        return sortedStudents;
    }
    
    public ArrayList<Course> getCourses()
    {
        ArrayList<Course> sortedCourse = new ArrayList<>(c.values());
        sortedCourse.sort((a,b)->a.name.compareTo(b.name));
        return sortedCourse;
        
    }
    
    
    public void addStudent(Student student)
    {
       this.s.put(student.getStudentNumber(), student);
    }
    
    public void addCourse(Course course)
    {
        this.c.put(course.getCode(), course);
    }
    
    public void addAttainment(Attainment att)
    {
        this.at.add(att);
    }
    
   public void printStudentAttainments(String studentNumber)
   {
       if(!this.s.containsKey(studentNumber))
             {
                 System.out.println("Unknown student number: "+studentNumber);
             }
       else{
       ArrayList<Course> sorted = new ArrayList<>();
                   
               System.out.printf("%s (%s):\n", s.get(studentNumber).getName(),studentNumber);
               for(Attainment ai : at)
               {
                 if(studentNumber.equals(ai.getStudentNumber()))  
                 {
                     Course newObj = new Course(ai.getCourseCode(),c.get(ai.courseCode).getName(),ai.getGrade());
                     sorted.add(newObj);
                 }
               }
              
               for(Course o : sorted)
               {
                  System.out.printf("\s\s%s\s%s:\s%d\n",o.getCode(),o.getName(),o.getCredits());
                     
               }
       }
   }
   public void printStudentAttainments(String studentNumber, String order)
   {
       
       if(!this.s.containsKey(studentNumber))
             {
                 System.out.println("Unknown student number: "+studentNumber);
             }
       else{
           
           ArrayList<Course> sorted = new ArrayList<>();
                   
               System.out.printf("%s (%s):\n", s.get(studentNumber).getName(),studentNumber);
               for(Attainment ai : at)
               {
                 if(studentNumber.equals(ai.getStudentNumber()))  
                 {
                     Course newObj = new Course(ai.getCourseCode(),c.get(ai.courseCode).getName(),ai.getGrade());
                     sorted.add(newObj);
                 }
               }
       switch(order)
       {
           
           case  NAME_ORDER -> {
              
              
               sorted.sort((a,b)->a.getName().compareTo(b.getName()));
               for(Course o : sorted)
               {
                  System.out.printf("\s\s%s\s%s:\s%d\n",o.getCode(),o.getName(),o.getCredits());
                     
               }
               
            }
           case CODE_ORDER -> {
               
               sorted.sort((a,b)->a.getCode().compareTo(b.getCode()));
               for(Course o : sorted)
               {
                  System.out.printf("\s\s%s\s%s:\s%d\n",o.getCode(),o.getName(),o.getCredits());
                     
               }
               
            }
            default -> {
                
               for(Course o : sorted)
               {
                  System.out.printf("\s\s%s\s%s:\s%d\n",o.getCode(),o.getName(),o.getCredits());
                     
               }
               
            }
               
               
        }
      }
   }  
}
