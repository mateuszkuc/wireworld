package wireworld;

import javax.swing.JFrame;

public class Main
{
    int[][] board;
    int ROWS = 32;
    int COLUMNS = 32;

    public Main()
    {
        this.board = new int[this.COLUMNS][this.ROWS];
    }

    public void start()
    {
        new BoardInput();
    }

    public static void main(String[] args)
    {
        Main m = new Main();
        m.start();
    }
}

