import org.hofman.collection.LinkedList;
import org.hofman.collection.Queue;
import org.hofman.collection.SortedList;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel
 * Date: 6-9-12
 * Time: 12:48
 */
public class App {

    private static Student students[];

    public static void main(String[] args)
    {
        students = new Student[8];

        students[0] = new Student(1585854,"Maikel", 23, Geslacht.MAN);
        students[1] = new Student(1232131,"Piet", 24, Geslacht.MAN);
        students[2] = new Student(2233209,"Marie", 21, Geslacht.VROUW);
        students[3] = new Student(3232132,"Heleen", 19, Geslacht.VROUW);
        students[4] = new Student(2287843,"Jan", 20, Geslacht.MAN);
        students[5] = new Student(1187637,"Petra", 21, Geslacht.VROUW);
        students[6] = new Student(1827374,"Maarten", 21, Geslacht.MAN);
        students[7] = new Student(1239399,"Lisa", 21, Geslacht.MAN);

        //TestList();
        //TestQueue();
        TestSortedList();
    }

    private static void TestList() {
        LinkedList<Student> list = new LinkedList<Student>();

        list.add(students[0]);
        list.add(students[1]);
        list.add(students[2]);
        list.add(students[3]);

        System.out.println(list.get(3));

        System.out.println(list.toString() + "\n");

        list.add(students[7], 2);

        System.out.println(list.toString());

        System.out.println("\n Remove student");

        list.remove(students[2]);

        System.out.println("New list:");
        System.out.println(list.toString());

        System.out.println("\n Remove last student");
        list.remove(list.size()-1);
        System.out.println(list.toString());
    }

    private static void TestQueue() {
        Queue<Student> queue = new Queue<Student>();

        queue.add(students[0]);
        queue.add(students[1]);
        queue.add(students[2]);
        queue.add(students[3]);
        queue.add(students[4]);

        System.out.println("* Print all students in Queue.");
        System.out.println(queue.toString());

        System.out.println("* Dequeue one item");
        queue.remove();
        System.out.println(queue.toString());

        System.out.println("* Search for Student");
        System.out.println("Result of search: " + queue.contains(students[2]));

        System.out.println("\n * Remove one item: " + students[3].getNaam());
        queue.remove(students[3]);
        System.out.println(queue.toString());
    }

    private static void TestSortedList() {
        SortedList<Student> list = new SortedList<Student>();

        list.add(students[0]);
        list.add(students[1]);
        list.add(students[2]);
        list.add(students[3]);
        list.add(students[4]);

        // Return max/min Element
        System.out.println("Max element " + list.tail().getNaam());
        System.out.println("Min element " + list.head().getNaam());
    }
}
