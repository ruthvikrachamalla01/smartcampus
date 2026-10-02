package com.smartcampus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartcampus.entity.Feedback;
import com.smartcampus.repository.FeedbackRepository;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    // Save feedback
    public Feedback saveFeedback(Feedback feedback) {

        return feedbackRepository.save(feedback);
    }

    // Get all feedback
    public List<Feedback> getAllFeedback() {

        return feedbackRepository.findAll();
    }
}