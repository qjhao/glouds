package sin.glouds.util.webservice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;

import org.w3c.dom.Document;

/**
 * SOAP 工具类
 * 
 * 
 * @author JohnSin
 *
 */
public final class SoapUtil {

	private static <T> SoapResult<T> request(SOAPMessage requestMessage, Class<T> response, String url) throws Exception {
		URL urll = new URL(url);
		HttpURLConnection connection = (HttpURLConnection)urll.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("content-type", "text/xml;charset=utf-8");
		connection.setDoInput(true);
		connection.setDoOutput(true);
		OutputStream os = connection.getOutputStream();
		requestMessage.writeTo(os);
		int responseCode = connection.getResponseCode();
		if(200 == responseCode) {
			System.out.println("success");
			InputStream is = null;
			try {
				is = connection.getInputStream();
				SOAPMessage responseMessage = MessageFactory.newInstance(SOAPConstants.DEFAULT_SOAP_PROTOCOL).createMessage(null, is);
				responseMessage.writeTo(System.out);
				Unmarshaller unmarshaller = JAXBContext.newInstance(response).createUnmarshaller();
				JAXBElement<T> element = unmarshaller.unmarshal(responseMessage.getSOAPBody().extractContentAsDocument(), response);
				return SoapResult.success(element.getValue());
			}catch(Exception e) {
				e.printStackTrace();
				throw e;
			}finally {
				os.close();
			}
		}else {
			System.out.println(connection.getResponseCode());
			InputStream is = null;
			try {
				is = connection.getErrorStream();
				SOAPMessage responseMessage = MessageFactory.newInstance(SOAPConstants.DEFAULT_SOAP_PROTOCOL).createMessage(null, is);
				responseMessage.writeTo(System.out);
				System.out.println();
				if(responseMessage.getSOAPBody().hasFault()) {
					SOAPFault fault = responseMessage.getSOAPBody().getFault();
					return SoapResult.fail(fault);
				}
				throw new RuntimeException("未知的异常");
//				JAXBElement<Fault> element = unmarshaller.unmarshal(responseMessage.getSOAPBody().extractContentAsDocument(), Fault.class);
//				return SoapResult.fail(element.getValue());
			}catch(Exception e) {
				e.printStackTrace();
				throw e;
			}finally {
				os.close();
			}
		}
	}

	private static SOAPMessage getRequestMessage(Object param, String envelopePrefix, String bodyPrefix) throws ParserConfigurationException, JAXBException, SOAPException, IOException {
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Marshaller marshaller = JAXBContext.newInstance(param.getClass()).createMarshaller();
		marshaller.marshal(param, document);
		SOAPMessage message = MessageFactory.newInstance(SOAPConstants.DEFAULT_SOAP_PROTOCOL).createMessage();
		
		SOAPBody soapBody = message.getSOAPBody();
		soapBody.addDocument(document);
		
		SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
		envelope.removeNamespaceDeclaration("SOAP-ENV");
		envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
		envelope.setPrefix(envelopePrefix);
		envelope.removeChild(envelope.getHeader());
		soapBody.setPrefix(bodyPrefix);
		message.writeTo(System.out);
		return message;
	}
	
	public static <T> SoapResult<T> request(Object param, Class<T> responseClass, String url, String prefix) throws ParserConfigurationException, JAXBException, SOAPException, IOException, Exception {
		return request(getRequestMessage(param, prefix, prefix), responseClass, url);
	}
}
