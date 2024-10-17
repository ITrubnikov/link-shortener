package ru.linkshortener.service;

import ru.linkshortener.dto.CreateLinkInfoRequest;

public interface LinkInfoService {
    String createShortLink(CreateLinkInfoRequest createLinkInfoRequest);
}
