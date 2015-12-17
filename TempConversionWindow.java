import javax.swing.*;
import java.awt.*;//NEW STUFF!
import java.awt.event.*;
import java.util.*;

public class TempConversionWindow extends JFrame implements ActionListener{
    private Container pane;
    private JPanel buttons;
    private JLabel j;
    private JTextField f;

    public TempConversionWindow() {
	this.setTitle("Temperature Conversion");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setSize(800,200);
	this.setLocation(100,100);
	
	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	
	JButton b = new JButton("To Fahrenheit");
	b.addActionListener(this);
	b.setActionCommand("toF");
	JButton b2 = new JButton("To Celsius");
	b2.addActionListener(this);
	b2.setActionCommand("toC");
	
	
	f = new JTextField(20);
	
	j = new JLabel("Temperature Conversion!");
	pane.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
	pane.add(f);
	buttons.add(b);
	buttons.add(b2);
	buttons.add(j);
	pane.add(buttons,BorderLayout.CENTER);
	

    }

    public static double CtoF(double t){
	double otpt = t;
	otpt= 9*otpt/5;
	return otpt+32;
    }
    public static double FtoC(double t){
	double otpt = t;
	otpt -= 32;
	otpt= 5*otpt/9;
	return otpt;
    }
    
    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if(event.equals("toF")){
	    try{
		double otpt = Double.parseDouble(f.getText());
		otpt = CtoF(otpt);
		String s = ""+otpt;
		j.setText(s);}
	    catch (Exception x) {
		j.setText("Please use an integer or double input");
	    }
	}
	if(event.equals("toC")){
	    try{
		double otpt = Double.parseDouble(f.getText());
		otpt = FtoC(otpt);
		String s = ""+otpt;
		j.setText(s);}
	    catch (Exception x) {
		j.setText("Please use an integer or double input");
	    }
	    
	}
	
	
    }
}