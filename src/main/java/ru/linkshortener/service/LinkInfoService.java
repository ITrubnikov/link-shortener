package ru.linkshortener.service;

import ru.linkshortener.dto.CreateLinkInfoRequest;
import ru.linkshortener.dto.LinkInfoResponse;

public interface LinkInfoService {
    LinkInfoResponse getByShortLink (String shortLink);
}
