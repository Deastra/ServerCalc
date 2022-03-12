import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculate extends Remote{
    public Complex add(Complex c1, Complex c2) throws RemoteException;
    public Complex substitute(Complex c1, Complex c2) throws RemoteException;
    public Complex multiply(Complex c1, Complex c2) throws RemoteException;
    public Complex intDivision(Complex c1, Complex c2) throws RemoteException;
    public Complex Calculation(Complex c1, Complex c2,String op) throws RemoteException;
    
}
