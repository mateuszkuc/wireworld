package wireworld;
import java.awt.Dialog;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class BoardInput
        extends JDialog
{
    int[][] board;


    public BoardInput(int[][] inboard)
    {
        super((Dialog)null, true);
        setTitle("Symulacja WireWorld - Mateusz Kuc");
        this.board = inboard;

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

        setDefaultCloseOperation(2);
        pack();
        setVisible(true);
    }

}




