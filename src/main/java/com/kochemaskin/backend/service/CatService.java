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
        return catMapper.toCatDtos(catRepository.findAll());
    }

    public CatDto createCat(CatDto catDto) {
        Cat cat = catMapper.toCat(catDto);

        Cat savedCat = catRepository.save(cat);

        return catMapper.toCatDto(savedCat);
    }

    public CatDto updateCat(Long id, CatDto catDto) {
        Cat cat = catRepository.findById(id)
                .orElseThrow(() -> new AppException("Cat not found", HttpStatus.NOT_FOUND));

        catMapper.updateCat(cat, catMapper.toCat(catDto));

        Cat savedCat = catRepository.save(cat);

        return catMapper.toCatDto(savedCat);
    }

    public CatDto patchCat(Long id, CatDto catDto) {
        Cat cat = catRepository.findById(id)
                .orElseThrow(() -> new AppException("Cat not found", HttpStatus.NOT_FOUND));

        if (catDto.getBreed() != null) {
            cat.setBreed(catDto.getBreed());
        }
        if (catDto.getName() != null) {
            cat.setName(catDto.getName());
        }
        if (catDto.getYear() != 0) {
            cat.setYear(catDto.getYear());
        }
        if (catDto.getColor() != null) {
            cat.setColor(catDto.getColor());
        }

        Cat savedCat = catRepository.save(cat);

        return catMapper.toCatDto(savedCat);
    }

    public CatDto deleteCat(Long id) {
        Cat cat = catRepository.findById(id)
                .orElseThrow(() -> new AppException("Cat not found", HttpStatus.NOT_FOUND));
        CatDto catDto = catMapper.toCatDto(cat);

        catRepository.deleteById(id);

        return catDto;
    }

    public CatDto getCat(Long id) {
        Cat cat = catRepository.findById(id)
                .orElseThrow(() -> new AppException("Cat not found", HttpStatus.NOT_FOUND));
        return catMapper.toCatDto(cat);
    }
}