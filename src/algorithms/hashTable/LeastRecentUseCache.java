package algorithms.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/205
 * https://leetcode.com/problems/lru-cache/
 * LRU:
 *  1. find the corresponding answer / response to a question / request: hashMap
 *  2. adjust the timestamp / order of a particular entry
 *  3. find and delete the oldest entry
 *  4. insert an entry as the newest
 *  data structure: HashMap + Linked List (doubly)
 *  Limit is the max capacity of the cache
 *  each node contains the key, value pair
 *  and it is also a double linked list node.
 *
 *  prev
 *          cur
 *                  next
 *  head------intermediate-------tail
 *  MRU                          LRU
 */

public class LeastRecentUseCache<K, V> {
    /**
     *  make it final for the pre-defined size limit of the cache.
     *  record all the time the head and tail of the double linked list.
     *  maintains the relationship of key and its corresponding Cachenode
     * in the double linked list.
     */
    private final int limit;
    private CacheNode<K, V> head;
    private CacheNode<K, V> tail;
    private Map<K, CacheNode<K, V>> map;

    public LeastRecentUseCache(int limit) {
        this.limit = limit;
        this.map = new HashMap<K, CacheNode<K, V>>();
    }

    public void set(K key, V value) {
        CacheNode<K, V> cacheNode = null;
        if (map.containsKey(key)) {
            /**
             *  1. if the key already in the cache, we need to update its value
             *  and move it to head(most recent position).
             */
            cacheNode = map.get(key);
            cacheNode.value = value;
            remove(cacheNode);
        } else if (map.size() < limit) {
            /**
             *  2. if the key is not in the cache and we still have space,
             *  we can add append a new Cachenode to head.
             */
            cacheNode = new CacheNode<K, V>(key, value);
        } else {
            /**
             *  3. if the key is not in the cache and we don't have space,
             *  we need to evict the tail and reuse the Cachenode let it maintain
             *  the new key, value and put it to head.
             */
            cacheNode = tail;
            remove(cacheNode);
            cacheNode.update(key, value);
        }
        append(cacheNode);
    }

    public V get(K key) {
        CacheNode<K, V> cacheNode = map.get(key);
        if (cacheNode == null) {
            return null;
        }
        /**
         *  even it is a read operation, it is still a write operation to
         *  the double linked list, and we need to move the Cachenode to head.
         */
        remove(cacheNode);
        append(cacheNode);
        return cacheNode.value;
    }

    private CacheNode<K, V> remove(CacheNode<K, V> cacheNode) {
        map.remove(cacheNode.key);
        if (cacheNode.prev != null) {
            cacheNode.prev.next = cacheNode.next;
        }
        if (cacheNode.next != null) {
            cacheNode.next.prev = cacheNode.prev;
        }
        if (cacheNode == head) {
            head = head.next;
        }
        if (cacheNode == tail) {
            tail = tail.prev;
        }
        /**
         *  break apart the curr Cachenode
         */
        cacheNode.next = cacheNode.prev = null;
        return cacheNode;
    }

    private CacheNode<K, V> append(CacheNode<K, V> cacheNode) {
        map.put(cacheNode.key, cacheNode);
        if (head == null) {
            head = tail = cacheNode;
        } else {
            cacheNode.next = head;
            head.prev = cacheNode;
            head = cacheNode;
        }
        return cacheNode;
    }

    static class CacheNode<K, V> {
        CacheNode<K, V> next;
        CacheNode<K, V> prev;
        K key;
        V value;
        CacheNode (K key, V value) {
            this.key = key;
            this.value = value;
        }
        void update(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

