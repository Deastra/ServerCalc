import java.io.Serializable;
public class Complex implements Serializable{
    private double real,img;
    private String err=new String("");
    public Complex(){
        this.real=0;
        this.img=0;
    }

    public Complex(double real, double img){
        this.real=real;
        this.img=img;
    }

    public Complex(String err){
        this.err=err;
    }

    public double getReal() {
        return this.real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImg() {
        return this.img;
    }

    public void setImg(double img) {
        this.img = img;
    }

    public String getErr() {
        return this.err;
    }

    public void setErr(String err) {
        this.err = new String (err);
    }

    public String getComplex() {
        if (this.err!=""){
            // System.out.println("ERROR Complex");
            return this.err;
        }
        else{
            String strReal=new String(Double.toString(this.real));
            String strImg=new String(Double.toString(this.img));
            if (this.real==0 & this.img==0){
                return "0";
            }else if(this.real==0){
                return strImg+"i";
            }else if(this.img==0){
                return strReal;
            }else if(this.img>0){
                return strReal+"+"+strImg+"i";
            }else{
                return strReal+strImg+"i";
            }
        }
    }
}
