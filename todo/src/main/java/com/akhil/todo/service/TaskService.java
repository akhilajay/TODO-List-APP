/**
 * 
 */
package com.akhil.todo.service;

import java.util.List;

import com.akhil.todo.entiities.Task;

/**
 * @author akhilajay
 *
 */
public interface TaskService {

	Task findById(int id);

	Task findByName(String name);

	Task saveTask(Task task);

	Task updateTask(Task task);

	boolean deleteTaskById(int id);

	List<Task> findAllTasks();

	List<Task> findAllCompletedTask();

	List<Task> findAllPendingTask();

}
