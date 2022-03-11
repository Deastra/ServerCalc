import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import static java.lang.Math.*;

//Increase font size
//Keyboard listener

public class Calc implements ActionListener {
    JFrame f;
    JTextField tOperator,t1,t2,total;
    JTextField textFields[] = new JTextField[3];
    int focusedTextField = 0;
    JLabel t1Label,t2Label,tOPLabel;
    JButton bplus,bminus,bdiv,bmult,beq,clear,bi,bdot,bleft,bright,backspace;
    JButton[] numberButtons = new JButton[10];
    float a = 0, b = 0;
    String result=new String();
    int operator = 0;
    String C1, C2, OP;

    public Calc() {
        f = new JFrame("Calculator");
        total = new JTextField();
        total.setEditable(false);
        total.setHorizontalAlignment(SwingConstants.RIGHT);
        tOPLabel = new JLabel("Op");
        tOperator = new JTextField();
        t1Label = new JLabel("complex 1");
        t1 = new JTextField();
        t2Label = new JLabel("complex 2");
        t2 = new JTextField();
        t1Label.setLabelFor(t1);
        t2Label.setLabelFor(t2);
        textFields[0] = t1;
        textFields[1] = tOperator;
        textFields[2] = t2;
        for (int i = 0; i < 3; i++) {
        	final int inner_i = i;
        	textFields[i].addFocusListener(new FocusListener() {
        		public void focusGained(FocusEvent e) { focusedTextField = inner_i; }        		
        		public void focusLost(FocusEvent e){};
        	});
        }
        
        bplus=new JButton("+");
        bminus=new JButton("-");
        bdiv=new JButton("/");
        bmult=new JButton("x");
        bplus.addActionListener(this);
        bminus.addActionListener(this);
        bdiv.addActionListener(this);
        bmult.addActionListener(this);
        beq = new JButton("=");
        beq.addActionListener(this);
        bi=new JButton("i");
        bi.addActionListener(this);
        bdot=new JButton(".");
        bdot.addActionListener(this);
        bleft=new JButton("<-");
        bright=new JButton("->");	
        bleft.addActionListener(this);
        bright.addActionListener(this);
        clear = new JButton("Clear");
        clear.addActionListener(this);
        backspace=new JButton("[X]");
        backspace.addActionListener(this);
        backspace.setBackground(Color.RED);
        for (int i=0;i<=9;i++){
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            f.add(numberButtons[i]);
        }
        t1Label.setBounds(40,100,100,20);
        t2Label.setBounds(220,100,100,20);	
        tOPLabel.setBounds(150,100,40,20);
        total.setBounds(10,5,320,50);
        t1.setBounds(20, 60, 110, 40);
        tOperator.setBounds(135, 60, 50, 40);
        tOperator.setHorizontalAlignment(JTextField.CENTER);
        t2.setBounds(190, 60, 110, 40);
        numberButtons[7].setBounds(10,180,80,40);
        numberButtons[8].setBounds(100,180,80,40);
        numberButtons[9].setBounds(190,180,80,40);
        numberButtons[4].setBounds(10,230,80,40);
        numberButtons[5].setBounds(100,230,80,40);
        numberButtons[6].setBounds(190,230,80,40);
        numberButtons[1].setBounds(10,280,80,40);
        numberButtons[2].setBounds(100,280,80,40);
        numberButtons[3].setBounds(190,280,80,40);
        bi.setBounds(10, 330,80,40);
        numberButtons[0].setBounds(100,330,80,40);
        bdot.setBounds(190, 330, 80,40);
        bplus.setBounds(280, 130, 50, 40);
        bminus.setBounds(280, 180, 50, 40);
        bdiv.setBounds(280, 230, 50, 40);
        bmult.setBounds(280, 280, 50, 40);
        beq.setBounds(280, 330, 50, 40);
        clear.setBounds(10, 130, 90, 40);
        backspace.setBounds(110,130,50,40);
        bleft.setBounds(170,130,50,40);
        bright.setBounds(225,130,50,40);
        f.add(backspace);
        f.add(tOPLabel);
        f.add(total);
        f.add(tOperator);
        f.add(t1);
        f.add(t2);
        f.add(t1Label);
        f.add(t2Label);
        f.add(bleft);
        f.add(bright);
        f.add(bplus);
        f.add(bminus);
        f.add(bdiv);
        f.add(bmult);
        f.add(bi);
        f.add(beq);
        f.add(bdot);
        f.add(clear);
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(355, 450);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        clear.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
    	String content = textFields[focusedTextField].getText();
    	
    	for (int i = 0; i <= 9; i++) {
    		if (e.getSource() == numberButtons[i]) {
        		if (focusedTextField != 1 && (content.isEmpty() ? true : !content.substring(content.length()-1).equals("i"))) {
        			textFields[focusedTextField].setText(content + String.valueOf(i));
        		}
        	}
    	}
    	
    	if (e.getSource() == bplus) {
    		if (focusedTextField != 1) {
    			if (!content.isEmpty()) {
    				if (content.equals("-")) textFields[focusedTextField].setText("");
    				else if (content.substring(content.length()-1).equals(".")) {
    					textFields[focusedTextField].setText(content + "0+");
    				}
    				else if (!(content.substring(content.length()-1).equals("+") || content.substring(content.length()-1).equals("-")))
    					textFields[focusedTextField].setText(content + "+");
    				else textFields[focusedTextField].setText(content.substring(0, content.length()-1) + "+");
    			}
    		}
    		else textFields[focusedTextField].setText("+");
    	}
    	
    	if (e.getSource() == bminus) {
    		if (focusedTextField != 1) {
    			if (content.isEmpty()) textFields[focusedTextField].setText("-");
    			else if (content.substring(content.length()-1).equals(".")) {
					textFields[focusedTextField].setText(content + "0-");
				}
    			else if (!(content.substring(content.length()-1).equals("+") || content.substring(content.length()-1).equals("-")))
        			textFields[focusedTextField].setText(content + "-");
    			else textFields[focusedTextField].setText(content.substring(0, content.length()-1) + "-");
    		}
    		else textFields[focusedTextField].setText("-");
    	}
    	
    	if (e.getSource() == bmult) {
    		if (focusedTextField == 1) textFields[focusedTextField].setText("x");
    	}
    	
    	if (e.getSource() == bdiv) {
    		if (focusedTextField == 1) {
    			textFields[focusedTextField].setText("/");
    			
    			if (textFields[2].getText().contains("i")) textFields[2].setText("");
    		}
    	}
    	
    	if (e.getSource() == bi) {
    		if (!content.contains("i")) {
    			if (focusedTextField == 0) textFields[focusedTextField].setText(content + (content.length() != 0 && content.substring(content.length()-1).equals(".") ? "0i" : "i"));
    			if (focusedTextField == 2 && !textFields[1].getText().equals("/")) 
    				textFields[focusedTextField].setText(content + (content.substring(content.length()-1).equals(".") ? "0i" : "i"));
    		}
    	}
    	
    	if (e.getSource() == bdot) {
    		if (focusedTextField != 1) {
    			if (content.isEmpty() || content.substring(content.length()-1).equals("+") || content.substring(content.length()-1).equals("-")) {
    				textFields[focusedTextField].setText(content + "0.");
    			}
    			else if (this.isDigit(content.charAt(content.length()-1))) {
    				int index = 1;
    				while (true) {
    					if (!this.isDigit(content.charAt(content.length()-index))) {
    						if (content.charAt(content.length()-index) != '.') textFields[focusedTextField].setText(content + ".");
    						break;
    					}
    					
    					index++;
    					
    					if (index > content.length()) {
    						textFields[focusedTextField].setText(content + ".");
    						break;
    					}
    				}
    			}
    		}
    	}
    	
    	if (e.getSource() == clear) textFields[focusedTextField].setText("");
    	if (e.getSource() == backspace && !content.isEmpty()) textFields[focusedTextField].setText(content.substring(0, content.length()-1));
    	
    	if (e.getSource() == bright) focusedTextField = focusedTextField != 2 ? focusedTextField+1 : 0;
    	if (e.getSource() == bleft ) focusedTextField = focusedTextField != 0 ? focusedTextField-1 : 2;
    	
    	this.C1 = textFields[0].getText().isEmpty() ? "" : "(" + textFields[0].getText() + ")";
    	this.C2 = textFields[2].getText().isEmpty() ? "" : "(" + textFields[2].getText() + ")";
    	this.OP = textFields[1].getText();
    	this.total.setText(this.C1 + this.OP + this.C2);
    	
    	if (e.getSource() == beq) {
    		float real_im_1[] = Calc.parseComplexNumber(textFields[0].getText());   
    		float real_im_2[] = Calc.parseComplexNumber(textFields[2].getText());
    		System.out.println(real_im_1[0]);
    		System.out.println(real_im_1[1]);
    		System.out.println(real_im_2[0]);
    		System.out.println(real_im_2[1]);
    	}
    }
    
