package dev.tcnam.shopcart.mapper;

import java.util.List;
import java.util.stream.Collectors;

import dev.tcnam.shopcart.dto.image.ImageRequestDTO;
import dev.tcnam.shopcart.dto.image.ImageResponseDTO;
// import dev.tcnam.shopcart.dto.product.ProductResponseDTO;
import dev.tcnam.shopcart.model.Image;

public class ImageMapper {
    public static Image toModel(ImageRequestDTO createImageDTO){
        Image image = new Image();
        image.setDownloadUrl(createImageDTO.getDownloadUrl());
        image.setFileName(createImageDTO.getFileName());
        image.setFileType(createImageDTO.getFileType());
        return image;
    }

    public static ImageResponseDTO toDTO(Image image){
        ImageResponseDTO imageResponseDTO = new ImageResponseDTO(image.getImageId(), image.getDownloadUrl(), image.getFileName(), image.getFileType());
        return imageResponseDTO;
    }

    public static List<ImageResponseDTO> toDTOList(List<Image> images) {
        return images.stream()
                        .map(image -> ImageMapper.toDTO(image))
                        .collect(Collectors.toList());
        }
}
