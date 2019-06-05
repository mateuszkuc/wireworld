package wireworld;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main
    extends JFrame
    implements ActionListener
{
    int[][] board;
    int ROWS = 32;
    int COLUMNS = 32;
    DrawingPanel dp;
    boolean editRequested = true;

    public void actionPerformed(ActionEvent e)
    {
        this.editRequested = true;
    }

    public class DrawingPanel
            extends JPanel
    {
        int[][] BI;
        int BLOCKSIZE = 15;

        DrawingPanel(int[][] b)
        {
            this.BI = b;
            setPreferredSize(new Dimension(Main.this.COLUMNS * this.BLOCKSIZE + 1, Main.this.ROWS * this.BLOCKSIZE + 1));
        }

        public void paintComponent(Graphics g)
        {
            for (int r = 0; r < Main.this.ROWS; r++) {
                for (int c = 0; c < Main.this.COLUMNS; c++)
                {
                    int x = c * this.BLOCKSIZE;
                    int y = r * this.BLOCKSIZE;
                    switch (Main.this.board[c][r])
                    {
                        case 0:
                            g.setColor(Color.black);
                            break;
                        case 1:
                            g.setColor(Color.blue);
                            break;
                        case 2:
                            g.setColor(Color.red);
                            break;
                        case 3:
                            g.setColor(Color.yellow);
                    }
                    g.fillRect(x, y, this.BLOCKSIZE, this.BLOCKSIZE);
                    g.setColor(Color.darkGray);
                    g.drawRect(x, y, this.BLOCKSIZE, this.BLOCKSIZE);
                }
            }
        }
    }

    public Main()
    {
        setTitle("Symulacja WireWorld - Mateusz Kuc");
        this.board = new int[this.COLUMNS][this.ROWS];
        setDefaultCloseOperation(3);
        this.dp = new DrawingPanel(this.board);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(this.dp, "Center");
        JButton j = new JButton("Stop | Edycja");
        j.addActionListener(this);
        getContentPane().add(j, "South");
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
        for (;;)
        {
            new BoardInput(this.board);
            pack();
            setVisible(true);
            editRequested = false;
            while (!editRequested)
            {
                this.board = computeNextGeneration();
                this.dp.repaint();
                try
                {
                    Thread.sleep(200L);
                }
                catch (InterruptedException ex) {}
            }
        }
    }

    public static void main(String[] args)
    {
        Main m = new Main();
        m.start();
    }
}

