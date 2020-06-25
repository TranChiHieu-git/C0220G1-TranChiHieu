import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';

function compareID(c: AbstractControl) {
  const v = c.value;
  if (v.id !== '' && v.typeservice !== '') {
    switch (v.typeservice) {
      case 'Villa':
        const patt1 = new RegExp('^(VL)\\-+[0-9]{4}$');
        if (!patt1.test(v.id)) {
          return {idmatchtypeservice: true};
        }
        break;
      case 'House':
        const patt2 = new RegExp('^(HO)\\-+[0-9]{4}$');
        if (!patt2.test(v.id)) {
          return {idmatchtypeservice: true};
        }
        break;
      case 'Room':
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
export class CServiceComponent implements OnInit {
  createServiceForm: FormGroup;

  constructor(private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.createServiceForm = this.fb.group({

      idGroup: this.fb.group({
        typeservice: ['', Validators.required],
        id: ['', [Validators.required, Validators.pattern('^(RO|HO|VL)\\-+[0-9]{4}$')]],
      }, {validator: compareID}),


      name: ['', [Validators.required,
        Validators.pattern('^[a-zA-Z0-9\\_\\-\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹế]+$'),
        Validators.maxLength(100)]],
      area: ['', [Validators.required,
        Validators.pattern('^[1-9]{1}[0-9]{0,}\\.[0-9]{1,}$')]],
      numberoffloor: ['', [Validators.required,
        Validators.pattern('^[1-9]{1}[0-9]{0,3}$')]],
      numbermaxofpeople: ['', [Validators.required,
        Validators.pattern('^[1-9]{1}[0-9]{0,3}$')]],
      rent: ['', [Validators.required,
        Validators.pattern('^[1-9]{1}[0-9]{5,}$')]],
      typerent: ['', [Validators.required]],
      status: ['', Validators.required],
    });
  }


  onSubmit() {
    console.log(this.createServiceForm);
  }

}
