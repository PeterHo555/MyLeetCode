import java.util.ArrayList;
import java.util.List;

public class test119 {
    public List<Integer> getRow(int rowIndex) {
        //小改杨辉三角1的代码
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> lastList = new ArrayList<>();
        lastList.add(1);
        if (rowIndex == 0) return lastList;
        ansList.add(lastList);
        System.out.println(ansList);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> curList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j==0 || j==i){
                    curList.add(1);
                }else {
                    curList.add(lastList.get(j)+lastList.get(j-1));
                }
            }
            ansList.add(curList);
            lastList = curList;
        }
        return ansList.get(rowIndex);
    }
}
