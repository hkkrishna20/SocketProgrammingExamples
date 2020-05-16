package name.javacode.webservices.jaxrs.provider.readerNwriter;

import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import name.javacode.webservices.jaxrs.provider.domain.Car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* A Java EE container can scan and register classes annotated with @Provider; Servlet containers like Jetty can't so
 * Providers need to be registered with the Application class.
 */

@Provider
@Produces(MediaType.APPLICATION_XML)
public class CarsMarshaler implements MessageBodyWriter<List<Car>> {
    private static final Logger LOGGER = LoggerFactory
	    .getLogger(CarsMarshaler.class);

    @Override
    public boolean isWriteable(Class<?> type, Type genericType,
	    Annotation[] annotations, MediaType mediaType) {
	return ProviderUtil.isManageable(type, genericType, annotations,
		mediaType);
    }

    @Override
    public long getSize(List<Car> cars, Class<?> type, Type genericType,
	    Annotation[] annotations, MediaType mediaType) {
	return -1;
    }

    @Override
    public void writeTo(List<Car> cars, Class<?> type, Type genericType,
	    Annotation[] annotations, MediaType mediaType,
	    MultivaluedMap<String, Object> httpHeaders,
	    OutputStream entityStream) {

	writeXML(cars, type, genericType, mediaType, entityStream);
    }

    private void writeXML(List<Car> cars, Class<?> type, Type genericType,
	    MediaType mediaType, OutputStream entityStream) {
	LOGGER.info("Writing out a list of cars to XML.");

	Transformer tf = null;

	try {
	    tf = TransformerFactory.newInstance().newTransformer();

	    String namespace = "http://javacode.name/webservices/jaxrs/provider/";
	    String namespacePrefix = "jc";
	    String carsLocalName = "cars";
	    String aCarLocalName = "car";
	    String classnameAttr = "classname";

	    DocumentBuilderFactory docFactory = DocumentBuilderFactory
		    .newInstance();
	    Document doc = docFactory.newDocumentBuilder().newDocument();

	    doc.setXmlStandalone(true);
	    doc.setXmlVersion("1.0");

	    Element rootElement = doc.createElementNS(namespace,
		    namespacePrefix + ":" + carsLocalName);
	    Element childElement = null;

	    for (Car aCar : cars) {
		childElement = doc.createElement(aCarLocalName);
		childElement.setAttribute(classnameAttr, aCar.getClass()
			.getName());
		childElement.setTextContent(aCar.getName());

		rootElement.appendChild(childElement);
	    }

	    Source source = new DOMSource(rootElement);
	    Result result = new StreamResult(entityStream);

	    tf.transform(source, result);

	} catch (Exception e) {
	    throw new WebApplicationException(
		    "Can't marshal content for media type="
			    + mediaType.toString() + ", type=" + type
			    + ", genericType=" + genericType,
		    Status.INTERNAL_SERVER_ERROR);
	}
    }
}
