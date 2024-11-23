package com.shortner.url.shortner.url.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Random;

@Data
@Builder
public class ShortnerBodyDTO {

    private String url;

    private String shortenedUrl;
}