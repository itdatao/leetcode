import java.util.Random;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName SkipList.java
 * @Description 跳表的实现
 * @Date 2023-03-07 12:22:00
 */
public class SkipList<T> {

    // skipListNode head tail point nodes level random
    private SkipListNode<T> head, tail;
    private int nodes;
    private int level;
    private final Random random;
    private static final double PROBABILITY = 0.5;

    public SkipList() {
        random = new Random();
        clear();
    }

    public void clear() {
        head = new SkipListNode<T>(SkipListNode.HEAD_KEY, null);
        tail = new SkipListNode<T>(SkipListNode.TAIL_KEY, null);
        horizontalLink(head, tail);
        level = 0;
        nodes = 0;
    }

    public int size() {
        return nodes;
    }

    /**
     * 在最下面一层，找到要插入的位置前面的那个key
     */
    private SkipListNode<T> findNode(int key) {
        SkipListNode<T> p = head;
        while (true) {
            while (p.right.key != SkipListNode.TAIL_KEY && p.right.key <= key) {
                p = p.right;
            }
            if (p.down != null) {
                p = p.down;
            } else {
                break;
            }

        }
        return p;
    }

    public SkipListNode<T> search(int key) {
        SkipListNode<T> node = findNode(key);
        return node.key == key ? node : null;
    }

    public void put(int key, T value) {
        SkipListNode<T> node = findNode(key);
        if (node != null && node.value == value) {
            node.setValue(value);
            return;
        }
        SkipListNode<T> q = new SkipListNode<T>(key, value);
        backLink(node, q);
        int currentLevel = 0;// 当前所在的层级是0
        while (random.nextDouble() < PROBABILITY) {
            // 如果超出了高度，需要重新建一个顶层
            if (currentLevel >= level) {
                level++;
                SkipListNode<T> p1 = new SkipListNode<T>(SkipListNode.HEAD_KEY, null);
                SkipListNode<T> p2 = new SkipListNode<T>(SkipListNode.TAIL_KEY, null);
                horizontalLink(p1, p2);
                vertiacallLink(p1, head);
                vertiacallLink(p2, tail);
                head = p1;
                tail = p2;
            }
            //将p移动到上一层
            while (node.up==null) {
                node=node.left;
            }
            node=node.up;
            SkipListNode<T> e=new SkipListNode<T>(key, null);//只保存key就ok
            backLink(node, e);//将e插入到p的后面
            vertiacallLink(e, q);//将e和q上下连接
            q=e;
            currentLevel++;
        }

        this.nodes++;

    }

    // node1后面插入node2
    private void backLink(SkipListNode<T> node1, SkipListNode<T> node2) {
        if (node1 == null) {
            return;
        }
        node2.left = node1;
        node2.right = node1.right;
        node1.right.left = node2;
        node1.right = node2;
    }

    // 水平连接
    private void horizontalLink(SkipListNode<T> node1, SkipListNode<T> node2) {
        node1.right = node2;
        node2.left = node1;
    }

    /**
     * 垂直双向连接
     */
    private void vertiacallLink(SkipListNode<T> node1, SkipListNode<T> node2) {
        node1.down = node2;
        node2.up = node1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "跳跃表为空！";
        }
        StringBuilder builder = new StringBuilder();
        SkipListNode<T> p = head;
        while (p.down != null) {
            p = p.down;
        }

        while (p.left != null) {
            p = p.left;
        }
        if (p.right != null) {
            p = p.right;
        }
        while (p.right != null) {
            builder.append(p);
            builder.append("\n");
            p = p.right;
        }

        return builder.toString();
    }

    private boolean isEmpty() {
        return nodes == 0;
    }

}

class SkipListNode<T> {
    public int key;
    public T value;
    public SkipListNode<T> up, down, left, right; // 上下左右 四个指针

    public static final int HEAD_KEY = Integer.MIN_VALUE; // 负无穷
    public static final int TAIL_KEY = Integer.MAX_VALUE; // 正无穷

    public SkipListNode(int key, T value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof SkipListNode<?>)) {
            return false;
        }
        SkipListNode<T> ent;
        try {
            ent = (SkipListNode<T>) o; // 检测类型
        } catch (ClassCastException ex) {
            return false;
        }
        return (ent.getKey() == key) && (ent.getValue() == value);
    }

    @Override
    public String toString() {
        return "key-value:" + key + "-" + value;
    }
}
