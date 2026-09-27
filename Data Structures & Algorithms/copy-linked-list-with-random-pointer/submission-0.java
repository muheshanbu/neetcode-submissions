/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node original) {
        Node newHead = new Node(0);
        Node current = newHead;
        Node o2 = original;
        HashMap<Node, Node> map = new HashMap<>();

        //In the first pass i link up the nexts and dont touch the randoms
        while (original != null) {
            Node newNode = new Node(original.val);
            //this doesnt work cuz, it sets the copy's random to orig's random, also orig's random might not have been visited then
            //newNode.random = original.random;
            current.next = newNode;
            current = newNode;
            map.put(original, newNode);          //so for orig node i map to its corresponding copy
            original = original.next;
        }

        Node c2 = newHead.next;
        while (c2 != null) {
            //so i have all orig mapped to its copies (which doesnt have random linked)
            Node copyRandom = map.get(o2.random); //o2.random - return its random copy node
            c2.random = copyRandom;

            c2 = c2.next;
            o2 = o2.next;
        }
        return newHead.next;
    }
}
