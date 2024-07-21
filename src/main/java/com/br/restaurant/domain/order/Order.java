package com.br.restaurant.domain.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "orders")
@Entity(name = "Order")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ingredients;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String price;
    private Boolean active;

    public Order(DataCreateOrder dataCreateOrder) {
        this.active=true;
        this.name= dataCreateOrder.name();
        this.ingredients= dataCreateOrder.ingredients();
        this.type= dataCreateOrder.type();
        this.price= dataCreateOrder.price();
    }

    public void updateOrder(DataUpdateOrder dataUpdateOrder){
        if (dataUpdateOrder.name()!=null){
            this.name= dataUpdateOrder.name();
        }
        if (dataUpdateOrder.ingredients()!=null){
            this.ingredients= dataUpdateOrder.ingredients();
        }
        if (dataUpdateOrder.type()!=null){
            this.type= dataUpdateOrder.type();
        }
        if (dataUpdateOrder.price()!=null){
            this.price= dataUpdateOrder.price();
        }
    }

    public void logicDelete(){
        this.active=false;
    }
}
