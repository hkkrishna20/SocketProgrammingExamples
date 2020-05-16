/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
 * 
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 * 
 * Contributor(s):
 * 
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package name.javacode.xml.jaxb.basic.unmarshalvalidate;

import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import name.javacode.xml.jaxb.basic.unmarshalvalidate.generated.ObjectFactory;

import org.xml.sax.SAXException;

public class Driver {

	// This sample application demonstrates how to enable validation during
	// the unmarshal operations.

	public static void main(String[] args) {
		try {
			JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class
					.getPackage().getName());

			// create an Unmarshaller
			Unmarshaller u = jc.createUnmarshaller();

			SchemaFactory sf = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);
			try {
				Schema schema = sf.newSchema(Driver.class
						.getResource("/po.xsd"));
				u.setSchema(schema);
				u.setEventHandler(new ValidationEventHandler() {
					// allow unmarshalling to continue even if there are errors
					public boolean handleEvent(ValidationEvent ve) {
						// ignore warnings
						if (ve.getSeverity() != ValidationEvent.WARNING) {
							ValidationEventLocator vel = ve.getLocator();
							System.out.println("Line:Col["
									+ vel.getLineNumber() + ":"
									+ vel.getColumnNumber() + "]:"
									+ ve.getMessage());
						}
						return true;
					}
				});
			} catch (SAXException se) {
				System.out
						.println("Unable to validate due to following error.");
				se.printStackTrace();
			}

			System.out
					.println("NOTE: This sample is working correctly if you see validation errors!!");
			Object poe = u.unmarshal(Driver.class
					.getResource("/unmarshal-validate/po.xml"));

			// even though document was determined to be invalid unmarshalling,
			// marshal out result.
			System.out.println("");
			System.out.println("Still able to marshal invalid document");
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(poe, System.out);
		} catch (UnmarshalException ue) {
			// The JAXB specification does not mandate how the JAXB provider
			// must behave when attempting to unmarshal invalid XML data. In
			// those cases, the JAXB provider is allowed to terminate the
			// call to unmarshal with an UnmarshalException.
			System.out.println("Caught UnmarshalException");
		} catch (JAXBException je) {
			je.printStackTrace();
		}
	}
}
