import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ContractService} from '../contract.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Accompaniedservice} from '../accompaniedservice';
import {Contractdetails} from '../contractdetails';

@Component({
  selector: 'app-create-contractdetails',
  templateUrl: './create-contractdetails.component.html',
  styleUrls: ['./create-contractdetails.component.css']
})
export class CreateContractdetailsComponent implements OnInit {
  createContractDetailForm: FormGroup;
  AccompaniedServiceList: Accompaniedservice[] = [];
  ContractDetailsList: Accompaniedservice[] = [];
  ListContractDetails: Contractdetails[] = [];
  status = false;

  constructor(private fb: FormBuilder, private contractService: ContractService, private router: Router,
              private activedRouter: ActivatedRoute) {
    this.contractService.findAllAccompaniedService().subscribe(next => {
      this.AccompaniedServiceList = next;
    });
    this.activedRouter.paramMap.subscribe((paramMap: ParamMap) => {
      this.contractService.findContractDetailById(paramMap.get('id')).subscribe(next => {
        this.ListContractDetails = next;
      });
    });
  }

  ngOnInit(): void {
    this.createContractDetailForm = this.fb.group({
      id: [''],
      idContract: ['', [Validators.required]],
      accompaniedService: ['', [Validators.required]],
      amount: ['', [Validators.required, Validators.pattern('^[0-9]{1,}$')]],
    });
    this.activedRouter.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      this.contractService.findContractDetailById(id).subscribe(
        next => {
          for (const contractdetail of next) {
            this.contractService.findAllAccompaniedServiceById(contractdetail.accompaniedService).subscribe(
              // tslint:disable-next-line:no-shadowed-variable
              next => {
                for (const accompaniedservice of next) {
                  this.ContractDetailsList.push(accompaniedservice);
                }
              },
              error => {
                console.log(error);
              });
          }
        }
      );
      this.createContractDetailForm.patchValue({
          idContract: id,
        }
      );
    });
  }

  delteContractDetails(key) {
    this.activedRouter.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      this.contractService.findContractDetailById(id).subscribe(next => {
        for (const contractdetails of next) {
          if (contractdetails.accompaniedService === String(key)) {
            this.contractService.deleteContractDetailsById(contractdetails.id).subscribe(
              // tslint:disable-next-line:no-shadowed-variable
              next => {
                alert('Xóa dịch vụ đi kèm thành công');
                window.location.reload();
              },
              error => {
                console.log(error);
                alert('Xóa không thành công. Vui lòng kiểm tra lại');
              }
            );
          }
        }
      }, error => {
        console.log(error);
      });
    });
  }

  onSubmit() {
    this.contractService.findAllContractDetail().subscribe(next => {
      for (const contractdetail of next) {
        if (this.createContractDetailForm.value.idContract === contractdetail.idContract &&
          this.createContractDetailForm.value.accompaniedService === contractdetail.accompaniedService) {
          this.status = true;
          this.createContractDetailForm.patchValue({
              id: contractdetail.id,
              idContract: contractdetail.idContract,
              accompaniedService: contractdetail.accompaniedService,
              amount: (this.createContractDetailForm.value.amount + contractdetail.amount)
            }
          );
          this.contractService.updateContractDetails(this.createContractDetailForm.value).subscribe(
            // tslint:disable-next-line:no-shadowed-variable
            next => {

              alert('thêm mới dịch vụ kèm theo thành công');
              window.location.reload();
            },
            error => {
              alert('thêm mới dịch vụ kèm theo không thành công. Vui lòng kiểm tra lại.');
              console.log(error);
            }
          );
        }
      }
      if (this.status === false) {
        // tslint:disable-next-line:no-shadowed-variable
        this.contractService.findAllContractDetail().subscribe(next => {
          let id = 0;
          for (const contract of next) {
            if (Number(contract.id) === id) {
              id++;
            }
          }
          this.createContractDetailForm.value.id = id;
        });
        this.contractService.createContractDetails(this.createContractDetailForm.value).subscribe(
          // tslint:disable-next-line:no-shadowed-variable
          next => {
            alert('thêm mới dịch vụ kèm theo thành công');
            window.location.reload();
          },
          error => {
            alert('thêm mới dịch vụ kèm theo không thành công. Vui lòng kiểm tra lại.');
            console.log(error);
          }
        );
      }
    });
  }
}
