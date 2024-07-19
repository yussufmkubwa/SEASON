// src/app/services/student.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient) { }

  getStudents(): Observable<any[]> {
    // Replace 'api/students' with your actual API endpoint
    return this.http.get<any[]>('api/students');
  }

  // Add other methods as needed
}
