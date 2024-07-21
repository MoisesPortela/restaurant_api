package com.br.restaurant.controller;

import com.br.restaurant.domain.order.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    @Transactional
    public ResponseEntity createOrders(@RequestBody @Valid DataCreateOrder dataCreateOrder, UriComponentsBuilder uriComponentsBuilder){
        var order = new Order(dataCreateOrder);
        orderRepository.save(order);
        var uri =uriComponentsBuilder.path("orders/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataDetailsOrder(order));
    }

    @GetMapping
    public ResponseEntity<Page<DataDetailsOrder>> getAllOrders(@PageableDefault(size = 10,sort = "name") Pageable pageable){
        var page =orderRepository.findAllByActiveTrue(pageable).map(DataDetailsOrder::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    @ReadOnlyProperty
    public ResponseEntity getOrderById(@PathVariable Long id){
        var order=orderRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailsOrder(order));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateOrder(@RequestBody @Valid DataUpdateOrder dataUpdateOrder){
        var order = orderRepository.getReferenceById(dataUpdateOrder.id());
        order.updateOrder(dataUpdateOrder);
        return ResponseEntity.ok(new DataDetailsOrder(order));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteOrder(@PathVariable Long id){
        var order = orderRepository.getReferenceById(id);
        order.logicDelete();
        return ResponseEntity.noContent().build();
    }
}
