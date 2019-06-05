package wireworld;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class BoardInput
        extends JDialog
        implements ActionListener
{
    int color = 3;
    int ROWS;
    int COLUMNS;
    int[][] board;

    public class DrawingPanel
    extends JPanel
    implements MouseListener, MouseMotionListener

    {
        BoardInput BI;
        int BLOCKSIZE = 15;

        public void mouseClicked(MouseEvent e) {}

        public void mousePressed(MouseEvent e)
        {
            colorBlock(e);
        }

        public void mouseReleased(MouseEvent e) {}

        public void mouseEntered(MouseEvent e) {}

        public void mouseExited(MouseEvent e) {}

        public void mouseDragged(MouseEvent e)
        {
            colorBlock(e);
        }

        public void mouseMoved(MouseEvent e) {}

        public void colorBlock(MouseEvent e)
        {
            int x = e.getX();
            int y = e.getY();
            x /= this.BLOCKSIZE;
            y /= this.BLOCKSIZE;
            BoardInput.this.board[x][y] = BoardInput.this.color;
            repaint();
        }

        DrawingPanel(BoardInput b)
        {
            this.BI = b;
            setPreferredSize(new Dimension(BoardInput.this.COLUMNS * this.BLOCKSIZE + 1, BoardInput.this.ROWS * this.BLOCKSIZE + 1));
            addMouseMotionListener(this);
            addMouseListener(this);
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

        pusta.setName("pusta");
        przewodnik.setName("przewodnik");
        glowa.setName("glowa");
        ogon.setName("ogon");
        generuj.setName("generuj");

        pusta.addActionListener(this);
        przewodnik.addActionListener(this);
        glowa.addActionListener(this);
        ogon.addActionListener(this);
        generuj.addActionListener(this);

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

    public void actionPerformed(ActionEvent e)
    {
        JButton b = (JButton)e.getSource();
        if (b.getName().equals("pusta")) {
            this.color = 0;
        }
        if (b.getName().equals("glowa")) {
            this.color = 1;
        }
        if (b.getName().equals("ogon")) {
            this.color = 2;
        }
        if (b.getName().equals("przewodnik")) {
            this.color = 3;
        }
        if (b.getName().equals("generuj")) {
            dispose();
        }
    }

}




