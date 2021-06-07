package com.example.kidszonea4arctic3.bootstrap;


import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.repositories.ChildRepository;
import com.example.kidszonea4arctic3.repositories.ParentRepository;

import com.example.kidszonea4arctic3.services.ParentService;

import com.example.kidszonea4arctic3.models.ChildCareCenter;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.repositories.ChildCareCenterRepository;
import com.example.kidszonea4arctic3.repositories.ChildRepository;
import com.example.kidszonea4arctic3.repositories.ParentRepository;

import com.example.kidszonea4arctic3.services.CccSpecification;
import com.example.kidszonea4arctic3.services.EmailServiceImpl;
import com.example.kidszonea4arctic3.services.ParentService;
import com.example.kidszonea4arctic3.services.SearchCriteria;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.List;


@Component
public class BootStrapData implements CommandLineRunner {

    private final ParentRepository parentRepository;
    private final ChildRepository childRepository;
    private final ParentService parentService;

    Parent parent;
   

    private final EmailServiceImpl emailService;
    private final ChildCareCenterRepository cccRepo;

    public BootStrapData(ParentRepository parentRepository, ChildRepository childRepository, ParentService parentService, EmailServiceImpl emailService, ChildCareCenterRepository cccRepo) {
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
        this.parentService = parentService;
        this.emailService = emailService;
        this.cccRepo = cccRepo;

    }

    @Override
    public void run(String... args) throws Exception {


     //   Parent parent1 = new Parent("yassine.younes@esprit.tn","123","Yassine","Younes",56160377,false);

      //  parentRepository.save(parent1);
      //  Child child1 = new Child("Amine","Gongi",3,parent1);

       // childRepository.save(child1);
        //parent1.getChildren().add(child1);

       // Child child2 = new Child("Mohamed","Lahsoumi",4,parent1);
      //  childRepository.save(child2);

       // parent1.getChildren().add(child2);



        //parentRepository.save(parent1);


        //String email="yassine.younes@esprit.tn";
        //String subject="Test";
        //String text="This mail is for testing";
        //emailService.sendSimpleMessage(email,subject,text);


        System.out.println("started bootstrap");


        /*CccSpecification spec = new CccSpecification(new SearchCriteria("cost","<","300"));

        List<ChildCareCenter> results = cccRepo.findAll(spec);

        System.out.println(results.toString());*/


        // System.out.println(parent1.toString());
       // System.out.println(child1.toString());
        //System.out.println(child2.toString());
        //System.out.println(parent1.toString());
    }
}
