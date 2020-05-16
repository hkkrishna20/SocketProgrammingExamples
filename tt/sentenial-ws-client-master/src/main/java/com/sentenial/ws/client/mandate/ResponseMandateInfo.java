
package com.sentenial.ws.client.mandate;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ResponseMandateInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseMandateInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NewMandateId" type="{urn:com:sentenial:origix:ws:common:types}Max35Text" minOccurs="0"/>
 *         &lt;element name="MandateId" type="{urn:com:sentenial:origix:ws:common:types}Max35Text" minOccurs="0"/>
 *         &lt;element name="ContractRef" type="{urn:com:sentenial:origix:ws:common:types}Max35Text" minOccurs="0"/>
 *         &lt;element name="NewDomesticMandateId" type="{urn:com:sentenial:origix:ws:common:types}Max35Text" minOccurs="0"/>
 *         &lt;element name="DomesticMandateId" type="{urn:com:sentenial:origix:ws:common:types}Max35Text" minOccurs="0"/>
 *         &lt;element name="DomesticMandateCountry" type="{urn:com:sentenial:origix:ws:common:types}IsoCountryCode" minOccurs="0"/>
 *         &lt;element name="Type" type="{urn:com:sentenial:origix:ws:common:types}MandateType" minOccurs="0"/>
 *         &lt;element name="SignatureDate" type="{urn:com:sentenial:origix:ws:common:types}IsoDate" minOccurs="0"/>
 *         &lt;element name="SignatureLocation" type="{urn:com:sentenial:origix:ws:common:types}Max70Text" minOccurs="0"/>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/>
 *         &lt;element name="CreationDate" type="{urn:com:sentenial:origix:ws:common:types}IsoDate" minOccurs="0"/>
 *         &lt;element name="Status" type="{urn:com:sentenial:origix:ws:common:types}MandateStatus" minOccurs="0"/>
 *         &lt;element name="MandateOperationReason" type="{urn:com:sentenial:origix:ws:common:types}Max140Text" minOccurs="0"/>
 *         &lt;element name="DomesticOriginatorNumber" type="{urn:com:sentenial:origix:ws:common:types}Max35Text" minOccurs="0"/>
 *         &lt;element name="ResendMandateForSignature" type="{urn:com:sentenial:origix:ws:common:types}SignatureResubmitRequiredRule" minOccurs="0"/>
 *         &lt;element name="MigratingMandate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TotalCollected" type="{urn:com:sentenial:origix:ws:common:types}DecimalNumber" minOccurs="0"/>
 *         &lt;element name="TotalInFlight" type="{urn:com:sentenial:origix:ws:common:types}DecimalNumber" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseMandateInfo", namespace = "urn:com:sentenial:origix:ws:mandate", propOrder = {
    "newMandateId",
    "mandateId",
    "contractRef",
    "newDomesticMandateId",
    "domesticMandateId",
    "domesticMandateCountry",
    "type",
    "signatureDate",
    "signatureLocation",
    "userId",
    "creationDate",
    "status",
    "mandateOperationReason",
    "domesticOriginatorNumber",
    "resendMandateForSignature",
    "migratingMandate",
    "totalCollected",
    "totalInFlight"
})
public class ResponseMandateInfo {

