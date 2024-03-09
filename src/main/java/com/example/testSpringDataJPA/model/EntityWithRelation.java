package com.example.testSpringDataJPA.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@MappedSuperclass
@Getter
@Setter
public abstract class EntityWithRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long relatedEntityId;

}
