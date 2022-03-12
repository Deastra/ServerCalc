import java.io.Serializable;
public class Complex implements Serializable{
    private double a,b;
    private String err=new String("");
    public Complex(){
        this.a=0;
        this.b=0;
    }
    public Complex(double a, double b){
        this.a=a;
        this.b=b;
    }

    public double getA() {
        return this.a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return this.b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public String getErr() {
        return this.err;
    }

    public void setErr(String err) {
        this.err = new String (err);
    }

    @Override
    public String toString() {
        if (this.err.equals("err")){
            // System.out.println("ERROR Complex");
            return "ERROR!";
        }else{
            String strA=new String(Double.toString(this.a));
            String strB=new String(Double.toString(this.b));
            if (this.a==0 & this.b==0){
                return "0";
            }else if(this.a==0){
                return strB+"i";
            }else if(this.b==0){
                return strA;
            }else if(this.b>0){
                return strA+"+"+strB+"i";
            }else{
                return strA+strB+"i";
            }
        }
    }
}
