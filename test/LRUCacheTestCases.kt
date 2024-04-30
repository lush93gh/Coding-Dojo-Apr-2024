import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals

//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
class LRUCacheTestCases {
    private val capability = 100

    @org.junit.jupiter.api.Test
    fun getPositiveKeyValueSuccess() {
        val lruCache = LRUCache(capability)
        val expected = 1
        lruCache.put(1, expected)
        val result = lruCache.get(1)
        assertEquals(expected, result)
    }

    @org.junit.jupiter.api.Test
    fun getPositiveKeyValue2Success() {
        val lruCache = LRUCache(capability)
        val expected = 2
        lruCache.put(2, expected)
        val result = lruCache.get(2)
        assertEquals(expected, result)
    }

    @org.junit.jupiter.api.Test
    fun capacity_available() {
        val lruCache = LRUCache(1)
        lruCache.put(1, 1)
        lruCache.put(2, 2)
    }

}