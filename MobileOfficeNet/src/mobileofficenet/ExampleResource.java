package mobileofficenet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/* annotation 을 통해 경로 지정 */
@Path( "/hello" )
public class ExampleResource {
	@GET
	public String helloWorld() {
		return "Hello World";
	}
}
