import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Service} from '../../service/service';
import {Employee} from '../employee';
import {EmployeeService} from '../employee.service';
import {Router} from '@angular/router';
import {Typeservice} from '../../service/typeservice';
import {Part} from '../part';
import {Level} from '../level';
import {Position} from '../position';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  createEmployeeForm: FormGroup;
  private resultForm: any;
  private employeeForm: Employee;
  EmployeePosList: Position[] = [];
  PartList: Part[] = [];
  LevelList: Level[] = [];
  EmployeeList: Employee[] = [];

  constructor(private fb: FormBuilder, private employeeService: EmployeeService, private router: Router) {
    this.employeeService.findAllEmployee().subscribe(next => {
      console.log(next);
      this.EmployeeList = next;
    });
  }

  ngOnInit(): void {
    this.employeeService.findAllPosition().subscribe(
      next => [
        this.EmployeePosList = next],
      error => console.log(error)
    );
    this.employeeService.findAllPart().subscribe(
      next => [
        this.PartList = next],
      error => console.log(error)
    );
    this.employeeService.findAllLevel().subscribe(
      next => [
        this.LevelList = next],
      error => console.log(error)
    );


    this.createEmployeeForm = this.fb.group({
      id: ['', [Validators.required, Validators.pattern('^(NV\-)+[0-9]{4}$'), this.existID.bind(this)]],
      name: ['', [Validators.required,
        Validators.pattern('^[a-zA-Z0-9\\_\\-\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹế]+$'),
        Validators.maxLength(100)]],
      birthday: ['', [Validators.required,
        Validators.pattern('^[1-9]{1}[0-9]{3}\-+[0-9]{2}\-+[0-9]{2}$')]],
      identificationCard: ['', [Validators.required,
        Validators.pattern('^([1-9]{1}[0-9]{8}|[1-9]{1}[0-9]{11})$'), this.existCMND.bind(this)]],
      numberPhone: ['', [Validators.required,
        Validators.pattern('^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)+[0-9]{7}$')]],
      email: ['', [Validators.required,
        Validators.pattern('^[a-zA-Z]{1}[a-zA-Z0-9\\_]{1,100}\\@[a-zA-Z]{2,10}\\.[a-zA-Z]{2,10}$'),
        this.existEmail.bind(this)]],
      address: ['', [Validators.required,
        Validators.pattern('^[a-zA-Z0-9\\-\\/\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹế]+$')]],
      idPos: ['', Validators.required],
      idLevel: ['', Validators.required],
      idPart: ['', Validators.required],
      salary: ['', [Validators.required,
        Validators.pattern('^[1-9]{1}[0-9]+$')]],
    });
  }

  existID(c: AbstractControl) {
    const v = c.value;
    console.log(this.EmployeeList);
    for (const employee of this.EmployeeList) {
      if (employee.id === v) {
        return {idExist: true};
      }
    }
    return null;
  }

  existEmail(c: AbstractControl) {
    const v = c.value;
    console.log(this.EmployeeList);
    for (const employee of this.EmployeeList) {
      if (employee.email === v) {
        return {emailExist: true};
      }
    }
    return null;
  }

  existCMND(c: AbstractControl) {
    const v = c.value;
    console.log(this.EmployeeList);
    for (const employee of this.EmployeeList) {
      if (employee.identificationCard === v) {
        return {identificationCardExist: true};
      }
    }
    return null;
  }

  onSubmit() {
    this.resultForm = this.createEmployeeForm.value;
    this.employeeForm = new Employee(this.resultForm.id, this.resultForm.name, this.resultForm.birthday, this.resultForm.identificationCard,
      this.resultForm.salary, this.resultForm.numberPhone, this.resultForm.email, this.resultForm.address, this.resultForm.idPos,
      this.resultForm.idLevel, this.resultForm.idPart);
    this.employeeService.create(this.employeeForm).subscribe(
      next => {
        alert('Bạn đã thêm thành công nhân viên mới!'),
          this.router.navigate(['/employee/list']);
      },
      error => alert('Thêm mới nhân viên không thành công hãy kiểm tra lại.')
    );
  }
}
