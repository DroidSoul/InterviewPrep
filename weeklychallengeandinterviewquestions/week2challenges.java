// package whatever; // don't place package name!

import java.io.*;
import java.util.HashMap;
import java.util.Map;


class MyCode {
  public static void main (String[] args) {
    /*
    LinkedListNode<Integer> head = null;
    Integer[] listValues = new Integer[] {1, 2, 3};

    head = new LinkedListNodeImpl<Integer>();
    head.setValuesFromArray(listValues);
    
    System.out.println(head.getNext().getValue());
    
    
    Integer[] listValues2 = new Integer[] {1, 2};

    LinkedListNode<Integer> n1 = new LinkedListNodeImpl<Integer>();
    n1.setValuesFromArray(listValues2);
    
    
    Integer[] listValues3 = new Integer[] {5, 3};

    LinkedListNode<Integer> n2 = new LinkedListNodeImpl<Integer>();
    n2.setValuesFromArray(listValues3);
    
    LinkedListNode<Integer> result = addTwoNumbers(n1, n2);
    result.printNode();*/
    
    // subsequence of s is substring of t, longest 
    // substring of t is o(n^2) (form i to j, which can be form 0->n-1), substring can be a subsequence of s, thast is o(n*m), o(n^3*m)
    // abc -> a, b, c, ab, bc, abc
    //potential subsequence of s (2^n)
    
    
    String str = "To be or not to be, that is the question";
    HashMap<String, Integer> map = wordCount(str);
    for (Map.Entry<String, Integer> e: map.entrySet()) {
      System.out.println(e.getKey() + " " + e.getValue());
    }
    
    
  }
  
  public static LinkedListNode<Integer> addTwoNumbers(LinkedListNode<Integer> x, LinkedListNode<Integer> y) {
    
    if (x == null) {
      return y;
    }
    
    if (y == null) {
      return x;
    }
    
    int carry = 0;
    
    LinkedListNode<Integer> head = new LinkedListNodeImpl<Integer>(-1);
    LinkedListNode<Integer> res = head;
    
    while (x != null &&  y != null) {
    
      
      int sum = x.getValue() + y.getValue() + carry;
      if (sum >= 10) {
        carry = 1;
        sum = sum % 10;
      } else {
        carry = 0;
      }
      
      x = x.getNext();
      y = y.getNext();
      
      res.setNext(new LinkedListNodeImpl<Integer>(sum));
      res = res.getNext();
      
    }
    
    if (x == null) {
      
      while (y != null) {
        
        int val = y.getValue() + carry;
        if (val >= 10) {
          carry = 1;
          val = val % 10;
        } else {
          carry = 0;
        }
        

        y = y.getNext();
        res.setNext(new LinkedListNodeImpl<Integer>(val));
        res = res.getNext();
        
      }
      
    } else {
      
      
      while (x != null) {
        
        int val = x.getValue() + carry;
        if (val >= 10) {
          carry = 1;
          val = val % 10;
        } else {
          carry = 0;
        }
        
        x = x.getNext();

        res.setNext(new LinkedListNodeImpl<Integer>(val));
        res = res.getNext();
      }
      
    }
    
    
    return head.getNext();
  }
  
  
  public static HashMap<String, Integer> wordCount(String str) {
    
    //Program or program?
    //split into words array, clean them, gnore everything other than letters, change them to lower case
    // go thourgh the array and add to map
    //"To be or not to be, that is the question"
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    String[] words = str.split(" ");
    for (String word : words) {
       // abc##de
      word = clean(word);
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    return map;

    
  }
  public static String clean(String str) {
    StringBuilder sb = new StringBuilder();
    str = str.toLowerCase();
    for (char c : str.toCharArray()) {
      if (c >= 'a' && c <= 'z') {
        sb.append(c);
      }
    }
    return sb.toString();
  }
  
  
  
  
  
}

 interface LinkedListNode<E> {

    /* getter/setter for this node's value */
    E getValue();
    void setValue(E value);

    /* getter/setter for the subsequent node, or null if this is the last node */
    LinkedListNode<E> getNext();
    void setNext(LinkedListNode<E> next);

    /**
     * Initialize this node and all of its subsequent nodes from
     * an array of values, starting with the head value at index 0
     *
     * @param listValues - the ordered values for the whole list
     */
    void setValuesFromArray(E[] listValues);
    
   void printNode();

}

class LinkedListNodeImpl<E> implements LinkedListNode<E> {
  private E value;
  private LinkedListNode<E> next;
  
  public LinkedListNodeImpl () {
    next = null;
  }
  
  public LinkedListNodeImpl (E value) {
    this.value = value;
    this.next = null;
  }
  
  public E getValue() {
    return value;
  }
  
  public void setValue(E value) {
    this.value = value;
  }
  
  public LinkedListNode<E> getNext() {
    return next;
  }
  
  public void setNext(LinkedListNode<E> next) {
    this.next = next;
  }
  
  public void setValuesFromArray(E[] listValues) {
    if (listValues == null || listValues.length == 0) {
      return;
    }
    
    this.value = listValues[0];
    LinkedListNode<E> current = this;
    for(int i = 1; i < listValues.length; ++i) {
      current.setNext(new LinkedListNodeImpl(listValues[i]));
      current = current.getNext();
    }
    
  }
  
  public void printNode() {
        System.out.print(this.getValue() + " ");
        LinkedListNode next = this.getNext();
        while (next != null) {
            System.out.print(next.getValue() + " ");
            next = next.getNext();
        }
        System.out.println();
    }
}