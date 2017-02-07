# JDK 8
## List
| 名称 | 线程安全 | 数据结构 | 允许 null | 默认初始容量 | 扩容策略 | 备注 |
| --- | :-----: | :-----: | :------: | ---------: | ------: | --- |
| ArrayList | N | 数组 | Y | 10 | 1.5 * old | |
| LinkedList | N | 双链表 | Y | N/A | N/A | 作为 List 使用时，最好换用低复杂度的 [TreeList](https://commons.apache.org/proper/commons-collections/apidocs/org/apache/commons/collections4/list/TreeList.html) |
| CopyOnWriteArrayList | Y | 数组 + 快照 | Y | 0 | +1 | |

## Map
| 名称 | 线程安全 | 数据结构 | 允许 null key | 允许 null value | 有序 | 默认初始容量 | 扩容策略 | 备注 |
| --- | :-----: | ------- | :----------: | :------------: | :--: | ---------: | ------: | --- |
| HashMap | N | 多个(单链表或者红黑树)组成的数组 | Y | Y | N | 16 | 2 * old |
| IdentityHashMap | N |
| LinkedHashMap | N | 多个双链表组成的数组 | Y | Y | N | 16 | 2 * old |
| TreeMap | N | 红黑树 | N | Y | Y | N/A | N/A |
| EnumMap | N | 数组 | N | Y | Y | N/A | N/A |
| ConcurrentHashMap | Y | 多个(单链表或者红黑树)组成的数组 | N | N | N | 16 | 2 * old |
| ConcurrentSkipListMap | Y | 跳表 | N | N | Y | N/A | ? |

## Set
| 名称 | 线程安全 | 数据结构 | 允许 null | 有序 | 备注 |
| --- | :-----: | ------- | :------: | :-: | :--: |
| HashSet | N | HashMap | Y | N | |
| LinkedHashSet | N | LinkedHashMap | Y | N |
| TreeSet | N | TreeMap | N | Y |
| ConcurrentSkipListSet | Y | ConcurrentSkipListMap | N | Y |
| CopyOnWriteArraySet | Y | CopyOnWriteArrayList | Y | N |

## Queue
| 名称 | 线程安全 | 数据结构 | 允许 null | 默认初始容量 | 扩容策略 | 备注 |
| --- | :-----: | :-----: | :------: | ---------: | ------: | --- |
| ArrayDeque | N | 数组 | N | 16 | 2 * old | head 从数组的最大下标开始变小，tail 从 0 开始变大 |
| PriorityQueue | N | [平衡最小二叉堆](http://blog.csdn.net/lcore/article/details/9100073) | N | 11 | old < 64 则 2 * old; 否则 1.5 * old | 空穴, sift up，sift down |
| ConcurrentLinkedQueue | Y | 单链表 + CAS | N | N/A | N/A |
| ConcurrentLinkedDeque | Y | 双链表 + CAS | N | N/A | N/A |
| ArrayBlockingQueue | Y | 循环数组 | N | N/A | 定长, 不可扩容 | 1. 有 fair 选项; 2. 有一把公共的 ReentrantLock 与 notFull、notEmpty 两个 Condition 管理队列满或空时的阻塞状态 |
| LinkedBlockingQueue | Y | 单链表 | N | N/A | 定长或无界 | 利用链表的特征，分离了 takeLock 与 putLock 两把锁，继续用 notEmpty、notFull 管理队列满或空时的阻塞状态 |
| LinkedBlockingDeque | Y | 双链表 | N | N/A | 定长或无界 | 利用链表的特征，分离了 takeLock 与 putLock 两把锁，继续用 notEmpty、notFull 管理队列满或空时的阻塞状态  |
| PriorityBlockingQueue | Y | [平衡最小二叉堆](http://blog.csdn.net/lcore/article/details/9100073) | N | 11 | old < 64 则 2 * old; 否则 1.5 * old | 空穴, sift up，sift down |
| DelayQueue | Y | PriorityQueue | N | 见 PriorityQueue | 见 PriorityQueue | ScheduledThreadPoolExecutor 用了类似的结构 |
| SynchronousQueue | Y | N/A | N | 1 | N/A | 有 fair 选项 |
| LinkedTransferQueue | Y | 单链表 + CAS | N | N/A | N/A |
