package com.br.restaurant.domain.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataCreateOrder(
        @NotBlank
        String name,
        @NotBlank
        String ingredients,
        @NotNull
        Type type,
        @NotBlank
        String price) {
}
