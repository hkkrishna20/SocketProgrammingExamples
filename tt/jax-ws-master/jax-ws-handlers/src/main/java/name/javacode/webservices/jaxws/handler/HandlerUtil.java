package name.javacode.webservices.jaxws.handler;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.LogicalMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HandlerUtil {
    private static final Logger LOGGER = LoggerFactory
	    .getLogger(HandlerUtil.class);

    public void prettyPrintSOAPMessage(SOAPMessage soapMessage) {
	if (soapMessage.countAttachments() == 0) {
	    // This should have been enough for logging but it does not
	    // pretty-print
	    String soapMsgContent = soapMsgContent(soapMessage);

	    // Need to be careful so as not to unintentionally change the SOAP
	    // message. Could happen if a DOMSource is used
	    Source src = new StreamSource(new StringReader(soapMsgContent));

	    StreamResult result = (StreamResult) transform(src);

	    LOGGER.debug("SOAPMessage: \n{}.", result.getWriter().toString());
	} else {
	    LOGGER.info("Logging of SOAP messages with attachments is not supported yet.");

	    LOGGER.info("Number of attachments: {}.",
		    soapMessage.countAttachments());
	}
    }

    private String soapMsgContent(SOAPMessage soapMessage) {
	String soapMsgContent = "";

	try {
	    OutputStream os = new ByteArrayOutputStream();
	    soapMessage.writeTo(os);
	    soapMsgContent = os.toString();

	    os.close();
	} catch (Exception e) {
	    LOGGER.error(e.getMessage(), e);
	}

	return soapMsgContent;
    }

    public void prettyPrintLogicalMessage(LogicalMessage logicalMessage) {

	Source payload = logicalMessage.getPayload();

	StreamResult result = (StreamResult) transform(payload);

	LOGGER.debug("Payload: \n{}.", result.getWriter().toString());
    }

    public Result transform(Source src, Transformer transformer) {
	Writer writer = new StringWriter();
	StreamResult result = new StreamResult(writer);

	initTransformer(transformer);

	try {
	    transformer.transform(src, result);

	    writer.close();
	} catch (Exception e) {
	    LOGGER.error(e.getMessage(), e);
	}

	return result;
    }

    protected void initTransformer(Transformer transformer) {
	transformer.reset();
	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	transformer.setOutputProperty(
		"{http://xml.apache.org/xslt}indent-amount", "2");
    }

    public Result transform(Source src) {
	return transform(src, newTransformer());
    }

    private Transformer newTransformer() {
	TransformerFactory factory = TransformerFactory.newInstance();
	try {
	    return factory.newTransformer();
	} catch (TransformerConfigurationException e) {
	    LOGGER.error(e.getMessage(), e);
	}
	return null;
    }
}
