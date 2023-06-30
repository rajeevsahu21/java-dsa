import java.util.*;

public class Collections {
    public static void main(String[] args) {

        ArrayList<String> studentsName = new ArrayList<>(); // creating a ArrayList of type String
        studentsName.add("Rajeev"); // Adding the element in the ArrayList
        studentsName.add("Sahu");
        System.out.println(studentsName);

        List<Integer> list = new ArrayList<>(); // crating the ArrayList of Type Integer
        list.add(1);
        list.add(2);
        list.add(1, 3);
        System.out.println(list);

        List<Integer> newList = new ArrayList<>();
        newList.add(150);
        newList.add(200);
        list.addAll(1, newList); // inserting the whole new ArrayList into the old ArrayList at position
                                 // specified in the first argument
        System.out.println(list);

        list.remove(2); // removing the element from the position
        System.out.println(list);

        list.remove(Integer.valueOf(3)); // removing the element which matches the specified element
        System.out.println(list);

        list.set(2, 30); // updating the postion with new value
        System.out.println(list);

        System.out.println(list.contains(30)); // checking the value is present in the ArrayList or not

        for (int i = 0; i < list.size(); i++) { // traverse the ArrayList item
            System.out.println(list.get(i));
        }

        for (Integer element : list) { // traversing the ArrayList with forEach method
            System.out.println(element);
        }

        Iterator<Integer> it = list.iterator(); // iterating over the ArrayList

        while (it.hasNext()) { // return the boolean value element is present or not
            System.out.println(it.next()); // return the element value
        }

        list.clear(); // removing the whole ArrayList
        System.out.println(list);

        Stack<String> stack = new Stack<>(); // creating a stack of type String

        stack.push("Rajeev"); // adding the new lelement into the stack
        stack.push("Sahu");
        System.out.println(stack);
        System.out.println(stack.peek()); // getting the the top element of the stack
        stack.pop(); // removing the element from the stack
        System.out.println(stack);

        Queue<Integer> queue = new LinkedList<>(); // creating a queue of type Integer
        queue.offer(12); // adding the new element into the queue
        queue.offer(24);
        queue.offer(36);
        System.out.println(queue);

        System.out.println(queue.poll()); // remove the element from front of the queue and return it
    }
}