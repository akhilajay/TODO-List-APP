import {Injectable} from '@angular/core';
import {Headers, Http} from '@angular/http';
import 'rxjs/add/operator/toPromise';
import {Task} from 'app/task';
import 'rxjs/add/operator/map';



@Injectable()
export class TaskserviceService {
  private taskServiceUrl = 'http://localhost:5000/todo/task';  // URL to web API
  private headers = new Headers({'Content-Type': 'application/json'});
  constructor(private _http: Http) {

  }
  createTask(task: Task): Promise<Task> {
    return this._http.post(this.taskServiceUrl + "/create", JSON.stringify(task), {headers: this.headers})
      .toPromise().then(res => res.json() as Task);
  }
  getAllTask() {
    return this._http.get(this.taskServiceUrl + "/all").map(data => data.json()).toPromise();
  }
  deleteTask(id) {
    this._http.delete(this.taskServiceUrl + "/delete/id/" + id, {headers: this.headers}).map(data => data.json()).toPromise();
  }
  completedTask() {
    return this._http.get(this.taskServiceUrl + "/completed").map(data => data.json()).toPromise();
  }
  pendingTask() {
    return this._http.get(this.taskServiceUrl + "/pending").map(data => data.json()).toPromise();
  }
  updateTask(task:Task) {
    return this._http.put(this.taskServiceUrl + "/update", JSON.stringify(task), {headers: this.headers})
      .toPromise().then(res => res.json() as Task);
  }

}
