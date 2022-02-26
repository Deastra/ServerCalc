import javax.swing.*;
import java.awt.event.*;

public class Calc implements ActionListener {
    JFrame f;
    JTextField t,t1,t2,t3,t4;
    JButton bplus,bminus,bdiv,bmult,beq,clear;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    int count=0;
    float a = 0, b = 0;
    String result=new String();
    int operator = 0;

    public Calc() {
        f = new JFrame("Calculator");
        t = new JTextField();
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        
        b1 = new JButton("=");
        beq = new JButton("=");
        clear = new JButton("Clear");

        t.setBounds(30, 10, 100, 30);
        t1.setBounds(140, 10, 100, 30);
        t2.setBounds(235, 45, 50, 30);
        t3.setBounds(30, 80, 100, 30);
        t4.setBounds(140, 80, 100, 30);
        b1.setBounds(0,150,50,50);
        // y 120
        for (int i=1;i<=9;i++){
            // b
        }
        beq.setBounds(180, 310, 50, 40);
        clear.setBounds(180, 270, 100, 40);
        b1.setBounds(0,120,50,50);
        f.add(t);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);

        f.add(b1);
        f.add(beq);
        f.add(clear);
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(350, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(true);
        b1.addActionListener(this);
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
            t.setText("" + result);
        }
        if (e.getSource() == clear) {
            t.setText(null);
        }

    }


}