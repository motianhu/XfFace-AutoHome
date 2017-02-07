
package com.smona.base.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _VreBusiness_QNAME = new QName("http://webservice.com/", "VreBusiness");
    private final static QName _VreBusinessResponse_QNAME = new QName("http://webservice.com/", "VreBusinessResponse");
    private final static QName _DownloadFile_QNAME = new QName("http://webservice.com/", "DownloadFile");
    private final static QName _DownloadFileResponse_QNAME = new QName("http://webservice.com/", "DownloadFileResponse");
    private final static QName _DownloadFileResponseReturn_QNAME = new QName("", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DownloadFile }
     * 
     */
    public DownloadFile createDownloadFile() {
        return new DownloadFile();
    }

    /**
     * Create an instance of {@link DownloadFileResponse }
     * 
     */
    public DownloadFileResponse createDownloadFileResponse() {
        return new DownloadFileResponse();
    }

    /**
     * Create an instance of {@link VreBusinessResponse }
     * 
     */
    public VreBusinessResponse createVreBusinessResponse() {
        return new VreBusinessResponse();
    }

    /**
     * Create an instance of {@link VreBusiness }
     * 
     */
    public VreBusiness createVreBusiness() {
        return new VreBusiness();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VreBusiness }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.com/", name = "VreBusiness")
    public JAXBElement<VreBusiness> createVreBusiness(VreBusiness value) {
        return new JAXBElement<VreBusiness>(_VreBusiness_QNAME, VreBusiness.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VreBusinessResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.com/", name = "VreBusinessResponse")
    public JAXBElement<VreBusinessResponse> createVreBusinessResponse(VreBusinessResponse value) {
        return new JAXBElement<VreBusinessResponse>(_VreBusinessResponse_QNAME, VreBusinessResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.com/", name = "DownloadFile")
    public JAXBElement<DownloadFile> createDownloadFile(DownloadFile value) {
        return new JAXBElement<DownloadFile>(_DownloadFile_QNAME, DownloadFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.com/", name = "DownloadFileResponse")
    public JAXBElement<DownloadFileResponse> createDownloadFileResponse(DownloadFileResponse value) {
        return new JAXBElement<DownloadFileResponse>(_DownloadFileResponse_QNAME, DownloadFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = DownloadFileResponse.class)
    public JAXBElement<byte[]> createDownloadFileResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_DownloadFileResponseReturn_QNAME, byte[].class, DownloadFileResponse.class, ((byte[]) value));
    }

}
