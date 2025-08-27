package com.highway.trustchecks.api;
import java.time.LocalDateTime;

public record ApiResponse<T>(
        LocalDateTime timeStamp,
        Integer status,
        T data,
        String message
) {
}
