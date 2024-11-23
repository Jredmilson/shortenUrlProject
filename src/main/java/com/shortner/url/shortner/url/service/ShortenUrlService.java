package com.shortner.url.shortner.url.service;

import com.shortner.url.shortner.url.model.ShortnerBodyDTO;
import com.shortner.url.shortner.url.model.ShortnerDTO;
import com.shortner.url.shortner.url.model.ShortnerEntity;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

public interface ShortenUrlService {

    ShortnerBodyDTO shortenUrl(ShortnerDTO shortnerDTO);

    RedirectView findMyUrl(String url);

    void expiredUrl();


}
