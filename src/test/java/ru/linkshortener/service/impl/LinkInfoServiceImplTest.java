package ru.linkshortener.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import ru.linkshortener.dto.CreateLinkInfoRequest;

import static org.junit.jupiter.api.Assertions.*;

//@Slf4j
class LinkInfoServiceImplTest {

//    @Test
//    void createShortLink() {
//        LinkInfoServiceImpl service = new LinkInfoServiceImpl();
//        CreateLinkInfoRequest request = new CreateLinkInfoRequest(
//                "http://example.com",
//                null,
//                "Example link",
//                true
//        );
//
//        String shortLink = service.createShortLink(request);
//        System.out.println("gen short link: " + shortLink);
////        log.info("gen short link: " + shortLink);
//        assertNotNull(shortLink);
//        assertEquals(10, shortLink.length());
//    }
//}