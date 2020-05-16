@XmlSchema(xmlns = {
		@XmlNs(prefix = "ms", namespaceURI = "http://name.javacode/movieservice"),
		@XmlNs(prefix = "xs", namespaceURI = "http://www.w3.org/2001/XMLSchema") }, attributeFormDefault = XmlNsForm.UNQUALIFIED, elementFormDefault = XmlNsForm.QUALIFIED, namespace = "http://name.javacode/movieservice")
package name.javacode.moviemanager.domain;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;

