package leetcode.offer;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName Offer67MaxXOR.java
 * @Date 2023-02-18 22:11:00
 */
public class Offer67MaxXOR {
    // 求数组中 两个元素最大的异或值
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        root.insert(nums[0]);
        int ans = 0;
        for (int i = 1; i < nums.length; ++i) {
            ans = Math.max(root.maxXOR(nums[i]), ans);
            root.insert(nums[i]);
        }
        return ans;
    }
    class Trie {
        Trie[] child; // 表示二进制0 / 1是否存在
        int k; // 记录数字
        public Trie() {
            child = new Trie[2]; // 最多两位二进制0 和 1
            k = -1;
        }
        // 按位从高到低插入数字的每个二进制位;
        public void insert(int num) {
            Trie node = this;
            int i = 31;
            while (i >= 0) {
                int bit = (num >> i) & 1;
                if (node.child[bit] == null) {
                    node.child[bit] = new Trie();
                }
                node = node.child[bit];
                --i;
            }
            node.k = num;
        }
        // 求数值num与字典树中的数值的最大异或
        public int maxXOR(int num) {
            Trie node = this;
            int i = 31;
            while (i >= 0) { // 想要异或值越大越好，那么就看bit ^ 1的位置是否存在。
                int bit = (num >> i) & 1;
                if (node.child[bit ^ 1] != null) {
                    node = node.child[bit ^ 1];
                } else {
                    node = node.child[bit];
                }
                --i;
            }
            return num ^ node.k;
        }
    }
}
