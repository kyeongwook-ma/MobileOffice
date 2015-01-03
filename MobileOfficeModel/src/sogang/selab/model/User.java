package sogang.selab.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class User implements XMLService {
	private int id;
	private String name;
	private String department;
	private double[] location;
	private List<Project> onGoingPrjs;
	private List<Schedule> schedules;

	public int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	void setDepartment(String department) {
		this.department = department;
	}

	public double[] getLocation() {
		return location;
	}

	void setLocation(double[] location) {
		this.location = location;
	}

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public List<Project> getOnGoingPrjs() {
		return onGoingPrjs;
	}

	void setOnGoingPrjs(List<Project> onGoingPrjs) {
		this.onGoingPrjs = onGoingPrjs;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	class UserBuilder {

		private int id;
		private String name;
		private String department;
		private double[] location;
		private List<Project> onGoingPrjs;
		private List<Schedule> schedules;

		public UserBuilder(int id, String name) {
			this.id = id;
			this.name = name;
			this.location = new double[2];
			this.onGoingPrjs = new ArrayList<Project>();
			this.schedules = new ArrayList<Schedule>();
		}

		public UserBuilder department(String department) {
			this.department = department;
			return this;
		}

		public UserBuilder location(double latitude, double longtitude) {
			this.location[0] = latitude;
			this.location[1] = longtitude;
			return this;
		}

		public UserBuilder ongoingPrjs(Project prj) {
			this.onGoingPrjs.add(prj);
			return this;
		}

		public UserBuilder schedule(Schedule schedule) {
			this.schedules.add(schedule);
			return this;
		}

		public User createUser() {

			User user = new User(this.id, this.name);
			user.setDepartment(this.department);
			user.setLocation(this.location);
			user.setOnGoingPrjs(this.onGoingPrjs);
			user.setSchedules(this.schedules);

			return user;
		}		
	}

	@Override
	public String toXML() {


		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		
		try {
			docBuilder = docFactory.newDocumentBuilder();
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("user_info");
			doc.appendChild(rootElement);
			
			rootElement.setAttribute("id", String.valueOf(this.id));
			
			Element name = doc.createElement("name");
			rootElement.appendChild(name);
			
			Element location = doc.createElement("location");
			location.appendChild(doc.createTextNode(
					String.valueOf(this.location[0]) + "," + 
					String.valueOf(this.location[1])));
			rootElement.appendChild(location);
			
			Element job = doc.createElement("job");
			job.appendChild(doc.createTextNode(""));
			
			Element preferences = doc.createElement("preferences");
			
			// TODO preference 리스트 구현			
	 
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\file.xml"));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
			transformer.transform(source, result);
		
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

		return null;
	}

}
