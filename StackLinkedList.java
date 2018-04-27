
public class StackLinkedList {

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

  public class LinkList {
    private Link first;

    public LinkList() {
      first = null;
    }
    // isEmpty
    public boolean isEmpty() {
      return (first == null);
    }
    // insertFirst
    public void insertFirst(String linkName) {
      if (isEmpty()) {
        first = new Link(linkName);
      } else {
        Link newLink = new Link(linkName);
        newLink.next = first;
        first = newLink;
      }
    }
    // removeFirst
    public String removeFirst() {
      Link temp = first;
      first = first.next;
      return temp.linkName;
    }
    // displayList
    public void displayList() {
      Link current = first;
      System.out.println("---DISPLAY LIST---");
      while(current != null) {
        current.displayLink();
        current = current.next;
      }
      System.out.println("\n-------");
    }
  }

  // StackLinkedList cannot be from inner class, must be outer

  private LinkList myList;

  public StackLinkedList() {
    myList = new LinkList();
  }

  // push
  public void push(String name) {
    myList.insertFirst(name);
  }

  // pop
  public void pop() {
    System.out.println(myList.removeFirst() + " popped");
  }

  // isEmpty
  public boolean isEmpty() {
    return (myList.isEmpty());
  }

  // displayStack
  public void displayStack() {
    myList.displayList();
  }

  public static void main(String[] args) {
    System.out.println("LinkStack implements a Stack with LinkedList");
    StackLinkedList ls = new StackLinkedList();
    ls.push("Mickles");
    ls.push("Lizardo");
    ls.push("Gooter");
    ls.displayStack();
    ls.push("Saulamander");
    ls.push("Henri");
    ls.displayStack();
    ls.pop();
    ls.pop();
    ls.displayStack();
  }


}
