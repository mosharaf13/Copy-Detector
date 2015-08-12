import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Main extends JFrame{

	public static void main(String[] args) {
		new Main();
	}
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 600);
		setLocationRelativeTo(null);
		JTextArea are = new JTextArea();
		
//		JTextPane pan = new JTextPane();
//
//		JScrollPane jp = new JScrollPane(pan);
//		jp.setSize(500, 400);
//		jp.setLocation(100, 40);
		JScrollPane pane = new JScrollPane(are);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setSize(500, 400);
		pane.setLocation(100, 50);
		
		
		add(pane);
		
		setVisible(true);
	}

}
