package com.prosayj.springboot.javacollections;

import com.prosayj.springboot.javacollections.sourcecode.map.HashMapSrc;

import java.util.*;

/**
 * @author yangjian
 * @description hashMap
 * 基于hash table 的Map接口实现, 该类实现提供了所有可选的map操作。允许null值和null key
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/10/30 下午 06:25
 * @since 1.0.0
 */
public class HashMapSrcDemo {
    public static void main(String[] args) {


        /**
         * hashMap的问题：
         *  1：死锁
         *  2：核心是基于哈希值的桶(数组实现：硬件电路地址的线性地址变换，直接寻址。)和链表
         *  3：O(1)(时间复杂度和数据的规模无关)的平均查找(很少的hash碰撞，如果hash函数合适的话)、插入、删除时间。
         *  4：致命的缺陷是hash表的hash值碰撞(collision)，解决碰撞的思路是链表。
         */
        //hash碰撞
        List<String> list = Arrays.asList("Aa", "BB", "C#");
        list.forEach(data -> System.out.println("data.hashCode() " + data.hashCode()));

        Map<String, String> mapSrc = new HashMapSrc<>();
        mapSrc.put("zs","23");
        mapSrc.put("zs1","23");
        mapSrc.put("zs2","23");
        System.out.println("mapSrc = " + mapSrc);


        /**
         * jdk1.7
         * 经典的哈希实现：数组+链表
         * 知识点：
         * 初始化容量
         * 负载因子
         * 哈希算法
         * 扩容
         *  低效
         *  线程不安全
         */

        //哈希表 = 哈希值、哈希桶、碰撞 ===》Java hashMap.根据hashCode把数据方到对应的桶中
        //key int 有限个数的hash桶

        /**
         * The default initial capacity - MUST be a power of two.
         * 为什么默认的初始化容量是2的二次幂？即：默认的hash桶的数量是2的n次方。
         *
         */
        //static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

        /**
         * The maximum capacity, used if a higher value is implicitly specified
         * by either of the constructors with arguments.
         * MUST be a power of two <= 1<<30.
         */
        //static final int MAXIMUM_CAPACITY = 1 << 30;//2的31次方

        /**
         * The load factor used when none specified in constructor.
         */
        //static final float DEFAULT_LOAD_FACTOR = 0.75f;//默认负载因子.


        /**
         * 构造方法：
         */
        // public HashMap(int initialCapacity, float loadFactor)


        /**
         * Associates the specified value with the specified key in this map.
         * If the map previously contained a mapping for the key, the old
         * value is replaced.
         *
         * @param key key with which the specified value is to be associated
         * @param value value to be associated with the specified key
         * @return the previous value associated with <tt>key</tt>, or
         *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
         *         (A <tt>null</tt> return can also indicate that the map
         *         previously associated <tt>null</tt> with <tt>key</tt>.)
         */
        /*
        public V put(K key, V value) {
            return putVal(hash(key), key, value, false, true);
        }
        */
        /**
         * Implements Map.put and related methods.
         *
         * @param hash hash for key
         * @param key the key
         * @param value the value to put
         * @param onlyIfAbsent if true, don't change existing value
         * @param evict if false, the table is in creation mode.
         * @return previous value, or null if none
         */
        /*final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
        boolean evict) {
            HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, i;
            if ((tab = table) == null || (n = tab.length) == 0)//第一次put的时候，才会默认开辟hash桶。杜绝浪费空间
                n = (tab = resize()).length;
            if ((p = tab[i = (n - 1) & hash]) == null)
                tab[i] = newNode(hash, key, value, null);
            else {
                HashMap.Node<K,V> e; K k;
                if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                    e = p;
                else if (p instanceof HashMap.TreeNode)
                    e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                else {
                    for (int binCount = 0; ; ++binCount) {
                        if ((e = p.next) == null) {
                            p.next = newNode(hash, key, value, null);
                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                treeifyBin(tab, hash);
                            break;
                        }
                        if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                            break;
                        p = e;
                    }
                }
                if (e != null) { // existing mapping for key
                    V oldValue = e.value;
                    if (!onlyIfAbsent || oldValue == null)
                        e.value = value;
                    afterNodeAccess(e);
                    return oldValue;
                }
            }
            ++modCount;
            if (++size > threshold)
                resize();
            afterNodeInsertion(evict);
            return null;
        }*/

        /**
         * Initializes or doubles table size.  If null, allocates in
         * accord with initial capacity target held in field threshold.
         * Otherwise, because we are using power-of-two expansion, the
         * elements from each bin must either stay at same index, or move
         * with a power of two offset in the new table.
         *
         * @return the table
         */
       /* final HashMap.Node<K, V>[] resize () {
            HashMap.Node<K, V>[] oldTab = table;
            int oldCap = (oldTab == null) ? 0 : oldTab.length;
            int oldThr = threshold;
            int newCap, newThr = 0;
            if (oldCap > 0) {
                if (oldCap >= MAXIMUM_CAPACITY) {
                    threshold = Integer.MAX_VALUE;
                    return oldTab;
                } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                        oldCap >= DEFAULT_INITIAL_CAPACITY)
                    newThr = oldThr << 1; // double threshold
            } else if (oldThr > 0) // initial capacity was placed in threshold
                newCap = oldThr;
            else {               // zero initial threshold signifies using defaults
                newCap = DEFAULT_INITIAL_CAPACITY;
                newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
            }
            if (newThr == 0) {
                float ft = (float) newCap * loadFactor;
                newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ?
                        (int) ft : Integer.MAX_VALUE);
            }
            threshold = newThr;
            @SuppressWarnings({"rawtypes", "unchecked"})
            HashMap.Node<K, V>[] newTab = (HashMap.Node<K, V>[]) new HashMap.Node[newCap];
            table = newTab;
            if (oldTab != null) {
                for (int j = 0; j < oldCap; ++j) {
                    HashMap.Node<K, V> e;
                    if ((e = oldTab[j]) != null) {
                        oldTab[j] = null;
                        if (e.next == null)
                            newTab[e.hash & (newCap - 1)] = e;
                        else if (e instanceof HashMap.TreeNode)
                            ((HashMap.TreeNode<K, V>) e).split(this, newTab, j, oldCap);
                        else { // preserve order
                            HashMap.Node<K, V> loHead = null, loTail = null;
                            HashMap.Node<K, V> hiHead = null, hiTail = null;
                            HashMap.Node<K, V> next;
                            do {
                                next = e.next;
                                if ((e.hash & oldCap) == 0) {
                                    if (loTail == null)
                                        loHead = e;
                                    else
                                        loTail.next = e;
                                    loTail = e;
                                } else {
                                    if (hiTail == null)
                                        hiHead = e;
                                    else
                                        hiTail.next = e;
                                    hiTail = e;
                                }
                            } while ((e = next) != null);
                            if (loTail != null) {
                                loTail.next = null;
                                newTab[j] = loHead;
                            }
                            if (hiTail != null) {
                                hiTail.next = null;
                                newTab[j + oldCap] = hiHead;
                            }
                        }
                    }
                }
            }
            return newTab;
        }*/


    }
}
