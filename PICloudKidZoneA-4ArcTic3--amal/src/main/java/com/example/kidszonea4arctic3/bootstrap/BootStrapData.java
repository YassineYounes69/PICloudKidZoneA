package com.example.kidszonea4arctic3.bootstrap;

import com.example.kidszonea4arctic3.repositories.ChildRepository;
import com.example.kidszonea4arctic3.repositories.ParentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final ParentRepository parentRepository;
    private final ChildRepository childRepository;

    public BootStrapData(ParentRepository parentRepository, ChildRepository childRepository) {
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
    }

    @Override
    public void run(String... args) throws Exception {


  


        System.out.println("started bootstrap");
    
    }
}
