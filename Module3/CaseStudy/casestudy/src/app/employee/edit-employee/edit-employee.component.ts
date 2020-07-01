import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Employee} from '../employee';
import {Position} from '../position';
import {Part} from '../part';
import {Level} from '../level';
import {EmployeeService} from '../employee.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {
  editEmployeeForm: FormGroup;
  private resultForm: any;
  private employeeForm: Employee;
  EmployeePosList: Position[] = [];
  PartList: Part[] = [];
  LevelList: Level[] = [];
  EmployeeList: Employee[] = [];
  // @ts-ignore
  Employee: Employee = Employee;

  constructor(private fb: FormBuilder, private employeeService: EmployeeService, private router: Router,
              private activedRouter: ActivatedRoute) {
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
    this.activedRouter.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      this.employeeService.findEmployeeById(id).subscribe(
        next => {
          this.Employee = next;
          this.editEmployeeForm.patchValue({
              id: next.id,
              name: next.name,
              birthday: next.birthday,
              identificationCard: next.identificationCard,
              numberPhone: next.numberPhone,
              email: next.email,
              address: next.address,
              idPos: next.idPos,
              idLevel: next.idLevel,
              idPart: next.idPart,
              salary: next.salary
            }
          );
        }
      );
    });

    this.editEmployeeForm = this.fb.group({
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
      if (employee.id === v && v !== this.Employee.id) {
        return {idExist: true};
      }
    }
    return null;
  }

  existEmail(c: AbstractControl) {
    const v = c.value;
    console.log(this.EmployeeList);
    for (const employee of this.EmployeeList) {
      if (employee.email === v && v !== this.Employee.email) {
        return {emailExist: true};
      }
    }
    return null;
  }

  existCMND(c: AbstractControl) {
    const v = c.value;
    console.log(this.EmployeeList);
    for (const employee of this.EmployeeList) {
      if (employee.identificationCard === v && v !== this.Employee.identificationCard) {
        return {identificationCardExist: true};
      }
    }
    return null;
  }

  onSubmit() {
    this.resultForm = this.editEmployeeForm.value;
    this.employeeForm = new Employee(this.resultForm.id, this.resultForm.name, this.resultForm.birthday, this.resultForm.identificationCard,
      this.resultForm.salary, this.resultForm.numberPhone, this.resultForm.email, this.resultForm.address, this.resultForm.idPos,
      this.resultForm.idLevel, this.resultForm.idPart);
    this.employeeService.update(this.employeeForm).subscribe(
      next => {
        alert('Bạn đã chỉnh sửa thành công thông tin nhân viên!'),
          this.router.navigate(['/employee/list']);
      },
      error => alert('Chỉnh sửa thông tin nhân viên không thành công hãy kiểm tra lại.')
    );
  }
}
