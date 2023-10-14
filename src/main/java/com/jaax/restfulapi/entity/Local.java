package com.jaax.restfulapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity // Para indicarle que es un entidad y poder mapearlo que se llama local
@Table(name = "locals")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Please add the name")
    private String name;
    private String floor;
    @Length(min = 4, max =10, message = "Ingresa bien los datos min 4 y max 10 carecteres")
    private String code;
}
