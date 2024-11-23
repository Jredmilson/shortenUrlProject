package com.shortner.url.shortner.url.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "Urls")
@Entity(name = "url")
public class ShortnerEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Setter
    @Getter
    private String url;

    @Setter
    @Getter
    private String shortenedUrl;

    private final LocalDateTime creationDateTime = LocalDateTime.now();

    private final LocalDateTime expirationDateTime = LocalDateTime.now().plusMinutes(2);

}