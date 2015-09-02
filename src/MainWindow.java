import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import net.miginfocom.swing.MigLayout;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JScrollPane;


import SharedRepo.MasterControl;


public class MainWindow implements ActionListener {
	
	private JRadioButton rdbtnPipeAndFilter,  rdbtnArchitecture ;
	private static JTextArea textArea_1, textArea;
	private JButton btnSubmit, btnUpdateIgnoreWords;
	private HashMap<Integer, String> ignoreWords;
	private ArrayList<String> ignoreWordList;
	private boolean click = false;
	private ButtonGroup group;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}
	
	public static JTextArea getOutputView () {
		return textArea;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 529, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][][]", "[][][grow][][][][][][][][grow][]"));
		
		ignoreWords = new HashMap<Integer,String>();
		
		rdbtnPipeAndFilter= new JRadioButton("Pipe and filter");
		frame.getContentPane().add(rdbtnPipeAndFilter, "cell 0 0");
		rdbtnPipeAndFilter.setSelected(true);
		rdbtnPipeAndFilter.setActionCommand("Arch1");
		
		rdbtnArchitecture = new JRadioButton("Shared Repository");
		frame.getContentPane().add(rdbtnArchitecture, "cell 2 0");
		rdbtnArchitecture.setActionCommand("Arch2");
		
		group = new ButtonGroup();
	    group.add(rdbtnPipeAndFilter);
	    group.add(rdbtnArchitecture);
	   
		
		JLabel lblInput = new JLabel("Input");
		frame.getContentPane().add(lblInput, "cell 0 1");
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, "cell 0 2,grow");
		
		textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		
		btnSubmit = new JButton("Submit");
		frame.getContentPane().add(btnSubmit, "cell 2 2");
		btnSubmit.addActionListener(this);
		
		JSeparator separator = new JSeparator();
		frame.getContentPane().add(separator, "cell 0 8");
		
		JLabel lblOutput = new JLabel("Output");
		frame.getContentPane().add(lblOutput, "cell 0 9");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		frame.getContentPane().add(scrollPane_1, "cell 0 10,grow");
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		btnUpdateIgnoreWords = new JButton("Show Ignore Words");
		frame.getContentPane().add(btnUpdateIgnoreWords, "cell 2 10");
		btnUpdateIgnoreWords.addActionListener(this);
		
		scanIgnoreWords();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSubmit){
			if(click){
				scanIgnoreWords();
				click = false;
			}
			if(group.getSelection().getActionCommand().equals("Arch1")){
				Input input = new Input(textArea_1.getText(), ignoreWords);
			}else {
				try{
				MasterControl master = new MasterControl(textArea_1.getText());
				textArea.setText(master.start(ignoreWordList));
				}catch (Exception err){
					err.printStackTrace();
				}
			}
		}else{
			//UpdateIgnoreWords newWindow = new UpdateIgnoreWords(ignoreWords);
			//newWindow.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//newWindow.setVisible(true);
			click = true;
			try{
				Runtime.getRuntime().exec("notepad " +"ignorewords.txt");
				
			}catch(Exception err){
				err.printStackTrace();
			}
		}
	   
	} 
	
	private boolean  scanIgnoreWords()  {
		BufferedReader br = null;
		ignoreWords = new HashMap<Integer,String>();
		ignoreWordList = new ArrayList<String>();

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("ignorewords.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				ignoreWords.put(sCurrentLine.hashCode(), sCurrentLine);
				ignoreWordList.add(sCurrentLine);
				//textArea.setText(ignoreWords.values().toString());
			}

		} catch (IOException e) {
			return false;
		} finally {
			try {
				if (br != null)br.close();
				
			} catch (IOException ex) {
				return false;
			}
		}
		return true;
	}

}
