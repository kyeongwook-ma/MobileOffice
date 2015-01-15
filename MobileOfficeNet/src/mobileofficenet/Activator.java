package mobileofficenet;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

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
