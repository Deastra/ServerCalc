import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class Calc implements ActionListener {
    JFrame f;
    JTextField t,t1,t2,t3,t4;
    JButton bplus,bminus,bdiv,bmult,beq,clear;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    int count=0;
    float a = 0, b = 0;
    String result=new String();
    int operator = 0;
    Calculate obj;
    public Calc(Calculate obj) {
        this.obj=obj;
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
        // MouseListeneris m1 = new MouseListener() {
        //     @Override
        //     public void mouseClicked(MouseEvent e) {
        //         System.out.println(e.getID());
        //     }

        //     @Override
        //     public void mousePressed(MouseEvent e) {
        //         JComponent JC = (JComponent) e.getSource();
        //         TransferHandler TH = JC.getTransferHandler();
        //         TH.exportAsDrag(JC, e, TransferHandler.COPY);
        //         System.out.println("Foo");
        //     }
        // };
    }

    public String Equals(Calculate obj,float a,float b, float c, float d,String op) throws Exception{
        Complex c1 = new Complex(a,b) ;
        Complex c2 = new Complex(c,d) ;
        return obj.Calculation(c1, c2, op).toString();
        // try{
        //     return obj.Calculation(c1, c2, op).toString();
        // }catch(Exception e){
        //     System.out.println("Exception in Calculation!");
        // }
        // return "";

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == beq) {
            // b = Float.parseFloat(t.getText());
            try{
                if (count%3==0){
                    result=new String(Equals(this.obj,1,1,2,-1,"+"));
                }else if(count%3==1){
                    result=new String(Equals(this.obj,1,1,1,-1,"-"));
                }else{
                    result=new String(Equals(this.obj,1,1,2,0,"/"));
                }
            }catch(Exception e1){
                result=new String("ERROR");
            }
            count+=1;
            t.setText("" + result);
        }
        if (e.getSource() == clear) {
            t.setText(null);
        }

    }


}