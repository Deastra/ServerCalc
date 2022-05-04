import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.event.*;
import java.awt.Color;
import static java.lang.Math.*;
import java.awt.Font;
import java.awt.*;
import java.awt.font.*;

//Keyboard listener

public class GraphicalCalculator implements ActionListener {

    JFrame f;
	JPanel p1,p2;
    JTextField tOperator,t1,t2,total;
    JTextField textFields[] = new JTextField[3];
    int focusedTextField = 0;
    JLabel t1Label,t2Label,tOPLabel;
    JButton bplus,bminus,bdiv,bmult,beq,clear,bi,bdot,bleft,bright,backspace;
    JButton[] numberButtons = new JButton[10];
    double a = 0, b = 0;
    String result=new String();
    int operator = 0;
    String C1, C2, OP;
    Calculate obj;

    public GraphicalCalculator(Calculate obj) {
        this.obj=obj;
        f = new JFrame("GraphicalCalculator");
		p1=new JPanel();
		p2=new JPanel();
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
        Font font1 = new Font("SansSerif", Font.BOLD, 16);
        Font font2 = new Font("SansSerif", Font.BOLD, 20);
        textFields[0].setFont(font1);
        textFields[1].setFont(font1);
        textFields[2].setFont(font1);
        total.setFont(font2);

        for (int i = 0; i < 3; i++) {
        	final int inner_i =  i;
        	textFields[i].addFocusListener(new FocusListener() {
        		public void focusGained(FocusEvent e) { focusedTextField = inner_i; }        		
        		public void focusLost(FocusEvent e){};
        	});
			textFields[i].addKeyListener(new KeyAdapter() {
        		public void keyTyped(KeyEvent e) {
        			e.consume();
        		}
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
        clear = new JButton("AC");
        clear.addActionListener(this);
        backspace=new JButton("Del");
        backspace.addActionListener(this);
        for (int i=0;i<=9;i++){
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
			numberButtons[i].setBorder(null);
			numberButtons[i].setBackground(Color.decode("#efefef"));
			numberButtons[i].setFont(font1);
            p2.add(numberButtons[i]);
        }
		p1.setBounds(0,0,350,120);
		p2.setBounds(0,120,350,300);
        t1Label.setBounds(40,100,100,20);
        t2Label.setBounds(240,100,100,20);	
        tOPLabel.setBounds(160,100,40,20);
        total.setBounds(10,5,320,50);
        t1.setBounds(10, 60, 125, 40);
        tOperator.setBounds(145, 60, 50, 40);
        tOperator.setHorizontalAlignment(JTextField.CENTER);
        t2.setBounds(205, 60, 125, 40);
        numberButtons[7].setBounds(10,60,80,40);
        numberButtons[8].setBounds(100,60,80,40);
        numberButtons[9].setBounds(190,60,80,40);
        numberButtons[4].setBounds(10,110,80,40);
        numberButtons[5].setBounds(100,110,80,40);
        numberButtons[6].setBounds(190,110,80,40);
        numberButtons[1].setBounds(10,160,80,40);
        numberButtons[2].setBounds(100,160,80,40);
        numberButtons[3].setBounds(190,160,80,40);
        bi.setBounds(10, 210,80,40);
        numberButtons[0].setBounds(100,210,80,40);
        bdot.setBounds(190, 210, 80,40);
        bplus.setBounds(280, 10, 50, 40);
        bminus.setBounds(280, 60, 50, 40);
        bdiv.setBounds(280, 110, 50, 40);
        bmult.setBounds(280, 160, 50, 40);
        beq.setBounds(280, 210, 50, 40);
        clear.setBounds(10, 10, 60, 40);
        backspace.setBounds(80,10,60,40);
        bleft.setBounds(150,10,55,40);
        bright.setBounds(215,10,55,40);
		bi.setBorder(null);
		bi.setBackground(Color.decode("#efefef"));
		bi.setFont(font1);
		bdot.setBorder(null);
		bdot.setBackground(Color.decode("#efefef"));
		bdot.setFont(font1);
		bplus.setBorder(null);
		bplus.setBackground(Color.decode("#feeec5"));
		bplus.setFont(font1);
		bminus.setBorder(null);
		bminus.setBackground(Color.decode("#feeec5"));
		bminus.setFont(font1);
		bdiv.setBorder(null);
		bdiv.setBackground(Color.decode("#feeec5"));
		bdiv.setFont(font1);
		bmult.setBorder(null);
		bmult.setBackground(Color.decode("#feeec5"));
		bmult.setFont(font1);
		beq.setBorder(null);
		beq.setBackground(Color.decode("#fec03e"));
		beq.setFont(font1);
		backspace.setBorder(null);
		backspace.setBackground(Color.decode("#feeec5"));
		backspace.setFont(font1);
		bleft.setBorder(null);
		bleft.setBackground(Color.decode("#feeec5"));
		bleft.setFont(font1);
		bright.setBorder(null);
		bright.setBackground(Color.decode("#feeec5"));
		bright.setFont(font1);
		clear.setBorder(null);
		clear.setBackground(Color.decode("#fec03e"));
		clear.setFont(font1);
        p2.add(backspace);
        p1.add(tOPLabel);
        p1.add(total);
        p1.add(tOperator);
        p1.add(t1);
        p1.add(t2);
        p1.add(t1Label);
        p1.add(t2Label);
        p2.add(bleft);
        p2.add(bright);
        p2.add(bplus);
        p2.add(bminus);
        p2.add(bdiv);
        p2.add(bmult);
        p2.add(bi);
        p2.add(beq);
        p2.add(bdot);
        p2.add(clear);
		f.add(p1);
		f.add(p2);
		p1.setLayout(null);
		p1.setBackground(Color.white);
		p2.setBackground(Color.white);
		p2.setLayout(null);
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
        String total_exp=new String(this.C1 + this.OP + this.C2);
    	this.total.setText(total_exp);
    	
    	if (e.getSource() == beq) {
    		double real_im_1[] = GraphicalCalculator.parseComplexNumber(textFields[0].getText());   
    		double real_im_2[] = GraphicalCalculator.parseComplexNumber(textFields[2].getText());
            try{
                total_exp+="="+Equals(this.obj, real_im_1[0], real_im_1[1], real_im_2[0],real_im_2[1],OP);
                this.total.setText(total_exp);
            }catch(Exception e1){
                this.total.setText("ERROR EXCEPT");
            }
        
        }
    }
    
    public String Equals(Calculate obj,double real1,double img1, double real2, double img2,String op) throws Exception{
        Complex c1 = new Complex(real1,img1) ;
        Complex c2 = new Complex(real2,img2) ;
        return obj.Calculation(c1, c2, op).getComplex();

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
    
    private static double[] parseComplexNumber(String complexNumber) {
    	String[] real_im = new String[2];	
    	if (!complexNumber.contains("i")) {
    		if (complexNumber.length() > 0) real_im[0] = GraphicalCalculator.evalString(complexNumber);
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
    		real_im[0] = GraphicalCalculator.evalString((imaginaryPartRemoved.length > 0 ? imaginaryPartRemoved[0] : "") + (imaginaryPartRemoved.length > 1 ? imaginaryPartRemoved[1] : ""));
    	}
    	
    	double[] real_im_fl = new double[2];
    	real_im_fl[0] = Double.parseDouble(real_im[0]);
    	real_im_fl[1] = Double.parseDouble(real_im[1].substring(0, real_im[1].length()-1));
    	real_im_fl[0] = (double)(Math.round(real_im_fl[0] * 100.0)/100.0);
    	real_im_fl[1] = (double)(Math.round(real_im_fl[1] * 100.0)/100.0);
    	
    	return real_im_fl;
    }
    
    private static String evalString(String expression) {
    	double result = 0;
    	String current = "";
    	char op = '+';
    	
    	for (int i = 0; i < expression.length(); i++) {
    		if (expression.charAt(i) != '+' && expression.charAt(i) != '-') current += expression.charAt(i);
    		else if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
    			if (i != 0) {
	    			if (op == '+') result += Double.parseDouble(current);
	    			if (op == '-') result -= Double.parseDouble(current);   			
	    			current = "";
    			}
    			op = expression.charAt(i);
    		}
    	}
    	if (op == '+') result += current != "" ? Double.parseDouble(current) : 0.0;
		if (op == '-') result -= current != "" ? Double.parseDouble(current) : 0.0;
    	
    	return String.valueOf(result);
    }
}