    private boolean isDigit(char c) {
    	switch(c) {
    		case '1': case '2': case '3':
    		case '4': case '5': case '6':
    		case '7': case '8': case '9':
    		case '0':
    			return true;
    		default:
    			return false;
    	}
    }
    
    private static float[] parseComplexNumber(String complexNumber) {
    	String[] real_im = new String[2];
    	
    	if (!complexNumber.contains("i")) {
    		if (complexNumber.length() > 0) real_im[0] = Calc.evalString(complexNumber);
    		else real_im[0] = "0.0";
    		real_im[1] = "0.0i";
    	}
    	else {
    		real_im[1] = "i";
    		String regex = "i";
    		int index = complexNumber.indexOf('i');
    		
    		while(--index >= 0 && (complexNumber.charAt(index) != '+' && complexNumber.charAt(index) != '-')) {
    			real_im[1] = complexNumber.charAt(index) + real_im[1];
    		}
    		if (index >= 0) {
    			if (complexNumber.charAt(index) == '-') {
    				real_im[1] = '-' + real_im[1];
    				regex = real_im[1];
    			}
    			if (complexNumber.charAt(index) == '+') regex = "\\+" + real_im[1];
    		} else regex = real_im[1];
    		
    		String[] imaginaryPartRemoved = complexNumber.split(regex);
    		real_im[0] = Calc.evalString(imaginaryPartRemoved[0] + (imaginaryPartRemoved.length != 1 ? imaginaryPartRemoved[1] : ""));
    	}
    	
    	float[] real_im_fl = new float[2];
    	real_im_fl[0] = Float.parseFloat(real_im[0]);
    	real_im_fl[1] = Float.parseFloat(real_im[1].substring(0, real_im[1].length()-1));
    	real_im_fl[0] = (float)(Math.round(real_im_fl[0] * 100.0)/100.0);
    	real_im_fl[1] = (float)(Math.round(real_im_fl[1] * 100.0)/100.0);
    	
    	return real_im_fl;
    }
    
    private static String evalString(String expression) {
    	float result = 0;
    	String current = "";
    	char op = '+';
    	
    	for (int i = 0; i < expression.length(); i++) {
    		if (expression.charAt(i) != '+' && expression.charAt(i) != '-') current += expression.charAt(i);
    		else if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
    			if (i != 0) {
	    			if (op == '+') result += Float.parseFloat(current);
	    			if (op == '-') result -= Float.parseFloat(current);   			
	    			current = "";
    			}
    			op = expression.charAt(i);
    		}
    	}
    	if (op == '+') result += current != "" ? Float.parseFloat(current) : 0.0;
		if (op == '-') result -= current != "" ? Float.parseFloat(current) : 0.0;
    	
    	return String.valueOf(result);
    }
}