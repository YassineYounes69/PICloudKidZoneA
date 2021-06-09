package com.example.kidszonea4arctic3.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.kidszonea4arctic3.models.Category;
import com.example.kidszonea4arctic3.models.CategoryEvent;
import com.example.kidszonea4arctic3.models.ChildCareCenter;
import com.example.kidszonea4arctic3.models.Event;
import com.example.kidszonea4arctic3.models.Rate;
import com.example.kidszonea4arctic3.services.ChildCareCenterService;
import com.example.kidszonea4arctic3.services.EventService;
import com.example.kidszonea4arctic3.services.RateService;
import com.example.kiszonea4arctic3.utils.FileUploadUtil;
import com.example.kiszonea4arctic3.utils.Utils;

import javax.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;


@Controller(value = "eventController")
@ELBeanName(value = "eventController")
public class EventController {
	@Autowired
	EventService es;
	@Autowired
	ChildCareCenterService js;

	@Autowired
	RateService rs;
	
	private Event e = new Event();
	private Part file;
	private List<Event> list;
	private CategoryEvent category;
	private boolean showForm = false;
	private boolean showStat = false;
	private CategoryEvent searchCat;
	private float education;
	private float competition;
	private float divertissant;
	private float autre;
	
	
	
	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public void showStatistics(){
		int n = es.retrieveAllEvents(Long.parseLong("1")).size();
		float  edu = es.searchByCategory(CategoryEvent.EDUCATIF).size() ;
		float  comp = es.searchByCategory(CategoryEvent.COMPETITION).size() ;
		float  div = es.searchByCategory(CategoryEvent.DIVERTISSANT).size() ;
		float  autr = es.searchByCategory(CategoryEvent.AUTRE).size() ;
	    education =  edu/n*100;
	    competition = comp/n*100;
	    divertissant = div/n*100;
	    autre = autr/n*100;
	    System.out.println(education + "\n"+ competition+ "\n" + divertissant +"\n" + autre);
	    showStatMeth();
	}
	
	public EventController(EventService es) {
		list = es.retrieveAllEvents(Long.parseLong("1"));
		for (Event e : list) {
			float rate = calculerRates(e);
			if (Float.isNaN(rate))
				rate = 0;
			e.setTotalRates(rate);
		}
		
	}
	
	
	public void showStatMeth(){
		showStat = true;
	}
	
	public boolean isShowStat() {
		return showStat;
	}

	public void setShowStat(boolean showStat) {
		this.showStat = showStat;
	}

	public float getEducation() {
		return education;
	}




	public void setEducation(float education) {
		this.education = education;
	}




	public float getCompetition() {
		return competition;
	}




	public void setCompetition(float competition) {
		this.competition = competition;
	}




	public float getDivertissant() {
		return divertissant;
	}




	public void setDivertissant(float divertissant) {
		this.divertissant = divertissant;
	}




	public float getAutre() {
		return autre;
	}




	public void setAutre(float autre) {
		this.autre = autre;
	}




	public float calculerRates(Event e) {
		Set<Rate> setR = new HashSet<Rate>();
		setR.addAll(e.getRates());
		float s = 0;
		for (Rate r : setR) {
			s += r.getValue();
		}
		return s / setR.size();
	}

	public List<Event> getList() {
		
		return list;
	}

	public void setList(List<Event> list) {
		
		this.list = list;
	}

	public void removeEvent(Long id) {
		es.deleteEvent(id);
		showAll();
	}

	public CategoryEvent getCategory() {
		return category;
	}

	public void setCategory(CategoryEvent category) {
		this.category = category;
	}

	public Event getE() {
		return e;
	}

	public void setE(Event e) {
		this.e = e;
	}

	
	public void rate(Event e){
		System.out.println("event : " + e);
		Rate r = new Rate();
		System.out.println("rateValue : " +e.getRateValue());
		r.setValue(e.getRateValue());
		Set<Event> setE = new HashSet<Event>();
		setE.add(e);
		r.setEvents(setE);
		System.out.println("rate : " + r);
		rs.addRateMeth(r);
		showAll();
	}
	
	
	
	




