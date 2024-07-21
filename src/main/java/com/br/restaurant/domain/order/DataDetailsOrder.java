package com.br.restaurant.domain.order;

public record DataDetailsOrder(Long id, String name, String ingredients, Type type,String price) {
    public DataDetailsOrder(Order order){
        this(order.getId(), order.getName(), order.getIngredients(), order.getType(),order.getPrice());
    }
}
