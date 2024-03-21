package com.pragma.arquetipobootcamp2024.adapters.driving.http.controller;

import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.UpdateTechnologyRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.TechnologyResponse;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ITechnologyRequestMapper;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ITechnologyResponseMapper;
import com.pragma.arquetipobootcamp2024.domain.api.ITechnologyServicePort;
import com.pragma.arquetipobootcamp2024.domain.model.Technology;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technology")
@RequiredArgsConstructor
public class TechnologyRestControllerAdapter {
    private final ITechnologyServicePort technologyServicePort;
    private final ITechnologyRequestMapper technologyRequestMapper;
    private final ITechnologyResponseMapper technologyResponseMapper;

    @PostMapping("/")
public ResponseEntity<Void>addTechnology(@RequestBody AddTechnologyRequest request) {
        technologyServicePort.saveTechnology(technologyRequestMapper.addRequestToTechnology(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
public ResponseEntity<List<Technology>> getAllTechnologies(@RequestParam Integer page, @RequestParam Integer size) {return  ResponseEntity.ok(technologyServicePort.getAllTechnologies(page, size));
    }

    @PutMapping("/")
public ResponseEntity<TechnologyResponse> updateTechnology(@RequestBody UpdateTechnologyRequest request){
        return ResponseEntity.ok(technologyResponseMapper.toTechnologyResponse(technologyServicePort.updateTechnology(technologyRequestMapper.updateRequestToTechnology(request))));
    }

    @DeleteMapping("/{id}")
public  ResponseEntity<Void>deleteTechnology(@PathVariable Long id){
       technologyServicePort.deleteTechnology(id);
       return  ResponseEntity.noContent().build();
    }
}