	public void showFormMeth(){
		showForm = true;
		System.out.println("showForm : "+showForm );
	}
	public void hideFormMeth(){
		System.out.println("showForm : "+showForm );
		showForm = false;
	}
	
	
	public boolean isShowForm() {
		return showForm;
	}

	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}

	public void addEvent() throws IOException{
		/*System.out.println("enter addEvent ...");
		InputStream inputStream = null;
		OutputStream outputStream = null;
		FacesContext context = FacesContext.getCurrentInstance();
		ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
		String path = servletContext.getRealPath("");
		boolean file1Success = false;
		String fileName = "event.jpg";
		if (file.getSize() > 0) {
			 fileName = Utils.getFileNameFromPart(file);
			
			File outputFile = new File(path + File.separator + "resources" + File.separator +"images" + File.separator + fileName);
			inputStream = file.getInputStream();
			outputStream = new FileOutputStream(outputFile);
			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			if (outputStream != null) {
				outputStream.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
			file1Success = true;
		}
		*/
		
		ChildCareCenter cc = js.retrieveJardin((long) 1).get();
		e.setChildCareCenter(cc);
		e.setImage("event.jpg");
		System.out.println(e);
		es.addEvent(e);
		showAll();
	}

	public void updateEvent(Event e1) {
		showFormMeth();
		e = e1;
	}

	public CategoryEvent[] getCategories() {
		return CategoryEvent.values();
	}

	
	public void participate(Long id){
		es.participateEvent(id);
		showAll();
	}
	
	
	
	
	public void searchEvent(){
		System.out.println("searchCat : " + searchCat);
		list = es.searchByCategory(searchCat);
	  	for (Event e : list) {
			float rate = calculerRates(e);
			if(Float.isNaN(rate))rate=0;
			e.setTotalRates(rate);
		}
	}
	
	
	
	
	public void showAll(){
		list = es.retrieveAllEvents(Long.parseLong("1"));
		for (Event e : list) {
			float rate = calculerRates(e);
			if (Float.isNaN(rate))
				rate = 0;
			e.setTotalRates(rate);
		}
	}
	
	public CategoryEvent getSearchCat() {
		return searchCat;
	}



	public void setSearchCat(CategoryEvent searchCat) {
		this.searchCat = searchCat;
	}

	public void sortByRate(){
		list = es.retrieveAllEventsSortedByRate(Long.parseLong("1"));
		  for (Event e : list) {
				float rate = calculerRates(e);
				if(Float.isNaN(rate))rate=0;
				e.setTotalRates(rate);
			}
		
	}

	public void resetEvent(){
		e = new Event();
	}
	
	
	// http://localhost:8082/jardinEnfantEvents/servlet/retrieveAllEvents/{jardin-id}
	@GetMapping("/retrieveAllEvents/{jardin-id}")
	@ResponseBody
	public List<Event> retrieveAllEvents(@PathVariable("jardin-id") String jardinId) {
		return es.retrieveAllEvents(Long.parseLong(jardinId));
	}

	// http://localhost:8082/jardinEnfantEvents/servlet/ajouterEvent/{jardin-id}
	@PostMapping("/ajouterEvent/{jardin-id}")
	@ResponseBody
	public void ajouterEvent(@PathVariable("jardin-id") String idJardin,
			@RequestParam("image") MultipartFile multipartFile, @RequestParam("category") String category,
			@RequestParam("date_event") String date_event, @RequestParam("description") String description,
			@RequestParam("name") String name, @RequestParam("nb_participants") int nb_participants) throws IOException

	{
		ChildCareCenter j = js.retrieveJardin(Long.parseLong(idJardin)).get();

		// e.setJardin_enfant(j);
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		CategoryEvent c = CategoryEvent.AUTRE;
		switch (category) {
		case "COMPETITION":
			c = CategoryEvent.COMPETITION;
			break;
		case "EDUCATIF":
			c = CategoryEvent.EDUCATIF;
			break;
		case "DIVERTISSANT":
			c = CategoryEvent.DIVERTISSANT;
			break;
		case "AUTRE":
			c = CategoryEvent.AUTRE;
			break;
		}
		Date date1 = new Date();
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date_event);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Event e = new Event(date1, name, description, fileName, nb_participants, c, j);
		// es.addEvent(e);
		String uploadDir = "event-photos/" + e.getName();
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		es.addEvent(e);

	}

	// http://localhost:8082/jardinEnfantEvents/servlet/remove-event/{event-id}
	@DeleteMapping("/remove-event/{event-id}")
	@ResponseBody
	public void removeEvent(@PathVariable("event-id") String id) {
		es.deleteEvent(Long.parseLong(id));
	}

	// http://localhost:8082/jardinEnfantEvents/servlet/modify-event/{jardin-id}
	@PutMapping("/modify-event/{jardin-id}")
	@ResponseBody
	public void modifyEvent(@RequestBody Event e, @PathVariable("jardin-id") String idJardin) {
		ChildCareCenter j = js.retrieveJardin(Long.parseLong(idJardin)).get();
		e.setJardin_enfant(j);
		es.updateEvent(e);
	}

	// http://localhost:8082/jardinEnfantEvents/servlet/participer-event/{jardin-id}
	@PutMapping("/participer-event/{event-id}")
	@ResponseBody
	public void participerEvent(@RequestBody Event e, @PathVariable("event-id") String idEvent) {
		es.participateEvent(Long.parseLong(idEvent));
	}

	// http://localhost:8082/jardinEnfantEvents/servlet/retrieve-event/{event-id}
	@GetMapping("/retrieve-event/{event-id}")
	@ResponseBody
	public Optional<Event> retrieveEvent(@PathVariable("event-id") String eventId) {
		return es.retrieveEvent(Long.parseLong(eventId));
	}

	// http://localhost:8082/jardinEnfantEvents/servlet/searchByCategory/{category}
	@GetMapping("/searchByCategory/{category}")
	@ResponseBody
	public List<Event> searchByCategory(@PathVariable("category") CategoryEvent category) {
		return es.searchByCategory(category);
	}

	// http://localhost:8082/jardinEnfantEvents/servlet/retrieveAllEventsSortedByRate/{jardin-id}
	@GetMapping("/retrieveAllEventsSortedByRate/{jardin-id}")
	@ResponseBody
	public List<Event> retrieveAllEventsSortedByRate(@PathVariable("jardin-id") String jardinId) {
		return es.retrieveAllEventsSortedByRate(Long.parseLong(jardinId));
	}

}
