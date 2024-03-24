package com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper;

import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddTechnologyRequest;
import  com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.UpdateTechnologyRequest;
import com.pragma.arquetipobootcamp2024.domain.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ITechnologyRequestMapper {
@Mapping(target = "id", ignore = true)
@Mapping(source = "name", target = "name")
@Mapping(source = "description", target = "description")
Technology addRequestToTechnology(AddTechnologyRequest addTechnologyRequest);

@Mapping(target = "id", ignore = true)
@Mapping(source = "name", target = "name")
@Mapping(source = "description", target = "description")
Technology updateRequestToTechnology(UpdateTechnologyRequest updateTechnologyRequest);
}



