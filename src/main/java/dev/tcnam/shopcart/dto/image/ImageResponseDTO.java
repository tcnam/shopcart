package dev.tcnam.shopcart.dto.image;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ImageResponseDTO {
    private Long imageId;
    private String downloadUrl;
    private String fileName;
    private String fileType;
}
