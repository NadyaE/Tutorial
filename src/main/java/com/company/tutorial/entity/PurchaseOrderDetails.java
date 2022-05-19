package com.company.tutorial.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "PURCHASE_ORDER_DETAILS", indexes = {
        @Index(name = "IDX_PURCHASEORDERDETAILS", columnList = "PURCHASE_ORDER_ID"),
        @Index(name = "IDX_PURCHASEORDERDETAILS", columnList = "VENDOR_ID")
})
@Entity
public class PurchaseOrderDetails {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @OneToMany(mappedBy = "purchaseOrderDetails")
    private List<Product> product;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "PRICE_PER_UNIT")
    private String pricePerUnit;

    @Column(name = "TOTAL_PRICE")
    private String totalPrice;

    @JoinColumn(name = "PURCHASE_ORDER_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private PurchaseOrder purchaseOrder;

    @JoinColumn(name = "VENDOR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vendor vendor;

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(String pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}