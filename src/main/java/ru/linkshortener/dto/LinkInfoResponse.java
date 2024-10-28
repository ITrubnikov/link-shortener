package ru.linkshortener.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class LinkInfoResponse {
    private UUID id;
    private String shortLink;
    private Long openingCount;
    private String link;
    private LocalDateTime endTime;
    private String description;
    private Boolean active;
}
