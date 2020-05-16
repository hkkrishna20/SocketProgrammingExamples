
package fi.vm.kapa.xml.rova.api.orgpersonmandates;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fi.vm.kapa.xml.rova.api.orgpersonmandates package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MemberCode_QNAME = new QName("http://x-road.eu/xsd/identifiers", "memberCode");
    private final static QName _ServiceVersion_QNAME = new QName("http://x-road.eu/xsd/identifiers", "serviceVersion");
    private final static QName _UserId_QNAME = new QName("http://x-road.eu/xsd/xroad.xsd", "userId");
    private final static QName _Id_QNAME = new QName("http://x-road.eu/xsd/xroad.xsd", "id");
    private final static QName _ServiceCode_QNAME = new QName("http://x-road.eu/xsd/identifiers", "serviceCode");
    private final static QName _ProtocolVersion_QNAME = new QName("http://x-road.eu/xsd/xroad.xsd", "protocolVersion");
    private final static QName _Client_QNAME = new QName("http://x-road.eu/xsd/xroad.xsd", "client");
    private final static QName _XRoadInstance_QNAME = new QName("http://x-road.eu/xsd/identifiers", "xRoadInstance");
    private final static QName _Service_QNAME = new QName("http://x-road.eu/xsd/xroad.xsd", "service");
    private final static QName _Async_QNAME = new QName("http://x-road.eu/xsd/xroad.xsd", "async");
    private final static QName _MemberClass_QNAME = new QName("http://x-road.eu/xsd/identifiers", "memberClass");
    private final static QName _SubsystemCode_QNAME = new QName("http://x-road.eu/xsd/identifiers", "subsystemCode");
    private final static QName _ResponseExceptionMessage_QNAME = new QName("", "exceptionMessage");
    private final static QName _OrgPersonMandatesTypeIncomplete_QNAME = new QName("", "incomplete");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fi.vm.kapa.xml.rova.api.orgpersonmandates
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link XRoadServiceIdentifierType }
     * 
     */
    public XRoadServiceIdentifierType createXRoadServiceIdentifierType() {
        return new XRoadServiceIdentifierType();
    }

    /**
     * Create an instance of {@link XRoadClientIdentifierType }
     * 
     */
    public XRoadClientIdentifierType createXRoadClientIdentifierType() {
        return new XRoadClientIdentifierType();
    }

    /**
     * Create an instance of {@link AuthCertDeletionType }
     * 
     */
    public AuthCertDeletionType createAuthCertDeletionType() {
        return new AuthCertDeletionType();
    }

    /**
     * Create an instance of {@link ClientRequestType }
     * 
     */
    public ClientRequestType createClientRequestType() {
        return new ClientRequestType();
    }

    /**
     * Create an instance of {@link XRoadCentralServiceIdentifierType }
     * 
     */
    public XRoadCentralServiceIdentifierType createXRoadCentralServiceIdentifierType() {
        return new XRoadCentralServiceIdentifierType();
    }

    /**
     * Create an instance of {@link XRoadIdentifierType }
     * 
     */
    public XRoadIdentifierType createXRoadIdentifierType() {
        return new XRoadIdentifierType();
    }

    /**
     * Create an instance of {@link RovaOrgPersonMandatesService }
     * 
     */
    public RovaOrgPersonMandatesService createRovaOrgPersonMandatesService() {
        return new RovaOrgPersonMandatesService();
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link RovaOrgPersonMandatesServiceResponse }
     * 
     */
    public RovaOrgPersonMandatesServiceResponse createRovaOrgPersonMandatesServiceResponse() {
        return new RovaOrgPersonMandatesServiceResponse();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link PrincipalListType }
     * 
     */
    public PrincipalListType createPrincipalListType() {
        return new PrincipalListType();
    }

    /**
     * Create an instance of {@link OrgPersonMandatesType }
     * 
     */
    public OrgPersonMandatesType createOrgPersonMandatesType() {
        return new OrgPersonMandatesType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/identifiers", name = "memberCode")
    public JAXBElement<String> createMemberCode(String value) {
        return new JAXBElement<String>(_MemberCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/identifiers", name = "serviceVersion")
    public JAXBElement<String> createServiceVersion(String value) {
        return new JAXBElement<String>(_ServiceVersion_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/xroad.xsd", name = "userId")
    public JAXBElement<String> createUserId(String value) {
        return new JAXBElement<String>(_UserId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/xroad.xsd", name = "id")
    public JAXBElement<String> createId(String value) {
        return new JAXBElement<String>(_Id_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/identifiers", name = "serviceCode")
    public JAXBElement<String> createServiceCode(String value) {
        return new JAXBElement<String>(_ServiceCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/xroad.xsd", name = "protocolVersion")
    public JAXBElement<String> createProtocolVersion(String value) {
        return new JAXBElement<String>(_ProtocolVersion_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XRoadClientIdentifierType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/xroad.xsd", name = "client")
    public JAXBElement<XRoadClientIdentifierType> createClient(XRoadClientIdentifierType value) {
        return new JAXBElement<XRoadClientIdentifierType>(_Client_QNAME, XRoadClientIdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/identifiers", name = "xRoadInstance")
    public JAXBElement<String> createXRoadInstance(String value) {
        return new JAXBElement<String>(_XRoadInstance_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XRoadServiceIdentifierType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/xroad.xsd", name = "service")
    public JAXBElement<XRoadServiceIdentifierType> createService(XRoadServiceIdentifierType value) {
        return new JAXBElement<XRoadServiceIdentifierType>(_Service_QNAME, XRoadServiceIdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/xroad.xsd", name = "async")
    public JAXBElement<Boolean> createAsync(Boolean value) {
        return new JAXBElement<Boolean>(_Async_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/identifiers", name = "memberClass")
    public JAXBElement<String> createMemberClass(String value) {
        return new JAXBElement<String>(_MemberClass_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/identifiers", name = "subsystemCode")
    public JAXBElement<String> createSubsystemCode(String value) {
        return new JAXBElement<String>(_SubsystemCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "exceptionMessage", scope = Response.class)
    public JAXBElement<String> createResponseExceptionMessage(String value) {
        return new JAXBElement<String>(_ResponseExceptionMessage_QNAME, String.class, Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "incomplete", scope = OrgPersonMandatesType.class)
    public JAXBElement<Boolean> createOrgPersonMandatesTypeIncomplete(Boolean value) {
        return new JAXBElement<Boolean>(_OrgPersonMandatesTypeIncomplete_QNAME, Boolean.class, OrgPersonMandatesType.class, value);
    }

}
