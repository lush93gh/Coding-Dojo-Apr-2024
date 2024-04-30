import java.util.Deque
import java.util.ArrayDeque
import java.util.concurrent.LinkedBlockingQueue

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
 * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */
class LRUCache(private val capacity: Int) {

    private val cache = mutableMapOf<Int, Int>()
    private val keyPriorityQueue = ArrayDeque<Int>(capacity)

    fun get(key: Int): Int {
        keyPriorityQueue.remove(key)
        keyPriorityQueue.add(key)
        return cache[key] ?: -1
    }

    fun put(key: Int, value: Int) {
        keyPriorityQueue.remove(key)
        if (keyPriorityQueue.size >= capacity) {
            val removeKey = keyPriorityQueue.pop()
            cache.remove(removeKey)
        }
        keyPriorityQueue.add(key)
        cache[key] = value
    }
}