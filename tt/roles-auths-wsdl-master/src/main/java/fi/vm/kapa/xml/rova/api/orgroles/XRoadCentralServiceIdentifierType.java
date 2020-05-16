
package fi.vm.kapa.xml.rova.api.orgroles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for XRoadCentralServiceIdentifierType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XRoadCentralServiceIdentifierType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://x-road.eu/xsd/identifiers}XRoadIdentifierType">
 *       &lt;sequence>
 *         &lt;element ref="{http://x-road.eu/xsd/identifiers}xRoadInstance"/>
 *         &lt;element ref="{http://x-road.eu/xsd/identifiers}serviceCode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XRoadCentralServiceIdentifierType", namespace = "http://x-road.eu/xsd/identifiers")
public class XRoadCentralServiceIdentifierType
    extends XRoadIdentifierType
{


}
