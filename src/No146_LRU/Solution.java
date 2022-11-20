package No146_LRU;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);

    }

    public static void readMap(LRUCache lruCache) {
        for (Map.Entry item : lruCache.map.entrySet()) {
            System.out.println(item);
        }
    }

    static class LRUCache {

        int cap;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            Integer val = map.get(key);
            if (val == null) {
                return -1;
            }
            countMap.put(key, count++);
            System.out.println("get--->" + val);
            return val;
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                if (map.size() == cap) {
                    long minCount = Long.MAX_VALUE;
                    int minKey = -1;
                    for (Map.Entry<Integer, Integer> time : countMap.entrySet()) {
                        if (time.getValue() < minCount) {
                            minCount = time.getValue();
                            minKey = time.getKey();
                        }
                    }
                    map.remove(minKey);
                    countMap.remove(minKey);
                }
            }
            map.put(key, value);
            countMap.put(key, count++);
            System.out.println("-----------------------");
            for (Map.Entry item : map.entrySet()) {
                System.out.println(item);
            }
        }
    }





    class LRUCache1 {
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode pre;
            DLinkedNode next;
            public DLinkedNode(){}
            public DLinkedNode(int _key, int _value) {
                key = _key;
                value = _value;
            }
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        int size = 0;
        int cap = 0;
        private DLinkedNode head, tail;

        public LRUCache1(int capacity) {
            this.cap = capacity;
            this.size = 0;
            head.next = tail;
            tail.pre = head;
        }

        public void moveToHead(DLinkedNode node) {
            removeNode(node); //移除在当前位置
            addToHead(node); //插到最头上
        }

        public void removeNode(DLinkedNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public void addToHead(DLinkedNode node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        public DLinkedNode removeTail() {
            DLinkedNode res = tail.pre;
            removeNode(res);
            return res;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                DLinkedNode newNode = new DLinkedNode(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
                ++size;
                if (size > cap) {
                    DLinkedNode tail = removeTail();
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }
    }

}
