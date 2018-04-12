import java.util.*;


// A prime number is a whole number greater than 1 that can be divided evenly (no remainder or fraction) only by itself and 1.
// First few prime numbers include: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29

public class Primer {

  // much faster algorithm, still fast up to 10,000,000, and still works with lag up to 100,000,000 atleast 
  private static List<Integer> sieveOfEratosthenes(int input) {
    List<Integer> finalPrimes = new ArrayList<Integer>();

    // initialize boolean primes array to true mostly
    boolean[] boolPrimes = new boolean[input + 1];
    boolPrimes[0] = false;
    boolPrimes[1] = false;
    for (int i = 2; i < boolPrimes.length; i++) {
      boolPrimes[i] = true;
    }

    // set indexes to true or false depending on prime
    for (int i = 2; i < boolPrimes.length; i++) {
      if (boolPrimes[i]) {
        // set all multiples of that prime to false
        for (int k = i; k < boolPrimes.length; k += i) {
          boolPrimes[k] = false;
        }
        finalPrimes.add(i);
      }
    }

    return finalPrimes;
  }

  // naive algorithm, slows down noticeably if input is higher than 10,000
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

    //List<Integer> primes = findPrimesNaive(input);
    List<Integer> primes = sieveOfEratosthenes(input);

    for(int prime : primes) {
      System.out.print(prime + " ");
    }
    System.out.println("");
    System.out.println("There are " + primes.size() + " primes from 2 to " + input);
  }
}
