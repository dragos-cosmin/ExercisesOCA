package org.example.streams.grouping;

import org.example.collections.Product;

import java.time.LocalDate;
import java.util.List;

/**
 * @author dragos.cosmin
 **/
public class Order {
    private Customer customer;
    private LocalDate date;
    private List<Product> items;

    public Order(Customer customer, LocalDate date, List<Product> items) {
        this.customer = customer;
        this.date = date;
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", date=" + date +
                ", items=" + items +
                '}';
    }
}
