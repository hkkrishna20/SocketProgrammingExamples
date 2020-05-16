package name.javacode.webservices.jaxrs.provider;

import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static org.jboss.shrinkwrap.api.Filters.exclude;
import static org.jboss.shrinkwrap.api.ShrinkWrap.create;

import java.util.List;

import name.javacode.webservices.jaxrs.provider.client.CarDealerClient;
import name.javacode.webservices.jaxrs.provider.domain.Car;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class CarDealerIT {
    private final CarDealerClient client = new CarDealerClient();

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
	WebArchive app = create(WebArchive.class, "jax-rs-provider.war")
		.addPackages(true, exclude(CarDealerClient.class.getPackage()),
			ProviderApplication.class.getPackage());

	System.out.println(app.toString(true));

	return app;
    }

    @Test
    public void testListCars() {
	List<Car> cars = client.request(APPLICATION_XML);

	System.out.println(cars);
    }
}
