package org.example.jzoffer;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {

    // 顺序打印线程
    public static void test1() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1...");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2...");
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread3...");
            }
        });

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
    }

    private static ReentrantLock lock = new ReentrantLock();
    private static int states = 0;

    static class Thread1 extends Thread {


        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (states % 3 == 0) {
                        System.out.println("A");
                        states++;
                        i++;
                    }
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (states % 3 == 1) {
                        System.out.println("B");
                        states++;
                        i++;
                    }
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Thread3 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (states % 3 == 2) {
                        System.out.println("C");
                        states++;
                        i++;
                    }
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }


    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;

        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 顺时针打印矩阵
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     *
     * 1    2   3   4
     * 5    6   7   8
     * 9    10  11  12
     * 13   14  15  16
     */


    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
     * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
     * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     * 窗口大于数组长度的时候，返回空
     */
    public static ArrayList<Integer> windows(int[] num, int size) {
        if (num == null || num.length == 0 || size > num.length || size == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num.length - size + 1; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(num[i]);
            int max = num[i];
            for (int j = i; j < i + size - 1; j++) {
                max = Math.max(max, num[j + 1]);
                sb.append(num[j + 1]);
            }
            System.out.println(sb.toString());
            list.add(max);
        }
        return list;
    }


    /**
     * 1
     * 2               3
     * 4       5       6       7
     * <p>
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     * {8,6,10,5,7,9,11}
     * [[8],[10,6],[5,7,9,11]]
     * <p>
     * <p>
     * 之字形打印二叉树
     */
    private static void printZTreeNode(TreeNode root) {
        ArrayList list = new ArrayList();
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();//8 6,10 5,7,9,11
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        deque.add(root);
        boolean leftToRight = true;
        int start = 0, end = 1;
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            layerList.add(poll.val);
            start++;
            if (poll.left != null) {
                deque.add(poll.left);
            }
            if (poll.right != null) {
                deque.add(poll.right);
            }

            if (start == end) {
                end = deque.size();
                start = 0;
                if (!leftToRight) {
                    list.add(reverse(layerList));
                } else {
                    list.add(layerList);
                }
                leftToRight = !leftToRight;
                layerList = new ArrayList<Integer>();
            }
        }

    }

    private static ArrayList reverse(ArrayList<Integer> layerList) {
        int length = layerList.size();
        ArrayList<Integer> reverseList = new ArrayList<Integer>();
        for (int i = length - 1; i >= 0; i--) {
            reverseList.add(layerList.get(i));
        }
        return reverseList;
    }

    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     * {8,6,10,5,7,9,11}
     */


    private static ArrayList printLineTreeNode(TreeNode pRoot) {
        ArrayList list = new ArrayList();
        if (pRoot == null) {
            return list;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        deque.add(pRoot);
        int start = 0, end = 1;
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            layerList.add(poll.val);
            start++;
            if (poll.left != null) {
                deque.add(poll.left);
            }
            if (poll.right != null) {
                deque.add(poll.right);
            }

            if (start == end) {
                end = deque.size();
                start = 0;
                list.add(layerList);
                layerList = new ArrayList<Integer>();
            }
        }
        return list;
    }




    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
     * 中序遍历
     * {5,3,7,2,4,6,8},3
     * 4
     * <p>
     * {8,6,10,5,7,9,11},7
     */
    private static TreeNode topk(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        ArrayList<TreeNode> nodes = getNodes(pRoot, list);
        return k - 1 > nodes.size() - 1 || k - 1 < 0 ? null : nodes.get(k - 1);
    }

    private static ArrayList<TreeNode> getNodes(TreeNode pRoot, ArrayList<TreeNode> list) {
        if (pRoot == null) {
            return null;
        }

        getNodes(pRoot.left, list);
        list.add(pRoot);
        getNodes(pRoot.right, list);

        return list;
    }

    /**
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
     * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
     */

    public void Insert(Integer num) {

    }

    public Double GetMedian() {
        return null;
    }


    /**
     *
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

        public TreeLinkNode GetNext(TreeLinkNode pNode) {
             if (pNode == null) {
                return null;
             }

            TreeLinkNode head = pNode;
             LinkedList<TreeLinkNode> list = new LinkedList<>();
             while (head.next != null) {
                 head = head.next;
             }

             midOrder(head, list);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == pNode && i != list.size() - 1) {
                    return list.get(i+1);
                }
            }
            return null;
        }

        private void midOrder(TreeLinkNode pNode, LinkedList<TreeLinkNode> list) {
            if (pNode == null) {
                return;
            }
            midOrder(pNode.left, list);
            list.add(pNode);
            midOrder(pNode.right, list);
        }



    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }





    /**
     * JZ56
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode pre = head;
        ListNode last = head.next;
        while (last != null) {
            if (last.next != null && last.next.val == last.val) {
                while (last.next != null && last.next.val == last.val) {
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            } else {
                pre = pre.next;
                last = last.next;
            }
        }
        return head.next;
    }


    /**
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     */


    ArrayList<String> result = new ArrayList();
    StringBuffer sb = new StringBuffer();
    String str = new String();
    int sum = 0;
    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int sumNumbers (TreeNode root) {
        if (root == null) return 0;
        // write code here

        path(root);
        return sum;
    }

    private void path(TreeNode root) {
        sb.append(root.val + "");
//         str += root.val;
        if (root.left == null && root.right == null) {
            int num =  Integer.parseInt(sb.toString());
            sum += num;
        }

        if (root.left != null) {
            path(root.left);
        }
        if (root.right != null) {
            path(root.right);
        }
        sb = new StringBuffer(sb.substring(0, sb.length() - 1));
    }

    Map<String, Integer> map = new HashMap<>();
    int num = 0;


    public boolean hasPathSum (TreeNode root, int sum) {
        if (root == null) return false;
        dfs(root);
        return map.containsKey(sum + "");
    }

    private void dfs(TreeNode root) {
        num += root.val;
        if (root.left == null && root.right == null) {
            map.put(num + "", num);
        }

        if (root.left != null)
            dfs(root.left);
        if (root.right != null)
            dfs(root.right);

        num -= root.val;
        }

    /**
     * 给出一个仅包含字符'('和')'的字符串，计算最长的格式正确的括号子串的长度。
     * 对于字符串"(()"来说，最长的格式正确的子串是"()"，长度为2.
     * 再举一个例子：对于字符串")()())",来说，最长的格式正确的子串是"()()"，长度为4.
     */

    public static int longestValidParentheses (String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        if (s == null || s.length() == 0) return 0;
        for (int i =0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    count += 2;
                }
            }
        }
        return  count;
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        if(n < 2) return n;
        int res = 0;
        HashSet set = new HashSet();
        int i = 0, j = 0;
        while (j < n) {
            if (!set.contains(a[j])) {
                set.add(a[j]);
                j++;
            } else {
                set.remove(a[i]);
                i++;
            }
            res = Math.max(res, set.size());
        }
        return res;
    }

    public static int maxLength (int[] arr) {
        // write code here
        if (arr == null || arr.length == 0)return 0;
        Map<Integer, Integer> map = new LinkedHashMap();
        int maxLen = 0;
        int i = 0;
        while (i < arr.length) {
            if (map.containsKey(arr[i])) {
                i = map.get(arr[i]);
                maxLen = Math.max(maxLen, map.size());
                map = new LinkedHashMap();
            } else {
                map.put(arr[i], i);
            }
            i++;
        }
        maxLen = Math.max(maxLen, map.size());
        System.out.println(maxLen);
        return maxLen;
    }


    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);


