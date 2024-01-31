package pl.piomin.services.quarkus.function.account.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Account extends PanacheEntity {
    public String number;
    public int balance;
    public Long customerId;
}
