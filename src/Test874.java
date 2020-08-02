import java.util.HashSet;
import java.util.Set;

public class Test874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for(int[] obstacle:obstacles){
            set.add(obstacle[0] + "," + obstacle[1]);
        }
        int ans = 0;
        //分别代表不同方向上（上右下左），前进一步时x和y发生的变化（0列为x变化，1列为y变化）
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //now是现在前进的方向，0123代表上右下左
        int now = 0, x1, y1;
        int[] position={0,0};
        for(int command:commands){
            if(command == -1){
                now++;
                if(now > 3){
                    now = 0;
                }
            }else if(command == -2){
                now--;
                if(now < 0){
                    now = 3;
                }
            }else{
                for (int i = 0; i < command; i++) {
                    x1 = position[0] + direction[now][0];
                    y1 = position[1] + direction[now][1];
                    if (!set.contains(x1 + "," + y1)) {
                        position[0] = x1;
                        position[1] = y1;
                        ans=Math.max((int)(Math.pow(position[0],2) + Math.pow(position[1],2)), ans);
                    }
                }
            }
        }
        return ans;
    }

    //答案超时了
//    public int robotSim(int[] commands, int[][] obstacles) {
//        int ans = 0;
//        int x=0, y=0;
//        //1、2、3、4代表上、右、下、左
//        int direction = 1;
//        for (int i = 0; i < commands.length; i++) {
//            if (1 <= commands[i] && commands[i] <= 9) {
//                if (direction == 1){
//                    for (int j = 0; j < commands[i]; j++) {
//                        if (isObstacles(x, y+1, obstacles))
//                            break;
//                        y++;
//                    }
//                }
//                else if (direction == 2){
//                    for (int j = 0; j < commands[i]; j++) {
//                        if (isObstacles(x+1, y, obstacles))
//                            break;
//                        x++;
//                    }
//                }
//                else if (direction == 3 ){
//                    for (int j = 0; j < commands[i]; j++) {
//                        if (isObstacles(x, y-1, obstacles))
//                            break;
//                        y--;
//                    }
//                }
//                else if (direction == 4){
//                    for (int j = 0; j < commands[i]; j++) {
//                        if (isObstacles(x-1, y, obstacles))
//                            break;
//                        x--;
//                    }
//                }
//            }else if (commands[i] == -2){
//                if (direction == 1)
//                    direction = 4;
//                else if (direction == 2)
//                    direction = 1;
//                else if (direction == 3)
//                    direction = 2;
//                else if (direction == 4)
//                    direction = 3;
//            }else if (commands[i] == -1){
//                if (direction == 1)
//                    direction = 2;
//                else if (direction == 2)
//                    direction = 3;
//                else if (direction == 3)
//                    direction = 4;
//                else if (direction == 4)
//                    direction = 1;
//            }
//            ans = Math.max(ans, x * x + y * y);
//        }
//        return ans;
//    }
//
//    public boolean isObstacles(int x, int y, int[][] obstacles){
//        for (int i = 0; i < obstacles.length; i++) {
//            for (int j = 0; j < obstacles[i].length; j++) {
//                if (obstacles[i][0] == x && obstacles[i][1] == y)
//                    return true;
//            }
//        }
//        return false;
//    }

}
