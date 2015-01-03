package mobileofficenet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/example")
public class ExampleService {
	 
	  @GET
	  public String seyHello() {
	    return "JAX-RS and OSGi are a lovely couple.";
	  }	
}
