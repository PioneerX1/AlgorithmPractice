import java.util.Scanner;

// Implements Queue functionality with an array
// Must resize (grow and shrink) dynamically 10, 25, 50, 100
// Must be able to OFFER (aka push) and POLL (aka pop) and maintain order


public class ImplementQueue {

  private static String[] aq;
  private boolean full = false;

  private static void initializeNewQueue() {
    for(int i = 0; i < aq.length; i++) {
      aq[i] = "";
    }
  }

  // add new value to beginning of queue
  private static void offer(String value) {
    //System.out.println("You entered " + value);
    for(int i = aq.length - 1; i >= 0; i--) {
      if(aq[i].equals("")) {
        aq[i] = value;
        System.out.println(aq[i] + " added to index " + i);
        break;
      } else {
        // keep going
      }

    }


  }

  // remove value from end of queue
  private static void poll() {

  }

  private static void printQueue() {
    System.out.println("---Queue Contents---");
    for(int i = aq.length - 1; i >= 0; i--) {
      if (aq[i].equals("")) {
        // do nothing
      } else {  // print element's contents
        System.out.print(aq[i] + " ");
      }
    }
    System.out.println("");
  }

  // grow array if limit is reached
  private static void grow() {

  }

  // shrink array ??
  private static void shrink() {

  }

  public static void main(String[] args) {

    aq = new String[10];
    initializeNewQueue();

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
        System.out.println(choice + " POLL selected");
      } else if (choice.equals("3")) {
        printQueue();
      } else {
        System.out.println("Quitting");
      }

    }

  }
}
