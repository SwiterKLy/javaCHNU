import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void printStudents(List students, int course)
    {
        Iterator iter = students.iterator();
        while (iter.hasNext())
        {
            Student st = (Student) iter.next();
            if (st.course() == course)
            {
                System.out.println(st.name());
            }
        }
    }
    public static void main(String[] args) {
     List<Student> stnds = new ArrayList<>();
     stnds.add(new Student("Oleg", 2));
     stnds.add(new Student("Alex", 1));
     stnds.add(new Student("Misha", 3));
     stnds.add(new Student("Masha", 4));
     stnds.add(new Student("Pasha", 5));
     stnds.add(new Student("Dasha", 8));
     stnds.add(new Student("Sergi", 3));
     stnds.add(new Student("Kiril", 1));
     stnds.add(new Student("Vasya", 2));
     stnds.add(new Student("Petya", 1));
     printStudents(stnds, 3);

    }
}