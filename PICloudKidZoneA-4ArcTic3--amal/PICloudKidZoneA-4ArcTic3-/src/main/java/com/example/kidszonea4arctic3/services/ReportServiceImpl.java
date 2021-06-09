package com.example.kidszonea4arctic3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.models.Publication;
import com.example.kidszonea4arctic3.models.Report;
import com.example.kidszonea4arctic3.repositories.IReportRepository;
import com.example.kidszonea4arctic3.repositories.PublicationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements IReportService {
	@Autowired 
	IReportRepository reportRepository;

	
	
	@Override
	public List<Report> getReportList() {
        return (List<Report>) reportRepository.findAll();
	}

	@Override
	public void addReport(Report r) {
		reportRepository.save(r);		
	}

}