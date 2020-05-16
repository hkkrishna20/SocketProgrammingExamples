
package fi.vm.kapa.xml.rova.api.authorization.list;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RovaAuthorizationListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RovaAuthorizationListResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="roles" type="{http://xml.vrk.fi/ws/Rova/AuthorizationList/Entities}RoleList"/>
 *         &lt;element name="reason" type="{http://xml.vrk.fi/ws/Rova/AuthorizationList/Entities}DecisionReasonType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "RovaAuthorizationListResponse", propOrder = {
    "roles",
    "reason",
    "exceptionMessage"
})
public class RovaAuthorizationListResponse {

    @XmlElement(required = true)
    protected RoleList roles;
    @XmlElement(nillable = true)
    protected List<DecisionReasonType> reason;
    @XmlElementRef(name = "exceptionMessage", type = JAXBElement.class, required = false)
    protected JAXBElement<String> exceptionMessage;

    /**
     * Gets the value of the roles property.
     * 
     * @return
     *     possible object is
     *     {@link RoleList }
     *     
     */
    public RoleList getRoles() {
        return roles;
    }

    /**
     * Sets the value of the roles property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoleList }
     *     
     */
    public void setRoles(RoleList value) {
        this.roles = value;
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
