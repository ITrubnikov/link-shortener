package ru.linkshortener.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateLinkInfoRequest {
    String link;
    LocalDateTime endTime;
    String description;
    Boolean active;
}
