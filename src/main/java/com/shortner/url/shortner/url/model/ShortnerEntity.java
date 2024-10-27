package com.shortner.url.shortner.url.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "Usuarios")
@Entity(name = "Usuario")
public class ShortnerEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String shortenedUrl;

    private LocalDateTime creationDateTime;



}
