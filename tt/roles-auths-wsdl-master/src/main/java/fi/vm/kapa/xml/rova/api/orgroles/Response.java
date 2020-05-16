
package fi.vm.kapa.xml.rova.api.orgroles;

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
 *         &lt;element name="organizationList" type="{http://xml.vrk.fi/ws/Rova/OrgRoles/Entities}OrganizationListType"/>
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
    "organizationList",
    "exceptionMessage"
})
public class Response {

    @XmlElement(required = true)
    protected OrganizationListType organizationList;
    @XmlElementRef(name = "exceptionMessage", type = JAXBElement.class, required = false)
    protected JAXBElement<String> exceptionMessage;

    /**
     * Gets the value of the organizationList property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationListType }
     *     
     */
    public OrganizationListType getOrganizationList() {
        return organizationList;
    }

    /**
     * Sets the value of the organizationList property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationListType }
     *     
     */
    public void setOrganizationList(OrganizationListType value) {
        this.organizationList = value;
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
