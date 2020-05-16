package name.javacode.javaee.appointment.representation;

import static java.net.URI.create;

import java.io.StringReader;
import java.net.URI;
import java.util.Objects;

import javax.enterprise.context.Dependent;
import javax.ws.rs.core.UriBuilder;

import name.javacode.javaee.appointment.domain.Appointment;

import com.theoryinpractise.halbuilder.api.ContentRepresentation;
import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;

@Dependent
public class AppointmentRepresentationFactory extends
	StandardRepresentationFactory {
    private static final URI[] HAL_JSON_FLAGS = new URI[] { PRETTY_PRINT,
	    COALESCE_ARRAYS };

    public static final String BASE_PATH = "appointment";
    public static final String APPOINTMENT_PATH = "{id}";

    private String baseUri;

    public void setBaseUri(String baseUri) {
	this.baseUri = baseUri;
    }

    UriBuilder newAppointmentUriBuilder() {
	Objects.requireNonNull(baseUri);

	return UriBuilder.fromUri(baseUri).path(BASE_PATH)
		.path(APPOINTMENT_PATH);
    }

    public Representation newAppointmentRepresentation(Appointment appt) {
	UriBuilder apptUriBuilder = newAppointmentUriBuilder();

	Representation rep = newRepresentation(apptUriBuilder.build(
		appt.getId()).toString());

	rep.withLink("edit", apptUriBuilder.build(appt.getId()).toString(),
		"cancel", "cancel", null, null);

	rep.withBean(appt);

	return rep;
    }

    public String convertToString(Representation rep) {
	return rep.toString(HAL_JSON, HAL_JSON_FLAGS);
    }

    public URI getRepresentationURI(Representation rep) {
	return create(rep.getResourceLink().getHref());
    }

    public ContentRepresentation getContent(String str) {
	return readRepresentation(HAL_JSON, new StringReader(str));
    }

    public String findRelUriWithTitle(String rel, ContentRepresentation rep,
	    String title) {
	return rep.getLinksByRel(rel).stream()
		.filter(l -> l.getTitle().equals(title)).findAny()
		.map(l -> l.getHref()).get();
    }
}
