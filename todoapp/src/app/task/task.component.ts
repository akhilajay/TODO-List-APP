import {Component, OnInit} from '@angular/core';
import {Task} from '../task';
import {TaskserviceService} from '../services/task/taskservice.service';


@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {
  taskform = false;
  taskUpdateform = false;
  newTask: Task;
  name: string;
  description: string;
  status: string;
  taskId: number;
  hideId: true;
  taskList: Array<Task> = [];

  constructor(private _taskservice: TaskserviceService) {}
  addTask() {
    this.taskform = true;
  }
  closeEvent() {
    this.taskform = false;
    this.taskUpdateform = false;
  }

  ngOnInit() {
    this.findAllTask();
  }
  creatTask(task: Task): void {
    this._taskservice.createTask(task);
    this.closeEvent();
   // this.findAllTask();
    location.reload();
  }
  findAllTask() {
    this._taskservice.getAllTask()
      .then(taskList => this.taskList = taskList);
  }
  deleteTask(id) {
    this._taskservice.deleteTask(id);
    this.closeEvent();
    location.reload();
  }
  completedTask() {
    this._taskservice.completedTask().then(taskList => this.taskList = taskList);
  }

  pendingTask() {
    this._taskservice.pendingTask().then(taskList => this.taskList = taskList);
  }

  editTaskWindow(task) {
    this.taskId = task.taskId;
    this.name = task.name;
    this.description = task.description;
    this.status = task.status;
    this.taskUpdateform = true;
  }

  updateTask(task: Task) {
    this._taskservice.updateTask(task);
    this.taskUpdateform = false;
     // this.findAllTask();
     location.reload();
  }


}
