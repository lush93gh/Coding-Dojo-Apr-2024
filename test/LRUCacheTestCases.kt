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

    @org.junit.jupiter.api.Test
    fun getPositiveKeyValueSuccess() {
        val capability = 100
        val lruCache = LRUCache(capability)
        val expected = 1
        lruCache.put(1, expected)
        val result = lruCache.get(1)
        assertEquals(expected, result)
    }

    @org.junit.jupiter.api.Test
    fun getPositiveKeyValue2Success() {
        val capability = 100
        val lruCache = LRUCache(capability)
        val expected = 2
        lruCache.put(2, expected)
        val result = lruCache.get(2)
        assertEquals(expected, result)
    }

    @org.junit.jupiter.api.Test
    fun complex_LRU_case() {
        val capability = 2
        val lruCache = LRUCache(capability)
        lruCache.put(1, 1)
        lruCache.put(2, 2)
        val actual1 = lruCache.get(1)    // return 1
        assertEquals(1, actual1)
        lruCache.put(3, 3)
        val actual2 = lruCache.get(2)
        assertEquals(-1, actual2)
    }

    @org.junit.jupiter.api.Test
    fun complex_LRU_case_2() {
        val capability = 2
        val lruCache = LRUCache(capability)
        lruCache.put(1, 1)
        lruCache.put(2, 2)
        lruCache.assertGet(1, 1)    // return 1
        lruCache.put(3, 3)
        lruCache.assertGet(-1, 2)

        lruCache.put(4, 4)
        lruCache.assertGet(-1, 1)
        lruCache.assertGet(3, 3)
        lruCache.assertGet(4, 4)
    }


    @org.junit.jupiter.api.Test
    fun complex_LRU_case_3() {
        val capability = 2
        val lruCache = LRUCache(capability)
        lruCache.put(1, 1)
        lruCache.put(2, 2)
        lruCache.assertGet(1, 1)    // return 1
        lruCache.put(3, 3)
        lruCache.assertGet(-1, 2)
        lruCache.assertGet(1, 1)
        lruCache.put(4, 4)
//        lruCache.assertGet(-1, 1)
        lruCache.assertGet(-1, 3)
//        lruCache.assertGet(4, 4)
    }


    private fun LRUCache.assertGet(expect: Int, key: Int) {
        val actual = this.get(key)
        assertEquals(expect, actual)
    }


}