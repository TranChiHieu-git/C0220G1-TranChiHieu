import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {CustomerService} from '../customer.service';
import {Customer} from '../customer';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  searchCustomerForm: FormGroup;
  customerList: Customer[] = [];
  customerInfor: Customer;
  birthdayValid = '';
  p: any;
  filter: any;
  key: string;
  private searchForm: any;

  constructor(private customerService: CustomerService, private formBuilder: FormBuilder) {
    this.searchCustomerForm = this.formBuilder.group({
      key: ['']
    });
  }

  ngOnInit(): void {
    this.customerService.findAllCustomer().subscribe(next => {
        this.customerList = next;
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
    this.customerService.findCustomerById(id).subscribe(
      next => {
        this.customerInfor = next;
        this.customerService.findCustomerById(next.id).subscribe(
          // tslint:disable-next-line:no-shadowed-variable
          next => {
            this.birthdayValid = next.birthday.split('-')[2] + '/'
              + next.birthday.split('-')[1] + '/'
              + next.birthday.split('-')[0];
            this.customerInfor.birthday = this.birthdayValid;
          }, error => {
            console.log(error);
          });
        this.customerService.findTypeCustomerById(next.idTypeCustomer).subscribe(
          // tslint:disable-next-line:no-shadowed-variable
          next => {
            this.customerInfor.idTypeCustomer = next.nameTypeId;
          }, error => {
            console.log(error);
          });
      },
      error => console.log(error));
  }

  deleteCustomerById(id: string) {
    if (confirm('Bạn có muốn xóa dịch vụ ' + id + ' không?')) {
      this.customerService.deleteCustomerById(id).subscribe(
        next => {
          window.location.reload();
        },
        error => console.log(error)
      );
    }
  }

  onSearch() {
    this.searchForm = this.searchCustomerForm.value;
    if (this.searchForm.key !== '') {
      this.customerService.findAllCustomerByName(this.searchForm.key).subscribe(
        next => {
          this.customerList = next;
        }
      );
    }
  }
}
