package com.AlphaTech.AlphaDevelopment.dto;

public record ErrorResponse(
        String message,
        String timestamp,
        int status
) {
}
