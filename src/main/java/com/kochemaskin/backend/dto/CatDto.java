package com.kochemaskin.backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CatDto {

   private Long id;

    @NotNull
    private String breed;

    @NotNull
    private String name;

    @NotNull
    private String color;

    @NotNull
    private int year;
}