import java.io.Serializable;
public class Complex implements Serializable{
    private float a,b;

    public Complex(float a, float b){
        this.a=a;
        this.b=b;
    }
    // public Complex(String c){
    //     float strt=0,end;
    //     for (int i=0;i<c.length;i++){
    //         if(c.charAt(i+1)=="i"){
    //            end=i; 
    //         }
    //         else if(c.charAt(i))
    //     Integer.parseInt();
    //    }
    // }
    
    public float getA() {
        return this.a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public float getB() {
        return this.b;
    }

    public void setB(int b) {
        this.b = b;
    }
    
    @Override
    public String toString() {
        String strA=new String(Float.toString(this.a));
        String strB=new String(Float.toString(this.b));
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
