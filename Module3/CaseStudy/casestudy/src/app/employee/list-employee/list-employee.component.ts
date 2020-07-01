import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Service} from '../../service/service';
import {Statusservice} from '../../service/statusservice';
import {EmployeeService} from '../employee.service';
import {Employee} from '../employee';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {
  searchEmployeeForm: FormGroup;
  employeeList: Employee[] = [];
  employeeInfor: Employee;
  birthdayValid = '';
  p: any;
  filter: any;
  key: string;
  private searchForm: any;

  constructor(private employeeService: EmployeeService, private formBuilder: FormBuilder) {
    this.searchEmployeeForm = this.formBuilder.group({
      key: ['']
    });
  }

  ngOnInit(): void {
    this.employeeService.findAllEmployee().subscribe(next => {
        this.employeeList = next;
      },
      error => console.log(error));
  }

  showDetailsInfor(id: string): void {
    // @ts-ignore
    if (!$('#myModal').show()) {
      // @ts-ignore
      $('#myModal').show();
    }
    // @ts-ignore
    // tslint:disable-next-line:only-arrow-functions
    $('#close').click(function() {
      // @ts-ignore
      $('#myModal').hide();
    });
    this.employeeService.findEmployeeById(id).subscribe(
      next => {
        this.employeeInfor = next;
        this.employeeService.findEmployeeById(next.id).subscribe(
          // tslint:disable-next-line:no-shadowed-variable
          next => {
            this.birthdayValid = next.birthday.split('-')[2] + '/'
              + next.birthday.split('-')[1] + '/'
              + next.birthday.split('-')[0];
            this.employeeInfor.birthday = this.birthdayValid;
          }, error => {
            console.log(error);
          });
        this.employeeService.findPositionById(next.idPos).subscribe(
          // tslint:disable-next-line:no-shadowed-variable
          next => {
            this.employeeInfor.idPos = next.namePosition;
          }, error => {
            console.log(error);
          });
        this.employeeService.findPartById(next.idPart).subscribe(
          // tslint:disable-next-line:no-shadowed-variable
          next => {
            this.employeeInfor.idPart = next.namePart;
          }, error => {
            console.log(error);
          });
        this.employeeService.findLevelById(next.idLevel).subscribe(
          // tslint:disable-next-line:no-shadowed-variable
          next => {
            this.employeeInfor.idLevel = next.nameLevel;
          }, error => {
            console.log(error);
          });
      },
      error => console.log(error));
  }

  deleteEmployeeById(id: string) {
    if (confirm('Bạn có muốn xóa dịch vụ ' + id + ' không?')) {
      this.employeeService.deleteEmployeeById(id).subscribe(
        next => {
          window.location.reload();
        },
        error => console.log(error)
      );
    }
  }

  onSearch() {
    this.searchForm = this.searchEmployeeForm.value;
    if (this.searchForm.key !== '') {
      this.employeeService.findAllEmployeeByName(this.searchForm.key).subscribe(
        next => {
          this.employeeList = next;
        }
      );
    }
  }
}
