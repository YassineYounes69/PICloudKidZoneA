package com.example.kidszonea4arctic3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.models.Publication;
import com.example.kidszonea4arctic3.models.TypePub;
import com.example.kidszonea4arctic3.repositories.PublicationRepository;
import com.example.kidszonea4arctic3.models.Employee.Role;
import com.example.kidszonea4arctic3.services.IPublicationService;
import com.sun.el.parser.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@SpringBootTest
class KidsZoneA4arctic3ApplicationTests {
	IPublicationService ps ;

    @Test
    void contextLoads() {
    	
    }

    
    
}
