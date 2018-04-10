import java.util.Scanner;

// Implements Queue functionality with an array
// Must resize (grow and shrink) dynamically 10, 25, 50, 100
// Must be able to OFFER (aka push) and POLL (aka pop) and maintain order


public class ImplementQueue {

  private static String[] aq;
  private static boolean qFull = false;

  // add new value to beginning of queue
  private static void offer(String value) {

    if(qFull == true) {
      grow();
    }

    for(int i = aq.length - 1; i >= 0; i--) {
      if(aq[i] == null) {
        aq[i] = value;
        System.out.println(aq[i] + " added to index " + i);
        if (i == 0) {
          qFull = true;
        }
        break;
      } else {
        // keep going
      }
    }
  }

  // remove value from end of queue
  private static void poll() {
    int spot = aq.length - 1;
    if (aq[spot] == null) {
      System.out.println("No entries to remove in the queue.");
      return;
    } else {
      System.out.println(aq[spot] + " removed from queue.");
    }
    aq[spot] = null;
    spot--;

    // shift each entry up one index until its null or reach zero
    while (spot >= 0 && aq[spot] != null) {
      aq[spot+1] = aq[spot];
      aq[spot] = null;
      spot--;
    }
    System.out.println("Index at polled: " + spot);

    // check if array size should shrink
    if ((spot > aq.length * 0.666) && aq.length > 9) {
      shrink();
    }

  }

  private static void printQueue() {
    System.out.println("---Queue Contents---");
    for(int i = aq.length - 1; i >= 0; i--) {
      if (aq[i] == null) {
        // do nothing
      } else {  // print element's contents
        System.out.print(aq[i] + " ");
      }
    }
    System.out.println("");
  }

  // grow array if limit is reached
  private static void grow() {

    System.out.println("---Queue MAX reached. Growing!---");
    // create new array
    String[] newAQ = new String[aq.length * 2];
    int oldAQpointer = aq.length - 1;
    int newAQpointer = newAQ.length - 1;

    while (oldAQpointer >= 0 && aq[oldAQpointer] != null) {
      newAQ[newAQpointer] = aq[oldAQpointer];
      oldAQpointer--;
      newAQpointer--;
    }

    // set original aq to the new array
    aq = newAQ;
    // set qFull back to false
    qFull = false;
  }

  // shrink array ??
  private static void shrink() {
    System.out.println("---Shrinking queue size to free up space---");

    String[] newAQ = new String[aq.length / 2];
    int newAQpointer = newAQ.length - 1;
    int oldAQpointer = aq.length - 1;

    while (aq[oldAQpointer] != null) {
      newAQ[newAQpointer] = aq[oldAQpointer];
      newAQpointer--;
      oldAQpointer--;
    }

    aq = newAQ;

  }

  public static void main(String[] args) {

    aq = new String[5];
    //initializeNewQueue();

    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to the Queue Array");
    System.out.println("----------");
    String choice = "1";

    while (choice.equals("1") || choice.equals("2") || choice.equals("3")) {

      System.out.println("Type 1 to OFFER a new string value into the queue.");
      System.out.println("Type 2 to POLL the FIFO value out of queue.");
      System.out.println("Type 3 to print contents of queue.");
      System.out.println("Type any other key to Quit.");
      choice = scanner.nextLine();

      if (choice.equals("1")) {
        System.out.println("Type any string to be stored in queue");
        String newEntry = scanner.nextLine();
        offer(newEntry);

      } else if (choice.equals("2")) {
        poll();
      } else if (choice.equals("3")) {
        printQueue();
      } else {
        System.out.println("Quitting");
      }

    }

  }
}
