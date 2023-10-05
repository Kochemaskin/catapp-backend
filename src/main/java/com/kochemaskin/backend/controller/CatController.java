package com.kochemaskin.backend.controller;

import com.kochemaskin.backend.dto.CatDto;
import com.kochemaskin.backend.service.CatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @GetMapping("/cats")
    public ResponseEntity<List<CatDto>> allCats() {
        return ResponseEntity.ok(catService.allCats());
    }

    @GetMapping("/cats/{id}")
    public ResponseEntity<CatDto> getCat(@PathVariable Long id){
        return ResponseEntity.ok(catService.getCat(id));
    }

    @PostMapping("/cats")
    public ResponseEntity<CatDto> createCat(@Valid @RequestBody CatDto catDto){
        CatDto createdCat = catService.createCat(catDto);
        return ResponseEntity.created(URI.create("/cats/" + catDto.getId())).body(createdCat);
    }
}