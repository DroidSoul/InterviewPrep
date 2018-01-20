/ package whatever; // don't place package name!

import java.io.*;


/* 
Your last Swift code is saved below:
enum Move: String {
  case AB, AC, BA, BC, CA, CB
}

func solve(_ n: Int) -> [Move] {
  return helper(n: n, start: "A", middle: "B", end: "C")
}

func helper(n: Int, start: String, middle: String, end: String) -> [Move] {
  if n == 0 {
    return []
  } else {
    var result = helper(n: n - 1, start: start, middle: end, end: middle)
    result.append(Move.init(rawValue: "\(start)\(end)")!)
    result.append(contentsOf: helper(n: n - 1, start: middle, middle: start, end: end))
    return result
  }
}


print(solve(3))

/* 
Your last Swift code is saved below:
print("Hello Swift")


In the classic Towers of Hanoi problem, there are three rods, A, B, and C, and there are n number of discs of different unique sizes which can slide onto any rod. The puzzle starts with all the discs in a neat stack in ascending order of size on the rod A, the smallest at the top, thus making a conical shape.

The objective of the puzzle is to move the entire stack to rod C, obeying the following simple rules:

Only one disc can be moved at a time
Only the uppermost disc can be moved
No disc may be placed on top of a smaller disc
Write a program which uses recursion to compute the correct sequence of moves that solve the puzzle, using the following interface:
*/
/*Interview Question 2 - Calculating n choose k
The binomial coefficient,   is often read aloud as "n choose k" and is used to denote the number of different ways to choose k elements from a set of n elements without respect to their order.

There are a number of different approaches to calculating this value, including a well-known approach using recursion:



Stated another way, the value for (n choose k) is equal to the sum of (n - 1 choose k - 1) and (n - 1 choose k).

Write a program that takes as its input two int values n and k and implements the above algorithm using tail recursion, returning a long value representing the number of different ways to choose k elements from a set of n elements.

Hint: there two base cases to consider

Bonus 1 - Memoization
The above solution is known to be inefficient due to repeated calculations. Improve the solution using memoization and explain the improvement in efficiency and the cost at which it is made.*/

class MyCode {
  
  
  
  public long nChooseK(int n, int k) {
    
    if (k > n) {
      return 0;
    }
    
    if (k == 0 || k == n) {
      return 1;
    }
    // long[][] table = new long[n + 1][n + 1];
    // table[n][k] = table[n - 1, k - 1] + table[n - 1, k];
   /* // for (int i = 2; i <= n; i++) {
              int j = 0; j <= Math.min(i, k); j++)
  }*/
    return nChooseK(n - 1, k - 1) + nChooseK(n - 1, k);
    
    
  }
  
  
    public static long nChooseK2(int n, int k) {
    
    if (k > n) {
      return 0;
    }
    
    if (k == 0 || k == n) {
      return 1;
    }
    long[][] table = new long[n + 1][k + 1];
    table[1][0] = 1;
    table[1][1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 0; j <= Math.min(i, k); j++) {
        if (j == 0 || j == i) {
          table[i][j] = 1;
        }
        else if (j == 1) {
          table[i][j] = i;
        }
        else {
          table[i][j] = table[i - 1][j - 1] + table[i - 1][j];
        }
      }
    }
      
   // n = 2, k = 1; tabel[2][0] = 1, table[2][1] = table[1][0] + table[1][1];
    return table[n][k];    
    
  }
  
  public static void main(String[] args) {
    long res = nChooseK2(5, 2);
    System.out.println(res);
  }
  
  
 
  
}
 