package labs.lab9;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

import labs.lab9.InvestmentFrame2.AddInterestListener;
public class EmptyFrameViewer extends JFrame implements ActionListener  {
	
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 1000;
	//JComboBox menu;
	JTextArea af;
	String ca; 
	String f;
	ArrayList<String> tagged = new ArrayList<String>();
	private JLabel resultLabel;
	
	

	
	
	public EmptyFrameViewer() {
		resultLabel = new JLabel("current user: " + "Gaby");
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public JPanel createComboBox() {
		JLabel m = new JLabel("mood: ");
		
		JComboBox menu = new JComboBox<String>();
		menu.addItem("Select");
		menu.addItem("Happy");
		menu.addItem("mid");
		menu.addItem("sad");
		menu.addItem("mad");
		menu.setEditable(false);
		menu.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	JComboBox cb = (JComboBox)e.getSource();
		        f = (String)cb.getSelectedItem();
				
		    }
		});
		//menu.addActionListener((ActionListener) this);
		JPanel panel = new JPanel();
		//panel.setLayout(new BorderLayout());
		panel.add(m);
		panel.add(menu);
		
		//get selceted from menu 
		//String varName = (String)menu.getSelectedItem();
		String value = menu.getSelectedItem().toString();
		
		return panel;
		}
	
	public JPanel checkbox() {
		ArrayList<String> cars = new ArrayList<String>();
	    cars.add("Kitty");
	    cars.add("Muffin");
	    cars.add("Dunkin");
	    cars.add("Babas");
		JLabel al = new JLabel("Tag friends: ");
		JCheckBox c1 = new JCheckBox(cars.get(0));  
		JCheckBox c2 = new JCheckBox(cars.get(1)); 
		JCheckBox c3 = new JCheckBox(cars.get(2)); 
		JCheckBox c4 = new JCheckBox(cars.get(3)); 
		
		 
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p , BoxLayout.X_AXIS));
		p.add(al);
		p.add(c1);
		p.add(c2);
		p.add(c3);
		p.add(c4);
		
		c1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		        if (tagged.contains("Kitty")) {
		        	tagged.remove("Kitty");
		        }
		        else {
		        	tagged.add("Kitty");
		        }
		    }
		});
		c2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		        System.out.println("Muffin");
		        if (tagged.contains("Muffin")) {
		        	tagged.remove("Muffin");
		        }
		        else {
		        	tagged.add("Muffin");
		        }
		    }
		});
		c3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		        System.out.println("Dunkin");
		        if (tagged.contains("Dunkin")) {
		        	tagged.remove("Dunkin");
		        }
		        else {
		        	tagged.add("Dunkin");
		        }
		    }
		});
		c4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		        System.out.println("Babas");
		        if (tagged.contains("Babas")) {
		        	tagged.remove("Babas");
		        }
		        else {
		        	tagged.add("Babas");
		        }
		    }
		});
		
		//boolean checked = c1.isSelected();
		//System.out.println(checked);
		
		//c1.addActionListener((ActionListener) this);
		//c2.addActionListener((ActionListener) this);
		//c3.addActionListener((ActionListener) this);
		//c4.addActionListener((ActionListener) this);
		
		return p;	
		
	}
	
	public JPanel current() {
		JLabel al = new JLabel("Current Activity: ");
	
		JTextArea af = new JTextArea();
		
		af.setPreferredSize(new Dimension(300,100));
		
		af.getDocument().addDocumentListener(new DocumentListener(){
		    @Override
		    public void insertUpdate(DocumentEvent e) { printText(); }
		    @Override
		    public void removeUpdate(DocumentEvent e) { printText(); }
		    @Override
		    public void changedUpdate(DocumentEvent e) { printText(); }

		    private void printText() {
		        //System.out.println(af.getText());
		        ca = af.getText();
		    }
		});
		
		
		JPanel panel = new JPanel();
		panel.add(al);
		panel.add(af);
		panel.setSize(500, 400);
		//where your data is 
		
		
		
		return panel;
		
	}
	
	
	
	
	public JPanel c_center()  {
		JButton save = new JButton("save");
		//ActionListener listener = new AddInterestListener();
		//save.addActionListener(listener);
		save.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	String t = "";
		    	for (String s : tagged) {
		    	  t += s + ", ";
		    	} 
		       if (f==null && t.equals("")) {
		    	   System.out.println("Gaby is "+ ca + ".");
		       }
		       else if (t.equals("")) {
		    	   System.out.println("Gaby is feeling " + f + ", "+ ca + ".");
		       }
		       else if (f==null ) {
		    	   System.out.println("Gaby is "+ ca + " with "+ t.substring(0,t.length()-2) +".");
		       }
		       else {
		        System.out.println("Gaby is feeling " + f + ", "+ ca +" with "+ t.substring(0,t.length()-2) + ".");
		       }
		       
		        
		    }
		});
		
		
		
		JPanel p = new JPanel();
		
		
		p.setLayout(new BoxLayout(p , BoxLayout.Y_AXIS));
		p.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		p.add(Box.createRigidArea(new Dimension(10, 100)));
		p.add(createComboBox());
		p.add(Box.createRigidArea(new Dimension(10, 100)));
		p.add(checkbox());
		p.add(Box.createRigidArea(new Dimension(10, 200)));
		p.add(save);
		p.add(Box.createRigidArea(new Dimension(10, 100)));
		return p;
	}
	
	
	
	public JPanel center() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(current(), BorderLayout.NORTH);
		p.add(c_center(), BorderLayout.CENTER);
		
		return p;
	}

	public class CustomOutputStream extends OutputStream {
	    private JTextArea textArea;
	     
	    public CustomOutputStream(JTextArea textArea) {
	        this.textArea = textArea;
	    }
	     
	    @Override
	    public void write(int b) throws IOException {
	        // redirects data to the text area
	        textArea.append(String.valueOf((char)b));
	        
	        // scrolls the text area to the end of data
	        textArea.setCaretPosition(textArea.getDocument().getLength());
	        
	    }
	}
	
	public JPanel botton() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p , BoxLayout.Y_AXIS));
		JLabel al = new JLabel("Friends: ");
		
		JTextArea textArea = new JTextArea(10, 100);
		PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
		System.setOut(printStream);
		System.setErr(printStream);
		p.add(al);
		p.add(textArea);
		return p;
	}
	
	private void createPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(resultLabel, BorderLayout.NORTH);
		panel.add(center(), BorderLayout.CENTER);
		panel.add(botton(), BorderLayout.SOUTH);
		
		add(panel);
		}
	
public static void main(String[] args) {
	JFrame frame = new EmptyFrameViewer();
	frame.setTitle("Friend Tracker");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);


}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}


}