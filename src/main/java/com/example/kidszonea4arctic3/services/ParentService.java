package com.example.kidszonea4arctic3.services;

import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {
    @Autowired
    ParentRepository parentRepository;

    public void addParent(Parent parent) {
        parentRepository.save(parent);
    }

    public List<Parent> getAllParents() {
        return parentRepository.getAllParents();
    }

    public Parent authenticate(String login, String password) {
        return parentRepository.getParentByLoginPw(login,password);
    }
}
