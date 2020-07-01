import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {CustomerService} from '../customer.service';
import {Customer} from '../customer';
import {Typecustomer} from '../typecustomer';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  createCustomerForm: FormGroup;
  private resultForm: any;
  private customerForm: Customer;
  TypeCustomerList: Typecustomer[] = [];
  CustomerList: Customer[] = [];

  constructor(private fb: FormBuilder, private customerService: CustomerService, private router: Router) {
    this.customerService.findAllTypeCustomer().subscribe(next => {
      this.TypeCustomerList = next;
    });
    this.customerService.findAllCustomer().subscribe(next => {
      this.CustomerList = next;
    });
  }

  ngOnInit(): void {
    this.customerService.findAllTypeCustomer().subscribe(
      next => [
        this.TypeCustomerList = next],
      error => console.log(error)
    );
    this.createCustomerForm = this.fb.group({
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
      idTypeCustomer: ['', Validators.required],
    });
  }

  existID(c: AbstractControl) {
    const v = c.value;
    console.log(this.CustomerList);
    for (const customer of this.CustomerList) {
      if (customer.id === v) {
        return {idExist: true};
      }
    }
    return null;
  }

  existEmail(c: AbstractControl) {
    const v = c.value;
    console.log(this.CustomerList);
    for (const customer of this.CustomerList) {
      if (customer.email === v) {
        return {emailExist: true};
      }
    }
    return null;
  }

  existCMND(c: AbstractControl) {
    const v = c.value;
    console.log(this.CustomerList);
    for (const customer of this.CustomerList) {
      if (customer.identificationCard === v) {
        return {identificationCardExist: true};
      }
    }
    return null;
  }

  onSubmit() {
    this.resultForm = this.createCustomerForm.value;
    this.customerForm = new Customer(this.resultForm.id, this.resultForm.name, this.resultForm.birthday, this.resultForm.identificationCard,
      this.resultForm.salary, this.resultForm.numberPhone, this.resultForm.email, this.resultForm.address, this.resultForm.idTypeCustomer);
    this.customerService.create(this.customerForm).subscribe(
      next => {
        alert('Bạn đã thêm thành công khách hàng mới!'),
          this.router.navigate(['/customer/list']);
      },
      error => alert('Thêm mới khách hàng không thành công hãy kiểm tra lại.')
    );
  }
}
