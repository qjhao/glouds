package com.eagerto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.hibernate.validator.internal.util.privilegedactions.Unmarshal;
import org.w3c.dom.Document;

import sin.glouds.util.webservice.SoapResult;
import sin.glouds.util.webservice.SoapUtil;

@XmlRootElement(namespace = "http://www.eagerto.com", name = "test2")
public class Test {

	public static void main(String[] args) throws Exception {
//		request();
		
		SoapResult<TestResponse> result = SoapUtil.request(new Test(), TestResponse.class, "http://localhost/webService/server", "soap");
		if(result.isFlag()) {
			System.out.println(result.getResult().getResult());
		}else {
			System.out.println(result.getErrorMessage().getFaultString());
		}
	}
	
	public static SOAPMessage getSoapMessage(Object obj) throws ParserConfigurationException, JAXBException, SOAPException, IOException {
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Marshaller marshaller = JAXBContext.newInstance(Test.class).createMarshaller();
		marshaller.marshal(new Test(), document);
		SOAPMessage message = MessageFactory.newInstance(SOAPConstants.DEFAULT_SOAP_PROTOCOL).createMessage();
		
		SOAPBody soapBody = message.getSOAPBody();
		soapBody.addDocument(document);
		
		SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
		envelope.removeNamespaceDeclaration("SOAP-ENV");
		envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
		envelope.setPrefix("soap");
		envelope.removeChild(envelope.getHeader());
		soapBody.setPrefix("soap");
		return message;
	}
	
	public static void request() throws IOException, SOAPException, ParserConfigurationException, JAXBException {
//		User user = new Ws().getWsServerPort().getUser("1");
//		System.out.println(user == null?"-=":user.getName());
		URL url = new URL("http://localhost/webService/server");
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("content-type", "text/xml;charset=utf-8");
		connection.setDoInput(true);
		connection.setDoOutput(true);
		String soapXml = getXML("1");
		OutputStream os = connection.getOutputStream();
		getSoapMessage(new Test()).writeTo(os);
//		os.write(soapXml.getBytes());
		int responseCode = connection.getResponseCode();
		if(200 == responseCode) {
			System.out.println("success");
			InputStream is = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			StringBuilder sb = null;
			try {
				is = connection.getInputStream();
//				isr = new InputStreamReader(is);
//				br = new BufferedReader(isr);
//				
//				sb = new StringBuilder();
//				String temp = null;
//				while((temp = br.readLine()) != null) {
//					sb.append(temp);
//				}
//				System.out.println(sb.toString());
				SOAPMessage message = MessageFactory.newInstance(SOAPConstants.DEFAULT_SOAP_PROTOCOL).createMessage(null, is);
				message.writeTo(System.out);
				Unmarshaller unmarshaller = JAXBContext.newInstance(TestResponse.class).createUnmarshaller();
				JAXBElement<TestResponse> element = unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument(), TestResponse.class);
				TestResponse response = element.getValue();
				System.out.println();
				System.out.println(response.getResult());
			}catch(Exception e) {
				e.printStackTrace();
				throw e;
			}finally {
//				br.close();
			}
		}else {
			System.out.println(connection.getResponseCode());
			InputStream is = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			StringBuilder sb = null;
			try {
				is = connection.getErrorStream();
				isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
				
				sb = new StringBuilder();
				String temp = null;
				while((temp = br.readLine()) != null) {
					sb.append(temp);
				}
				System.out.println(sb.toString());
			}catch(Exception e) {
				e.printStackTrace();
				throw e;
			}finally {
				br.close();
			}
		}
		os.close();
	}
	
	public static String getXML(String id){  
        String soapXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"  
        +"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"  
            +"<soap:Body>"  
            +"<test xmlns=\"http://www.eagerto.com\">"  
            +"</test>"  
          +"</soap:Body>"  
        +"</soap:Envelope>";  
        return soapXML;  
    } 
}

@XmlRootElement(name="testResponse", namespace = "http://www.eagerto.com")
@XmlAccessorType(XmlAccessType.FIELD)
class TestResponse{
	@XmlElement(name = "return")
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}

