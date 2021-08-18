package br.org.caixa.jms.sibar;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.jboss.logging.Logger;

import br.org.caixa.jms.JMSConsumer;

public abstract class JMSMensagemXMLCosumer extends JMSConsumer{
	
	private static final String XML_TEMPLATE_REMOVE_NAMESPACE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"><xsl:template match=\"/\"><xsl:copy><xsl:apply-templates /></xsl:copy></xsl:template><xsl:template match=\"*\"><xsl:element name=\"{local-name()}\"><xsl:apply-templates select=\"@* | node()\" /></xsl:element></xsl:template><xsl:template match=\"@*\"><xsl:attribute name=\"{local-name()}\"><xsl:value-of select=\".\" /></xsl:attribute></xsl:template><xsl:template match=\"text() | processing-instruction() | comment()\"><xsl:copy /></xsl:template></xsl:stylesheet>";
	private final Logger logger = Logger.getLogger(JMSMensagemXMLCosumer.class);

	protected String transform(String xml) {
	    try {
	        var tFactory = TransformerFactory.newDefaultInstance();
	        String xsl = XML_TEMPLATE_REMOVE_NAMESPACE;

	        Source xslSource = new StreamSource(new ByteArrayInputStream(xsl.getBytes()));
	        var transformer = tFactory.newTransformer(xslSource);

	        Source xmlSource = new StreamSource(new ByteArrayInputStream(xml.getBytes()));
	        var outputStream = new ByteArrayOutputStream();
	        transformer.transform(xmlSource, new StreamResult(outputStream));

	        return new String(outputStream.toByteArray());

	    }
	    catch (Exception e) {
	    	logger.error("Erro ao remover namespace do xml", e);
	        return null;
	    }
	}
	
}
