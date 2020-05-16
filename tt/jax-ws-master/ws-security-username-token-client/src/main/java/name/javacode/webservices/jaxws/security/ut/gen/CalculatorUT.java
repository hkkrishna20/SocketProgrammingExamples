
package name.javacode.webservices.jaxws.security.ut.gen;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CalculatorUT", targetNamespace = "http://javacode.name/webservices/jaxws/security/CalculatorUT/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CalculatorUT {


    /**
     * 
     * @param i
     * @param j
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "add", targetNamespace = "http://javacode.name/webservices/jaxws/security/CalculatorUT/", className = "name.javacode.webservices.jaxws.security.ut.gen.Add")
    @ResponseWrapper(localName = "addResponse", targetNamespace = "http://javacode.name/webservices/jaxws/security/CalculatorUT/", className = "name.javacode.webservices.jaxws.security.ut.gen.AddResponse")
    public int add(
        @WebParam(name = "i", targetNamespace = "")
        int i,
        @WebParam(name = "j", targetNamespace = "")
        int j);

}
