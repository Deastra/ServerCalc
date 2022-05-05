import java.lang.Math.*;
import java.io.Serializable;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class CalculatorImpl implements Calculator{
    // public CalculateImpl(){};
    public Complex addition(Complex c1, Complex c2){
        double a=c1.getReal()+c2.getReal();
        double b=c1.getImg()+c2.getImg();
        Complex res=new Complex(a,b);
        return res;
    }
    
    public Complex substitution(Complex c1, Complex c2){
        double a=c1.getReal()-c2.getReal();
        double b=c1.getImg()-c2.getImg();
        Complex res=new Complex(a,b);
        return res;
    }
    
    public Complex multiplication(Complex c1, Complex c2){
        double real_real=c1.getReal()*c2.getReal();
        double img_img=c1.getImg()*c2.getImg();
        double real_img=c1.getReal()*c2.getImg();
        double img_real=c1.getImg()*c2.getReal();

        Complex res=new Complex(real_real-img_img,real_img+img_real);
        return res;
    }

    public Complex intDivision(Complex c1, Complex c2){
        Complex res;
        if (Math.signum(c2.getReal())==0){
            res=new Complex();
            res.setErr("Division by Zero!");
        }else{
            double a=c1.getReal()/c2.getReal();
            double b=c1.getImg()/c2.getReal();
            res=new Complex(a,b);
        }
        return res;
    }

    public Complex Calculate(Complex c1, Complex c2,String op){
        switch (op){
            case "+": return addition(c1,c2);
            case "-": return substitution(c1, c2);
            case "x": return multiplication(c1,c2);
            case "/": return intDivision(c1, c2);
            default: return new Complex("Error");
        }
    }

}
