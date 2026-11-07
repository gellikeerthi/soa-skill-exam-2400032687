package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Interview;
import com.klef.soa.service.InterviewService;

@RestController
@RequestMapping("/interview")
public class InterviewController {
@Autowired
private InterviewService service;

@GetMapping("/")
public String home() {
	return "Interview Project Task";
}
@PostMapping("/add")
public ResponseEntity<Interview> saveInterview(@RequestBody Interview i) {
	Interview in=service.saveInterview(i);
	return ResponseEntity.status(201).body(in);
}

@GetMapping("/displayall")
public ResponseEntity<List<Interview>> getAllInterviews(){
	List<Interview> in=service.getAllInterviews();
	return ResponseEntity.status(200).body(in);
}

@PutMapping("/update/{id}")
public ResponseEntity<?> updateInterview(@PathVariable("id") Long interviewId,@RequestBody Interview i) {
	Interview updated=service.updateInterview(interviewId, i);
	if(updated!=null) {
		return ResponseEntity.ok(updated);
	}
    else {
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Interview ID not found"+interviewId);
			    }
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<String> deleteInterview(
        @PathVariable("id") Long interviewId) {

    boolean deleted = service.deleteInterview(interviewId);

    if (deleted) {
        return ResponseEntity.ok("Interview deleted Successfully");
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Interview ID not found: " + interviewId);
    }
}
@GetMapping("/name/{name}")
public ResponseEntity<?> findByName(@PathVariable String name){
	List<Interview> in=service.findByName(name);
	if(!in.isEmpty()) {
		return ResponseEntity.ok(in);
	}else {
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Interview found with name: "+name);
	}
	
}
@GetMapping("/type/{type}")
public ResponseEntity<?> findByType(@PathVariable String type){
	List<Interview> in=service.findByType(type);
	if(!in.isEmpty()) {
		return ResponseEntity.ok(in);
	}
	else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No interview found with type: "+type);
	}
}
}
