package com.example.testSpringDataJPA.repository;

import com.example.testSpringDataJPA.model.Project;
import com.example.testSpringDataJPA.model.UsersProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersProjectRepository extends JpaRepository<UsersProject, Long> {
    List getUsersByProjectId(Long projectId);
    List getProjectsByUserId(Long userId);
    List findAllByProjectId(Long projectId);
    List findAllByUserId(Long userId);

    UsersProject findByUserIdAndProjectId(Long userId, Long projectId);
}
