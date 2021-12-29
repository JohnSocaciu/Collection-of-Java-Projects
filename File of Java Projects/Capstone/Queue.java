// John Socaciu 
// CIS 2353 
// Fall 2021
// Prof. John P. Baugh 

public class Queue 
{
        private Node first;
        private Node last;
        private Node newNode; 
        private String toRemove; 

        public class Node
        {
            String data;
            Node next;

            public Node() 
            {
                this.data = null;
                this.next = null;
            }
        }

        public Queue() 
        {
            this.first = null;
            this.last = null;
        }

        public void enqueue(String entry) 
        {
            newNode = new Node();
            newNode.data = entry;

            if (isEmpty())
                this.first = newNode;
            else
                this.last.next = newNode;
                this.last = newNode;
        }

        public String dequeue()
        {
            toRemove = getFront();
            this.first = this.first.next;
            if (this.first == null)
                this.last = null;
            return toRemove;
        }

        public String getFront()
        {
            if (isEmpty())
            {
                throw new IllegalArgumentException("The Queue is empty");
            }
            return this.first.data;
        }

        public boolean isEmpty()
        {
            return this.first == null;
        }
}
