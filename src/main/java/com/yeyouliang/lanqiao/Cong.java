package com.yeyouliang.lanqiao;

/**
 * Created by YYL on 2021/4/12 : 22:46.
 */
public class Cong {
    /**
     * 振兴中华
     * 小明参加了学校的趣味运动会，其中的一个项目是：跳格子。
     * 地上画着一些格子，每个格子里写一个字，如下所示：
     * 从我做起振
     * 我做起振兴
     * 做起振兴中
     * 起振兴中华
     * 比赛时，先站在左上角的写着“从”字的格子里，可以横向或纵向跳到相邻的格子里，但不能跳到对角的格子或其它位置。一直要跳到“华”字结束。
     * 要求跳过的路线刚好构成“从我做起振兴中华”这句话。
     * 请你帮助小明算一算他一共有多少种可能的跳跃路线呢？
     */
    public static void main(String[] args) {
        Node hua = new Node("华", null, null);
        Node zhong1 = new Node("中", null, hua);
        Node zhong2 = new Node("中", hua, null);
        Node xing1 = new Node("兴", null, zhong1);
        Node xing2 = new Node("兴", zhong1, zhong2);
        Node xing3 = new Node("兴", zhong2, null);
        Node zhen1 = new Node("振", null, xing1);
        Node zhen2 = new Node("振", xing1, xing2);
        Node zhen3 = new Node("振", xing2, xing3);
        Node zhen4 = new Node("振", xing3, null);
        Node qi1 = new Node("起", zhen1, zhen2);
        Node qi2 = new Node("起", zhen2, zhen3);
        Node qi3 = new Node("起", zhen3, zhen4);
        Node qi4 = new Node("起", zhen4, null);
        Node zuo1 = new Node("做", qi1, qi2);
        Node zuo2 = new Node("做", qi2, qi3);
        Node zuo3 = new Node("做", qi3, qi4);
        Node wo1 = new Node("我", zuo1, zuo2);
        Node wo2 = new Node("我", zuo2, zuo3);
        Node cong = new Node("从", wo1, wo2);
        int[] count = new int[1];
        co(cong, count);
        System.out.println(count[0]);
    }

    public static void co(Node root, int[] count) {
        if ("华".equals(root.getContent())) {
            count[0]++;
            return;
        }
        Node right = root.getRight();
        Node down = root.getDown();
        if (right != null) {
            co(right, count);
        }
        if (down != null) {
            co(down, count);
        }
    }

    private static class Node {
        String content;
        Node right;
        Node down;

        public Node(String content, Node right, Node down) {
            this.content = content;
            this.right = right;
            this.down = down;
        }

        public String getContent() {
            return content;
        }

        public Node getRight() {
            return right;
        }

        public Node getDown() {
            return down;
        }
    }
}
