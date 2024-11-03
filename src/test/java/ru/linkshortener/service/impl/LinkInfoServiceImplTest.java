package ru.linkshortener.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.linkshortener.dto.CreateLinkInfoRequest;
import ru.linkshortener.dto.LinkInfoResponse;
import ru.linkshortener.repository.LinkInfoRepository;
import ru.linkshortener.repository.impl.LinkInfoRepositoryImpl;
import ru.linkshortener.service.LinkInfoService;

import java.time.LocalDateTime;
import java.util.List;

//@Slf4j
class LinkInfoServiceImplTest {
    @Test
    void getByShortLink() {
        LinkInfoRepository linkInfoRepository = new LinkInfoRepositoryImpl();
        LinkInfoService linkInfoService = new LinkInfoServiceImpl(linkInfoRepository);
        CreateLinkInfoRequest request = new CreateLinkInfoRequest(
                "http://example.com",
                null,
                "Example link",
                true
        );
        LinkInfoResponse linkInfoResponse = linkInfoService.createLinkInfo(request);
        Assertions.assertEquals(linkInfoResponse, linkInfoService.getByShortLink(linkInfoResponse.getShortLink()));
    }

    @Test
    void findByFilterTest() {
        LinkInfoRepository linkInfoRepository = new LinkInfoRepositoryImpl();
        LinkInfoServiceImpl linkInfoService = new LinkInfoServiceImpl(linkInfoRepository);
        CreateLinkInfoRequest request1 = new CreateLinkInfoRequest(
                "http://example1.com",
                LocalDateTime.now(),
                "Example Link 1",
                true
        );
        CreateLinkInfoRequest request2 = new CreateLinkInfoRequest(
                "http://example2.com",
                LocalDateTime.now(),
                "Example Link 2",
                true
        );
        LinkInfoResponse linkInfoResponse1 = linkInfoService.createLinkInfo(request1);
        LinkInfoResponse linkInfoResponse2 = linkInfoService.createLinkInfo(request2);

        Assertions.assertEquals(List.of(linkInfoResponse1, linkInfoResponse2), linkInfoService.findByFilter());
    }

    @Test
    void createLinkInfo() {
        LinkInfoRepository linkInfoRepository = new LinkInfoRepositoryImpl();
        LinkInfoServiceImpl linkInfoService = new LinkInfoServiceImpl(linkInfoRepository);
        CreateLinkInfoRequest request = new CreateLinkInfoRequest(
                "http://example.com",
                LocalDateTime.now(),
                "Example link",
                true
        );
        LinkInfoResponse linkInfoResponse = linkInfoService.createLinkInfo(request);

        Assertions.assertNotNull(linkInfoResponse.getId());
    }
}

