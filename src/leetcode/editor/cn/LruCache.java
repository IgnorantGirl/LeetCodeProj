//
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
// 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 3126 👎 0

package leetcode.editor.cn;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LruCache {
    public static void main(String[] args) {
        // Solution solution = new LruCache().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class LRUCache {

        class Node {
            // 以key value的形式存储
            int key, val;
            // 构造前驱和后继节点
            Node prew, next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        // 以key - node 为k-v的map集合，以便于移除节点
        private Map<Integer, Node> keyToNode;
        // 哨兵 一直是第一个！ 它的前驱节点就是最后一个
        private Node dummy;
        private int capacity = 0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            keyToNode = new HashMap<>();
            dummy = new Node(0, 0);
            // 自称环
            dummy.next = dummy;
            dummy.prew = dummy;
        }

        // 记住：获取数据 时 需要将其移到顶层，即头节点位置
        public int get(int key) {
            Node node = getNode(key);
            return node != null ? node.val : -1;
        }

        // 存入数据时，需要判断容量是否超出范围
        public void put(int key, int value) {
            // 已经存在，则更新值即可
            if (keyToNode.containsKey(key)) {
                Node node = getNode(key);
                node.val = value;
                return;
            }

            // 新的数据
            Node newNode = new Node(key, value);
            keyToNode.put(key, newNode);
            pushFront(newNode);
            // 容量超出处理
            if (keyToNode.size() > capacity) {
                // 移除尾节点
                Node lastNode = dummy.prew;
                remove(lastNode);
                keyToNode.remove(lastNode.key);
            }
        }

        /**
         * 根据key 获取节点;同时移动节点到顶层
         *
         * @param key
         * @return
         */
        private Node getNode(int key) {
            if (!keyToNode.containsKey(key)) {
                return null;
            }
            Node node = keyToNode.get(key);
            // 从当前节点移除
            remove(node);
            // 放到头节点
            pushFront(node);
            return node;
        }

        private void remove(Node node) {
            // 当前节点的前驱节点的下一个 等于 当前节点的下一个
            node.prew.next = node.next;
            node.next.prew = node.prew;
        }

        private void pushFront(Node node) {
            node.next = dummy.next;
            node.prew = dummy;
            // 变化会影响下一个数据的地方要后 设置 下面的位置不能颠倒
            dummy.next.prew = node;
            dummy.next = node;

        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}