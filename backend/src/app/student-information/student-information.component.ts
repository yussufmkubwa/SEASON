import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student-information',
  templateUrl: './student-information.component.html',
  styleUrls: ['./student-information.component.css']
})
export class StudentInformationComponent implements OnInit {

  // Define a placeholder array for students
  students: any[] = [];

  constructor() { }

  ngOnInit(): void {
    // Initialize student data (example)
    this.students = [
      { fullName: 'John Doe', email: 'john.doe@example.com', school: 'Example School', course: 'Example Course' },
      { fullName: 'Jane Smith', email: 'jane.smith@example.com', school: 'Another School', course: 'Another Course' }
    ];
  }

  // Define the logout method
  logout() {
    // Add your logout logic here, e.g., clearing session data, navigating to login page
    console.log('Logout clicked');
  }
}
