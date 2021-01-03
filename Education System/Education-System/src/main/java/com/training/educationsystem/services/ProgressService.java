package com.training.educationsystem.services;

import java.util.List;

import com.training.educationsystem.entities.Progress;

/*
 * progress service interface to declare all the methods
 */
public interface ProgressService {
	
	public Progress addProgress(int completedHours);

	public Progress  viewProgress(int progressId);

	public List<Progress> viewAllProgresses();
}
