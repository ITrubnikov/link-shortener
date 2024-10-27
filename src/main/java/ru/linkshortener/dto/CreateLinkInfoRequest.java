package ru.linkshortener.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateLinkInfoRequest {
    private String link;
    private LocalDateTime endTime;
    private String description;
    private Boolean active;
}
