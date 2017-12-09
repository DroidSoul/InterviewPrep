Alice is a teacher with a class of n children, each of whom has been assigned a numeric rating. The classroom is seated in a circular arrangement, with Alice at the top of the circle. She has a number of gold stars to give out based on each child's rating, but with the following conditions:

Each child must receive at least one gold star
Any child with a higher rating than his or her immediate neighbor should get more stars than that neighbor
Assuming n >= 3, what is the minimum total number of stars Alice will need to give out?

Write a program which takes as its input an int[] containing the ratings of each child, ordered by seating position, and returns an int value for the minimum total number of stars that Alice will need to give out.

For example:

In a class of three children with ordered ratings of {1, 2, 2}, Alice will need to give out {1, 2, 1} stars accordingly, for a total number of 4 stars overall.

# {2, 4, 6},=> {1, 2, 3}
# {2, 2, 2} => {1, 1, 1}
# {3, 7, 5, 6 , 9} = > {1, 2, 1, 2, 3}
# { 3, 7, 5} => {1, 2, 1} => {1, 2, 2} => {1, 3, 2}
# {3, 7, 5, 6} => {1, 2, 1, 2}
# {7, 8, 5, 6}= >{1, 2, 1, 2} = > {3, 4, 1, 2}
# {8, 7, 5, 6}=> {3,1 , 1 ,2}
# {6,9 , 7 , 6, 7, 5, 8} =>      {  1, 3,  2, 1, 2, 1, 2}
#n + detal(m);
public class Solution {
    public int minStars(int[] A) {
        if (A == null || A.length ==0) {
        return 0;}
        if (A.length == 1) {
        return 1;}
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {7
            if(A[i] < min) {
                index = i;
                min = A[i];
            }
        }
        int res = 0;
        int[] table = new int[A.length];
        table[index] = 1;
        for (int i = index + 1, i < index + A.length; i++) {
            int j = i % A.length;
            if (A[j] > A[j - 1]) {
                table[j] = table[j - 1] + 1;
            }
            else {
            table[j] = 1;
        }
        if (table[index - 1] == 1) {
        while (
        
        
        
        }
        
    
    
    
    
    }