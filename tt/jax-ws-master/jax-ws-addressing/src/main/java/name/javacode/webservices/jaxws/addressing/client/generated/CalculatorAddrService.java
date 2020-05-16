
package name.javacode.webservices.jaxws.addressing.client.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CalculatorAddrService", targetNamespace = "http://addressing.jaxws.webservices.javacode.name/", wsdlLocation = "http://localhost:8080/jax-ws-addressing/CalculatorAddrService?wsdl")
public class CalculatorAddrService
    extends Service
{

    private final static URL CALCULATORADDRSERVICE_WSDL_LOCATION;
    private final static WebServiceException CALCULATORADDRSERVICE_EXCEPTION;
    private final static QName CALCULATORADDRSERVICE_QNAME = new QName("http://addressing.jaxws.webservices.javacode.name/", "CalculatorAddrService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/jax-ws-addressing/CalculatorAddrService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CALCULATORADDRSERVICE_WSDL_LOCATION = url;
        CALCULATORADDRSERVICE_EXCEPTION = e;
    }

    public CalculatorAddrService() {
        super(__getWsdlLocation(), CALCULATORADDRSERVICE_QNAME);
    }

    public CalculatorAddrService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CALCULATORADDRSERVICE_QNAME, features);
    }

    public CalculatorAddrService(URL wsdlLocation) {
        super(wsdlLocation, CALCULATORADDRSERVICE_QNAME);
    }

    public CalculatorAddrService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CALCULATORADDRSERVICE_QNAME, features);
    }

    public CalculatorAddrService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CalculatorAddrService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CalculatorAddr
     */
    @WebEndpoint(name = "CalculatorAddrPort")
    public CalculatorAddr getCalculatorAddrPort() {
        return super.getPort(new QName("http://addressing.jaxws.webservices.javacode.name/", "CalculatorAddrPort"), CalculatorAddr.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CalculatorAddr
     */
    @WebEndpoint(name = "CalculatorAddrPort")
    public CalculatorAddr getCalculatorAddrPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://addressing.jaxws.webservices.javacode.name/", "CalculatorAddrPort"), CalculatorAddr.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CALCULATORADDRSERVICE_EXCEPTION!= null) {
            throw CALCULATORADDRSERVICE_EXCEPTION;
        }
        return CALCULATORADDRSERVICE_WSDL_LOCATION;
    }

}
