
package fi.vm.kapa.xml.rova.api.orgmandates;

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
 *         &lt;element name="delegate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="principal" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
    "delegate",
    "principal"
})
public class Request {

    @XmlElement(required = true)
    protected String delegate;
    @XmlElement(required = true)
    protected List<String> principal;

    /**
     * Gets the value of the delegate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelegate() {
        return delegate;
    }

    /**
     * Sets the value of the delegate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelegate(String value) {
        this.delegate = value;
    }

    /**
     * Gets the value of the principal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the principal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrincipal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPrincipal() {
        if (principal == null) {
            principal = new ArrayList<String>();
        }
        return this.principal;
    }

}
