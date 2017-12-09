his problem is concerned with deleting repeated elements from a sorted array.

Write a program which takes as input a sorted int[] and updates it such that:

all duplicates have been removed and
all remaining valid elements have been shifted left to fill the emptied indices
all remaining empty indices have values set to 0
the function returns the number of remaining valid elements (the array size minus the number of removed elements)
For example, given an input array with the values {2,3,5,5,7,11,11,11,11,13}, after the function completes, the values in the array should be {2,3,5,7,11,13,0,0,0}, and the function should return 6.




// {0, 0} -> {0, 0} - length:1


// i, j 

// {2,3,5,5,7,11,11,11,11,13}

// {2,3,5,5,7,11,11,11,11,13}

int findArrayLength(int[] array) {
    if (array.length <= 1) {
        return array.length;
    }
    
    int i = 0;
    
    for(int j = 1; j < array.length; ++j) {
        if (array[i] != array[j]){
            ++i;
            swap(array, i, j);
        }
    }
    
    for (int j = i + 1; j < array.length; ++j) {
        array[j] = 0;
    }
    
    return i + 1;
}

void swap(int[] array, int i, int j){
int temp = array[i];
array[i] = array[j];
array[j] = temp;
}






/////////



A prime number (or a prime) is an integer greater than 1 that has no positive divisors other than 1 and itself.

Write a program which takes as input an int value n and returns an array of int containing all unique primes <= n.

Example: if the value of n is 8, the function should return: {2,3,5,7}

Hint: One well-known algorithm for doing this is over 2,000 years old, but it's not the most efficient.

Remember, you are not allowed to use any primality testing functions.


x  1 -> sqroot(x) 



