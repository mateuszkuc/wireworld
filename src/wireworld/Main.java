package wireworld;

public class Main
{
    int[][] board;
    int ROWS = 32;
    int COLUMNS = 32;

    public int getNeighbours(int c, int r)
    {
        int sum = 0;
        if (this.board[(c - 1)][(r - 1)] == 1) {
            sum++;
        }
        if (this.board[c][(r - 1)] == 1) {
            sum++;
        }
        if (this.board[(c + 1)][(r - 1)] == 1) {
            sum++;
        }
        if (this.board[(c - 1)][r] == 1) {
            sum++;
        }
        if (this.board[(c + 1)][r] == 1) {
            sum++;
        }
        if (this.board[(c - 1)][(r + 1)] == 1) {
            sum++;
        }
        if (this.board[c][(r + 1)] == 1) {
            sum++;
        }
        if (this.board[(c + 1)][(r + 1)] == 1) {
            sum++;
        }
        return sum;
    }

    public Main()
    {
        this.board = new int[this.COLUMNS][this.ROWS];
    }

    public void start()
    {
        new BoardInput(this.board);
    }

    public static void main(String[] args)
    {
        Main m = new Main();
        m.start();
    }
}

