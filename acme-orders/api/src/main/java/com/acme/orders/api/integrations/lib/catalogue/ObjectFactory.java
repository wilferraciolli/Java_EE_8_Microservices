
package com.acme.orders.api.integrations.lib.catalogue;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.acme.orders.api.integrations.lib.catalogue package. 
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

    private final static QName _RetrieveProduct_QNAME = new QName("http://acme.com/services/eCommerce/v1", "RetrieveProduct");
    private final static QName _ECommerceErrorFault_QNAME = new QName("http://acme.com/services/eCommerce/v1", "ECommerceErrorFault");
    private final static QName _RetrieveProductResponse_QNAME = new QName("http://acme.com/services/eCommerce/v1", "RetrieveProductResponse");
    private final static QName _RetrieveProductRequestMessageId_QNAME = new QName("http://acme.com/schemes/messages/v1", "id");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.acme.orders.api.integrations.lib.catalogue
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ECommerceErrorFault }
     * 
     */
    public ECommerceErrorFault createECommerceErrorFault() {
        return new ECommerceErrorFault();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link OrderItemList }
     * 
     */
    public OrderItemList createOrderItemList() {
        return new OrderItemList();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link TransactionList }
     * 
     */
    public TransactionList createTransactionList() {
        return new TransactionList();
    }

    /**
     * Create an instance of {@link SupplierList }
     * 
     */
    public SupplierList createSupplierList() {
        return new SupplierList();
    }

    /**
     * Create an instance of {@link CustomerList }
     * 
     */
    public CustomerList createCustomerList() {
        return new CustomerList();
    }

    /**
     * Create an instance of {@link ProductList }
     * 
     */
    public ProductList createProductList() {
        return new ProductList();
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link OrderItem }
     * 
     */
    public OrderItem createOrderItem() {
        return new OrderItem();
    }

    /**
     * Create an instance of {@link Supplier }
     * 
     */
    public Supplier createSupplier() {
        return new Supplier();
    }

    /**
     * Create an instance of {@link OrderList }
     * 
     */
    public OrderList createOrderList() {
        return new OrderList();
    }

    /**
     * Create an instance of {@link BaseErrorType }
     * 
     */
    public BaseErrorType createBaseErrorType() {
        return new BaseErrorType();
    }

    /**
     * Create an instance of {@link BaseType }
     * 
     */
    public BaseType createBaseType() {
        return new BaseType();
    }

    /**
     * Create an instance of {@link BaseMessageType }
     * 
     */
    public BaseMessageType createBaseMessageType() {
        return new BaseMessageType();
    }

    /**
     * Create an instance of {@link RetrieveProduct }
     * 
     */
    public RetrieveProduct createRetrieveProduct() {
        return new RetrieveProduct();
    }

    /**
     * Create an instance of {@link RetrieveProductResponse }
     * 
     */
    public RetrieveProductResponse createRetrieveProductResponse() {
        return new RetrieveProductResponse();
    }

    /**
     * Create an instance of {@link ECommerceError }
     * 
     */
    public ECommerceError createECommerceError() {
        return new ECommerceError();
    }

    /**
     * Create an instance of {@link RetrieveProductRequestMessage }
     * 
     */
    public RetrieveProductRequestMessage createRetrieveProductRequestMessage() {
        return new RetrieveProductRequestMessage();
    }

    /**
     * Create an instance of {@link RetrieveProductResponseMessage }
     * 
     */
    public RetrieveProductResponseMessage createRetrieveProductResponseMessage() {
        return new RetrieveProductResponseMessage();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.com/services/eCommerce/v1", name = "RetrieveProduct")
    public JAXBElement<RetrieveProduct> createRetrieveProduct(RetrieveProduct value) {
        return new JAXBElement<RetrieveProduct>(_RetrieveProduct_QNAME, RetrieveProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ECommerceErrorFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.com/services/eCommerce/v1", name = "ECommerceErrorFault")
    public JAXBElement<ECommerceErrorFault> createECommerceErrorFault(ECommerceErrorFault value) {
        return new JAXBElement<ECommerceErrorFault>(_ECommerceErrorFault_QNAME, ECommerceErrorFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.com/services/eCommerce/v1", name = "RetrieveProductResponse")
    public JAXBElement<RetrieveProductResponse> createRetrieveProductResponse(RetrieveProductResponse value) {
        return new JAXBElement<RetrieveProductResponse>(_RetrieveProductResponse_QNAME, RetrieveProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.com/schemes/messages/v1", name = "id", scope = RetrieveProductRequestMessage.class)
    public JAXBElement<String> createRetrieveProductRequestMessageId(String value) {
        return new JAXBElement<String>(_RetrieveProductRequestMessageId_QNAME, String.class, RetrieveProductRequestMessage.class, value);
    }

}
