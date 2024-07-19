import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-courses',
  template: `
    <div class="course-container">
      <h2>Available Courses</h2>
      <div class="course-card" *ngFor="let course of courses">
        <h3>{{ course.name }}</h3>
        <p>{{ course.description }}</p>
        <button (click)="enroll(course)">Enroll</button>
      </div>
    </div>
  `,
  styles: [`
    .course-container {
      padding: 20px;
    }
    .course-card {
      border: 1px solid #ccc;
      border-radius: 8px;
      padding: 16px;
      margin: 8px 0;
    }
    .course-card h3 {
      margin-top: 0;
    }
    .course-card button {
      background-color: #4CAF50;
      color: white;
      border: none;
      padding: 10px 20px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
      margin: 4px 2px;
      cursor: pointer;
      border-radius: 4px;
    }
    .course-card button:hover {
      background-color: #45a049;
    }
  `]
})
export class CoursesComponent implements OnInit {
  courses: any[] = [];

  constructor() { }

  ngOnInit(): void {
    this.courses = [
      { name: 'Course 1', description: 'Description for Course 1' },
      { name: 'Course 2', description: 'Description for Course 2' }
      

    ];
  }

  enroll(course: any): void {
    console.log(`Enrolled in ${course.name}`);
  }
}
