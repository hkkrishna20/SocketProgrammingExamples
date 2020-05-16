
package fi.vm.kapa.xml.rova.api.orgmandates;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "rovaOrgMandatesPortType", targetNamespace = "http://xml.vrk.fi/ws/Rova/OrgMandates")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RovaOrgMandatesPortType {


    /**
     * 
     * @param request
     * @param response
     */
    @WebMethod
    @RequestWrapper(localName = "rovaOrgMandatesService", targetNamespace = "http://xml.vrk.fi/ws/Rova/OrgMandates/Entities", className = "fi.vm.kapa.xml.rova.api.orgmandates.RovaOrgMandatesService")
    @ResponseWrapper(localName = "rovaOrgMandatesServiceResponse", targetNamespace = "http://xml.vrk.fi/ws/Rova/OrgMandates/Entities", className = "fi.vm.kapa.xml.rova.api.orgmandates.RovaOrgMandatesServiceResponse")
    public void rovaOrgMandatesService(
        @WebParam(name = "request", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<Request> request,
        @WebParam(name = "response", targetNamespace = "", mode = WebParam.Mode.OUT)
        Holder<Response> response);

}
