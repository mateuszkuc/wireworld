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

        setDefaultCloseOperation(2);
        pack();
        setVisible(true);
    }

}




