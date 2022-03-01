import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
public class Calc implements ActionListener {
    JFrame f;
    JTextField tOperator,t1,t2,total;
    JLabel t1Label,t2Label,tOPLabel;
    JButton bplus,bminus,bdiv,bmult,beq,clear,bi,bdot,bleft,bright,backspace;
    JButton[] numberButtons = new JButton[10];
    int count=0;
    float a = 0, b = 0;
    String result=new String();
    int operator = 0;

    public Calc() {
        f = new JFrame("Calculator");
        total = new JTextField();
        tOPLabel = new JLabel("Op");
        tOperator = new JTextField();
        t1Label = new JLabel("complex 1");
        t1 = new JTextField();
        t2Label = new JLabel("complex 2");
        t2 = new JTextField();
        t1Label.setLabelFor(t1);
        t2Label.setLabelFor(t2);
        
        bplus=new JButton("+");
        bminus=new JButton("-");
        bdiv=new JButton("/");
        bmult=new JButton("x");
        beq = new JButton("=");
        bi=new JButton("i");
        bdot=new JButton(".");
        bleft=new JButton("<-");
        bright=new JButton("->");	
        clear = new JButton("Clear");
        backspace=new JButton("[X]");
        backspace.setBackground(Color.RED);
        for (int i=0;i<=9;i++){
            numberButtons[i]=new JButton(String.valueOf(i));
            f.add(numberButtons[i]);
        }
        t1Label.setBounds(40,100,100,20);
        t2Label.setBounds(220,100,100,20);	
        tOPLabel.setBounds(150,100,40,20);
        total.setBounds(10,5,320,50);
        t1.setBounds(20, 60, 110, 40);
        tOperator.setBounds(135, 60, 50, 40);
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
        beq.addActionListener(this);
        clear.addActionListener(this);

    }
    // public void addNumButtonAction(ActionEvent e,JButton b, int n,){
    //     if (e.getSource()==b){

    //     }

    // }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == beq) {
            // b = Float.parseFloat(t.getText());
            if (count%3==0){
                result="("+new String(Connect.connectServer(0,0,0,0))+")"; //0
                result+="("+ new String(Connect.connectServer(1,1,1,1))+")"; // +a+b
                result+="("+new String(Connect.connectServer(+1,-1,0,0))+")"; //+a-b


            }else if(count%3==1){
                result="("+new String(Connect.connectServer(-1,1,1,1))+")"; // +b
                result+="("+new String(Connect.connectServer(-1,-1,1,-1))+")"; // -b
                result+="("+new String(Connect.connectServer(1,-1,1,1))+")"; //a
                result+="("+new String(Connect.connectServer(1,-1,-5,1))+")"; //-a
                
            }else{

                result="("+new String(Connect.connectServer(-1,-1,0,0))+")"; //-a-b
                result+="("+new String(Connect.connectServer(-1,1,0,0))+")"; //-a+b
            }
            count+=1;
            total.setText("" + result);
        }
        if (e.getSource() == clear) {
            total.setText(null);
        }

    }


}