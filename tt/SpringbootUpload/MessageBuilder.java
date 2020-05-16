package com.mkyong.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class MessageBuilder {

	static InputStream getStream(String fileName) {
		InputStream xslStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("/" + fileName);
		if (xslStream == null) {
			xslStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
		}
		return xslStream;
	}

	
	public String convert(InputStream inputStream) throws IOException {
		Charset charset = StandardCharsets.UTF_8;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset))) {
			return br.lines().collect(Collectors.joining(System.lineSeparator()));
		}
	}

	public String getMessage(String name) throws FileNotFoundException {

		StringBuilder result = new StringBuilder();
		URL xmlURL = MessageBuilder.class.getResource("tool.xml");
		URL xslURL = MessageBuilder.class.getResource("tool.xsl");
		final StringWriter writer = new StringWriter();
		final StreamResult output = new StreamResult(writer);

		try {
			InputStream xslStream = xslURL.openStream();
			InputStream xmlStream = xmlURL.openStream();
			//System.out.println("xsl Input Stream" + new MessageBuilder().convert(xslStream));
			//System.out.println("xml Input Stream" + new MessageBuilder().convert(xmlStream));
			TransformerFactory factory = TransformerFactory.newInstance();
			Source xslt = new StreamSource(xslStream);
			Transformer transformer = factory.newTransformer(xslt);

			Source text = new StreamSource(xmlStream);
			transformer.transform(text, output);
			return writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * // InputStream xslStream = new
		 * ByteArrayInputStream(XSLTRule.getBytes("UTF-8")); Source xslInput = new
		 * StreamSource(is); Source xmlInput = new StreamSource(is2);
		 * 
		 * Transformer transformer = tFactory.newTransformer(xslInput); // this is the
		 * line that throws the exception
		 * 
		 * ByteArrayOutputStream bos = new ByteArrayOutputStream(); Result resultw = new
		 * StreamResult(bos); transformer.transform(xmlInput, resultw); String s = new
		 * String(bos.toByteArray()); System.out.println(s); if (name == null ||
		 * name.trim().length() == 0) {
		 * 
		 * result.append("Please provide a name!");
		 * 
		 * } else {
		 * 
		 * result.append("Hello " + name);
		 * 
		 * }
		 */

		return result.toString();
	}

}
