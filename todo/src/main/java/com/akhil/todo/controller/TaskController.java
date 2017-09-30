/**
 * 
 */
package com.akhil.todo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akhil.todo.entiities.Task;
import com.akhil.todo.service.TaskService;
import com.akhil.todo.vo.TaskVO;

/**
 * @author akhilajay
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	TaskService taskService;

	@PostMapping("/create")
	public TaskVO create(@RequestBody Task task) {
		Task t = taskService.saveTask(task);
		TaskVO taskVo = new TaskVO();
		taskVo.setTaskId(t.getId());
		taskVo.setName(t.getName());
		taskVo.setDescription(t.getDescription());
		taskVo.setStatus((t.isIspending()) ? "Pending" : "Completed");
		return taskVo;
	}

	@GetMapping("/all")
	public List<TaskVO> findAll() {
		List<Task> taskList = taskService.findAllTasks();
		List<TaskVO> taskVoList = new ArrayList<TaskVO>();
		taskList.forEach(t -> {
			TaskVO taskVo = new TaskVO();
			taskVo.setTaskId(t.getId());
			taskVo.setName(t.getName());
			taskVo.setDescription(t.getDescription());
			taskVo.setStatus((t.isIspending()) ? "Pending" : "Completed");
			taskVoList.add(taskVo);
		});
		return taskVoList;
	}

	@PutMapping("/update")
	public TaskVO update(@RequestBody TaskVO taskvo) {
		Task task = new Task();
		task.setId(taskvo.getTaskId());
		task.setName(taskvo.getName());
		task.setDescription(taskvo.getDescription());
		task.setIscompleted(taskvo.getStatus().equals("Completed") ? true : false);
		task.setIspending(taskvo.getStatus().equals("Pending") ? true : false);
		Task t = taskService.updateTask(task);
		TaskVO taskVo = new TaskVO();
		taskVo.setTaskId(t.getId());
		taskVo.setName(t.getName());
		taskVo.setDescription(t.getDescription());
		taskVo.setStatus((t.isIspending()) ? "Pending" : "Completed");
		return taskVo;
	}

	@DeleteMapping("/delete/id/{id}")
	public boolean delete(@PathVariable int id) {
		return taskService.deleteTaskById(id);
	}

	@GetMapping("/id/{id}")
	public TaskVO findOne(@PathVariable int id) {
		Task t = taskService.findById(id);
		TaskVO taskVo = new TaskVO();
		taskVo.setTaskId(t.getId());
		taskVo.setName(t.getName());
		taskVo.setDescription(t.getDescription());
		taskVo.setStatus((t.isIspending()) ? "Pending" : "Completed");
		return taskVo;
	}

	@GetMapping("/name/{name}")
	public TaskVO findByName(@PathVariable String name) {
		Task t = taskService.findByName(name);
		TaskVO taskVo = new TaskVO();
		taskVo.setTaskId(t.getId());
		taskVo.setName(t.getName());
		taskVo.setDescription(t.getDescription());
		taskVo.setStatus((t.isIspending()) ? "Pending" : "Completed");
		return taskVo;
	}

	@GetMapping("/pending")
	public List<TaskVO> pending() {
		List<Task> taskList = taskService.findAllPendingTask();
		List<TaskVO> taskVoList = new ArrayList<TaskVO>();
		taskList.forEach(t -> {
			TaskVO taskVo = new TaskVO();
			taskVo.setTaskId(t.getId());
			taskVo.setName(t.getName());
			taskVo.setDescription(t.getDescription());
			taskVo.setStatus((t.isIspending()) ? "Pending" : "Completed");
			taskVoList.add(taskVo);
		});
		return taskVoList;
	}

	@GetMapping("/completed")
	public List<TaskVO> completed() {
		List<Task> taskList = taskService.findAllCompletedTask();
		List<TaskVO> taskVoList = new ArrayList<TaskVO>();
		taskList.forEach(t -> {
			TaskVO taskVo = new TaskVO();
			taskVo.setTaskId(t.getId());
			taskVo.setName(t.getName());
			taskVo.setDescription(t.getDescription());
			taskVo.setStatus((t.isIspending()) ? "Pending" : "Completed");
			taskVoList.add(taskVo);
		});
		return taskVoList;
	}

}
