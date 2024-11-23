package com.shortner.url.shortner.url.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShortnerResponseDTO {

    private String newUrl;

}
