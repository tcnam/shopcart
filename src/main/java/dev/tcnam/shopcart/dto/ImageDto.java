package dev.tcnam.shopcart.dto;

import java.sql.Blob;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.tcnam.shopcart.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

// @Data
public class ImageDto {
    private Long imageId;
    private String download_url;
    private String fileName;
    private String fileType;
    private Blob image;
    private Long productId;
	private LocalDateTime createdTimestamp;
    private String createdUser;
    private LocalDateTime updatedTimestamp;
    private String updatedUser;
}
