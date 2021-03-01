package theFirstProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.MenuBar;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
/**
*
* @author Hoak57uet
*/
public class SwingControlDemo extends JFrame{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MenuBar bar;
    public static JLabel welcome;
    public static JPanel extra;
    private JScrollPane sp;
    private JScrollBar sb;
    private JScrollBar sb_width;
    public SwingControlDemo(){

        extra = new JPanel();
    //    welcome = new JLabel("CHAO MUNG DEN VOI UNG DUNG BIEU DO CODE")
    //    extra.add(welcome);

        JPanel jp = new JPanel() {{ add(new JComponent() {
            { setPreferredSize(new Dimension(450, 450)); }
            });}};
 
        sp = new JScrollPane(extra,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Get the scroll-bar and make it a bit wider.
        sb = sp.getVerticalScrollBar();
        sb_width = sp.getHorizontalScrollBar();
        sb_width.setPreferredSize(new Dimension(20,10));
        sb.setPreferredSize(new Dimension(20, 10));

        // Put it to the right.
        sp.remove(sb);
        sp.remove(sb_width);
        jp.setLayout(new BorderLayout());
        jp.add(sp, BorderLayout.CENTER);
        jp.add(sb, BorderLayout.EAST);
        jp.add(sb_width,BorderLayout.SOUTH);
 
        bar = new MenuBar();
        this.setMenuBar(bar);
        this.add(jp);
      //  setLayout(new FlowLayout());
        setSize(1000,600);
        setVisible(true);

    }
    public static void main(String args [])throws IOException{
        SwingControlDemo main=new SwingControlDemo();
 
    }
}