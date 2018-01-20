/ package whatever; // don't place package name!

import java.io.*;
import java.util.*;

class MyCode {
  public static void main (String[] args) {
    
    ArrayList<String> result = getSubstrings("123");
    for(String s: result) {
      System.out.println(s);
    }
    
    /*
    System.out.println("Hello Java");
    ArrayList<Integer> arr = new ArrayList<Integer>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    ArrayList<ArrayList<Integer>> resPerm = getPermutations(arr);
    for (ArrayList<Integer> perm : resPerm) {
      for (Integer x : perm) {
        System.out.print(x + " ");
      }
      System.out.println();
    }
    */
  }
  /*
  Example: Given the input string 12345, the output of the program would contain
  the following strings: [1, 12, 123, 1234, 12345, 2, 23, 234, 2345, 3, 34, 345, 4, 45, 5]
  */
  
  public static ArrayList<String> getSubstrings(String s) {
    if (s == null) {
      throw new IllegalArgumentException("s");
    }
    
    if (s == "") {
      return new ArrayList<String>();
    }
    
    StringBuilder sb = new StringBuilder();
    ArrayList<String> result = new ArrayList<String>();
    
    for(int i = 0; i < s.length(); ++i) {
      for (int j = i; j < s.length(); ++j) {
        sb.append(s.charAt(j));
        result.add(sb.toString());
      }
      
      sb = new StringBuilder();
    }
    
    return result;
  }
/*  Challenge 6 - Number of 1 Bits
Write a function that takes an unsigned integer and returns the number of 1 bits it has.

For example, the 32-bit integer 11 has binary representation:

00000000000000000000000000001011
so the function should return 3.

Note: that since Java does not have unsigned int, use long for Java.*/
  
  1011
  1010
    
  1010
  1001
    
  1000
  0111  
    
    while (n != 0) {
      n = n & (n-1);
        ++result;
    }
  
  
  
  public static int numOfOneBits(int x) {
    long y = (long)x;
    int res = 0;
    for (int i = 0; i < 32; i++) {
      y >>= i;
      res += y & 1;
    }
    return res;
    
  }
  
  
  public static ArrayList<ArrayList<Integer>> getPermutations(ArrayList<Integer> arr) {
    
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    getPermutationsRec(arr, 0, result);
    
    return result;
    
  }
  
  public static void getPermutationsRec(ArrayList<Integer> arr, int start,
                                          ArrayList<ArrayList<Integer>> result) {
    
    if (start >= arr.size()) {
      ArrayList<Integer> permutation = new ArrayList<Integer>(arr);
      result.add(permutation);
      return;
    }
    
    for (int i = start; i < arr.size(); i++) {
      swap(arr, start, i);
      getPermutationsRec(arr, start+1, result);
      swap(arr, start, i);
    }
    
  }
  
  public static void swap(ArrayList<Integer> arr, int i, int j){
    int tmp = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, tmp);
  }
  
  
  public int gcd(int a, int b) {
    // a = 10, b = 24, return 2
    // a = 3, b = 24, return 3
    // a = 5, b = 7, return 1
    int c = Math.min(a, b);
    while (c > 1) {
      if (a % c == 0 && b % c == 0) {
        return c;
      }
      c--;
    }
    return 1;
  }
  /*
  if (a <= b) {
    int c = b % a;
    return gcd(c, a);
  }
  else return gcd(b, a);
  */
  
}


/*

Challenge 5 - Single Number
Given an array of integers, every element appears twice except for one.
Find that single one.

Input : [1 2 2 3 1]
Output : 3
Note: Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?


Challenge 4 - Compute all substrings
Consider the following interface:

interface SubstringProvider {
  java.util.Collection<String> getSubstrings(String s);
}
Write two implementations of this interface: one using an iterative algorithm
and the other using a recursive algorithm.

Example: Given the input string 12345, the output of the program would contain
the following strings: [1, 12, 123, 1234, 12345, 2, 23, 234, 2345, 3, 34, 345, 4, 45, 5]




Challenge 3 - Integer Array Permutations
Write a program that takes as its input an int[] containing 2 or more values
and returning all possible permutations of the numbers.

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]
Note: No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection
are unique. Do not use any library functions for generating permutations.

*/





/*
Challenge 1 - Compute factorial of an integer
The factorial of n is the product of all integers between 1 and n. For example,
the factorial of 5 is computed as follows: 5*4*3*2*1 == 120.

Write a program that takes as its input a java.math.BigInteger and returns a
java.math.BigInteger equal to the factorial of the input.

Hint: this can be implemented using a single static method with only one line of code.



Challenge 2 - Compute gcd of two integers
The greatest common divisor (gcd) of two or more non-zero integers is the largest
positive integer that divides all the numbers without a remainder.

Write a program that takes as its input two int values > 0 and returns an int value equal to their gcd.

*/
