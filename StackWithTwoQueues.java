import java.util.*;

public class StackWithTwoQueues {

  private static Deque<Integer> qMain = new ArrayDeque<Integer>();

  // PUSH
  private static void skPush(int entry) {
    //System.out.println("PUSH function reached");
    if (qMain.isEmpty()) {
      //System.out.println("First value added");
      qMain.add(entry);
      return;
    }

    // first, populate temp queue with contents from main queue
    Deque<Integer> qTemp = new ArrayDeque<Integer>();

    for(Iterator itr = qMain.iterator(); itr.hasNext();) {
      int temp = Integer.parseInt(itr.next()+"");
      qTemp.add(temp);
    }

    // second, empty the main queue
    for(Iterator itr = qMain.iterator(); itr.hasNext();) {
      qMain.remove(itr.next());
    }

    // third, add new entry into the main queue
    qMain.add(entry);

    // fourth, add temp queue entries back into main queue - descending iterator?
    for(Iterator itr = qTemp.iterator(); itr.hasNext();) {
      int temp = Integer.parseInt(itr.next()+"");
      qMain.add(temp);
    }

  }

  // POP
  private static void skPop() {

    qMain.remove();
  }

  // VIEW FULL STACK
  private static void skViewFull() {
    for(int entry : qMain) {
      System.out.print(entry + " ");
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    System.out.println("Welcome to Implementing Stacks with Queues");
    System.out.println("This program gives the functionality of the stack, but does it by implementing 2 queues.");
    System.out.println("-----------");

    Scanner scanner = new Scanner(System.in);
    int choice;

    while (true) {
      System.out.println("Press 1: Push new integer to stack");
      System.out.println("Press 2: Pop the last item from stack");
      System.out.println("Press 3: Peak at top of stack");
      System.out.println("Press 4: Check it stack is empty");
      System.out.println("Press 5: Check the size of the stack");
      System.out.println("Press 6: View the full stack");
      System.out.println("Or any other key to QUIT.");
      System.out.println("----------");

      try {
        choice = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        choice = -1;
        System.out.println("Invalid selection.");
      }

      if (choice == 1) {
        System.out.println(choice + ": PUSH selected");
        System.out.println("Enter an integer to push");
        int newEntry = Integer.parseInt(scanner.nextLine());
        skPush(newEntry);

      } else if (choice == 2) {
        System.out.println(choice + ": POP selected");
        skPop();

      } else if (choice == 3) {
        System.out.println(choice + ": PEAK selected");

      } else if (choice == 4) {
        System.out.println(choice + ": CHECK EMPTY selected");

      } else if (choice == 5) {
        System.out.println(choice + ": CHECK SIZE selected");

      } else if (choice == 6) {
        System.out.println(choice + ": VIEW the full stack");
        skViewFull();

      } else {
        System.out.println("Quitting...");
        break;
      }


    }

  }
}
