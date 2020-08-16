public class Test733 {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor != newColor) {
            dfs(image, sr, sc, currColor, newColor);
        }
        return image;
    }

    public void dfs(int[][] image, int x, int y, int currColor, int newColor) {
        //只有当前颜色与初始点一样再进行改色
        if (image[x][y] == currColor) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                //对四个方向的点DFS
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, currColor, newColor);
                }
            }
        }
    }
}