    @XmlElement(name = "NewMandateId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String newMandateId;
    @XmlElement(name = "MandateId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String mandateId;
    @XmlElement(name = "ContractRef")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String contractRef;
    @XmlElement(name = "NewDomesticMandateId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String newDomesticMandateId;
    @XmlElement(name = "DomesticMandateId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String domesticMandateId;
    @XmlElement(name = "DomesticMandateCountry")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String domesticMandateCountry;
    @XmlElement(name = "Type")
    protected MandateType type;
    @XmlElement(name = "SignatureDate")
    protected XMLGregorianCalendar signatureDate;
    @XmlElement(name = "SignatureLocation")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String signatureLocation;
    @XmlElement(name = "UserId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String userId;
    @XmlElement(name = "CreationDate")
    protected XMLGregorianCalendar creationDate;
    @XmlElement(name = "Status")
    protected MandateStatus status;
    @XmlElement(name = "MandateOperationReason")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String mandateOperationReason;
    @XmlElement(name = "DomesticOriginatorNumber")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String domesticOriginatorNumber;
    @XmlElement(name = "ResendMandateForSignature")
    protected SignatureResubmitRequiredRule resendMandateForSignature;
    @XmlElement(name = "MigratingMandate")
    protected Boolean migratingMandate;
    @XmlElement(name = "TotalCollected")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String totalCollected;
    @XmlElement(name = "TotalInFlight")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String totalInFlight;

    /**
     * Gets the value of the newMandateId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewMandateId() {
        return newMandateId;
    }

    /**
     * Sets the value of the newMandateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewMandateId(String value) {
        this.newMandateId = value;
    }

    /**
     * Gets the value of the mandateId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMandateId() {
        return mandateId;
    }

    /**
     * Sets the value of the mandateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMandateId(String value) {
        this.mandateId = value;
    }

    /**
     * Gets the value of the contractRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractRef() {
        return contractRef;
    }

    /**
     * Sets the value of the contractRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractRef(String value) {
        this.contractRef = value;
    }

    /**
     * Gets the value of the newDomesticMandateId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewDomesticMandateId() {
        return newDomesticMandateId;
    }

    /**
     * Sets the value of the newDomesticMandateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewDomesticMandateId(String value) {
        this.newDomesticMandateId = value;
    }

    /**
     * Gets the value of the domesticMandateId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomesticMandateId() {
        return domesticMandateId;
    }

    /**
     * Sets the value of the domesticMandateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomesticMandateId(String value) {
        this.domesticMandateId = value;
    }

    /**
     * Gets the value of the domesticMandateCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomesticMandateCountry() {
        return domesticMandateCountry;
    }

    /**
     * Sets the value of the domesticMandateCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomesticMandateCountry(String value) {
        this.domesticMandateCountry = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link MandateType }
     *     
     */
    public MandateType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandateType }
     *     
     */
    public void setType(MandateType value) {
        this.type = value;
    }

    /**
     * Gets the value of the signatureDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSignatureDate() {
        return signatureDate;
    }

    /**
     * Sets the value of the signatureDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSignatureDate(XMLGregorianCalendar value) {
        this.signatureDate = value;
    }

    /**
     * Gets the value of the signatureLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignatureLocation() {
        return signatureLocation;
    }

    /**
     * Sets the value of the signatureLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignatureLocation(String value) {
        this.signatureLocation = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link MandateStatus }
     *     
     */
    public MandateStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandateStatus }
     *     
     */
    public void setStatus(MandateStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the mandateOperationReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMandateOperationReason() {
        return mandateOperationReason;
    }

    /**
     * Sets the value of the mandateOperationReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMandateOperationReason(String value) {
        this.mandateOperationReason = value;
    }

    /**
     * Gets the value of the domesticOriginatorNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomesticOriginatorNumber() {
        return domesticOriginatorNumber;
    }

    /**
     * Sets the value of the domesticOriginatorNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomesticOriginatorNumber(String value) {
        this.domesticOriginatorNumber = value;
    }

    /**
     * Gets the value of the resendMandateForSignature property.
     * 
     * @return
     *     possible object is
     *     {@link SignatureResubmitRequiredRule }
     *     
     */
    public SignatureResubmitRequiredRule getResendMandateForSignature() {
        return resendMandateForSignature;
    }

    /**
     * Sets the value of the resendMandateForSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureResubmitRequiredRule }
     *     
     */
    public void setResendMandateForSignature(SignatureResubmitRequiredRule value) {
        this.resendMandateForSignature = value;
    }

    /**
     * Gets the value of the migratingMandate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMigratingMandate() {
        return migratingMandate;
    }

    /**
     * Sets the value of the migratingMandate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMigratingMandate(Boolean value) {
        this.migratingMandate = value;
    }

    /**
     * Gets the value of the totalCollected property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalCollected() {
        return totalCollected;
    }

    /**
     * Sets the value of the totalCollected property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalCollected(String value) {
        this.totalCollected = value;
    }

    /**
     * Gets the value of the totalInFlight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalInFlight() {
        return totalInFlight;
    }

    /**
     * Sets the value of the totalInFlight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalInFlight(String value) {
        this.totalInFlight = value;
    }

}
