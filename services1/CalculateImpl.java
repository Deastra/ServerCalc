import java.io.Serializable;

public class CalculateImpl implements Calculate{
    public Complex add(Complex c1, Complex c2){
        float a=c1.getA()+c2.getA();
        float b=c1.getB()+c2.getB();
        Complex res=new Complex(a,b);
        return res;
    }
    
    public Complex substitute(Complex c1, Complex c2){
        float a=c1.getA()-c2.getA();
        float b=c1.getB()-c2.getB();
        Complex res=new Complex(a,b);
        return res;
    }
    
    public Complex multiply(Complex c1, Complex c2){
        float aa=c1.getA()*c2.getA();
        float bb=c1.getB()*c2.getB();
        float ab=c1.getA()*c2.getB();
        float ba=c1.getB()*c2.getA();
        Complex res=new Complex(aa-bb,ab+ba);
        return res;
    }

    public Complex intDivision(Complex c1, Complex c2){
        float a=c1.getA()/c2.getA();
        float b=c1.getB()/c2.getA();
        Complex res=new Complex(a,b);
        return res;
    }
    

}
