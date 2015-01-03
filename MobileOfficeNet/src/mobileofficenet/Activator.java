package mobileofficenet;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	private ServiceRegistration registration;

	@Override
	public void start( BundleContext context ) throws Exception {
		ExampleService exampleService = new ExampleService();
		registration = context.registerService( ExampleService.class.getName(), exampleService, null );
	}

	@Override
	public void stop( BundleContext context ) throws Exception {
		registration.unregister();
	}
}
