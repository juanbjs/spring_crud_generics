package com.guaranitech.demo.model;

import java.io.Serializable;
import jakarta.persistence.*;

import lombok.*;

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
    private Integer id;

    private String description;

    private String status;

}
