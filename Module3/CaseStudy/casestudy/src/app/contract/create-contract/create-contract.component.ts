import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Customer} from '../../customer/customer';
import {CustomerService} from '../../customer/customer.service';
import {Router} from '@angular/router';
import {Employee} from '../../employee/employee';
import {Service} from '../../service/service';
import {ContractService} from '../contract.service';
import {Contract} from '../contract';
import {EmployeeService} from '../../employee/employee.service';
import {ServiceService} from '../../service/service.service';

@Component({
  selector: 'app-create-contract',
  templateUrl: './create-contract.component.html',
  styleUrls: ['./create-contract.component.css']
})
export class CreateContractComponent implements OnInit {
  createContractForm: FormGroup;
  private resultForm: any;
  total = 0;
  private contractForm: Contract;
  EmployeeList: Employee[] = [];
  CustomerList: Customer[] = [];
  ServiceList: Service[] = [];
  ContractList: Contract[] = [];
  private date1: Date;
  private date2: Date;
  private date: Date;
  private time: number;
  private now: Date;

  constructor(private fb: FormBuilder, private contractService: ContractService, private router: Router,
              private employeeService: EmployeeService, private customerService: CustomerService,
              private serviceService: ServiceService) {
    this.contractService.findAllContract().subscribe(next => {
      this.ContractList = next;
    });
  }

  ngOnInit(): void {
    this.customerService.findAllCustomer().subscribe(
      next => [
        this.CustomerList = next],
      error => console.log(error)
    );
    this.serviceService.findAllService().subscribe(
      next => [
        this.ServiceList = next],
      error => console.log(error)
    );
    this.employeeService.findAllEmployee().subscribe(
      next => [
        this.EmployeeList = next],
      error => console.log(error)
    );
    this.createContractForm = this.fb.group({
      id: ['', [Validators.required, Validators.pattern('^(HD)\-[0-9]{4}$'), this.existID.bind(this)]],
      idEmployee: ['', [Validators.required]],
      idCustomer: ['', [Validators.required]],
      idService: ['', [Validators.required]],
      dayContractGroup: this.fb.group({
        dateMakeContract: ['', [Validators.required, Validators.pattern('^[1-9]{1}[0-9]{3}\-+[0-9]{2}\-+[0-9]{2}$'),
          this.compareDayNow.bind(this)]],
        dateEndContract: ['', [Validators.required, Validators.pattern('^[1-9]{1}[0-9]{3}\-+[0-9]{2}\-+[0-9]{2}$')]],
      }, {validator: this.compareDay.bind(this)}),
      deposit: ['', [Validators.required,
        Validators.pattern('^[0-9]{1,}$')]],
      totalAmount: [''],
    });
  }

  existID(c: AbstractControl) {
    const v = c.value;
    for (const contract of this.ContractList) {
      if (contract.id === v) {
        return {idExist: true};
      }
    }
    return null;
  }

  compareDayNow(c: AbstractControl) {
    const v = c.value;
    if (v !== '') {
      const dateMake: string = v.split('-');
      const day = Number(dateMake[2]);
      const month = Number(dateMake[1]);
      const year = Number(dateMake[0]);
      this.date = new Date(year, month, day);
      this.now = new Date();
      this.now = new Date(this.now.getUTCFullYear(), this.now.getUTCMonth() + 1, this.now.getUTCDate());
      this.time = (Number(this.now.getTime() - this.date.getTime())) / 86400000;
      if (this.time > 0) {
        return {compareDayNow: true};
      }
    }
    return null;
  }

  compareDay(c: AbstractControl) {
    const v = c.value;
    if (v.dateMakeContract !== '' && v.dateEndContract !== '') {
      const dateMake: string = v.dateMakeContract.split('-');
      const dateEnd: string = v.dateEndContract.split('-');
      const day = Number(dateMake[2]);
      const month = Number(dateMake[1]);
      const year = Number(dateMake[0]);
      const day2 = Number(dateEnd[2]);
      const month2 = Number(dateEnd[1]);
      const year2 = Number(dateEnd[0]);
      this.date1 = new Date(year, month, day);
      this.date2 = new Date(year2, month2, day2);
      this.time = (Number(this.date2.getTime() - this.date1.getTime())) / 86400000;
      if (this.time < 0) {
        return {daycontractmatch: true};
      }
    }
    return null;
  }

  calDayRent(dayMake: string, dayEnd: string): number {
    const dateMake = dayMake.split('-');
    const dateEnd = dayEnd.split('-');
    const day = Number(dateMake[2]);
    const month = Number(dateMake[1]);
    const year = Number(dateMake[0]);
    const day2 = Number(dateEnd[2]);
    const month2 = Number(dateEnd[1]);
    const year2 = Number(dateEnd[0]);
    this.date1 = new Date(year, month, day);
    this.date2 = new Date(year2, month2, day2);
    this.time = (Number(this.date2.getTime() - this.date1.getTime())) / 86400000;
    console.log(this.time);
    if (this.time === 0) {
      return (this.time + 1);
    } else {
      return (this.time);
    }
  }

  onSubmit() {
    this.resultForm = this.createContractForm.value;
    this.serviceService.findServiceById(this.resultForm.idService).subscribe(
      next => {
        this.total = (this.calDayRent(this.resultForm.dayContractGroup.dateMakeContract, this.resultForm.dayContractGroup.dateEndContract)
          * Number(next.rent)) - Number(this.resultForm.deposit);
        if (confirm('Tổng tiền phải thanh toán là: ' + this.total)) {
          this.contractForm = new Contract(this.resultForm.id, this.resultForm.idEmployee, this.resultForm.idCustomer,
            this.resultForm.idService, this.resultForm.dayContractGroup.dateMakeContract, this.resultForm.dayContractGroup.dateEndContract,
            this.resultForm.deposit,
            String(this.total));
          this.contractService.create(this.contractForm).subscribe(
            // tslint:disable-next-line:no-shadowed-variable
            next => {
              alert('Bạn đã thêm thành công hợp đồng mới!'),
                this.router.navigate(['/contract/list']);
            },
            error => alert('Thêm mới hợp đồng không thành công hãy kiểm tra lại.')
          );
        }
      }
    );
  }
}
