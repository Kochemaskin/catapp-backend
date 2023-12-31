package com.kochemaskin.backend.mapper;

import com.kochemaskin.backend.dto.CatDto;
import com.kochemaskin.backend.entity.Cat;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatMapper {

    Cat toCat(CatDto catDto);

    CatDto toCatDto(Cat cat);

    List<CatDto> toCatDtos(List<Cat> cats);

    void updateCat(@MappingTarget Cat target, Cat source);
}
