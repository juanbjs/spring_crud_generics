package com.guaranitech.demo.model;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import lombok.*;

@Schema(name = "Domain", description = "Domain entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Domain implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Schema(description = "Domain id", example = "1")
    private Integer id;

    @Schema(description = "Domain name", example = "Domain 1")
    private String description;

    @Schema(description = "Domain status", example = "ACTIVE")
    private String status;

}
