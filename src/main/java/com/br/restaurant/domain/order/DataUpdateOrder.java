package com.br.restaurant.domain.order;

import jakarta.validation.constraints.NotNull;

public record DataUpdateOrder(
        @NotNull
        Long id,
        String name,
        String ingredients,
        Type type,
        String price
) {
}
