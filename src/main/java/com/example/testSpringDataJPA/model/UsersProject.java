package com.example.testSpringDataJPA.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Entity
@Data
public class UsersProject extends EntityWithRelation{

    private Long projectId;
    private  Long userId;

}
