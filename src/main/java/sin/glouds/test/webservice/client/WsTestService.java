
package sin.glouds.test.webservice.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WsTestService", targetNamespace = "http://webservice.test.glouds.sin/", wsdlLocation = "http://localhost:10811/service/WsTest?wsdl")
public class WsTestService
    extends Service
{

    private final static URL WSTESTSERVICE_WSDL_LOCATION;
    private final static WebServiceException WSTESTSERVICE_EXCEPTION;
    private final static QName WSTESTSERVICE_QNAME = new QName("http://webservice.test.glouds.sin/", "WsTestService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:10811/service/WsTest?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSTESTSERVICE_WSDL_LOCATION = url;
        WSTESTSERVICE_EXCEPTION = e;
    }

    public WsTestService() {
        super(__getWsdlLocation(), WSTESTSERVICE_QNAME);
    }

    public WsTestService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSTESTSERVICE_QNAME, features);
    }

    public WsTestService(URL wsdlLocation) {
        super(wsdlLocation, WSTESTSERVICE_QNAME);
    }

    public WsTestService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSTESTSERVICE_QNAME, features);
    }

    public WsTestService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WsTestService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WsTest
     */
    @WebEndpoint(name = "WsTestPort")
    public WsTest getWsTestPort() {
        return super.getPort(new QName("http://webservice.test.glouds.sin/", "WsTestPort"), WsTest.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WsTest
     */
    @WebEndpoint(name = "WsTestPort")
    public WsTest getWsTestPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservice.test.glouds.sin/", "WsTestPort"), WsTest.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSTESTSERVICE_EXCEPTION!= null) {
            throw WSTESTSERVICE_EXCEPTION;
        }
        return WSTESTSERVICE_WSDL_LOCATION;
    }

}
