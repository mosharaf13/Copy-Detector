import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class button1 extends JFrame{

	public button1(String substr[],int matchedindex2[]) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		
		JTextPane pan = new JTextPane();
		
		pan.setBackground(Color.white);
		
		
		for(int i=0,j=0;i<substr.length;i++)
        {

	        if(i==matchedindex2[j])
        	{
	        	String[] s1=new String[10];
	        	
	        	s1=substr[i].split(",");
	        	for(int co=0;co<s1.length;co++)
	        	{
	        		pan.setText(substr[i]);
	        		pan.setForeground(Color.RED);
	        	}
	        
        		for(int k=0;matchedindex2[k]==matchedindex2[k+1];k++)
        		{
        			j++;
        			System.out.println(j);
        		}
        		j++;
        		
        	}
        	else
        	{
        		pan.setText(substr[i]);
        		pan.setForeground(Color.DARK_GRAY);
        	}
        	
        }
		JScrollPane jp = new JScrollPane(pan);
		jp.setSize(500, 400);
		jp.setLocation(100, 40);
		JScrollPane pane = new JScrollPane(pan);
		//pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setSize(500, 400);
		pane.setLocation(100, 50);
		
		
		add(pane);
		
		setVisible(true);
	}

}