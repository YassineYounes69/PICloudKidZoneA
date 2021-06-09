package com.example.kidszonea4arctic3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kidszonea4arctic3.models.History;
import com.example.kidszonea4arctic3.models.Meeting;
import com.example.kidszonea4arctic3.repositories.HistoryRepository;

@RestController
public class HistoryController {
	
	
	@Autowired
	private HistoryRepository hr;

	
	
	
	
	@GetMapping("/allHistory")
	 @ResponseBody
	 public List<History> getHistory() {
	 List<History> list = (List<History>) hr.findAll();
	 return list;
	}
}
