import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class FileCh extends JFrame{
	JTextPane pan = new JTextPane();
	public static void main(String[] args) {
		new FileCh();
	}
	public FileCh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		JButton button = new JButton("Add text");
		button.setBounds(50, 50, 200, 60);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFileChooser fileChooser = new JFileChooser("Open File");
					fileChooser.showOpenDialog(FileCh.this);
					File f = fileChooser.getSelectedFile();
					if(f!=null){
						BufferedReader reader = new BufferedReader(new FileReader(f));
						char ch[] = new char[100];
						int ln;
						while((ln=reader.read(ch))!=-1){
							pan.setText(pan.getText()+(new String(ch)));
						}
						reader.close();
						
					}
				} catch (HeadlessException | IOException e) {					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		add(button);
		

		JScrollPane jp = new JScrollPane(pan);
		jp.setSize(500, 400);
		jp.setLocation(100, 150);
		add(jp);
		
		setVisible(true);
	}

}
