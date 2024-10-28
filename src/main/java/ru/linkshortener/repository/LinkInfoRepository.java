package ru.linkshortener.repository;

import org.springframework.stereotype.Repository;
import ru.linkshortener.dto.CreateLinkInfoRequest;
import ru.linkshortener.model.LinkInfo;

import java.util.List;
import java.util.Optional;

@Repository
public interface LinkInfoRepository {

    Optional<LinkInfo> findByShortLink(String shortLink);

    LinkInfo save(LinkInfo linkInfo);

    List<LinkInfo> findAll();
}
