package wireworld;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class BoardInput
        extends JDialog
{
    int ROWS;
    int COLUMNS;
    int[][] board;

    public class DrawingPanel
            extends JPanel
    {
        BoardInput BI;
        int BLOCKSIZE = 15;

        DrawingPanel(BoardInput b)
        {
            this.BI = b;
            setPreferredSize(new Dimension(BoardInput.this.COLUMNS * this.BLOCKSIZE + 1, BoardInput.this.ROWS * this.BLOCKSIZE + 1));
        }

        public void paintComponent(Graphics g)
        {
            for (int r = 0; r < BoardInput.this.ROWS; r++) {
                for (int c = 0; c < BoardInput.this.COLUMNS; c++)
                {
                    int x = c * this.BLOCKSIZE;
                    int y = r * this.BLOCKSIZE;

                    switch (BoardInput.this.board[c][r])
                    {
                        case 0:
                            g.setColor(Color.black);
                            break;
                    }

                    g.fillRect(x, y, this.BLOCKSIZE, this.BLOCKSIZE);
                    g.setColor(Color.darkGray);
                    g.drawRect(x, y, this.BLOCKSIZE, this.BLOCKSIZE);
                }
            }
        }
    }

    public BoardInput(int[][] inboard)
    {
        super((Dialog)null, true);
        setTitle("Symulacja WireWorld - Mateusz Kuc");
        this.board = inboard;
        this.ROWS = this.board[0].length;
        this.COLUMNS = this.board.length;

        JPanel p = new JPanel();
        JButton pusta = new JButton("Pusta");
        JButton przewodnik = new JButton("Przewodnik");
        JButton glowa = new JButton("Glowa");
        JButton ogon = new JButton("Ogon");
        JButton generuj = new JButton("Generuj");

        p.add(pusta);
        p.add(przewodnik);
        p.add(glowa);
        p.add(ogon);
        p.add(generuj);
        add(p, "South");

        DrawingPanel d = new DrawingPanel(this);
        add(d, "Center");

        setDefaultCloseOperation(2);
        pack();
        setVisible(true);
    }

}




