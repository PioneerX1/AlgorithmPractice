
class QueueLinkedList {

  // Link class
  public class Link {
    public String linkName;
    public Link next;

    public Link(String linkName) {
      this.linkName = linkName;
    }

    public void displayLink() {
      System.out.println(linkName);
    }
  }

  // LinkedList class
  public class FirstLastList {
    private Link first;
    private Link last;

    public FirstLastList() {
      first = null;
      last = null;
    }
    // isEmpty
    public boolean isEmpty() {
      return (first == null);
    }
    // insertLast
    public void insertLast(String name) {
      Link newLink = new Link(name);
      if (isEmpty()) {
        first = newLink;
      } else {
        last.next = newLink;
      }
      last = newLink;
    }
    // removeFront
    public String removeFront() {
      if (isEmpty()) {
        return "LinkedList Queue is Empty";
      }
      Link temp = first;
      first = first.next;
      return temp.linkName;
    }
    // displayList
    public void displayList() {
      Link current = first;
      while (current != null) {
        current.displayLink();
        current = current.next;
      }
    }
  }

  // outer class for QueueLinkedList

  // member vars
  private FirstLastList myList;
  // constructor
  public QueueLinkedList() {
    myList = new FirstLastList();
  }
  // isEmpty
  public boolean isEmpty() {
    return myList.isEmpty();
  }
  // add / enqueue
  public void enqueue(String name) {
    myList.insertLast(name);
  }
  // remove / dequeue
  public String dequeue() {
    return myList.removeFront();
  }
  // displayQueue
  public void displayQueue() {
    myList.displayList();
  }


  public static void main(String[] args) {
    System.out.println("This program implements a standard Queue with a LinkedList.\n");

    QueueLinkedList ql = new QueueLinkedList();
    //System.out.println(ql.dequeue() + " removed");
    //ql.displayQueue();
    ql.enqueue("Rickey");
    ql.enqueue("Tikki");
    ql.enqueue("Tavvi");
    ql.displayQueue();
    ql.enqueue("Manny");
    ql.enqueue("Mongoose");
    ql.displayQueue();
    System.out.println(ql.dequeue() + " removed");
    System.out.println(ql.dequeue() + " removed");
    ql.displayQueue();



  }

}
