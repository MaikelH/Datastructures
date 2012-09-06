import org.hofman.collection.DoubleLinkedList;
import org.hofman.collection.IList;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel
 * Date: 6-9-12
 * Time: 12:48
 */
public class App {

    public static void main(String[] args) {
        IList<Student> list = new DoubleLinkedList<Student>();

        Student students[] = new Student[8];

        students[0] = new Student(8585854,"Maikel", 23, Geslacht.MAN);
        students[1] = new Student(1232131,"Piet", 24, Geslacht.MAN);
        students[2] = new Student(1233209,"Marie", 21, Geslacht.VROUW);
        students[3] = new Student(1232132,"Heleen", 19, Geslacht.VROUW);
        students[4] = new Student(1287843,"Jan", 20, Geslacht.MAN);
        students[5] = new Student(1787637,"Petra", 21, Geslacht.VROUW);
        students[6] = new Student(1827374,"Maarten", 21, Geslacht.MAN);
        students[7] = new Student(1239399,"Lisa", 21, Geslacht.MAN);

        list.add(students[0]);
        list.add(students[1]);
        list.add(students[2]);
        list.add(students[4]);

        System.out.println(list.toString() + "\n");

        list.add(students[7], 2);

        System.out.println(list.toString());
    }
}
