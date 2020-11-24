package org.example.jzoffer;

import com.alibaba.fastjson.JSONObject;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    public static void main(String[] args) {
        String s = JSONObject.toJSONString(new TreeNode(1));
        System.out.println(s);
    }
}