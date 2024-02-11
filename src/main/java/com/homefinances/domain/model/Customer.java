package com.homefinances.domain.model;

import com.homefinances.enums.TypeRoles;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCustomer;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @NotNull
    @Size(min = 6)
    @Column(nullable = false)
    private String password;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private TypeRoles roles = TypeRoles.USER;

    private boolean enabled = true;
    private Instant lastLogin = Instant.now();

    @OneToMany(mappedBy = "customer")
    private List<Purchase> purchases;

    public Customer() {
    }

    public Customer(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Customer(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TypeRoles getRoles() {
        return roles;
    }

    public void setRoles(TypeRoles roles) {
        this.roles = roles;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Instant getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Instant lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(idCustomer, customer.idCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCustomer);
    }
}
