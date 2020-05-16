
package fi.vm.kapa.xml.rova.api.orgroles;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="delegateIdentifier">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="organizationIdentifier" maxOccurs="unbounded" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Request", propOrder = {
    "delegateIdentifier",
    "organizationIdentifier"
})
public class Request {

    @XmlElement(required = true)
    protected String delegateIdentifier;
    @XmlElement(nillable = true)
    protected List<String> organizationIdentifier;

    /**
     * Gets the value of the delegateIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelegateIdentifier() {
        return delegateIdentifier;
    }

    /**
     * Sets the value of the delegateIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelegateIdentifier(String value) {
        this.delegateIdentifier = value;
    }

    /**
     * Gets the value of the organizationIdentifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the organizationIdentifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrganizationIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOrganizationIdentifier() {
        if (organizationIdentifier == null) {
            organizationIdentifier = new ArrayList<String>();
        }
        return this.organizationIdentifier;
    }

}
