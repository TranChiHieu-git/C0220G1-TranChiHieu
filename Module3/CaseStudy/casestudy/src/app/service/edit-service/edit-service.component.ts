import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Typeservice} from '../typeservice';
import {Typerent} from '../typerent';
import {Statusservice} from '../statusservice';
import {Service} from '../service';
import {ServiceService} from '../service.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

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
  selector: 'app-edit-service',
  templateUrl: './edit-service.component.html',
  styleUrls: ['./edit-service.component.css']
})
export class EditServiceComponent implements OnInit {
  editServiceForm: FormGroup;
  TypeServiceList: Typeservice[] = [];
  TypeRentList: Typerent[] = [];
  StatusList: Statusservice[] = [];
  private resultForm: any;
  private serviceForm: Service;

  constructor(private fb: FormBuilder, private serviceService: ServiceService, private router: Router,
              private activedRouter: ActivatedRoute) {
  }

  ngOnInit(): void {
    console.log('oninit');
    this.editServiceForm = this.fb.group({
      idGroup: this.fb.group({
        idTypeService: ['', Validators.required],
        id: ['', [Validators.required, Validators.pattern('^(RO|HO|VL)\\-+[0-9]{4}$')]],
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
    this.activedRouter.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      this.serviceService.findServiceById(id).subscribe(
        next => {
          this.editServiceForm.patchValue({
              idGroup: {
                idTypeService: next.idTypeService,
                id: next.id
              },
              name: next.name,
              area: next.area,
              numberOfFloor: next.numberOfFloor,
              numberMaxOfPeople: next.numberMaxOfPeople,
              rent: next.rent,
              idTypeRent: next.idTypeRent,
              status: next.status
            }
          );
        }
      );
    });
  }

  onSubmit() {
    console.log('submit');
    this.resultForm = this.editServiceForm.value;
    this.serviceForm = new Service(this.resultForm.idGroup.id, this.resultForm.name, this.resultForm.area, this.resultForm.numberOfFloor
      , this.resultForm.numberMaxOfPeople, this.resultForm.rent, this.resultForm.idTypeRent, this.resultForm.idGroup.idTypeService,
      this.resultForm.status);
    this.serviceService.update(this.serviceForm).subscribe(
      next => {
        alert('Bạn đã chỉnh sửa thành công dịch vụ!'),
          this.router.navigate(['/service/list']);
      },
      error => alert('Chỉnh sửa dịch vụ không thành công hãy kiểm tra lại.'),
    );

  }
}
