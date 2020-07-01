import {Component, OnInit} from '@angular/core';
import {ServiceService} from '../service.service';
import {Service} from '../service';
import {Statusservice} from '../statusservice';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-list-service',
  templateUrl: './list-service.component.html',
  styleUrls: ['./list-service.component.css']
})
export class ListServiceComponent implements OnInit {
  searchServiceForm: FormGroup;
  serviceList: Service[] = [];
  serviceInfor: Service;
  private nameStatus: Statusservice;
  p: any;
  filter: any;
  key: string;
  private searchForm: any;

  constructor(private serviceService: ServiceService, private formBuilder: FormBuilder) {
    this.searchServiceForm = this.formBuilder.group({
      key: ['']
    });
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
    this.serviceService.findServiceById(id).subscribe(
      next => {
        this.serviceInfor = next;
        this.serviceService.findStatusById(next.status).subscribe(
          // tslint:disable-next-line:no-shadowed-variable
          next => {
            this.serviceInfor.status = next.nameStatusService;
          }, error => {
            console.log(error);
          });
        this.serviceService.findTypeRentById(next.idTypeRent).subscribe(
          // tslint:disable-next-line:no-shadowed-variable
          next => {
            this.serviceInfor.idTypeRent = next.nameTypeRent;
          }, error => {
            console.log(error);
          });
        this.serviceService.findTypeServiceById(next.idTypeService).subscribe(
          // tslint:disable-next-line:no-shadowed-variable
          next => {
            this.serviceInfor.idTypeService = next.nameTypeService;
          }, error => {
            console.log(error);
          });
      },
      error => console.log(error));
  }


  ngOnInit(): void {
    this.serviceService.findAllService().subscribe(
      next => {
        for (const service of next) {
          this.serviceService.findStatusById(service.status).subscribe(
            // tslint:disable-next-line:no-shadowed-variable
            next => {
              this.nameStatus = next;
              service.status = this.nameStatus.nameStatusService;
            }, error => {
              console.log(error);
            });
        }
        this.serviceList = next;
      },
      error => {
        console.log(error);
      }
    );
  }

  deleteServiceById(id: string) {
    if (confirm('Bạn có muốn xóa dịch vụ ' + id + ' không?')) {
      this.serviceService.deleteServiceById(id).subscribe(
        next => {
          window.location.reload();
        },
        error => console.log(error)
      );
    }
  }

  onSearch() {
    this.searchForm = this.searchServiceForm.value;
    console.log(this.searchForm.key);
    if (this.searchForm.key !== '') {
      this.serviceService.findAllServiceByName(this.searchForm.key).subscribe(
        next => {
          if (next !== null) {
            for (const service of next) {
              this.serviceService.findStatusById(service.status).subscribe(
                // tslint:disable-next-line:no-shadowed-variable
                next => {
                  this.nameStatus = next;
                  service.status = this.nameStatus.nameStatusService;
                }, error => {
                  console.log(error);
                });
            }
            this.serviceList = next;
          }
        }
      );
      this.serviceService.findAllServiceById(this.searchForm.key).subscribe(
        next => {
          if (next !== null) {
            // tslint:disable-next-line:no-shadowed-variable
            for (const element of next) {
              for (const service of next) {
                this.serviceService.findStatusById(service.status).subscribe(
                  // tslint:disable-next-line:no-shadowed-variable
                  next => {
                    this.nameStatus = next;
                    service.status = this.nameStatus.nameStatusService;
                  }, error => {
                    console.log(error);
                  });
              }
              this.serviceList = next;
              // this.serviceList.push(element);
            }
          }
        }
      );
    } else {
      this.serviceService.findAllService().subscribe(
        next => {
          if (next !== null) {
            for (const service of next) {
              this.serviceService.findStatusById(service.status).subscribe(
                // tslint:disable-next-line:no-shadowed-variable
                next => {
                  this.nameStatus = next;
                  service.status = this.nameStatus.nameStatusService;
                }, error => {
                  console.log(error);
                });
            }
            this.serviceList = next;
          }
        },
        error => {
          console.log(error);
        }
      );
    }

  }
}
