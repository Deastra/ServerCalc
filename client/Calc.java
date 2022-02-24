import javax.swing.*;
import java.awt.event.*;

public class Calc implements ActionListener {
    JFrame f;
    JTextField t;
    JButton beq, clear;
    int count=0;
    float a = 0, b = 0;
    String result=new String();
    int operator = 0;

    public Calc() {
        f = new JFrame("Calculator");
        t = new JTextField();

        beq = new JButton("=");
        clear = new JButton("Clear");

        t.setBounds(30, 40, 280, 30);

        beq.setBounds(180, 310, 50, 40);
        clear.setBounds(180, 270, 100, 40);

        f.add(t);

        f.add(beq);
        f.add(clear);
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(350, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);

        beq.addActionListener(this);
        clear.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == beq) {
            
            
            // b = Float.parseFloat(t.getText());
            if (count%2==0){
                result= new String(Connect.connectServer(3,5));
            }else{
                result=new String(Connect.connectServer(7,0));
            }
            count+=1;
            
            t.setText("" + result);
        }
        if (e.getSource() == clear) {
            t.setText(null);
        }
    }


}