# JDK 8
## List
| 名称 | 线程安全 | 数据结构 | 允许 null | 默认初始容量 | 扩容策略 | 备注 |
| --- | :-----: | :-----: | :------: | ---------: | ------: | --- |
| ArrayList | 否 | 数组 | 是 | 10 | 1.5 * old | |
| LinkedList | 否 | 双链表 | 是 | N/A | N/A | 作为 List 使用时，最好换用低复杂度的 [TreeList](https://commons.apache.org/proper/commons-collections/apidocs/org/apache/commons/collections4/list/TreeList.html) |
| CopyOnWriteArrayList | 是 | 数组 + 快照 | 是 | 0 | +1 | |

## Map
| 名称 | 线程安全 | 数据结构 | 允许 null key | 允许 null value | 有序 | 默认初始容量 | 扩容策略 | 备注 |
| --- | :-----: | ------- | :----------: | :------------: | :--: | ---------: | ------: | --- |
| HashMap | 否 | 多个(单链表或者红黑树)组成的数组 | 是 | 是 | 否 | 16 | 2 * old |
| IdentityHashMap | 否 |
| LinkedHashMap | 否 | 多个双链表组成的数组 | 是 | 是 | 否 | 16 | 2 * old |
| TreeMap | 否 | 红黑树 | 否 | 是 | 是 | N/A | N/A |
| EnumMap | 否 | 数组 | 否 | 是 | 是 | N/A | N/A |
| ConcurrentHashMap | 是 | 多个(单链表或者红黑树)组成的数组 | 否 | 否 | 否 | 16 | 2 * old |
| ConcurrentSkipListMap | 是 | 跳表 | 否 | 否 | 是 | N/A | ? |

## Set
| 名称 | 线程安全 | 数据结构 | 允许 null | 有序 | 备注 |
| --- | :-----: | ------- | :------: | :-: | :--: |
| HashSet | 否 | HashMap | 是 | 否 | |
| LinkedHashSet | 否 | LinkedHashMap | 是 | 否 |
| TreeSet | 否 | TreeMap | 否 | 是 |
| ConcurrentSkipListSet | 是 | ConcurrentSkipListMap | 否 | 是 |
| CopyOnWriteArraySet | 是 | CopyOnWriteArrayList | 是 | 否 |

## Queue
| 名称 | 线程安全 | 数据结构 | 允许 null | 默认初始容量 | 扩容策略 | 备注 |
| --- | :-----: | :-----: | :------: | ---------: | ------: | --- |
| ArrayDeque | 否 | 数组 | 否 | 16 | 2 * old | head 从数组的最大下标开始变小，tail 从 0 开始变大 |
| PriorityQueue | 否 | [平衡最小二叉堆](http://blog.csdn.net/lcore/article/details/9100073) | 否 | 11 | old < 64 则 2 * old; 否则 1.5 * old | 空穴, sift up，sift down |
| ConcurrentLinkedQueue | 是 | 单链表 + CAS | 否 | N/A | N/A |
| ConcurrentLinkedDeque | 是 | 双链表 + CAS | 否 | N/A | N/A |
| ArrayBlockingQueue | 是 | 循环数组 | 否 | N/A | 定长, 不可扩容 | 1. 有 fair 选项; 2. 有一把公共的 ReentrantLock 与 notFull、notEmpty 两个 Condition 管理队列满或空时的阻塞状态 |
| LinkedBlockingQueue | 是 | 单链表 | 否 | N/A | 定长或无界 | 利用链表的特征，分离了 takeLock 与 putLock 两把锁，继续用 notEmpty、notFull 管理队列满或空时的阻塞状态 |
| LinkedBlockingDeque | 是 | 双链表 | 否 | N/A | 定长或无界 | 利用链表的特征，分离了 takeLock 与 putLock 两把锁，继续用 notEmpty、notFull 管理队列满或空时的阻塞状态  |
| PriorityBlockingQueue | 是 | [平衡最小二叉堆](http://blog.csdn.net/lcore/article/details/9100073) | 否 | 11 | old < 64 则 2 * old; 否则 1.5 * old | 空穴, sift up，sift down |
| DelayQueue | 是 | PriorityQueue | 否 | 见 PriorityQueue | 见 PriorityQueue | ScheduledThreadPoolExecutor 用了类似的结构 |
| SynchronousQueue | 是 | N/A | 否 | 1 | N/A | 有 fair 选项 |
| LinkedTransferQueue | 是 | 单链表 + CAS | 否 | N/A | N/A |
