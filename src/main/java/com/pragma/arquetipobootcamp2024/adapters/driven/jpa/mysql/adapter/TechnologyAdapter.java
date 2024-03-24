package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistsException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.pragma.arquetipobootcamp2024.domain.model.Technology;
import com.pragma.arquetipobootcamp2024.domain.spi.ITechnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RequiredArgsConstructor
public class TechnologyAdapter implements ITechnologyPersistencePort {
private final ITechnologyRepository technologyRepository;
private final ITechnologyEntityMapper technologyEntityMapper;


@Override
public void saveTechnology(Technology technology) {
    if (technologyRepository.findByName(technology.getName()).isPresent()) {
        throw new TechnologyAlreadyExistsException();
    }

}

@Override
public Technology getTechnology(String name) {
    TechnologyEntity technology = technologyRepository.findByNameContaining(name).orElseThrow(ElementNotFoundException::new);
    return technologyEntityMapper.toModel(technology);

}

@Override
public List<Technology> getAllTechnologies(Integer page, Integer size) {
    Pageable pagination = PageRequest.of(page, size);
    List<TechnologyEntity> technologies = technologyRepository.findAll(pagination).getContent();
    if (technologies.isEmpty()) {
        throw new NoDataFoundException();
    }
    return technologyEntityMapper.toModelList(technologies);
}

@Override
public Technology updateTechnology(Technology technology) {
    TechnologyEntity existingTechnologyEntity = technologyRepository.findById(technology.getId())
            .orElseThrow(ElementNotFoundException::new);

    existingTechnologyEntity.setName(technology.getName());
    existingTechnologyEntity.setDescription(technology.getDescription());

    TechnologyEntity updatedTechnologyEntity = technologyRepository.save(existingTechnologyEntity);
    return technologyEntityMapper.toModel(updatedTechnologyEntity);
}

@Override
public void deleteTechnology(Long id) {
    if (technologyRepository.existsById(id)) {
        technologyRepository.deleteById(id);
    } else {
        throw new ElementNotFoundException();
    }
}
}










