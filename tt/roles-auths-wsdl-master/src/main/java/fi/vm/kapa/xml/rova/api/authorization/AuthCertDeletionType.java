
package fi.vm.kapa.xml.rova.api.authorization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for authCertDeletionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="authCertDeletionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="server" type="{http://x-road.eu/xsd/identifiers}XRoadCentralServiceIdentifierType"/>
 *         &lt;element name="authCert" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authCertDeletionType", namespace = "http://x-road.eu/xsd/xroad.xsd", propOrder = {
    "server",
    "authCert"
})
public class AuthCertDeletionType {

    @XmlElement(namespace = "http://x-road.eu/xsd/xroad.xsd", required = true)
    protected XRoadCentralServiceIdentifierType server;
    @XmlElement(namespace = "http://x-road.eu/xsd/xroad.xsd", required = true)
    protected byte[] authCert;

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
     * Gets the value of the authCert property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAuthCert() {
        return authCert;
    }

    /**
     * Sets the value of the authCert property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAuthCert(byte[] value) {
        this.authCert = value;
    }

}
