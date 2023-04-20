package com.example.autoservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_id")
    private Master master;
    private String description;
    private LocalDate dateOfAdoption;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    @Column(name = "services_in_order")
    private List<Service> serviceList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    @Column(name = "goods_in_order")
    private List<Good> goodsList;
    private OrderStatus status;
    private BigDecimal totalCost;
    private LocalDate completionDate;
}
