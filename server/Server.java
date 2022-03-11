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
      
      if(!Arrays.asList(registry.list()).contains("Calculate3"))
        registry.bind("Calculate3", skeleton); 
      else
        registry.rebind("Calculate3", skeleton);
        System.out.println("Service Calculator3 executed");
        System.out.println("Client <-> Service");
    } catch (Exception e) {
        System.out.println(e);
    }
  }
}
