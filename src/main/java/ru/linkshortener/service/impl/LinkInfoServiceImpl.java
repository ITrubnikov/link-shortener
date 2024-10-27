package ru.linkshortener.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import ru.linkshortener.dto.CreateLinkInfoRequest;
import ru.linkshortener.service.LinkInfoService;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class LinkInfoServiceImpl implements LinkInfoService {

    final Map<String, CreateLinkInfoRequest> resultMap = new HashMap<>();

    @Override
    public String createShortLink(CreateLinkInfoRequest createLinkInfoRequest) {
        String shortLink = RandomStringUtils.randomAlphanumeric(10);
        resultMap.put(shortLink, createLinkInfoRequest);
        log.info("in metod sl: " + shortLink);
        return shortLink;
    }
}
