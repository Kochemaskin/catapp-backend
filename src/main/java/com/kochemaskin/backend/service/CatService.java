package com.kochemaskin.backend.service;

import com.kochemaskin.backend.dto.CatDto;
import com.kochemaskin.backend.entity.Cat;
import com.kochemaskin.backend.exception.AppException;
import com.kochemaskin.backend.mapper.CatMapper;
import com.kochemaskin.backend.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatService {

    private final CatRepository catRepository;

    private final CatMapper catMapper;


    public List<CatDto> allCats() {
        List<Cat> allCats = catRepository.findAll();
        return catMapper.toCatDtos(allCats);
    }


    public CatDto getCat(Long id) {
        Cat cat = catRepository.findById(id)
                .orElseThrow(()-> new AppException("Cat not found", HttpStatus.NOT_FOUND));
        return catMapper.toCatDto(cat);
    }

    public CatDto createCat(CatDto catDto) {
        Cat cat = catMapper.toCat(catDto);
        Cat savedCat = catRepository.save(cat);
        return catMapper.toCatDto(savedCat);
    }
}
