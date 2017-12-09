using System;


/***

 Input: 1->2->2->3->4->2->8
step1:  1>2->2>2->3->4->8
step2: 1->2->3->4->8
 Output: 1->2->3->4->8
`
*/

public class Hash<K,V> {
  private int size = 16;
  private KeyValuePair<Tuple<K,V>> map[];
  public int count;
  
  public Hash(){
    map = new KeyValuePair[size];
    count = 0;
  }
  
  private int getHash(K key) {
      return key.getHash()%16;
  }
  
  public V get(K key){
     int index = getHash(key);
     if(this.map[index] == null) {
       throw new Exception("No Entry");
       
     } else {
       return this.map[index];
     }
  }
  
  public void put(K key, V value) {
     int index = getHash(key);
     this.map[index] = value;
     this.count++;
  }
  
  public void remove(K key){
     int index = getHash(key);
     this.map[index] = null;
     this.count--;
  }
  
  public int size() {
    return this.count();
  }
  
  public boolean isEmpty() {
    return (this.count == 0);
  }
  
  public boolean containsKey(K key){
     int index = getHash(key);
     return (this.map[index] != null);
  }
  
  public boolean containsValue(V value){
     for(V val: this.map){
         if(val == value){
           return true;
         }
     } 
    
    return false;
  }
  
  public void putAll(Collection<KeyValuePair<K,V>> values) {
     for(KeyValuePair<K,V> val: values){
       this.put(val.getKey(), val,getValue());
     }
  }
  
  public List<Key> keySet() {
     
    
  }
  
  public List<V> values () {
     List<V> vList = new ArrayList<V>();
     for(V val: this.map){
       vList.add(val);
     }
      
    return vList;
  }
    
  
}


public class Test
{
  public static void Main()
  {
    
    Console.WriteLine("Hello");
  }
  
  
  
  /*
  
  1->2->2->3->3->3
  public static LinkedListNode removeDuplicate(LinkedListNode node) {
    
    if (node == null || node.next == null) {
      return node;
    }
    
    LinkedListNode head = node;
    while (head != null) {
      int val = head.val;
      LinkedListNode pre = head;
      LinkedListNode next = pre.next;
      while (next != null) {
        if (next.val == val) {
          pre.next = next.next;
        }
        else {
          pre = next;
        }
        next = next.next;
      }
      head = head.next;
    }
    return node;
*/
  }
  
    public static LinkedListNode removeDuplicate(LinkedListNode node) {
    
    if (node == null || node.next == null) {
      return node;
    }
    
    LinkedListNode head = node.next;
    LinkedListNode pre = node;
    Set<Integer> set = new HashSet<>();
    set.add(node.val);
    while (head != null) {
      if (set.contains(head.val)) {
        pre.next = head.next;
      }
      else {
        pre = next;
        set.add(head.va);
      }
      head = head.next;
      
    }
      
    return node;
    
  }
 
  
}