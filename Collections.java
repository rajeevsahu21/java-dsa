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

        System.out.println(queue.peek()); // return the front element of the queue

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // or we can define like this
        // to change the priority of the queue we can use comparator // Queue<Integer>
        // pq = new PriorityQueue<>(); by default it will implement min heap
        pq.offer(42);
        pq.offer(12); // adding the new element into the priority queue
        pq.offer(24);
        pq.offer(36);

        System.out.println(pq.poll()); // remove the element from the priority queue
        System.out.println(pq.peek());// return the top element of the queue
        System.out.println(pq);
        ArrayDeque<Integer> adq = new ArrayDeque<>(); // this doubly ended queue
        adq.offer(23); // adding the new element into the doubly queue
        adq.offer(25);
        adq.offerFirst(12); // adding the new element at first position
        adq.offerLast(43); // adding the new element at last position
        System.out.println(adq.peek()); // return the element at the first position
        System.out.println(adq.peekFirst()); // return the element at the first position
        System.out.println(adq.peekLast()); // return the element at the last position
        System.out.println(adq);
        System.out.println(adq.poll()); // remove the element at the first position
        System.out.println(adq.pollFirst()); // remove the element at the first position
        System.out.println(adq.pollLast()); // remove the element at the last position
        System.out.println(adq);

        // Set<Integer> set = new HashSet<>(); // creating a new set which store unique
        // elements
        // Set<Integer> set = new LinkedHashSet<>(); // creating a new set which store
        // unique along with order
        Set<Integer> set = new TreeSet<>();// creating a new set which store unique in a sorted order
        set.add(32); // add the element into the set
        set.add(45);
        set.add(42);
        set.add(62);
        set.add(12);
        set.remove(12); // remove the element from the set
        System.out.println(set);
        System.out.println(set.contains(100)); // check if the set contains the element
        System.out.println(set.isEmpty()); // check if the set is empty or not
        System.out.println(set.size()); // return the number of elements present in the set
        set.clear(); // clear the set

        // Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map = new TreeMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("two", 23); // if we add duplicate key then it will be overwrite the value
        System.out.println(map.containsKey("two")); // return true if the key exists in the set
        System.out.println(map.containsValue(3)); // return true if the Value exists in the set
        map.putIfAbsent("two", 2); // only adding the new value if key don't already exist
        System.out.println(map);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        for (Integer value : map.values()) {
            System.out.println(value);
        }
        map.remove("three");
        System.out.println(map.isEmpty()); // return true if map is empty
        map.clear(); // clear the map

        Integer[] number = { 1, 2, 3, 4, 10, 6, 7, 8, 9 };
        // int index = Arrays.binarySearch(number, 4);
        // System.out.println(index);
        Arrays.sort(number);
        Arrays.fill(number, 12);
        for (int i : number) {
            System.out.println(i);
        }

        List<Integer> li = new ArrayList<>();
        li.add(34);
        li.add(64);
        li.add(54);
        li.add(44);
        li.add(3);
        System.out.println("min Element: " + Collections.min(li));
        System.out.println("max Element: " + Collections.max(li));
        System.out.println("min Element: " + Collections.frequency(li, 3));
    }
}