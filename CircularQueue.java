import java.util.*;

public class CircularQueue {

  private int nItems;  // number of entries in queue
  private int maxSize;
  private int front;
  private int back;
  private int[] qArr;

  public CircularQueue(int maxSize) {
    this.maxSize = maxSize;
    nItems = 0;
    qArr = new int[maxSize];
    back = -1;
    front = 0;
  }

  public boolean isFull() {
    if (nItems == maxSize) {
      System.out.println("Queue is Full");
      return true;
    } else {
      return false;
    }
  }

  public boolean isEmpty() {
    if (nItems == 0) {
      System.out.println("Queue is empty");
      return true;
    } else {
      return false;
    }
  }

  public int getSize() {
    return nItems;
  }

  public void insert(int newItem) {
    // validate max size not reached first
    if (!isFull()) {
      // check if reached last element, wraparound
      if (back == maxSize - 1) {
        back = -1;
      }
      qArr[++back] = newItem;
      nItems++;
    }
  }

  public int remove() {
    int removedItem = -1;
    if (!isEmpty()) {
      removedItem = qArr[front++];
      if (front == maxSize) {
        front = 0;
      }
      nItems--;
    }
    return removedItem;
  }

  public int peekFront() {
    if (!isEmpty()) {
      return qArr[front];
    } else {
      return -1;
    }
  }

  public static void main(String[] args) {
    System.out.println("--Circular Queue --");
    CircularQueue cq = new CircularQueue(5);
    cq.insert(3);
    cq.insert(5);
    cq.insert(1);
    cq.insert(7);
    cq.insert(8);
    //cq.insert(12);

    System.out.println("Peek " + cq.peekFront());
    while(cq.getSize() > 1) {
      System.out.println("Remove " + cq.remove());
    }
    cq.insert(44);
    cq.insert(13);
    cq.insert(12);

    while(cq.getSize() > 0) {
      System.out.println("Remove " + cq.remove());
    }
    System.out.println("Last Remove " + cq.remove());
  }

}
