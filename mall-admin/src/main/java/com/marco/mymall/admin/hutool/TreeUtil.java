package com.marco.mymall.admin.hutool;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONString;
import cn.hutool.json.JSONUtil;
import com.marco.mymall.admin.bo.UserTree;

import java.util.List;

public class TreeUtil {
    public static void main(String[] args) {
        /*List<TreeNode<UserTree>> treeNodeList = CollUtil.newArrayList();
        TreeNode<UserTree> treeTreeNode = new TreeNode<>();

        treeNodeList.add();
        cn.hutool.core.lang.tree.TreeUtil.build();*/
        // 构建node列表
        List<TreeNode<String>> nodeList = CollUtil.newArrayList();

        nodeList.add(new TreeNode<>("1", "0", "系统管理", 5));
        nodeList.add(new TreeNode<>("11", "1", "用户管理", 222222));
        nodeList.add(new TreeNode<>("111", "11", "用户添加", 0));
        nodeList.add(new TreeNode<>("2", "0", "店铺管理", 1));
        nodeList.add(new TreeNode<>("21", "2", "商品管理", 44));
        nodeList.add(new TreeNode<>("221", "2", "商品管理2", 2));
        nodeList.add(new TreeNode<>("222", "221", "商品管理2son", 2));
        // 0表示最顶层的id是0
        List<Tree<String>> treeList = cn.hutool.core.lang.tree.TreeUtil.build(nodeList, "0");
        JSONArray jsonArray = new JSONArray(treeList);
        /*System.out.println(jsonArray.jsonIter());
        System.out.println(jsonArray);
        JSONObject jsonObject = new JSONObject();*/
        Console.log(jsonArray );
        Console.log(jsonArray.getByPath("1"));
        Console.log(jsonArray.toList(UserTree.class));

    }
}
