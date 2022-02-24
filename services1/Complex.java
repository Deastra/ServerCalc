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
        
        if (this.a==0 & this.b==0){
            return "0";
        }

        String strA;
        String strB;
        String ext=new String();

        if (this.b==0){
            strB=new String();
        }
        else if(this.b<0){
            ext=new String();
            strB=Float.toString(this.b)+"i";
        }else{
            if (this.a==0){
                ext=new String();
            }
            ext=new String("+");
            strB=Float.toString(this.b)+"i";
        }

        if (this.a==0){
            ext=new String();
            strA=new String();
        }else{
            strA=Float.toString(this.a);
        }
        return strA+ext+strB;
    }

}
