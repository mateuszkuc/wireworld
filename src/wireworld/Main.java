package wireworld;

import javax.swing.JFrame;

public class Main
    extends JFrame
{
    int[][] board;
    int ROWS = 32;
    int COLUMNS = 32;

    public Main()
    {
        this.board = new int[this.COLUMNS][this.ROWS];
    }

    public int[][] computeNextGeneration()
    {
        int[][] boardNext = new int[this.COLUMNS][this.ROWS];
        for (int r = 1; r < this.ROWS - 1; r++) {
            for (int c = 1; c < this.COLUMNS - 1; c++) {
                switch (this.board[c][r])
                {
                    case 0:
                        boardNext[c][r] = this.board[c][r];
                        break;
                    case 1:
                        boardNext[c][r] = 2;
                        break;
                    case 2:
                        boardNext[c][r] = 3;
                        break;
                    case 3:
                        int n = getNeighbours(c, r);
                        if ((n == 1) || (n == 2)) {
                            boardNext[c][r] = 1;
                        } else {
                            boardNext[c][r] = 3;
                        }
                        break;
                }
            }
        }
        return boardNext;
    }

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

    public void start()
    {
        new BoardInput(this.board);
        pack();
        setVisible(true);
    }


    public static void main(String[] args)
    {
        Main m = new Main();
        m.start();
    }
}

