package ru.linkshortener.service;

import ru.linkshortener.dto.CreateLinkInfoRequest;
import ru.linkshortener.dto.LinkInfoResponse;

import java.util.List;

public interface LinkInfoService {
    LinkInfoResponse getByShortLink(String shortLink);

    LinkInfoResponse createLinkInfo(CreateLinkInfoRequest request);

    List<LinkInfoResponse> findByFilter();
}
