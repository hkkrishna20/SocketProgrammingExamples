
package fi.vm.kapa.xml.rova.api.orgpersonmandates;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="principalList" type="{http://xml.vrk.fi/ws/Rova/OrgPersonMandates/Entities}PrincipalListType"/>
 *         &lt;element name="exceptionMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Response", propOrder = {
    "principalList",
    "exceptionMessage"
})
public class Response {

    @XmlElement(required = true, nillable = true)
    protected PrincipalListType principalList;
    @XmlElementRef(name = "exceptionMessage", type = JAXBElement.class, required = false)
    protected JAXBElement<String> exceptionMessage;

    /**
     * Gets the value of the principalList property.
     * 
     * @return
     *     possible object is
     *     {@link PrincipalListType }
     *     
     */
    public PrincipalListType getPrincipalList() {
        return principalList;
    }

    /**
     * Sets the value of the principalList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrincipalListType }
     *     
     */
    public void setPrincipalList(PrincipalListType value) {
        this.principalList = value;
    }

    /**
     * Gets the value of the exceptionMessage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExceptionMessage() {
        return exceptionMessage;
    }

    /**
     * Sets the value of the exceptionMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExceptionMessage(JAXBElement<String> value) {
        this.exceptionMessage = value;
    }

}
