package com.klef.soa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klef.soa.entity.Interview;


public interface InterviewService {
    Interview saveInterview(Interview interview);
    Interview updateInterview(Long interviewId,Interview interview);
	boolean deleteInterview(Long interviewId);
	List<Interview> getAllInterviews();
	Interview getInterviewById(Long interviewId);
    List<Interview> findByName(String name);
    List<Interview> findByType(String type);
}
