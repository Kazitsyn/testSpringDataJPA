package com.example.testSpringDataJPA.repository;

import com.example.testSpringDataJPA.model.Project;
import com.example.testSpringDataJPA.model.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private UserRepository userRepository;

    private ProjectRepository projectRepository;
    private UsersProjectRepository usersProjectRepository;

    @Override
    public void run(String... args) throws Exception {
        // Добавление пользователей
        User user1 = new User();
        user1.setUsername("user1");
        user1.setPassword("password1");
        user1.setEmail("user1@example.com");
        user1.setRole("ROLE_USER");
        userRepository.save(user1);

        User user2 = new User();
        user2.setUsername("user2");
        user2.setPassword("password2");
        user2.setEmail("user2@example.com");
        user2.setRole("ROLE_ADMIN");
        userRepository.save(user2);

        // Добавление проектов
        Project project1 = new Project();
        project1.setName("Project 1");
        project1.setDescription("Description 1");
        projectRepository.save(project1);

        Project project2 = new Project();
        project2.setName("Project 2");
        project2.setDescription("Description 2");
        projectRepository.save(project2);

    }
}