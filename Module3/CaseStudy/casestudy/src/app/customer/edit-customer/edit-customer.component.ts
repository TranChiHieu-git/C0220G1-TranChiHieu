import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Customer} from '../customer';
import {Typecustomer} from '../typecustomer';
import {CustomerService} from '../customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  editCustomerForm: FormGroup;
  private resultForm: any;
  private customerForm: Customer;
  TypeCustomerList: Typecustomer[] = [];
  CustomerList: Customer[] = [];
  // @ts-ignore
  Customer: Customer = Customer;

  constructor(private fb: FormBuilder, private customerService: CustomerService, private router: Router,
              private activedRouter: ActivatedRoute) {
    this.customerService.findAllTypeCustomer().subscribe(next => {
      this.TypeCustomerList = next;
    });
  }

  ngOnInit(): void {
    this.customerService.findAllTypeCustomer().subscribe(
      next => [
        this.TypeCustomerList = next],
      error => console.log(error)
    );
    this.activedRouter.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      this.customerService.findCustomerById(id).subscribe(
        next => {
          // this.Customer = next;
          this.editCustomerForm.patchValue({
              id: next.id,
              name: next.name,
              birthday: next.birthday,
              identificationCard: next.identificationCard,
              numberPhone: next.numberPhone,
              email: next.email,
              address: next.address,
              idtypecustomer: next.idTypeCustomer
            }
          );
        }
      );
    });
    this.editCustomerForm = this.fb.group({
      id: ['', [Validators.required, Validators.pattern('^(KH\-)+[0-9]{4}$'), this.existID.bind(this)]],
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
      idtypecustomer: ['', Validators.required],
    });
  }

  existID(c: AbstractControl) {
    const v = c.value;
    for (const customer of this.CustomerList) {
      if (customer.id === v) {
        return {idExist: true};
      }
    }
    return null;
  }

  existEmail(c: AbstractControl) {
    const v = c.value;
    for (const customer of this.CustomerList) {
      if (customer.email === v) {
        return {emailExist: true};
      }
    }
    return null;
  }

  existCMND(c: AbstractControl) {
    const v = c.value;
    for (const customer of this.CustomerList) {
      if (customer.identificationCard === v) {
        return {identificationCardExist: true};
      }
    }
    return null;
  }

  onSubmit() {
    this.resultForm = this.editCustomerForm.value;
    this.customerForm = new Customer(this.resultForm.id, this.resultForm.name, this.resultForm.birthday, this.resultForm.identificationCard,
      this.resultForm.salary, this.resultForm.numberPhone, this.resultForm.email, this.resultForm.address, this.resultForm.idtypecustomer);
    this.customerService.update(this.customerForm).subscribe(
      next => {
        alert('Bạn đã chỉnh sửa thành công thông tin khách hàng!'),
          this.router.navigate(['/customer/list']);
      },
      error => alert('chỉnh sửa thông tin khách hàng không thành công hãy kiểm tra lại.')
    );
  }
}
