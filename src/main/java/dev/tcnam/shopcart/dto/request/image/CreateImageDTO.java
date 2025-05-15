package dev.tcnam.shopcart.dto.request.image;

import java.sql.Blob;

import dev.tcnam.shopcart.dto.request.product.CreateProductDTO;
import lombok.Data;

@Data
public class CreateImageDTO {
    private String downloadUrl;
    private String fileName;
    private String fileType;
    private Blob image;

    private CreateProductDTO product;
}
