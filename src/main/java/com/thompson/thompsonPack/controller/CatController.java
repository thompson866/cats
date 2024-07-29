package com.thompson.thompsonPack.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.thompson.thompsonPack.dto.CatDTO;
import com.thompson.thompsonPack.entity.Cat;
import com.thompson.thompsonPack.repository.CatRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "main_methods")
@RestController
@Slf4j
@RequiredArgsConstructor
public class CatController {

    @Autowired
    private final CatRepo catRepo;

    private final ObjectMapper objectMapper;



    @Operation (summary = "создает нового кота",
    description = "получает DTO кота, билдером собирает и сохраняет кота")
    @PostMapping("/api/add")
    public void addCat(@RequestBody CatDTO catDTO) {


        log.info("new cat: " + catRepo.save(
                Cat.builder()
                        .age(catDTO.getAge())
                        .name(catDTO.getName())
                        .weight(catDTO.getWeight())
                        .build()));
    }

    @SneakyThrows
    @GetMapping("/api/all")
    public String getAll() {
        List<Cat> cats = catRepo.findAll();
        return objectMapper.writeValueAsString(cats);
    }

//    public List<Cat> getAll() {
//        return catRepo.findAll();
//    }

    @GetMapping("/api")
    public Cat getCat(@RequestParam int id) {
        return catRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/api")
    public void deleteCat(@RequestParam int id) {
        catRepo.deleteById(id);
    }

    @PutMapping("/api/add")
    public String changeCat(@RequestBody Cat cat) {
        if (!catRepo.existsById(cat.getId())) {
            return "нет такого кота";

        }
        return catRepo.save(cat).toString();
    }
}
