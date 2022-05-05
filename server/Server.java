import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
public class Server {
  public static void main(String args[]) {
    int port  = 1099;
    if(args.length==1)
      port = Integer.parseInt(args[0]);
    try {
      Calculator skeleton = (Calculator)UnicastRemoteObject.exportObject(new CalculatorImpl(), 0);
      Registry registry = LocateRegistry.getRegistry(port);
      
      if(!Arrays.asList(registry.list()).contains("Calculator9")){
        System.out.println("Binding");
        registry.bind("Calculator9", skeleton); 
      }
      else{
        System.out.println("rebinding");
        registry.rebind("Calculator9", skeleton);
      }
      System.out.println("Service Calculator9 executed");
      System.out.println("Client <-> Service");
    } catch (Exception e) {
        System.out.println(e);
    }
  }
}
