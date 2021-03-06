import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ServiceService} from '../service.service';
import {Typeservice} from '../typeservice';
import {Typerent} from '../typerent';
import {Statusservice} from '../statusservice';
import {Service} from '../service';
import {Router} from '@angular/router';

function compareID(c: AbstractControl) {
  const v = c.value;
  if (v.id !== '' && v.idTypeService !== '') {
    switch (v.idTypeService) {
      case '1':
        const patt1 = new RegExp('^(VL)\\-+[0-9]{4}$');
        if (!patt1.test(v.id)) {
          return {idmatchtypeservice: true};
        }
        break;
      case '2':
        const patt2 = new RegExp('^(HO)\\-+[0-9]{4}$');
        if (!patt2.test(v.id)) {
          return {idmatchtypeservice: true};
        }
        break;
      case '3':
        const patt3 = new RegExp('^(RO)\\-+[0-9]{4}$');
        if (!patt3.test(v.id)) {
          return {idmatchtypeservice: true};
        }
        break;
    }
  } else {
    return {idmatchtypeservice: null};
  }
}

@Component({
  selector: 'app-create-service',
  templateUrl: './create-service.component.html',
  styleUrls: ['./create-service.component.css']
})
export class CreateServiceComponent implements OnInit {
  createServiceForm: FormGroup;
  TypeServiceList: Typeservice[] = [];
  TypeRentList: Typerent[] = [];
  StatusList: Statusservice[] = [];
  ServiceList: Service[] = [];
  private resultForm: any;
  private serviceForm: Service;

  constructor(private fb: FormBuilder, private serviceService: ServiceService, private router: Router) {
    this.serviceService.findAllService().subscribe(next => {
      this.ServiceList = next;
    });
    this.createServiceForm = this.fb.group({
      idGroup: this.fb.group({
        idTypeService: [''],
        id: [''],
      }),
      name: [''],
      area: [''],
      numberOfFloor: [''],
      numberMaxOfPeople: [''],
      rent: [''],
      idTypeRent: [''],
      status: [''],
    });
  }

  ngOnInit(): void {
    this.serviceService.findAllTypeService().subscribe(
      next => [
        this.TypeServiceList = next],
      error => console.log(error)
    );
    this.serviceService.findAllTypeRent().subscribe(
      next => [
        this.TypeRentList = next],
      error => console.log(error)
    );
    this.serviceService.findAllStatus().subscribe(
      next => [
        this.StatusList = next],
      error => console.log(error)
    );
    this.createServiceForm = this.fb.group({
      idGroup: this.fb.group({
        idTypeService: ['', Validators.required],
        id: ['', [Validators.required, Validators.pattern('^(RO|HO|VL)\\-+[0-9]{4}$'), this.existID.bind(this)]],
      }, {validator: compareID}),
      name: ['', [Validators.required,
        Validators.pattern('^[a-zA-Z0-9\\_\\-\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹế]+$'),
        Validators.maxLength(100)]],
      area: ['', [Validators.required,
        Validators.pattern('^[1-9]{1}[0-9]{0,}\\.[0-9]{1,}$')]],
      numberOfFloor: ['', [Validators.required,
        Validators.pattern('^[1-9]{1}[0-9]{0,3}$')]],
      numberMaxOfPeople: ['', [Validators.required,
        Validators.pattern('^[1-9]{1}[0-9]{0,3}$')]],
      rent: ['', [Validators.required,
        Validators.pattern('^[1-9]{1}[0-9]{5,}$')]],
      idTypeRent: ['', [Validators.required]],
      status: ['', Validators.required],
    });
  }

  notSpace(value: string) {
    let inputKey = '';
    value = value.toLowerCase().trim();
    for (let i = 0; i < value.length; i++) {
      if ((value.charAt(i) !== ' ' || (value.charAt(i) === ' ' && value.charAt(i + 1) !== ' '))) {
        inputKey += value.charAt(i);
      }
    }
    let toUpperCase: string[] = [];
    toUpperCase = inputKey.split(' ');
    for (let i = 0; i < toUpperCase.length; i++) {
      toUpperCase[i] = toUpperCase[i].charAt(0).toUpperCase() + toUpperCase[i].substring(1, toUpperCase[i].length);
    }
    this.createServiceForm.patchValue({
      name: toUpperCase.join(' ')
    });
  }

  existID(c: AbstractControl) {
    const v = c.value;
    for (const service of this.ServiceList) {
      if (service.id === v) {
        return {idExist: true};
      }
    }
    return null;
  }

  onSubmit() {
    this.resultForm = this.createServiceForm.value;
    this.serviceForm = new Service(this.resultForm.idGroup.id, this.resultForm.name, this.resultForm.area, this.resultForm.numberOfFloor
      , this.resultForm.numberMaxOfPeople, this.resultForm.rent, this.resultForm.idTypeRent, this.resultForm.idGroup.idTypeService,
      this.resultForm.status);
    this.serviceService.create(this.serviceForm).subscribe(
      next => {
        alert('Bạn đã thêm thành công dịch vụ mới!'),
          this.router.navigate(['/service/list']);
      },
      error => alert('Thêm mới dịch vụ không thành công hãy kiểm tra lại.'),
    );
  }
}
