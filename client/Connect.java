import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Connect {
    public static String connectServer(float a,float b){
      String machine = "localhost";
      Complex c1 = new Complex(a,b) ;
      Complex c2 = new Complex(b-a,a) ;
      int port = 1099;
      
      try {
        Registry registry = LocateRegistry.getRegistry(machine, port);
        Calculate obj = (Calculate)registry.lookup("Calculate");
        
        return obj.add(c1,c2).toString();
      } catch (Exception e) {
        return "Client exception: ";
      }
    }
}
