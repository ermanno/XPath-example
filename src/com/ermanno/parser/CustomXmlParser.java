package com.ermanno.parser;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class CustomXmlParser {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputStream fileStream = CustomXmlParser.class.getClassLoader().getResourceAsStream("config.xml");
		Document document = parser.parse(fileStream);
		XPath xpath = XPathFactory.newInstance().newXPath();
		String expression = "/wgt-config/solr-path";
		String path = (String) xpath.evaluate(expression, document, XPathConstants.STRING);
		System.out.println(path);
	}
}
