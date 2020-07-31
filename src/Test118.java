import java.util.ArrayList;
import java.util.List;

public class Test118 {
    public List<List<Integer>> generate(int numRows) {
        //curList[j]==lastList[j]+lastList[j-1]
        List<List<Integer>> ansList = new ArrayList<>();
        if (numRows == 0) return ansList;
        List<Integer> lastList = new ArrayList<>();
        lastList.add(1);
        ansList.add(lastList);
        System.out.println(ansList);
        for (int i = 1; i < numRows; i++) {
            List<Integer> curList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j==0 || j==i){
                    curList.add(1);
                }else {
                    curList.add(lastList.get(j)+lastList.get(j-1));
                }
            }
            System.out.println(curList);
            ansList.add(curList);
            lastList = curList;
        }
        return ansList;
    }

}
