package com.company.tutorial.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.FileRef;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "PRODUCT", indexes = {
        @Index(name = "IDX_PRODUCT_VENDOR_ID", columnList = "VENDOR_ID"),
        @Index(name = "IDX_PRODUCT_ORDER_DETAILS_ID", columnList = "ORDER_DETAILS_ID"),
        @Index(name = "IDX_PRODUCT", columnList = "PURCHASE_ORDER_DETAILS_ID")
})
@Entity
public class Product {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String productDescription;

    @Column(name = "UNIT")
    private String unit;

    @Column(name = "PRICE_PER_UNIT")
    private Double pricePerUnit;

    @Column(name = "RETAIL_PRICE")
    private Double retailPrice;

    @Column(name = "SKU")
    private String sku;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "MINIMUM_STOCK")
    private Integer minimumStock;

    @Column(name = "IMAGE", length = 1024)
    private FileRef image;

    @OnDeleteInverse(DeletePolicy.UNLINK)
    @JoinColumn(name = "PRODUCT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @OneToMany(mappedBy = "product")
    private List<Product> stock;

    @JoinColumn(name = "VENDOR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vendor vendor;

    @JoinColumn(name = "ORDER_DETAILS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderDetails orderDetails;
    @JoinColumn(name = "PURCHASE_ORDER_DETAILS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private PurchaseOrderDetails purchaseOrderDetails;

    public PurchaseOrderDetails getPurchaseOrderDetails() {
        return purchaseOrderDetails;
    }

    public void setPurchaseOrderDetails(PurchaseOrderDetails purchaseOrderDetails) {
        this.purchaseOrderDetails = purchaseOrderDetails;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public List<Product> getStock() {
        return stock;
    }

    public void setStock(List<Product> stock) {
        this.stock = stock;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public FileRef getImage() {
        return image;
    }

    public void setImage(FileRef image) {
        this.image = image;
    }

    public Integer getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(Integer minimumStock) {
        this.minimumStock = minimumStock;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}