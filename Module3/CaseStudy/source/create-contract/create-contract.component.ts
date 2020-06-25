import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, ValidatorFn, Validators} from '@angular/forms';
import {ExistIdService} from '../exist-id.service';

// export function existId(ei: ExistIdService): ValidatorFn {
//   return (c: AbstractControl) => {
//     const v = c.value;
//     if (ei.existId1(v)) {
//       return null;
//     } else {
//       return {existid: true};
//     }
//   };
// }

@Component({
  selector: 'app-create-contract',
  templateUrl: './create-contract.component.html',
  styleUrls: ['./create-contract.component.css']
})
export class CreateContractComponent implements OnInit {
  createContractForm: FormGroup;

  constructor(private fb: FormBuilder, private ei: ExistIdService) {
  }

  ngOnInit() {
    this.createContractForm = this.fb.group({
      id: ['', [Validators.required, Validators.pattern('^(CO)\-[0-9]{4}$'), this.existId.bind(this) /*,this.existId(this.ei)*/]],
      daycontractGroup: this.fb.group({
        daymakecontract: ['', [Validators.required, Validators.pattern('^[1-9]{1}[0-9]{3}\-+[0-9]{2}\-+[0-9]{2}$')]],
        dayendcontract: ['', [Validators.required, Validators.pattern('^[1-9]{1}[0-9]{3}\-+[0-9]{2}\-+[0-9]{2}$')]],
      }, {validator: this.compareDay}),
      deposit: ['', [Validators.required,
        Validators.pattern('^[0-9]{1,}$')]],
    });
  }

  existId(c: AbstractControl) {
    const v = c.value;
    if (this.ei.existId1(v)) {
      return {existid: true};
    } else {
      return null;
    }
  }

  compareDay(c: AbstractControl) {
    const v = c.value;
    if (v.daymakecontract !== '' && v.dayendcontract !== '') {
      const dateMake: string = v.daymakecontract.split('-');
      const dateEnd: string = v.dayendcontract.split('-');
      const day = Number(dateEnd[2]) - Number(dateMake[2]);
      const month = Number(dateEnd[1]) - Number(dateMake[1]);
      const year = Number(dateEnd[0]) - Number(dateMake[0]);
      if (day < 0 || month < 0 || year < 0) {
        return {daycontractmatch: true};
      }
    } else {
      return {daycontractmatch: null};
    }
  }

  onSubmit() {
    console.log(this.createContractForm);
  }

}
