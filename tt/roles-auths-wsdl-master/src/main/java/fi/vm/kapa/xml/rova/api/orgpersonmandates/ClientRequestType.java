
package fi.vm.kapa.xml.rova.api.orgpersonmandates;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClientRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClientRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="server" type="{http://x-road.eu/xsd/identifiers}XRoadCentralServiceIdentifierType"/>
 *         &lt;element name="client" type="{http://x-road.eu/xsd/identifiers}XRoadClientIdentifierType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClientRequestType", namespace = "http://x-road.eu/xsd/xroad.xsd", propOrder = {
    "server",
    "client"
})
public class ClientRequestType {

    @XmlElement(namespace = "http://x-road.eu/xsd/xroad.xsd", required = true)
    protected XRoadCentralServiceIdentifierType server;
    @XmlElement(namespace = "http://x-road.eu/xsd/xroad.xsd", required = true)
    protected XRoadClientIdentifierType client;

    /**
     * Gets the value of the server property.
     * 
     * @return
     *     possible object is
     *     {@link XRoadCentralServiceIdentifierType }
     *     
     */
    public XRoadCentralServiceIdentifierType getServer() {
        return server;
    }

    /**
     * Sets the value of the server property.
     * 
     * @param value
     *     allowed object is
     *     {@link XRoadCentralServiceIdentifierType }
     *     
     */
    public void setServer(XRoadCentralServiceIdentifierType value) {
        this.server = value;
    }

    /**
     * Gets the value of the client property.
     * 
     * @return
     *     possible object is
     *     {@link XRoadClientIdentifierType }
     *     
     */
    public XRoadClientIdentifierType getClient() {
        return client;
    }

    /**
     * Sets the value of the client property.
     * 
     * @param value
     *     allowed object is
     *     {@link XRoadClientIdentifierType }
     *     
     */
    public void setClient(XRoadClientIdentifierType value) {
        this.client = value;
    }

}
