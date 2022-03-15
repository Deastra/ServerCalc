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
      Calculate skeleton = (Calculate)UnicastRemoteObject.exportObject(new CalculateImpl(), 0);
      Registry registry = LocateRegistry.getRegistry(port);
      
      if(!Arrays.asList(registry.list()).contains("Calculate5")){
        System.out.println("binding");
        registry.bind("Calculate5", skeleton); 
      }
      else{
        System.out.println("rebinding");
        registry.rebind("Calculate5", skeleton);
      }
      System.out.println("Service Calculator5 executed");
      System.out.println("Client <-> Service");
    } catch (Exception e) {
        System.out.println(e);
    }
  }
}
