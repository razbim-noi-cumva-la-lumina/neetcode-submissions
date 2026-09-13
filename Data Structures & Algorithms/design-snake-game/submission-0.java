class SnakeGame {
    final int w, h;
    final int[][] food;

    int r=0, c=0, score=0, dr=1, dc=0;
    final Queue<int[]> q = new LinkedList<>();

    public SnakeGame(int width, int height, int[][] food) {
        w = width;
        h = height;
        this.food = food;
        q.add(new int[]{0, 0});
    }
    
    public int move(final String direction) {
        System.out.println(r + " " + c + " " + score);
        switch (direction) {
            case "U":
                dr = -1; dc = 0;
                break;
            case "D":
                dr = 1; dc = 0;
                break;
            case "L":
                dr = 0; dc = -1;
                break;
            case "R":
                dr = 0; dc = 1;
                break;
        }

        r += dr;
        c += dc;
        if (r < 0 || r >= h || c < 0 || c >= w) return -1;

        if (score < food.length && food[score][0] == r && food[score][1] == c) ++score;
        else q.remove();

        if (bite()) return -1;
        q.add(new int[]{r, c});

        return score;
    }

    private boolean bite() {
        for (final int[] pos : q) {
            if (pos[0] == r && pos[1] == c) return true;
        }
        return false;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
