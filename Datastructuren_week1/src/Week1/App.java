package Week1;

import org.hofman.base.Predicate;
import org.hofman.collection.Stack;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel
 * Date: 3-9-12
 * Time: 9:25
 */
public class App {

   public static void main(String [] args)
   {
       Stack<Student> stack = new Stack<Student>();

       Student students[] = new Student[8];

       students[0] = new Student(8585854,"Maikel", 23, Geslacht.MAN);
       students[1] = new Student(1232131,"Piet", 24, Geslacht.MAN);
       students[2] = new Student(6233209,"Marie", 21, Geslacht.VROUW);
       students[3] = new Student(3232132,"Heleen", 19, Geslacht.VROUW);
       students[4] = new Student(7287843,"Jan", 20, Geslacht.MAN);
       students[5] = new Student(9787637,"Petra", 21, Geslacht.VROUW);
       students[6] = new Student(1827374,"Maarten", 21, Geslacht.MAN);
       students[7] = new Student(1239399,"Lisa", 21, Geslacht.VROUW);

       stack.push(students[5]);
       stack.push(students[4]);
       stack.push(students[3]);

       System.out.print(stack.printStack());
       System.out.println("Pop one off of the stack");

       stack.pop();


       System.out.print(stack.printStack());

       System.out.println("\nPrint Stack again.");
       stack.push(students[1]);
       stack.push(students[2]);
       stack.push(students[6]);
       stack.push(students[7]);

       System.out.print(stack.printStack());

       System.out.println("Search for: " + students[1].getNaam());

       Boolean result = stack.peek(students[1]);

       if(result)
       {
           System.out.println(students[1].getNaam() + " found in stack.");
       }
       else
       {
           System.out.println(students[1].getNaam() + " NOT found in stack.");
       }

       System.out.println("\nPrint only women in the Stack.");

       System.out.println(stack.printStack(new Predicate<Student>() {
           @Override
           public Boolean apply(Student object) {
               if(object.getGeslacht() == Geslacht.VROUW)
               {
                   return true;
               }

               return false;
           }
       }));
   }
}
