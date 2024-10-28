package ru.linkshortener.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import ru.linkshortener.dto.CreateLinkInfoRequest;
import ru.linkshortener.dto.LinkInfoResponse;
import ru.linkshortener.exception.NotFoundExeption;
import ru.linkshortener.model.LinkInfo;
import ru.linkshortener.repository.LinkInfoRepository;
import ru.linkshortener.service.LinkInfoService;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class LinkInfoServiceImpl implements LinkInfoService {

    private final LinkInfoRepository linkInfoRepository;

    public LinkInfoServiceImpl(LinkInfoRepository linkInfoRepository) {
        this.linkInfoRepository = linkInfoRepository;
    }

    @Override
    public LinkInfoResponse getByShortLink(String shortLink) {
        return  linkInfoRepository.findByShortLink(shortLink).map(this::toResponse).orElseThrow(() -> new NotFoundExeption("Не найден репозиторий для ссылки: " + shortLink));

    }

    private LinkInfoResponse toResponse(LinkInfo linkInfo) {
        return LinkInfoResponse.builder().id(linkInfo.getId()).shortLink(linkInfo.getShortLink()).openingCount(linkInfo.getOpeningCount()).link(linkInfo.getLink()).endTime(linkInfo.getEndTime()).description(linkInfo.getDescription()).active(linkInfo.getActive()).build();

    }

}
//    @Override
//    public String createShortLink(CreateLinkInfoRequest createLinkInfoRequest) {
//        String shortLink = RandomStringUtils.randomAlphanumeric(10);
//        resultMap.put(shortLink, createLinkInfoRequest);
//        log.info("in metod sl: " + shortLink);
//        return shortLink;
//
