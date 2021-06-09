package com.example.kidszonea4arctic3.bootstrap;

import com.example.kidszonea4arctic3.controllers.MeetingController;
import com.example.kidszonea4arctic3.models.Child;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.repositories.ChildRepository;
import com.example.kidszonea4arctic3.repositories.ParentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final ParentRepository parentRepository;
    private final ChildRepository childRepository;
    
    private final MeetingController meetingController;


    public BootStrapData(ParentRepository parentRepository, ChildRepository childRepository,MeetingController meetingController) {
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
        this.meetingController=meetingController;
    }

    @Override
    public void run(String... args) throws Exception {


       // Parent parent1 = new Parent("hamza.balti@esprit.tn","123","hamza","balti",56160377,false);
        //Parent parent2 = new Parent("baltihamza6@gmail.com","123","balti","hamzus",56160377,false);
      /* Parent parent3 = new Parent("hamza.ali@ok.tn","123","hamza","balti",56160377,false,"images/messi.jpg");

        parentRepository.save(parent3);
       // parentRepository.save(parent2);

        
        Child child1 = new Child("azmi","ali",3,parent3);

        childRepository.save(child1);
        parent3.getKids().add(child1);*/

       // Child child2 = new Child("Mohamed","Lahsoumi",4,parent1);
      //  childRepository.save(child2);

       // parent1.getChildren().add(child2);



        //parentRepository.save(parent1);


        System.out.println("started bootstrap");
        System.out.println(meetingController.getChild().toString());

       // System.out.println(parent1.toString());
       // System.out.println(child1.toString());
        //System.out.println(child2.toString());
        //System.out.println(parent1.toString());
    }
}