//        new Thread1().start();
//        new Thread2().start();
//        new Thread3().start();
//        int[] array = {10,14,12,11};
//        ArrayList<Integer> windows = windows(array, 0);
//        System.out.println(Arrays.asList(windows));
//        TreeNode root = new TreeNode(2);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(3);
//        root.left = node1;
//        root.right = node2;
//        TreeNode topk = topk(root, 2);
//        System.out.println(topk.val);

        int[] arr = new int[]{2,3,2,4,5,5,5};
//        maxLength(arr);
//        int i = lengthOfLongestSubstring("2324555");

        sort(arr);
        System.out.println(Arrays.asList(arr));
        for (int i =0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }




    public static int getLucklyNum(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= num; i++) {
            list.add(i);
        }

        int count = 1;
        for(int i = 0; list.size() != 1; i++) {
            if(i == list.size()) {
                i = 0;
            }

            if(count % 3 == 0) {
                list.remove(i--);
            }
            count++;
        }

        return list.get(0);
    }

    public static int game(int n,int num) {
        LinkedList<Integer> player=new LinkedList<Integer>();
        for(int i=1;i<=n;i++) {
            player.add(i);
        }
        while(player.size()>1) {
            player.addLast(player.removeFirst());
            player.addLast(player.removeFirst());
            player.removeFirst();
        }
        return player.getFirst();
    }



        public static void sort(int[] array) {
            if (array == null || array.length == 0 || array.length == 1) return;
            for (int i = 0 ; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - 1 - i; j++) {
                    if (array[j] > array[j+1]) {
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
        }


    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack1 = new Stack<>();
        while (head != null) {
            if (stack1.contains(head)) {
                return head;
            } else {
                stack1.push(head);
            }
            head = head.next;
        }
        return null;
    }


    /**
     * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
     * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
     * @param s
     * @return
     */
    public boolean isValid (String s) {

        return false;
    }








}

