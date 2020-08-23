import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test127 {
    //BFS的思想
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();//少不了队列
        queue.add(beginWord);//加入起始词
        boolean[] marked = new boolean[wordList.size() + 1];//少不了标记
        int layer = 1;//注意返回的是层数+1.所以这里直接放1了
        while(!queue.isEmpty()) {//固定的层数记录形式
            layer++;
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if(marked[i])
                        continue;
                    String dic = wordList.get(i);
                    if(canChange(dic, cur)) {
                        //先到达endWord就是最快换取法
                        if(dic.equals(endWord))
                            return layer;
                        //将当前词能改的词都存入队列
                        queue.add(dic);
                        marked[i] = true;
                    }
                }
            }
        }
        return 0;
    }
    //是否可以转换的辅助函数
    public boolean canChange(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != t.charAt(i))
                diff++;
        }
        return diff == 1;
    }
}
