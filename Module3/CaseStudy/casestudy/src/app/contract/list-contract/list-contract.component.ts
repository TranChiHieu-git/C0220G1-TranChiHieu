import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Contract} from '../contract';
import {ContractService} from '../contract.service';
import {CustomerService} from '../../customer/customer.service';
import {EmployeeService} from '../../employee/employee.service';
import {ServiceService} from '../../service/service.service';

@Component({
  selector: 'app-list-contract',
  templateUrl: './list-contract.component.html',
  styleUrls: ['./list-contract.component.css']
})
export class ListContractComponent implements OnInit {
  searchContractForm: FormGroup;
  contractList: Contract[] = [];
  contractInfor: Contract;
  dayValid = '';
  p: any;
  filter: any;
  key: string;
  private searchForm: any;

  constructor(private contractService: ContractService, private formBuilder: FormBuilder,
              private customerService: CustomerService, private employeeService: EmployeeService,
              private serviceService: ServiceService) {
    this.searchContractForm = this.formBuilder.group({
      key: ['']
    });
  }

  ngOnInit(): void {
    this.contractService.findAllContract().subscribe(next => {
        for (const contract of next) {
          this.contractService.findContractById(contract.id).subscribe(
            // tslint:disable-next-line:no-shadowed-variable
            next => {
              this.serviceService.findServiceById(next.idService).subscribe(
                // tslint:disable-next-line:no-shadowed-variable
                next => {
                  contract.idService = next.name;
                }, error => {
                  console.log(error);
                });
              this.employeeService.findEmployeeById(next.idEmployee).subscribe(
                // tslint:disable-next-line:no-shadowed-variable
                next => {
                  contract.idEmployee = next.name;
                }, error => {
                  console.log(error);
                });
              this.customerService.findCustomerById(next.idCustomer).subscribe(
                // tslint:disable-next-line:no-shadowed-variable
                next => {
                  contract.idCustomer = next.name;
                }, error => {
                  console.log(error);
                });
              this.contractList.push(contract);
            },
            error => console.log(error));
        }
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
    this.contractService.findContractById(id).subscribe(
      next => {
        this.contractInfor = next;
        this.contractService.findContractById(next.id).subscribe(
          // tslint:disable-next-line:no-shadowed-variable
          next => {
            this.dayValid = next.dateMakeContract.split('-')[2] + '/'
              + next.dateMakeContract.split('-')[1] + '/'
              + next.dateMakeContract.split('-')[0];
            this.contractInfor.dateMakeContract = this.dayValid;
            this.dayValid = next.dateEndContract.split('-')[2] + '/'
              + next.dateEndContract.split('-')[1] + '/'
              + next.dateEndContract.split('-')[0];
            this.contractInfor.dateEndContract = this.dayValid;
          }, error => {
            console.log(error);
          });
        this.serviceService.findServiceById(next.idService).subscribe(
          // tslint:disable-next-line:no-shadowed-variable
          next => {
            this.contractInfor.idService = next.name;
          }, error => {
            console.log(error);
          });
        this.employeeService.findEmployeeById(next.idEmployee).subscribe(
          // tslint:disable-next-line:no-shadowed-variable
          next => {
            this.contractInfor.idEmployee = next.name;
          }, error => {
            console.log(error);
          });
        this.customerService.findCustomerById(next.idCustomer).subscribe(
          // tslint:disable-next-line:no-shadowed-variable
          next => {
            this.contractInfor.idCustomer = next.name;
          }, error => {
            console.log(error);
          });
      },
      error => console.log(error));
  }

  deleteCustomerById(id: string) {
    if (confirm('Bạn có muốn xóa dịch vụ ' + id + ' không?')) {
      this.contractService.findContractDetailById(id).subscribe(next => {
        for (const contractdetails of next) {
          this.contractService.deleteContractDetailsById(contractdetails.id).subscribe(
            // tslint:disable-next-line:no-shadowed-variable
            next => {
              window.location.reload();
            },
            error => {
              console.log(error);
            }
          );
        }
      }, error => {
        console.log(error);
      });
      this.contractService.deleteContractById(id).subscribe(
        next => {
          window.location.reload();
        },
        error => console.log(error)
      );
    }
  }

  onSearch() {
    this.searchForm = this.searchContractForm.value;
    if (this.searchForm.key !== '') {
      this.contractService.findAllContractById(this.searchForm.key).subscribe(
        next => {
          this.contractList = next;
        }
      );
    }
  }
}
