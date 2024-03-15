package com.example.testSpringDataJPA.service;

import com.example.testSpringDataJPA.aspect.TrackUserAction;
import com.example.testSpringDataJPA.model.Project;
import com.example.testSpringDataJPA.model.User;
import com.example.testSpringDataJPA.model.UsersProject;
import com.example.testSpringDataJPA.repository.ProjectRepository;
import com.example.testSpringDataJPA.repository.UserRepository;
import com.example.testSpringDataJPA.repository.UsersProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserProjectService {
    private ProjectRepository projectRepository;
    private UsersProjectRepository usersProjectRepository;
    private UserRepository userRepository;

    /**
     * метод, возвращающий список пользователей, связанных с определенным проектом
     * @param projectId
     * @return
     */
    @TrackUserAction
    public List getUsersByProjectId(Long projectId){
        List<User> users = new ArrayList<>();
        List<UsersProject> usersProjects = usersProjectRepository.findAllByProjectId(projectId);
        for (UsersProject usersProject : usersProjects) {
            User user = userRepository.findById(usersProject.getUserId()).orElse(null);
            if (user != null) {
                users.add(user);
            }
        }
        return users;
    }

    /**
     * метод, возвращающий список проектов, связанных с определенным пользователем
     * @param userId
     * @return
     */
    @TrackUserAction
    public List getProjectsByUserId(Long userId){
        List<Project> projects = new ArrayList<>();
        List<UsersProject> usersProjects = usersProjectRepository.findAllByUserId(userId);
        for (UsersProject usersProject : usersProjects) {
            Project project = projectRepository.findById(usersProject.getProjectId()).orElse(null);
            if (project != null) {
                projects.add(project);
            }
        }
        return projects;
    }

    /**
     * метод, добавляющий пользователя к проекту
     * @param userId
     * @param projectId
     */
    @TrackUserAction
    public void addUserToProject(Long userId, Long projectId){
        UsersProject usersProject = new UsersProject();
        usersProject.setUserId(userId);
        usersProject.setProjectId(projectId);
        usersProjectRepository.save(usersProject);
    }

    /**
     * метод, удаляющий пользователя из проекта
     * @param userId
     * @param projectId
     */
    @TrackUserAction
    public UsersProject removeUserFromProject(Long userId, Long projectId){
        UsersProject usersProject = usersProjectRepository.findByUserIdAndProjectId(userId, projectId);
        if (usersProject != null) {
            usersProjectRepository.delete(usersProject);
        }
        return usersProject;
    }
    @TrackUserAction
    public void addUser(User user){
        userRepository.save(user);
    }
    @TrackUserAction
    public void addProject(Project project){
        projectRepository.save(project);
    }
    @TrackUserAction
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    @TrackUserAction
    public List<Project> findAllProject(){
        return projectRepository.findAll();
    }
}
