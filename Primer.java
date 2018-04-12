import java.util.*;


// A prime number is a whole number greater than 1 that can be divided evenly (no remainder or fraction) only by itself and 1.
// First few prime numbers include: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29

public class Primer {

  private static List<Integer> findPrimesNaive(int input) {

    List<Integer> primes = new ArrayList<Integer>();

    for (int k = 2; k < (input + 1); k++) {
      boolean isPrime = true;
      for (int i = k - 1; i > 1; i--) {
        if (k % i == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) {
        primes.add(k);
      } else {
        // do not add
      }
    }

    return primes;
  }

  public static void main(String[] args) {
    System.out.println("Primer reads in an integer and lists out all the prime numbers from one to that integer.");
    System.out.println("Enter an integer greater than 1");
    Scanner scanner = new Scanner(System.in);
    int input = Integer.parseInt(scanner.nextLine());

    List<Integer> primes = findPrimesNaive(input);

    for(int prime : primes) {
      System.out.print(prime + " ");
    }
    System.out.println("");
    System.out.println("There are " + primes.size() + " primes from 2 to " + input);
  }
}
