//journey to the moon


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
 //   static int count = 0;
    static long journeyToMoon(int n, int[][] astronaut) {   
    ArrayList<Integer>[] graph = new ArrayList[n];
        int count = 0;
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<Integer>();
    }
    for (int[] ast : astronaut) {
      graph[ast[0]].add(ast[1]);
      graph[ast[1]].add(ast[0]);
    }
    
    boolean[] mask = new boolean[n];
    int[] table = new int[n];
    for (int i = 0; i < n; i++) {      
      if (!mask[i]) {        
        dfs(i, count, table, graph, mask);
        count++;       
      }      
    }
    int[] res = new int[count];
    for (int val : table) {
      res[val]++;
    }
    long ans = 0;
        long sum = 0;
    for (int size : res) {
        ans += sum * size;
        sum += size;
    }
    return ans;   
        // Complete this function
  }
  static void dfs(int i, int count, int[] table, ArrayList<Integer>[] graph, boolean[] mask) {
    mask[i] =  true;
    table[i] = count;
    for (int val : graph[i]) {
      if (!mask[val]) {
        dfs(val, count, table, graph, mask);
      }
    }
  }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int[][] astronaut = new int[p][2];
        for(int astronaut_i = 0; astronaut_i < p; astronaut_i++){
            for(int astronaut_j = 0; astronaut_j < 2; astronaut_j++){
                astronaut[astronaut_i][astronaut_j] = in.nextInt();
            }
        }
        long result = journeyToMoon(n, astronaut);
        System.out.println(result);
        in.close();
    }
}

//roads and libraries
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if (c_road >= c_lib) {
            return (long)n * c_lib;
        }
        long count = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
          graph.add(new ArrayList<Integer>());
        }
        for (int[] city : cities) {
          graph.get(city[0] - 1).add(city[1] - 1);
          graph.get(city[1] - 1).add(city[0] - 1);
        }
    boolean[] mask = new boolean[n];
//    int[] table = new int[n];
    for (int i = 0; i < n; i++) {      
      if (!mask[i]) {        
        dfs(i, graph, mask);
        count++;       
      }      
    }
        return (long)n * c_road + count * (c_lib - c_road);
    }
    
      static void dfs(int i, ArrayList<ArrayList<Integer>> graph, boolean[] mask) {
    mask[i] =  true;
//    table[i] = count;
    for (int val : graph.get(i)) {
      if (!mask[val]) {
        dfs(val, graph, mask);
      }
    }
  }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int c_lib = in.nextInt();
            int c_road = in.nextInt();
            int[][] cities = new int[m][2];
            for(int cities_i = 0; cities_i < m; cities_i++){
                for(int cities_j = 0; cities_j < 2; cities_j++){
                    cities[cities_i][cities_j] = in.nextInt();
                }
            }
            long result = roadsAndLibraries(n, c_lib, c_road, cities);
            System.out.println(result);
        }
        in.close();
    }
}
