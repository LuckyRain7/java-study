# JDK 8
## List
| 名称 | 线程安全 | 数据结构 | 允许 null | 允许重复 | 有序 | 默认初始容量 | 扩容策略 | 备注 |
| --- | :-----: | :-----: | :------: | :-----: | :-: | ---------: | ------: | --- |
| ArrayList | N | 数组 | Y | Y | N | 10 | 1.5 * old | |
| LinkedList | N | 双链表 | Y | Y | N | N/A | N/A | |
| CopyOnWriteArrayList | Y | 数组 + 快照 | Y | Y | N | 0 | +1 | |

## Map
| 名称 | 线程安全 | 数据结构 | 允许 null key | 允许 null value | 有序 | 默认初始容量 | 扩容策略 | 备注 |
| --- | :-----: | ------- | :----------: | :------------: | :--: | ---------: | ------: | --- |
| HashMap | N | 多个(单链表或者红黑树)组成的数组 | Y | Y | N | 16 | 2 * old | |
| LinkedHashMap | N | 多个双链表组成的数组 | Y | Y | N | 16 | 2 * old | |
| TreeMap | N | 红黑树 | N | Y | Y | N/A | N/A | |
| EnumMap | N | 数组 | N | Y | Y | N/A | N/A | |
| ConcurrentHashMap | Y | 多个(单链表或者红黑树)组成的数组 | N | N | N | 16 | 2 * old | |
| ConcurrentSkipListMap | Y | 跳表 | N | N | Y | N/A | ? | |

## Set
| 名称 | 线程安全 | 数据结构 | 允许 null | 有序 | 备注 |
| --- | :-----: | ------- | :------: | :-: | :--: |
| HashSet | N | HashMap | Y | N | |
| LinkedHashSet | N | LinkedHashMap | Y | N | |
| TreeSet | N | TreeMap | N | Y | |
| ConcurrentSkipListSet | Y | ConcurrentSkipListMap | N | Y | |
| CopyOnWriteArraySet | Y | CopyOnWriteArrayList | Y | N | |

## Queue
| 名称 | 线程安全 | 数据结构 | 允许 null | 允许重复 | 有序 | 默认初始容量 | 扩容策略 | 备注 |
| --- | :-----: | :-----: | :------: | :-----: | :-: | ---------: | ------: | --- |
| ArrayDeque | N | 数组 | N | Y | N | 16 | 2 * old | head 从数组的最大下标开始变小，tail 从 0 开始变大 |
| PriorityQueue | N | 平衡最小二叉堆 | N | Y | N | 11 | old < 64 则 2 * old; 否则 1.5 * old | |
