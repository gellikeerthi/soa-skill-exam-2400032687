package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Interview;
import com.klef.soa.repository.InterviewRepository;

@Service
public class InterviewServiceImpl implements InterviewService{
@Autowired
private InterviewRepository repo;
	@Override
	public Interview saveInterview(Interview interview) {
		// TODO Auto-generated method stub
		return repo.save(interview);
		
	}
	@Override
	public Interview updateInterview(Long interviewId, Interview interview) {

	    Optional<Interview> optional = repo.findById(interviewId);

	    if (optional.isPresent()) {
	        Interview i = optional.get();
	        i.setName(interview.getName());
	        i.setType(interview.getType());
	        i.setStatus(interview.getStatus());
	        i.setLocation(interview.getLocation());
	        return repo.save(i);
	    }

	    return null;
	}
	//@Override
//	public Interview updateInterview(Interview interview) {
//		// TODO Auto-generated method stub
//		Optional<Interview> optional=repo.findById(interview.getInterviewId());
//		if(optional.isPresent()) {
//			Interview in=optional.get();
//			 in.setName(interview.getName());
//		     in.setType(interview.getType());
//		     in.setStatus(interview.getStatus());
//		     in.setLocation(interview.getLocation());
//		     return repo.save(in);
//		     
//		}
//		return null;
//	}

	@Override
	public boolean deleteInterview(Long interviewId) {

	    if (!repo.existsById(interviewId)) {
	        return false;
	    }

	    repo.deleteById(interviewId);
	    return true;
	}

	@Override
	public List<Interview> getAllInterviews() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Interview getInterviewById(Long interviewId) {
		// TODO Auto-generated method stub
		return repo.findById(interviewId).orElse(null);
	}

	@Override
	public List<Interview> findByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}

	@Override
	public List<Interview> findByType(String type) {
		// TODO Auto-generated method stub
		return repo.findByType(type);
	}

}
