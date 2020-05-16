
package com.sentenial.ws.client.mandate;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.5-b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MandateWs", targetNamespace = "urn:com:sentenial:origix:ws:mandate-ws:wsdl")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MandateWs {


    /**
     * 
     * @param addMandateRequest
     * @return
     *     returns com.sentenial.ws.client.mandate.AddMandateResponse
     */
    @WebMethod(operationName = "AddMandate")
    @WebResult(name = "AddMandateResponse", targetNamespace = "urn:com:sentenial:origix:ws:mandate-ws", partName = "AddMandateResponse")
    public AddMandateResponse addMandate(
        @WebParam(name = "AddMandateRequest", targetNamespace = "urn:com:sentenial:origix:ws:mandate-ws", partName = "AddMandateRequest")
        AddMandateRequest addMandateRequest);

    /**
     * 
     * @param editMandateRequest
     * @return
     *     returns com.sentenial.ws.client.mandate.EditMandateResponse
     */
    @WebMethod(operationName = "EditMandate")
    @WebResult(name = "EditMandateResponse", targetNamespace = "urn:com:sentenial:origix:ws:mandate-ws", partName = "EditMandateResponse")
    public EditMandateResponse editMandate(
        @WebParam(name = "EditMandateRequest", targetNamespace = "urn:com:sentenial:origix:ws:mandate-ws", partName = "EditMandateRequest")
        EditMandateRequest editMandateRequest);

    /**
     * 
     * @param viewMandateRequest
     * @return
     *     returns com.sentenial.ws.client.mandate.ViewMandateResponse
     */
    @WebMethod(operationName = "ViewMandate")
    @WebResult(name = "ViewMandateResponse", targetNamespace = "urn:com:sentenial:origix:ws:mandate-ws", partName = "ViewMandateResponse")
    public ViewMandateResponse viewMandate(
        @WebParam(name = "ViewMandateRequest", targetNamespace = "urn:com:sentenial:origix:ws:mandate-ws", partName = "ViewMandateRequest")
        ViewMandateRequest viewMandateRequest);

    /**
     * 
     * @param cancelMandateRequest
     * @return
     *     returns com.sentenial.ws.client.mandate.CancelMandateResponse
     */
    @WebMethod(operationName = "CancelMandate")
    @WebResult(name = "CancelMandateResponse", targetNamespace = "urn:com:sentenial:origix:ws:mandate-ws", partName = "CancelMandateResponse")
    public CancelMandateResponse cancelMandate(
        @WebParam(name = "CancelMandateRequest", targetNamespace = "urn:com:sentenial:origix:ws:mandate-ws", partName = "CancelMandateRequest")
        CancelMandateRequest cancelMandateRequest);

    /**
     * 
     * @param suspendMandateRequest
     * @return
     *     returns com.sentenial.ws.client.mandate.SuspendMandateResponse
     */
    @WebMethod(operationName = "SuspendMandate")
    @WebResult(name = "SuspendMandateResponse", targetNamespace = "urn:com:sentenial:origix:ws:mandate-ws", partName = "SuspendMandateResponse")
    public SuspendMandateResponse suspendMandate(
        @WebParam(name = "SuspendMandateRequest", targetNamespace = "urn:com:sentenial:origix:ws:mandate-ws", partName = "SuspendMandateRequest")
        SuspendMandateRequest suspendMandateRequest);

    /**
     * 
     * @param reactivateSuspendedMandateRequest
     * @return
     *     returns com.sentenial.ws.client.mandate.ReactivateSuspendedMandateResponse
     */
    @WebMethod(operationName = "ReactivateSuspendedMandate")
    @WebResult(name = "ReactivateSuspendedMandateResponse", targetNamespace = "urn:com:sentenial:origix:ws:mandate-ws", partName = "ReactivateSuspendedMandateResponse")
    public ReactivateSuspendedMandateResponse reactivateSuspendedMandate(
        @WebParam(name = "ReactivateSuspendedMandateRequest", targetNamespace = "urn:com:sentenial:origix:ws:mandate-ws", partName = "ReactivateSuspendedMandateRequest")
        ReactivateSuspendedMandateRequest reactivateSuspendedMandateRequest);

    /**
     * 
     * @param activateMandateRequest
     * @return
     *     returns com.sentenial.ws.client.mandate.ActivateMandateResponse
     */
    @WebMethod(operationName = "ActivateMandate")
    @WebResult(name = "ActivateMandateResponse", targetNamespace = "urn:com:sentenial:origix:ws:mandate-ws", partName = "ActivateMandateResponse")
    public ActivateMandateResponse activateMandate(
        @WebParam(name = "ActivateMandateRequest", targetNamespace = "urn:com:sentenial:origix:ws:mandate-ws", partName = "ActivateMandateRequest")
        ActivateMandateRequest activateMandateRequest);

}
