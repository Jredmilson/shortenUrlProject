package com.shortner.url.shortner.url.service.imp;

import com.shortner.url.shortner.url.exception.UrlNotFoundException;
import com.shortner.url.shortner.url.model.ShortnerBodyDTO;
import com.shortner.url.shortner.url.model.ShortnerDTO;
import com.shortner.url.shortner.url.model.ShortnerEntity;
import com.shortner.url.shortner.url.repository.ShortnerRepository;
import com.shortner.url.shortner.url.service.ShortenUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Random;

@Service
@EnableScheduling
public class ShortenUrlServiceImp implements ShortenUrlService {

    private final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    @Autowired
    private ShortnerRepository shortnerRepository;

    @Override
    public ShortnerBodyDTO shortenUrl(ShortnerDTO shortnerDTO) {

        ShortnerBodyDTO shortnerBodyDTO = ShortnerBodyDTO.builder()
                .url(shortnerDTO.getUrl())
                .shortenedUrl(generateNewUrl())
                .build();

        shortnerRepository.save(dtoToEntity(shortnerBodyDTO));

        return shortnerBodyDTO;
    }

    @Scheduled(cron = "0 */5 * * * *")
    @Override
    public void expiredUrl() {

        List<ShortnerEntity> shortnerEntityList = shortnerRepository.findAllExpiredUrls();

        if (!shortnerEntityList.isEmpty()) {

            for (ShortnerEntity shortnerEntity : shortnerEntityList) {

                System.out.println(" ---------- Delete url by Id: " + shortnerEntity.getId());
                shortnerRepository.delete(shortnerEntity);
            }
        }
    }

    @Override
    public RedirectView findMyUrl(String url) {

        ShortnerEntity shortnerEntity = shortnerRepository.findByShortenedUrl(url);

        if (shortnerEntity != null) {

            RedirectView redirectView = new RedirectView();
            redirectView.setUrl(shortnerEntity.getUrl());
            return redirectView;
        } else {
            throw new UrlNotFoundException();
        }
    }

    private ShortnerEntity dtoToEntity(ShortnerBodyDTO dto) {
        ShortnerEntity entity = new ShortnerEntity();
        entity.setUrl(dto.getUrl());
        entity.setShortenedUrl(dto.getShortenedUrl());
        return entity;
    }

    public String generateNewUrl() {

        Random random = new Random();

       final String url = "https://example/";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return String.valueOf(url + sb);

    }

}
