package algorithms.hashTable;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/205
 * https://leetcode.com/problems/lru-cache/
 * Least Recent Used Cache:
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
 *
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LeastRecentUsedCacheTest {

    LeastRecentUsedCache lru;

    @BeforeClass
    public void setUpClass() {
//        CacheNode<K, V> one = new lru.CacheNode<K, V>(1, 1);
        CacheNode<K, V> one = new CacheNode<K, V>(1, 1);
        CacheNode<K, V> two = new CacheNode<K, V>(2, 2);
        CacheNode<K, V> three = new CacheNode<K, V>(2, 2);
        CacheNode<K, V> four = new CacheNode<K, V>(2, 2);

        one.next = two;
        two.prev = one;
        two.next = three;
        three.prev = two;
        three.next = four;
        four.prev = three;
    }
    @Before
    public void setup() {
        lru = new LeastRecentUsedCache<K, V>();
    }

    @Test
    public void test1Set() {

    }

    @Test
    public void test1Get() {
    }
}