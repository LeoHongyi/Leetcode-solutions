package algorithms.hashTable;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/288
 * Case 1: If a is NOT in the HashMap, a has never appeared before.
 *  Case 2: If a is in the HashMap with a non-null value, a has appeared once and only once.
 *  Case 3: If a is in the HashMap with a null value, a has appeared >= 2.
 *  Data structure: HashMap, Linked List(double)
 *  Method: lazy deletion
 */
public class FirstNonRepeatingCharactorInStream {
    // each node is a double linked list node
    // and it contains one distinct character.
    static class Node {
        Node prev;
        Node next;
        Character ch;
        Node (Character ch) {
            this.ch = ch;
        }
    }
    // revord all the time the head and tail of the double linked lsit
    private Node head;
    private Node tail;
    // maintain the relationship of key and its corresponding node
    // in the double linked list.
    private Map<Character, Node> singled;
    private Set<Character> repeated;

    public Solution() {
        // Initialize the class.
        // an example of using sentinel node to eliminate some corner cases.
        tail = new Node(null);
        tail.next = tail.prev = tail;
        head = tail;
        singled = new HashMap<Character, Node>();
        repeated = new HashSet<Character>();
    }

    public void read(char ch) {
        // Implement this method here.
        // if the character already exists more than once,
        // we just ignore.
        if (repeated.contains(ch)) {
            return;
        }
        Node node = singled.get(ch);
        if (node == null) {
            // if the character appears for the first time,
            // it should be added to the list and added to
            // the nonRepeated.
            node = new Node(ch);
            append(node);
        } else {
            // if the character is already in the nonRepeated
            // Map, we should remove it from the Map and list,
            // and put it into the repeated Set.
            remove(node);
        }
    }

    public Character firstNonRepeating() {
        // Implement this method here.
        // when head == tail, it means there is only
        // the sentinel node in the list.
        if (head == tail) {
            return null;
        }
        return head.next.ch;
    }

    private void append(Node node) {
        singled.put(node.ch, node);
        tail.next = node;
        node.prev = tail;
        node.next = head;
        tail = tail.next;
    }

    private void remove(Node node) {
        // use sentinel node so that some of the
        // corner cases will be eliminated.
        node.prev.next = node.next;
        node.next.prev = node.prev;
        if (node == tail) {
            tail = node.prev;
        }
        node.prev = node.next = null;
        repeated.add(node.ch);
        singled.remove(node.ch);
    }
}
