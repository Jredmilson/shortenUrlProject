package com.shortner.url.shortner.url.controller;

import com.shortner.url.shortner.url.model.ShortnerBodyDTO;
import com.shortner.url.shortner.url.model.ShortnerDTO;
import com.shortner.url.shortner.url.service.imp.ShortenUrlServiceImp;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ShortnerController {

    @Autowired
    private ShortenUrlServiceImp shortenUrlServiceImp;

    @PostMapping("shorten-url")
    public ShortnerBodyDTO shortenUrl(@RequestBody ShortnerDTO shortnerDTO) {

        return shortenUrlServiceImp.shortenUrl(shortnerDTO);
    }

    @GetMapping("/{shortenedUrl}")
    public RedirectView redirectUrl(@PathVariable String shortenedUrl) {

        return shortenUrlServiceImp.findMyUrl(shortenedUrl);
    }
}
