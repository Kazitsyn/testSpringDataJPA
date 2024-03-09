package com.example.testSpringDataJPA.controller;

import com.example.testSpringDataJPA.model.UsersProject;
import com.example.testSpringDataJPA.service.UserProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserProjectController {
    private UserProjectService userProjectService;
    /**
     * - метод, обрабатывающий GET-запрос для получения списка пользователей, связанных с определенным проектом
     * @param projectId
     * @return
     */
    @GetMapping("/users/{projectId}")
    public ResponseEntity<List> getUsersByProjectId(@PathVariable Long projectId) {
        try {
            List usersProjects = userProjectService.getUsersByProjectId(projectId);
            return new ResponseEntity<>(usersProjects, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     *  - метод, обрабатывающий GET-запрос для получения списка проектов, связанных с определенным пользователем
     * @param userId
     * @return
     */
    @GetMapping("/projects/{userId}")
    public ResponseEntity<List> getProjectsByUserId(@PathVariable Long userId){
        try {
            List usersProjects = userProjectService.getProjectsByUserId(userId);
            return new ResponseEntity<>(usersProjects, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     *  - метод, обрабатывающий POST-запрос для добавления пользователя к проекту
     * @param userId
     * @param projectId
     * @return
     */
    @PostMapping("/addUserToProject/{userId}/{projectId}")
    public ResponseEntity addUserToProject(@PathVariable Long userId, @PathVariable Long projectId){
        userProjectService.addUserToProject(userId,projectId);
        return ResponseEntity.ok("User added to project successfully");
    }

    /**
     * - метод, обрабатывающий POST-запрос для удаления пользователя из проекта
     * @param userId
     * @param projectId
     * @return
     */
    @PostMapping("/removeUserFromProject/{userId}/{projectId}")
    public ResponseEntity removeUserFromProject(@PathVariable Long userId, @PathVariable Long projectId){
        if (userProjectService.removeUserFromProject(userId,projectId) != null) {
            return ResponseEntity.ok("User removed from project successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UsersProject not found");
        }
    }
}
