package com.pragma.arquetipobootcamp2024.domain.api.usecase;

import com.pragma.arquetipobootcamp2024.domain.api.ITechnologyServicePort;
import com.pragma.arquetipobootcamp2024.domain.model.Technology;
import com.pragma.arquetipobootcamp2024.domain.spi.ITechnologyPersistencePort;

import java.util.List;

public class TechnologyUseCase implements ITechnologyServicePort {
    private final ITechnologyPersistencePort technologyPersistencePort;

    public TechnologyUseCase(ITechnologyPersistencePort technologyPersistencePort) {
        this.technologyPersistencePort = technologyPersistencePort;
    }


    // crear metodo  del port persistencia que pregunte en la BD con el name si ya existe un registro  return bolean o optional.
    @Override
    public void saveTechnology(Technology technology) {
        technologyPersistencePort.saveTechnology(technology);
    }

    @Override
    public Technology getTechnology(String name) {
        return technologyPersistencePort.getTechnology(name);
    }

    @Override
    public List<Technology> getAllTechnologies(Integer page, Integer size) {
        return technologyPersistencePort.getAllTechnologies(page, size);
    }


    @Override
    public Technology updateTechnology(Technology technology) {
        return technologyPersistencePort.updateTechnology(technology);
    }

    @Override
    public void deleteTechnology(Long id) {
        technologyPersistencePort.deleteTechnology(id);
    }
}
