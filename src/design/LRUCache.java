package design;

import java.util.*;

public class LRUCache {
    
    class CacheNode {
        int key;
        int value;
        CacheNode next;
        CacheNode prev;
        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    
    private HashMap<Integer, CacheNode> lruMap;
    private CacheNode head;
    private CacheNode tail;
    private int capacity;
    public LRUCache(int capacity) {
        this.lruMap = new HashMap<Integer, CacheNode>();
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }
    
    public int get(int key) {
        if (!this.lruMap.containsKey(key))
            return -1;
            
        CacheNode node = this.lruMap.get(key);
        updatePointers(node);
        return node.value;
    }
    
    public void set(int key, int value) {
        if (this.lruMap.containsKey(key)) {
            CacheNode node = this.lruMap.get(key);
            node.value = value;
            this.lruMap.put(key, node);
            updatePointers(node);
        }
        //else if (this.lruMap.size() < {
            
        //}
    }
    
    private void updatePointers(CacheNode node) {
        
        if (node.prev != null) {
            node.prev.next = tail;
            tail.prev = node.prev;
        }
        else {
            head = head.next;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
        tail.next = null;
    }
}