package dev.tcnam.shopcart.dto.image;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ImageRequestDTO {
    private final String downloadUrl;
    private final String fileName;
    private final String fileType;
}
