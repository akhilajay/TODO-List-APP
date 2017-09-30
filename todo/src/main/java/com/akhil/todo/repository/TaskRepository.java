/**
 * 
 */
package com.akhil.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.akhil.todo.entiities.Task;

/**
 * @author akhilajay
 *
 */
@Repository("taskRepository")
public interface TaskRepository extends JpaRepository<Task, Integer>{
	
	public Task findByname(String name);

	@Query(value= "select id as id,name as name,description as description,iscompleted as iscompleted,ispending as ispending from Task where iscompleted =1",nativeQuery=true)
	public List<Task> findAllCompletedTask();
	
	@Query(value ="select id,name,description,iscompleted,ispending from Task where ispending =1",nativeQuery=true)
	public List<Task> findAllPendingTask();
}
