
package fi.vm.kapa.xml.rova.api.delegate;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="principalList" type="{http://xml.vrk.fi/ws/Rova/Delegate/Entities}Principal"/>
 *         &lt;element name="authorization" type="{http://xml.vrk.fi/ws/Rova/Delegate/Entities}AuthorizationType"/>
 *         &lt;element name="reason" type="{http://xml.vrk.fi/ws/Rova/Delegate/Entities}DecisionReasonType" maxOccurs="unbounded" minOccurs="0"/>
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
    "authorization",
    "reason",
    "exceptionMessage"
})
public class Response {

    @XmlElement(required = true)
    protected Principal principalList;
    @XmlElement(required = true)
    protected AuthorizationType authorization;
    @XmlElement(nillable = true)
    protected List<DecisionReasonType> reason;
    @XmlElementRef(name = "exceptionMessage", type = JAXBElement.class, required = false)
    protected JAXBElement<String> exceptionMessage;

    /**
     * Gets the value of the principalList property.
     * 
     * @return
     *     possible object is
     *     {@link Principal }
     *     
     */
    public Principal getPrincipalList() {
        return principalList;
    }

    /**
     * Sets the value of the principalList property.
     * 
     * @param value
     *     allowed object is
     *     {@link Principal }
     *     
     */
    public void setPrincipalList(Principal value) {
        this.principalList = value;
    }

    /**
     * Gets the value of the authorization property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorizationType }
     *     
     */
    public AuthorizationType getAuthorization() {
        return authorization;
    }

    /**
     * Sets the value of the authorization property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorizationType }
     *     
     */
    public void setAuthorization(AuthorizationType value) {
        this.authorization = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DecisionReasonType }
     * 
     * 
     */
    public List<DecisionReasonType> getReason() {
        if (reason == null) {
            reason = new ArrayList<DecisionReasonType>();
        }
        return this.reason;
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
