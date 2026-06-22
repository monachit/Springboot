package com.example.tp3.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private String status;
    private BigDecimal total;
    private BigDecimal totalPaid;
    private List<CommandItem> commandItems;

    @ManyToOne
    private CommandStatus commandStatus;

    @OneToMany(mappedBy = "command", cascade = CascadeType.REMOVE)
    private List<Payment> payments;

    @OneToMany(mappedBy = "command", cascade = CascadeType.REMOVE)
    private List<CommandItem> items;


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        this.totalPaid = totalPaid;
    }

    public List<CommandItem> getCommandItems() {
        return commandItems;
    }

    public void setCommandItems(List<CommandItem> commandItems) {
        this.commandItems = commandItems;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
