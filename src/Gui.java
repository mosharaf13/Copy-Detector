

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.BoxLayout;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;


public class Gui extends JFrame {
	
	String text1,text2;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
/**
 * first commit testing
 */
	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 26, 303, 269);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout());
		
		
		JTextArea textArea = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(textArea);
		scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textArea.setBounds(0, 0, 303, 269);
		
		panel_1.add(scroll1,BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(318, 26, 323, 269);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout());
		
		JTextArea textArea_1 = new JTextArea();
		JScrollPane scroll2 = new JScrollPane(textArea_1);
		scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textArea_1.setBounds(0, 0, 323, 269);
		
		//panel_2.add(textArea_1);
		panel_2.add(scroll2,BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 294, 641, 87);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.setBounds(260, 11, 100, 50);
		panel_3.add(btnNewButton);
		
		
		JButton btnNewButton2 = new JButton("Choose");
		btnNewButton2.setSize(78, 35);
		btnNewButton2.setLocation(10, 5);
		panel_3.add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("Choose");
		btnNewButton3.setSize(78, 35);
		btnNewButton3.setLocation(530, 5);
		panel_3.add(btnNewButton3);
		
		
		JLabel lblEnterYourMain = new JLabel("Enter Your main Text");
		lblEnterYourMain.setFont(new Font("serif", Font.PLAIN, 15));
		lblEnterYourMain.setBounds(76, 0, 177, 27);
		panel.add(lblEnterYourMain);
		
		JLabel lblNewLabel = new JLabel("Enter your second test");
		lblNewLabel.setFont(new Font("serif", Font.PLAIN, 15));
		lblNewLabel.setBounds(394, 0, 191, 27);
		panel.add(lblNewLabel);
		
		
		
		btnNewButton2.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent arg0) {
			try {
				JFileChooser fileChooser = new JFileChooser("Open File");
				fileChooser.showOpenDialog(Gui.this);
				File f = fileChooser.getSelectedFile();
				if(f!=null){
					BufferedReader reader = new BufferedReader(new FileReader(f));
					char ch[] = new char[200];
					int ln;
					while((ln=reader.read(ch))!=-1){
						textArea.setText(textArea.getText()+(new String(ch)));
					}
					reader.close();
					
				}
			} 
			catch (HeadlessException | IOException e) {					// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		};
		
		
		
		
	});
		
		
		btnNewButton3.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent arg0) {
			try {
				JFileChooser fileChooser2 = new JFileChooser("Open File");
				fileChooser2.showOpenDialog(Gui.this);
				File f2 = fileChooser2.getSelectedFile();
				if(f2!=null){
					BufferedReader reader = new BufferedReader(new FileReader(f2));
					char ch2[] = new char[100];
					int ln2;
					while((ln2=reader.read(ch2))!=-1){
						textArea_1.setText(textArea_1.getText()+(new String(ch2)));
					}
					reader.close();
					
				}
			} 
			catch (HeadlessException | IOException e) {					// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		};
		
		
		
		
	});
		
		btnNewButton.addActionListener(new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text1 = textArea.getText();
				text2 = textArea_1.getText();				
				
				internal_Work object = new internal_Work(); 
				object.sentenceSpliter(text1, text2);
				
			}
		});
		
		}
	}

