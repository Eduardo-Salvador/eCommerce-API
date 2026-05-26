package com.salvadoreduardo.ecommerce.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ResponseError(
        LocalDateTime timestamp,
        Integer status,
        String error,
        List<String> messages
) {
}
