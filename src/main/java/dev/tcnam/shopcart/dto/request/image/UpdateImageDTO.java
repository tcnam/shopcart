package dev.tcnam.shopcart.dto.request.image;

import java.sql.Blob;

import dev.tcnam.shopcart.dto.request.product.UpdateProductDTO;
import lombok.Data;

@Data
public class UpdateImageDTO {
    private String downloadUrl;
    private String fileName;
    private String fileType;
    private Blob image;

    private UpdateProductDTO product;
}
