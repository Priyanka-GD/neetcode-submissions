class LinkedList {
    ListNode head;
    ListNode tail;

    public LinkedList() {
        head = new ListNode(-1); 
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        int idx = 0;
        ListNode curr = head.next; 
        while (curr != tail) { 
            if (idx == index) {
                return curr.value;
            }
            curr = curr.next;
            idx++;
        }
        return -1; 
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
    }

    public void insertTail(int val) {
        ListNode newNode = new ListNode(val);
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;
    }

    public boolean remove(int index) {
        int idx = 0;
        ListNode curr = head.next; 
        while (curr != tail) { 
            if (idx == index) {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                return true;
            }
            curr = curr.next;
            idx++;
        }
        return false; 
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        ListNode curr = head.next; 
        while (curr != tail) { 
            values.add(curr.value);
            curr = curr.next;
        }
        return values;
    }
}

class ListNode {
    int value;
    ListNode next;
    ListNode prev;

    public ListNode(int value) {
        this.value = value;
    }
}
