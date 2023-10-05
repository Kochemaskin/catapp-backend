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

    @PostMapping("/cats")
    public ResponseEntity<CatDto> createCat(@Valid @RequestBody CatDto catDto) {
        CatDto createdCat = catService.createCat(catDto);
        return ResponseEntity.created(URI.create("/cats/" + catDto.getId())).body(createdCat);
    }

    @GetMapping("/cats/{id}")
    public ResponseEntity<CatDto> getCat(@PathVariable Long id) {
        return ResponseEntity.ok(catService.getCat(id));
    }

    @PutMapping("/cats/{id}")
    public ResponseEntity<CatDto> updateCat(@PathVariable Long id, @Valid @RequestBody CatDto catDto) {
        return ResponseEntity.ok(catService.updateCat(id, catDto));
    }

    @PatchMapping("/cats/{id}")
    public ResponseEntity<CatDto> patchCat(@PathVariable Long id, @RequestBody CatDto catDto) {
        return ResponseEntity.ok(catService.patchCat(id, catDto));
    }

    @DeleteMapping("/cats/{id}")
    public ResponseEntity<CatDto> deleteCat(@PathVariable Long id) {
        return ResponseEntity.ok(catService.deleteCat(id));
    }
}