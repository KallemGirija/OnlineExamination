import { Component } from '@angular/core';
import { StudentDto } from '../student-dto';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';
import { Student } from '../student';

@Component({
  selector: 'app-student-view',
  templateUrl: './student-view.component.html',
  styleUrls: ['./student-view.component.css']
})
export class StudentViewComponent {


  __StudentService:StudentService;
  router:Router;
  allStudent: Array<Student> = [];
  student:StudentDto[]=[];

  status=false;
  message='';

  studentId:string='';
  

  constructor(__StudentService:StudentService,router: Router){
    this.__StudentService=__StudentService;
    this.allStudent=this.__StudentService.getStudentArr();
    this.router = router;
  }

  addStudent(studentId:number){
    this.router.navigate(['addstudent']);
  }


  viewAllStudents(){
    this.__StudentService.getAllStudent().subscribe(
      data=>{
        console.log("data:-"+data);
        this.student  = data;
      },err=>{
        console.log("error from spring",err);

      }
    )
 
    }
}
