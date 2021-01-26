package com.quaint.algorithm.year2021.january;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> qu = new ArrayList<>();
        List<String> qu1 = new ArrayList<>();
        qu1.add("Gabe");
        qu1.add("Gabe0@m.co");
        qu1.add("Gabe1@m.co");
        List<String> qu2 = new ArrayList<>();
        qu2.add("Gabe");
        qu2.add("Gabe3@m.co");
        qu2.add("Gabe4@m.co");
        List<String> qu3 = new ArrayList<>();
        qu3.add("Gabe");
        qu3.add("Gabe4@m.co");
        qu3.add("Gabe5@m.co");
        List<String> qu4 = new ArrayList<>();
        qu4.add("Gabe");
        qu4.add("Gabe2@m.co");
        qu4.add("Gabe3@m.co");
        List<String> qu5 = new ArrayList<>();
        qu5.add("Gabe");
        qu5.add("Gabe1@m.co");
        qu5.add("Gabe2@m.co");
        qu.add(qu1);
        qu.add(qu2);
        qu.add(qu3);
        qu.add(qu4);
        qu.add(qu5);
        List<List<String>> lists = solution.accountsMerge(qu);
        lists.forEach(li -> {
            li.forEach(System.out::print);
            System.out.println();
        });
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        for(List<String> node : accounts) {
            uf.union(node);
        }
        int size = uf.parent.size();
        List<List<String>> ufParent = new ArrayList<>(uf.parent);
        uf.parent.clear();
        ufParent.forEach(uf::union);
        while (size != uf.parent.size()) {
            size = uf.parent.size();
            ufParent = new ArrayList<>(uf.parent);
            uf.parent.clear();
            ufParent.forEach(uf::union);
        }
        return uf.parent;
    }

    public class UnionFind {

        public List<List<String>> parent;

        public UnionFind(int size){
            this.parent = new ArrayList<>(size);
        }

        public void union(List<String> user) {
            int pIdx = find(user);
            if(pIdx > -1) {
                // 如果还有父 类没有合并
                int ppIdx = find(parent.get(pIdx));
                if(ppIdx > -1 && ppIdx != pIdx) {
                    union(parent.get(pIdx));
                }
                this.addAndRmDup(parent.get(pIdx), user);
            } else {
                user = user.stream().distinct().collect(Collectors.toList());
                user.sort(String::compareTo);
                parent.add(user);
            }
        }

        // 寻找 父节点有没有该元素
        public int find(List<String> user) {
            for(int j = 0;j < parent.size(); j++){
                if(parent.get(j).get(0).equals(user.get(0))) {
                    for(int i = 1; i < user.size(); i++) {
                        if(parent.get(j).contains(user.get(i))) {
                            return j;
                        }
                    }
                }
            }
            return -1;
        }

        // 判断是否相等
        public boolean isEquals(List<String> list1, List<String> list2) {
            if(list1.size()!=list2.size()) {
                return false;
            }
            for(int i = 0;i < list1.size(); i++) {
                if (!list1.get(i).equals(list2.get(i))) {
                    return false;
                }
            }
            return true;
        }

        // 去重重复元素
        public void addAndRmDup(List<String> addTo, List<String> addFrom){
            for(String f : addFrom) {
                if (!addTo.contains(f)) {
                    addTo.add(f);
                }
            }
            addTo.sort(String::compareTo);
        }

    }

}