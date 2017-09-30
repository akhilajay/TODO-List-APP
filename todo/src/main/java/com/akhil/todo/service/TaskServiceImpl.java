/**
 * 
 */
package com.akhil.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhil.todo.entiities.Task;
import com.akhil.todo.repository.TaskRepository;

/**
 * @author akhilajay
 *
 */
@Service("taskServiceImpl")
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;

	@Override
	public Task findById(int id) {
		return taskRepository.findOne(id);
	}

	@Override
	public Task findByName(String name) {
		return taskRepository.findByname(name);
	}

	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Task updateTask(Task task) {
		Task currentTask = taskRepository.findOne(task.getId());
		currentTask.setName(task.getName());
		currentTask.setDescription(task.getDescription());
		currentTask.setIscompleted(task.isIscompleted());
		currentTask.setIspending(task.isIspending());
		return saveTask(currentTask);
	}
	
	//TODO: instead of delete change this to isdelete flag
	@Override
	public boolean deleteTaskById(int id) {
		taskRepository.delete(id);
		return taskRepository.findOne(id) == null;
	}

	@Override
	public List<Task> findAllTasks() {
		return taskRepository.findAll();
	}

	@Override
	public List<Task> findAllCompletedTask() {
		return taskRepository.findAllCompletedTask();
	}

	@Override
	public List<Task> findAllPendingTask() {
		return taskRepository.findAllPendingTask();
	}

}
