package com.pragma.arquetipobootcamp2024.domain.model;

import com.pragma.arquetipobootcamp2024.domain.exception.EmptyFieldException;
import com.pragma.arquetipobootcamp2024.domain.util.DomainConstants;



import java.util.Objects;



public class Technology {
private final Long id;
private final String name;

private final String description;


public Technology(long id, String name, String description) {
    if (name.trim().isEmpty()) {
        throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
    }
    if (description.trim().isEmpty()) {
        throw new EmptyFieldException(DomainConstants.Field.DESCRIPTION.toString());
    }
    this.id = id;
    this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
    this.description = Objects.requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);

}

public Long getId() {
    return id;
}

public String getName() {
    return name;
}

public String getDescription() {
    return description;
}

}
