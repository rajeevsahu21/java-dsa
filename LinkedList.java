public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data) {
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node tmp = head;
        int cnt = 0;
        while(cnt+1 < idx){
            tmp = tmp.next;
            cnt++;
        }
        Node newNode = new Node(data);
        size++;
        newNode.next = tmp.next;
        tmp.next = newNode;

    }

    public int removeFirst() {
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        Node prev = head;
        for(int i=0;i<size-2;i++){
            prev = prev.next;
        }
        int val = prev.next.data; //tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key) {
        int idx = 0;
        Node tmp = head;
        while(tmp!=null){
            if(tmp.data == key){
                return idx;
            }
            tmp = tmp.next;
            idx++;
        }
        return -1;
    }

    public int helper(Node head, int key) {
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);

        if(idx == -1){
            return -1;
        }
        return idx+1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthfromEnd(int n) {
        Node tmp = head;
        int sz = 0;
        while(tmp != null){
            tmp = tmp.next;
            sz++;
        }
        if(n==sz){
            head = head.next;
            return;
        }
        int i = 1;
        Node prev = head;
        while(i<(sz-n)){
            prev=prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome() {
        if(head == null || head.next == null){
            return true;
        }
        // step 1 - find mid
        Node midNode = findMid(head);
        // step 2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        // step 3 - check left half and right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }

        //find meeting point
        slow = head;
        Node prev = null;
        while(fast != slow){
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        // remove cycle --> last.next = null
        prev.next = null;
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node tmp = mergedLL;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                tmp.next = head1;
                head1 = head1.next;
            }else{
                tmp.next = head2;
                head2 = head2.next;
            }
            tmp = tmp.next;
        }
        while(head1 != null){
            tmp.next = head1;
            head1 = head1.next;
            tmp = tmp.next;
        }
        while(head2 != null){
            tmp.next = head2;
            head2 = head2.next;
            tmp = tmp.next;
        }
        return mergedLL.next;
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node mergeSort(Node head) {
        if(head ==  null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        //merge
        return merge(newLeft, newRight);
    }

    public void zigZag() {
        //find mid
        Node slow = head;
        Node fast = head.next;
        while( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse 2nd half
        Node prev = null;
        Node curr = slow.next;
        slow.next = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        //alt merge - zigzag merge
        while(left != null && right != null){
            nextL = left.next;
            nextR = right.next;
            left.next = right;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.print();
        ll.zigZag();
        ll.print();
    }
}