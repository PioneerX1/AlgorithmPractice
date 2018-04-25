//import java.util.*;

class PriorityQueue {

  int maxSize;
  int nItems;
  int[] pqArray;
  // no need for front and rear since it is PritoryQueue

  public PriorityQueue(int maxSize) {
    this.maxSize = maxSize;
    pqArray = new int[maxSize];
    nItems = 0;
  }

  public int getSize() {
    return nItems;
  }

  public boolean isFull() {
    if (nItems == maxSize) {
      System.out.println("Priority Queue is FULL");
      return true;
    } else {
      return false;
    }
  }

  public boolean isEmpty() {
    if (nItems == 0) {
      return true;
    } else { return false; }
  }

  public void insert(int item) {
    if (isFull()) {
      return;
    } else { }

    if (nItems == 0) {
      pqArray[nItems++] = item;
    } else {
      int j;  // has to initialize outside loop
      for (j = nItems - 1; j >= 0; j--) {
        if (item > pqArray[j]) {
          // shift items up
          pqArray[j+1] = pqArray[j];
        } else {
          break;
        }
      }
      pqArray[j+1] = item;  // insert item
      nItems++;
    }
  }

  public int remove() {
    if (isEmpty()) {
      System.out.println("Priority Queue is EMPTY");
      return -1;
    }
    return pqArray[--nItems];
  }

  public int peek() {
    if (isEmpty()) {
      System.out.println("Priority Queue is EMPTY");
      return -1;
    }
    return pqArray[nItems-1];
  }

  public static void main(String[] args) {
    System.out.println("This program implements a Priority Queue with an integer array");
    System.out.println("Values are sorted with least in the front and most in the rear");

    PriorityQueue pq = new PriorityQueue(5);
    pq.remove();  // should print empty
    pq.peek();    // should print empty
    pq.insert(4);
    pq.insert(2);
    pq.insert(5);
    pq.insert(1);
    pq.insert(7);
    System.out.println("Remove " + pq.remove());
    pq.insert(11);
    System.out.println("Size is " + pq.getSize());
    System.out.println("Peek at " + pq.peek());
    System.out.println("-------");
    while(pq.getSize() > 0) {
      System.out.println("Remove " + pq.remove());
    }
    // should print empty 
    System.out.println("Remove " + pq.remove());

  }
}
