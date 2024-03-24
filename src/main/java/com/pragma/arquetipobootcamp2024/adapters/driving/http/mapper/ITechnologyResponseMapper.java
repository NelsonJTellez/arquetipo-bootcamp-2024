package com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper;
import  com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.TechnologyResponse;
import com.pragma.arquetipobootcamp2024.domain.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITechnologyResponseMapper {
@Mapping(target = "id", ignore = true)
@Mapping(source = "name", target = "name")
@Mapping(source = "description", target = "description")
TechnologyResponse toTechnologyResponse(Technology technology);

List<TechnologyResponse> toTechnologyResponseList(List<Technology> technologies);
}