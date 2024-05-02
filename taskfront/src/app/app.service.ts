import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const Api_Url = 'http://localhost:8080'

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor( private http: HttpClient ) { }

  getAll() {
    return this.http.get(`${Api_Url}/task`);
  }

  create(task: any) {
    return this.http.post(`${Api_Url}/task`, task);
  }

  update(id: string, task: any) {
    return this.http.put(`${Api_Url}/task/${id}`, task);
  }

  delete(id: string) {
    return this.http.delete(`${Api_Url}/task/${id}`);
  }
}
