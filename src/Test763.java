import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test763 {
    public List<Integer> partitionLabels(String S) {
        // 先用HashMap存每个字符对应的最后index;
        List<Integer> res = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap();
        for(int i = 0; i < S.length(); i++){
            map.put(S.charAt(i),i);
        }
        int firstIndex = 0;
        while(firstIndex < S.length()){
            //初始化当前的lastIndex，取当前字符的最后index
            int lastIndex = map.get(S.charAt(firstIndex));
            int currIndex = firstIndex;
            //当某一区间内的字符的lastIndex小于当前的lastIndex
            while(currIndex < lastIndex){
                //当前index表示的字符的最后index若大于当前lastIndex
                //则更新lastIndex为此字符的lastIndex
                if(map.get(S.charAt(currIndex)) > lastIndex){
                    lastIndex = map.get(S.charAt(currIndex));
                }
                currIndex++;
            }
            //添加区间长度
            res.add(lastIndex - firstIndex + 1);
            //赋值下一区间的firstIndex
            firstIndex = lastIndex + 1;
        }
        return res;
    }
}
