public ListNode treeToColumn(TreeNode root) {
      
      if (root == null) {
        return null;
      }
      
      Queue<TreeNode> queue = new LinkedList<>();
//      Queue<Integer> q = new LInek
      Map<Integer, List<TreeNode>> colMap = new HashMap<>();
      Map<TreeNode, Integer> colNumMap = 
      colNumMap.put(root, 0)
      queue.offer(root);
      
      TreeNode DUMMY_NODE = new TreeNode;
      
      int level = 0;
      
      while(!queue.isEmpty()) {
        int levelSize = queue.size();
        
        for (int i = 0; i < levelSize; i++) {
          TreeNode node = queue.poll();  
            
            int colNum = colNumMap.get(node);
            if (node.left != null) {
              addToMap(col, node.left);
              queue.offer(node.left);
              colNumMap.put(node.left, colNum -1);
            } 
            if (node.right != null) {
              addToMap(col, node.right);
              queue.offer(node.right);
              colNumMap.put(node.right, colNum + 1);
            } 
          
           colNumMap.remove(node);
        }
        level++;  
      }
    
      
      ListNode head = new ListNode();
      ListNode pre = head;
      for (int i = -level; i <= level; i++) {
        List<TreeNode> nodes = colMap.get(i);
        if (nodes != null) {
          for (TreeNode )
        }
      }
      
    }
      
      private void addToMap(Map<Integer, List<TreeNode>> colMap, int col, TreeNode node) {
        if (colMap.contains(col)) {
          colMap.get(col).add(node);
        } else {
          List<TreeNode> list = new ArrayList()
          
          list.add(node);
          colMap.put(col, list);
        }
      }
      
    }