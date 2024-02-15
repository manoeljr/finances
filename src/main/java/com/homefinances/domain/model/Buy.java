package com.homefinances.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.homefinances.enums.Card;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Objects;


@Entity
public class Buy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBuy;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private LocalDateTime DateOfBuy;

    @Column(nullable = false)
    private LocalDateTime dateOfPayment;

    @Enumerated(EnumType.STRING)
    private Card card;

    @Column(nullable = false)
    private boolean installment = false;

    @Column(nullable = false)
    private boolean cache = false;

    @OneToOne
    @Column(nullable = false)
    @NotBlank
    @JoinColumn(name = "category_id", referencedColumnName = "idCategory")
    private Category category;

    @ManyToOne
    @JsonIgnore
    @NotBlank
    @Column(nullable = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Buy() {
    }

    public Buy(String description, Double price, LocalDateTime dateOfBuy, LocalDateTime dateOfPayment, Card card, boolean installment, boolean cache, Customer customer) {
        this.description = description;
        this.price = price;
        DateOfBuy = dateOfBuy;
        this.dateOfPayment = dateOfPayment;
        this.card = card;
        this.installment = installment;
        this.cache = cache;
        this.customer = customer;
    }

    public Integer getIdBuy() {
        return idBuy;
    }

    public void setIdBuy(Integer idPurchase) {
        this.idBuy = idPurchase;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String name) {
        this.description = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public LocalDateTime getDateOfBuy() {
        return DateOfBuy;
    }

    public void setDateOfBuy(LocalDateTime dateOfBuy) {
        DateOfBuy = dateOfBuy;
    }

    public LocalDateTime getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDateTime dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public boolean isInstallment() {
        return installment;
    }

    public void setInstallment(boolean installment) {
        this.installment = installment;
    }

    public boolean isCache() {
        return cache;
    }

    public void setCache(boolean cache) {
        this.cache = cache;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buy buy = (Buy) o;
        return Objects.equals(idBuy, buy.idBuy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBuy);
    }
}
