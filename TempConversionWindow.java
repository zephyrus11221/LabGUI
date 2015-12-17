import javax.swing.*;
import java.awt.*;//NEW STUFF!
import java.awt.event.*;

public class TempConversionWindow extends JFrame implements ActionListener{
    private Container pane;
    private JLabel j;
    private JTextField f;

    public TempConversionWindow() {
	this.setTitle("Temperature Conversion");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(
				      EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	
	JButton b = new JButton("To Fahrenheit");
	b.addActionListener(this);
	b.setActionCommand("toF");
	JButton b2 = new JButton("To Celsius");
	b2.addActionListener(this);
	b2.setActionCommand("toC");
	
	
	f = new JTextField(10);
	
	j = new JLabel("Meaning of life is... ");
	pane.add(f);
	pane.add(b);
	pane.add(b2);
	pane.add(j);
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
	    catch (Exception e) {
		j.setText("Please use an integer or double input");
	    }
	}
	if(event.equals("toC")){
	    try{
		double otpt = Double.parseDouble(f.getText());
		otpt = FtoC(otpt);
		String s = ""+otpt;
		j.setText(s);}
	    catch (Exception e) {
		j.setText("Please use an integer or double input");
	    }
	    
	}
	
	
    }
}