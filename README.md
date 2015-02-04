MobileOffice
============

ExoBrain 프로젝트

<h1> 모델 라이브러리 소스 코드 예제 </h1>


```java
public class MobileOfficeSimulator {

	public static void main(String[] args) {
		

		/* create mobile office block 4 by 4 */
		MobileOffice.createOfficeBlock(4, 4);
		
		/* instantiate with environment */
		OfficeBlock block = new OfficeBlockBuilder()
				.xPos(0).yPos(0)
				.brightness(60)
				.humidity(55)
				.temperature(25)
				.createOfficeBlock();
	
		MobileOffice.assignBlock(block);
		
		MobileOffice.printCurrentState();
	
		/* instantiate device & assign to mobile office */
		AirCon aircon = new AirCon(0 , 0);
		MobileOffice.addDevice(aircon);
		
		/* operate device in duration time */
		aircon.cool(3);
	
		MobileOffice.printCurrentState();
		
		System.out.println(MobileOffice.getSerializedJson());
	}
}

```



<h1> 통신 기법 : OSGi HTTP Rest </h1>

<h2> 1-1. 새 개발환경 설정 </h2>

Eclipse 역시 OSGi플랫폼 위에 구동되므로 새로운 타겟 플랫폼을 생성하여 기존의 IDE에 변경이
없는 개발 환경을 만들어야 합니다.

<img src=http://eclipsesource.com/blogs/wp-content/uploads/2014/02/001-target.png><br>
 Eclipse 의 상단 메뉴 중 Preference - Plugin Development 에서 Target Platform에서
새로운 타겟 플랫폼을 추가합니다.

<img src=http://eclipsesource.com/blogs/wp-content/uploads/2014/02/002-create-target.png><br>
여타 다른 번들들은 필요하지 않으므로 Nothing 으로 플랫폼을 생성합니다.

<img src=http://eclipsesource.com/blogs/wp-content/uploads/2014/02/003-add-software-site.png><br>
개발시 필요한 OSGi - HTTP REST 를 지원하는 라이브러리를 추가합니다.

<i>http://download.eclipse.org/eclipse/updates/4.3</i><br>
를 추가하여 "Equinox Target Components" 를 설치합니다.

<i>http://hstaudacher.github.io/osgi-jax-rs-connector</i><br>
를 추가하여 "OSGi - JAX -RS Connector" 를 설치합니다. 그외 번들들은 기타 서비스를 이용할 때 필요합니다.

<h2> 1-2. 어플리케이션 생성  </h2>

<img src=http://eclipsesource.com/blogs/wp-content/uploads/2014/02/007-create-bundle.png><br>
새 프로젝트를 생성할 때 Target 을 Equinox로 설정해줍니다.

<img src=http://eclipsesource.com/blogs/wp-content/uploads/2014/02/009-add-manifest.png><br>
프로젝트 생성 후 MANIFEST.MF 를 다음과 같이 JAX-RS API를 이용할 수 있게 설정해줍니다.

<h2> 1-3. 소스 코드 작성  </h2>

<b>ExampleResource.java</b>

```java
/* annotation 을 통해 경로 지정 */
@Path( "/hello" )
public class ExampleResource {
	@GET
	public String helloWorld() {
		return "Hello World";
	}
}
```


<b>Activator.java</b>
```java
public class Activator implements BundleActivator {
	private ServiceRegistration<ExampleResource> registration;

	public void start(BundleContext bundleContext) throws Exception {
		/* 서비스 등록 */
		registration = bundleContext.registerService(ExampleResource.class, new ExampleResource(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		registration.unregister();
	}
}
```


<h2> 1-4. 실행  </h2>

<img src=http://eclipsesource.com/blogs/wp-content/uploads/2014/02/011-add-launch-bundles.png><br>
실행을 위해선 다음과 같은 번들들이 필요합니다.

// Our Application
osgi.rest.example

// The OSGI implementation
org.eclipse.osgi
org.eclipse.osgi.services

// The OSGi console
org.eclipse.equinox.console
org.apache.felix.gogo.command
org.apache.felix.gogo.runtime
org.apache.felix.gogo.shell

// The OSGi HttpService implementation
org.eclipse.equinox.http.jetty
org.eclipse.equinox.http.servlet
org.eclipse.jetty.continuation
org.eclipse.jetty.http
org.eclipse.jetty.io
org.eclipse.jetty.security
org.eclipse.jetty.server
org.eclipse.jetty.servlet
org.eclipse.jetty.util
javax.servlet-api

// The JAX-RS Connector
com.eclipsesource.jaxrs.publisher

// Jersey
com.eclipsesource.jaxrs.jersey-all (this is Jersey repackaged as a single bundle)

<img src=http://eclipsesource.com/blogs/wp-content/uploads/2014/02/012-configure-port.png><br>
HTTP 서비스를 이용하기 위해 Run 혹은 Debug 설정에서 OSGi 실행 Argument에
-Dorg.osgi.service.http.port=포트 번호
를 추가해줍니다.

<img src=http://eclipsesource.com/blogs/wp-content/uploads/2014/02/014-run-in-browser.png><br>
다음과 같은 실행결과가 나옵니다.

Ref : <i>http://eclipsesource.com/blogs/2014/02/04/step-by-step-how-to-bring-jax-rs-and-osgi-together/</i>

