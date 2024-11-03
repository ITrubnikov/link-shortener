package ru.linkshortener.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import ru.linkshortener.dto.CreateLinkInfoRequest;
import ru.linkshortener.dto.LinkInfoResponse;
import ru.linkshortener.exception.NotFoundExeption;
import ru.linkshortener.model.LinkInfo;
import ru.linkshortener.repository.LinkInfoRepository;
import ru.linkshortener.service.LinkInfoService;
import ru.linkshortener.util.Constant;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LinkInfoServiceImpl implements LinkInfoService {

    private final LinkInfoRepository linkInfoRepository;

    public LinkInfoServiceImpl(LinkInfoRepository linkInfoRepository) {
        this.linkInfoRepository = linkInfoRepository;
    }

    @Override
    public LinkInfoResponse getByShortLink(String shortLink) {
        return linkInfoRepository.findByShortLink(shortLink).map(this::toResponse).orElseThrow(() -> new NotFoundExeption("Не найден репозиторий для ссылки: " + shortLink));
    }

    @Override
    public LinkInfoResponse createLinkInfo(CreateLinkInfoRequest request) {
        String shortLink = RandomStringUtils.randomAlphabetic(Constant.SHORT_LINK_LENGTH);
        LinkInfo linkInfo = LinkInfo.builder()
                .link(request.getLink())
                .shortLink(shortLink)
                .description(request.getDescription())
                .endTime(request.getEndTime())
                .active(request.getActive())
                .openingCount(0L)
                .build();
        LinkInfo saveLinkInfo = linkInfoRepository.save(linkInfo);
        return toResponse(saveLinkInfo);
    }

    @Override
    public List<LinkInfoResponse> findByFilter() {
        return linkInfoRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private LinkInfoResponse toResponse(LinkInfo linkInfo) {
        return LinkInfoResponse.builder()
                .id(linkInfo.getId())
                .shortLink(linkInfo.getShortLink())
                .openingCount(linkInfo.getOpeningCount())
                .link(linkInfo.getLink())
                .endTime(linkInfo.getEndTime())
                .description(linkInfo.getDescription())
                .active(linkInfo.getActive())
                .build();
    }
}

