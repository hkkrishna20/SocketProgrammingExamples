
package fi.vm.kapa.xml.rova.api.delegate;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthorizationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AuthorizationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALLOWED"/>
 *     &lt;enumeration value="DISALLOWED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AuthorizationType")
@XmlEnum
public enum AuthorizationType {

    ALLOWED,
    DISALLOWED;

    public String value() {
        return name();
    }

    public static AuthorizationType fromValue(String v) {
        return valueOf(v);
    }

}
