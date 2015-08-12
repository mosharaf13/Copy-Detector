//import java.util.Random;
//import java.util.EnumSet;
//import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;






import java.util.Scanner;

class internal_Work extends JFrame
{
	int count=0;
	//String[] ans=new String[2000];
	int[] intindex=new int[2000];
	
	public void sentenceSpliter(String s1,String s2) {
		String[] s1bucket,s2bucket;
		
		s1 = s1.replaceAll("(\\r|\\n)", "");
		s2 = s2.replaceAll("(\\r|\\n)", "");
		
		System.out.println(s1);
		System.out.println(s2);
		
		
		s1bucket = s1.split("[.!?]");
		
		s2bucket = s2.split("[.!?]");
		
		
		int s1sentence= s1bucket.length;  //string array os the words
		int s2sentence= s2bucket.length;
		
		for(int i=0;i<intindex.length;i++)
			intindex[i]=-1;
		
		   //counter for the number of matched word	
	    count=0;
	    int repeatstopper[]=new int[2000];
	    //System.out.println(s2);
	    int k=0;
		for (int i = 0; i < s2sentence;i++)
		{
			for(int j=0;j<s1sentence;j++)
			{
				if(s1bucket[j].equals(s2bucket[i]))
				{
					if(intindex[i]==-1)
					{
						intindex[k]=i;
						//ans[k]=s2bucket[j];
	    				count++;
						k++;
						repeatstopper[j]=1;
					}				
				}
			}
		}
		Arrays.sort(intindex,0,k);
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new testing(s2bucket,intindex);
            }
        });
	    
		//Arrays.sort(intindex);
		for(int i=0;i<intindex.length;i++)
		{
			System.out.println(intindex[i]);
		}
			
		//button1 object=new button1(s2bucket,intindex);
	}
	public class testing extends JFrame
	{
	    //private JPanel topPanel;
	   

	    public testing(String s[],int intindex2[])
	    {
	    	JPanel topPanel = new JPanel();        

	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);            

	        EmptyBorder eb = new EmptyBorder(new Insets(60,60,60,60));

	        JTextPane tPane = new JTextPane();                
	        
	       // ScrollPane Scroll3= new ScrollPane(tPane);
	        tPane.setBorder(eb);
	        //tPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
	        tPane.setMargin(new Insets(30,30,30,30));
	        
			
	        topPanel.add(tPane);
	        for(int i=0,j=0;i<s.length;i++)
	        {

		        if(i==intindex2[j])
	        	{
		        	//String[] s1=new String[10];
		        	
		        	//s1=s[i].split(",");
//		        	for(int co=0;co<s1.length;co++)
//		        	{
		        		appendToPane(tPane,s[i]+".\n", Color.RED);
		        	//}
		        
	        		for(int k=0;intindex2[k]==intindex2[k+1];k++)
	        		{
	        			j++;
	        			System.out.println(j);
	        		}
	        		j++;
	        		
	        	}
	        	else
	        	{
	        		appendToPane(tPane,s[i]+".\n", Color.BLACK);
	        	}
	        	
	        }
	        
	        //setLocationRelativeTo(null);
	        

			//JScrollPane pane = new JScrollPane(tPane);
			//pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			//pane.setSize(500, 400);
			//pane.setLocation(100, 50);
	        
	        
	        getContentPane().add(topPanel);
	        
	        
	        //topPanel.add(jp);

	        pack();
	        setVisible(true);   
	    }

	    private void appendToPane(JTextPane tp, String msg, Color c)
	    {
	        StyleContext sc = StyleContext.getDefaultStyleContext();
	        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

	        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
	        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

	        int len = tp.getDocument().getLength();
	        tp.setCaretPosition(len);
	        tp.setCharacterAttributes(aset, false);
	        tp.replaceSelection(msg);
	    }



	}
}
	