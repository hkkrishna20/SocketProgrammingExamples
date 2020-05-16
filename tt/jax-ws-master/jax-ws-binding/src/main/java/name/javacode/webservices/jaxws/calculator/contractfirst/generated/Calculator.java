
package name.javacode.webservices.jaxws.calculator.contractfirst.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Calculator", targetNamespace = "http://javacode.name/webservices/jaxws/calculator-cf/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Calculator {


    /**
     * 
     * 			  
     * 			    When the operation name, input message name and the
     * 				input message element name don't all match up,
     * 				'bare' parameter style is the used by default.
     * 			  
     * 			
     * 
     * @param parameters
     * @return
     *     returns name.javacode.webservices.jaxws.calculator.contractfirst.generated.AddResponse
     */
    @WebMethod
    @WebResult(name = "addResponse", targetNamespace = "http://javacode.name/webservices/jaxws/calculator-cf/", partName = "parameters")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public AddResponse addDefaultBare(
        @WebParam(name = "addDefaultBareRequest", targetNamespace = "http://javacode.name/webservices/jaxws/calculator-cf/", partName = "parameters")
        AddDefaultBareRequest parameters);

    /**
     * 
     * 			  
     * 			    When the operation name, input message name and the input message 
     * 			    element name all match up, 'wrapped' parameter style is the used by default.
     * 			  
     * 			
     * 
     * @param param1
     * @param param2
     * @return
     *     returns float
     */
    @WebMethod
    @WebResult(name = "result", targetNamespace = "")
    @RequestWrapper(localName = "subtractDefaultWrapped", targetNamespace = "http://javacode.name/webservices/jaxws/calculator-cf/", className = "name.javacode.webservices.jaxws.calculator.contractfirst.generated.SubtractDefaultWrapped")
    @ResponseWrapper(localName = "subtractResponse", targetNamespace = "http://javacode.name/webservices/jaxws/calculator-cf/", className = "name.javacode.webservices.jaxws.calculator.contractfirst.generated.SubtractResponse")
    public float subtractDefaultWrapped(
        @WebParam(name = "param1", targetNamespace = "")
        float param1,
        @WebParam(name = "param2", targetNamespace = "")
        float param2);

}