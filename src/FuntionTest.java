import java.util.ArrayDeque;
import java.util.List;

public class FuntionTest {
    public static void main(String[] args) {
//        System.out.println(Math.pow(10, 2));
//        System.out.println(5^6^6);
//        test118 t118 = new test118();
//        System.out.println(t118.generate(5));
//        int n =11;
//        System.out.println(n);
//        n >>>= 1;
//        System.out.println(n);
//        String s = "ai";
//        Test345 test345_ = new Test345();
//        String ans = test345_.reverseVowels(s);
//        System.out.println(ans);
//        Test1403 test1403 = new Test1403();
//        int[] testArr = {6};
//        System.out.println(test1403.minSubsequence(testArr));
//        Test1029 test1029 = new Test1029();
//        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
//        test1029.twoCitySchedCost(costs);
//        Test1005 test1005 = new Test1005();
//        int[] test = {4,2,3};
//        System.out.println(test1005.largestSumAfterKNegations(test, 1));
//        int[] test1 = {4,-1,4,-2,4};
//        int[][] test2 = {{2,4}};
//        Test874 test874 = new Test874();
//        System.out.println(test874.robotSim(test1,test2));
//        String num1 = "54321789";
//        int len = num1.length()-1;
//        int ans = (int)num1.charAt(len);
//        System.out.println(ans);
//        Test202 test202 = new Test202();
//        test202.isHappy(19);
//        Test1047 test1047 = new Test1047();
//        System.out.println(test1047.removeDuplicates("abbaca"));


//        Test19 test19 = new Test19();
//        ListNode listNode = new ListNode();
//        listNode.val = 1;
//        listNode.next = null;
//        test19.removeNthFromEnd(listNode,1);
//        Test24 test24 = new Test24();
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = null;
//        test24.swapPairs(node1);
//        while (node2 != null){
//            System.out.println(node2.val);
//            node2 = node2.next;
//        }
//        int k = 5;
//        ListNode[] ans = new ListNode[k];
//        for (int i = 0; i < k; i++) {
//            if (ans[i] == null) {
//                System.out.println("null");
//            }
//        }
//        Test739 test739 = new Test739();
//        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
//        int[] ans = test739.dailyTemperatures(T);
////        for (int i = 0; i < ans.length; i++) {
////            System.out.println(ans[i]);
////        }
//        int[] dist = new int[5];
//        for (int i = 0; i < dist.length; i++) {
//            System.out.println(dist[i]);
//        }
//        int[] test = {1,2,4,3,1};
//        Test503 test503 = new Test503();
//        int[] ans = test503.nextGreaterElements(test);
//        for (int i = 0; i < ans.length; i++) {
//            System.out.println(ans[i]);
//
//        }
//
//        Test594 test594 = new Test594();
//        int[] test = {1,3,2,2,5,2,3,7};
//        test594.findLHS(test);

//        int[] test = {100, 4, 4, 200, 1, 3, 2};
//        Test128 test128 = new Test128();
//        test128.longestConsecutive(test);
//        Test378 test378 = new Test378();
//        int[][] test ={
//                {1,  5,  9},
//                {10, 11, 13},
//                {12, 13, 15}
//                };
//        test378.kthSmallest(test,8);

//       Test287 test287 = new Test287();
//       int[] test = {1,3,4,2,3};
//       test287.findDuplicate(test);
//        Test540 test540 = new Test540();
//        int[] test = {1,1,2,3,3,4,4,8,8};
//        test540.singleNonDuplicate(test);
//        Test34 test34 = new Test34();
//        int[] nums = {5,7,8,8,8,8,8,8,8,8,9,9,9,9,9,9,10};
//        int target = 8;
//        int[] ans = test34.searchRange(nums,target);
//        System.out.println(ans[0]+"::::"+ans[1]);
//        Test733 test733 = new Test733();
//        int[][] testArr = {
//                {1,1,1},
//                {1,1,0},
//                {1,0,1}};
//        test733.floodFill(testArr,1,1,2);
//        for (int i = 0; i < testArr.length; i++) {
//            for (int j = 0; j < testArr[0].length; j++) {
//                System.out.print(testArr[i][j]);
//            }
//            System.out.println("");
//        }
//        Test109 test109 = new Test109();
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
//        ListNode node7 = new ListNode(7);
//        ListNode node8 = new ListNode(8);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = null;
//        test109.sortedListToBST(node1);
//        Test279 test279 = new Test279();
//        test279.numSquares(12);
//        Test204 test204 = new Test204();
//        test204.countPrimes(20);
//        int[] test = {1,2,3,4};
//        Test238 test238 = new Test238();
//        test238.productExceptSelf(test);

//        int x = 1, y = 4;
//        System.out.println(x^y);
//        Test461 test461 = new Test461();
//        int ans = test461.hammingDistance(3,4);
//        System.out.println(ans);
//        for (int i = 1; i < 10; i++) {
//            System.out.println(i&(i-1));
//        }
//        Test201 test201 = new Test201();
//        int ans = test201.rangeBitwiseAnd(5,7);
//        System.out.println(ans);
//        Test279 test279 = new Test279();
//        int ans = test279.numSquares(13);
//        System.out.println(ans);
//        String s = "ababababab";
//        System.out.println((s + s).indexOf(s, 1));
//        Test491 test491 = new Test491();
//        int[] test = {4,6,7,7};
//        test491.findSubsequences(test);
//        Test17 test17 = new Test17();
//        List<String> ans = test17.letterCombinations("234");
//        for (int i = 0; i < ans.size(); i++) {
//            System.out.println(ans.get(i));
//        }
//        Test93 test93 = new Test93();
//        test93.restoreIpAddresses("25525511135");
//        Test39 test39 = new Test39();
//        test39.combinationSum(new int[]{2, 3, 6, 7},7);
//        Test214 test214 = new Test214();
//        test214.shortestPalindrome("aacecaaa");
//        Test78 test78 = new Test78();
//        test78.subsets(new int[]{1, 2, 3});
//        Test241 test241 = new Test241();
//        String test = "2-1-1";
//        test241.diffWaysToCompute(test);
//        Test51 test51 = new Test51();
//        List<List<String>> ans = test51.solveNQueens(4);
//        for (List<String> temp : ans) {
//            for (String temp2 : temp) {
//                System.out.println(temp2);
//            }
//        }
//    }
//        Test451 test451 = new Test451();
//        String ans = test451.frequencySort("tree");
//        Test435 test435 = new Test435();
//        int[][] test = {{1,2}, {2,3}, {3,4}, {1,3}};
//        test435.eraseOverlapIntervals(test);
//        Test406 test406 = new Test406();
//        int[][] testArr = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
//        test406.reconstructQueue(testArr);


//        Test1143 test1143 = new Test1143();
//        String text1 = "abcde";
//        String text2 = "ace";
//        test1143.longestCommonSubsequence(text1, text2);

//        Test416 test416 = new Test416();
//        int[] test = {1, 5, 11, 5};
//        boolean f = test416.canPartition(test);

//        Test474 test474 = new Test474();
//        String[] strs= {"10", "0001", "111001", "1", "0"};
//        test474.findMaxForm(strs,5,3);
//
//        Test322 test322 = new Test322();
//        int[] test = {2};
//        test322.coinChange(test,3);
//        Test117 test117 = new Test117();
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.right = new Node(7);
//        Node temp = root;
//        ArrayDeque<Node> queue = new ArrayDeque<>(20);
//        //首先将根节点加入栈中
//        queue.add(temp);
//        //遍历二叉树
//        while (!queue.isEmpty()) {
//            Node tempNode = queue.poll();
//            System.out.print(tempNode.val + " ");
//
//            if(tempNode.left != null){
//                queue.add(tempNode.left);
//            }
//            if(tempNode.right != null){
//                queue.add(tempNode.right);
//            }
//        }
//        System.out.println("");
//        test117.connect(root);

//        Test518 test518 = new Test518();
//        int amount = 5;
//        int[] coins =new int[]{1, 2, 5};
//        test518.change(amount, coins);

//        Test123 test123 = new Test123();
//        int[] test = new int[]{3,3,5,0,0,3,1,4};
//        test123.maxProfit(test);
//        Test583 test583 = new Test583();
//        test583.minDistance("sea", "eat");



    }
}
