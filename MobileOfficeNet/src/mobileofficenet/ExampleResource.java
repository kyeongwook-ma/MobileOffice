package mobileofficenet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/* annotation �� ���� ��� ���� */
@Path( "/hello" )
public class ExampleResource {
	@GET
	public String helloWorld() {
		return "Hello World";
	}
}
