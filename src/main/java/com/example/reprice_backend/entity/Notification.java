package com.example.reprice_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {
    private Integer notificationId;
    private Integer userId;
    private String type;
    private String title;
    private String body;
    private String ref_type;
    private Integer refId;
    private LocalDateTime readDt;
    private LocalDateTime createDt;
}
