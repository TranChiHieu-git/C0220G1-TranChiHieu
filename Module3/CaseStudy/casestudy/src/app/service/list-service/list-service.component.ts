import {Component, OnInit} from '@angular/core';
import {ServiceService} from '../service.service';
import {Service} from '../service';
import {Status} from 'tslint/lib/runner';
import {Statusservice} from '../statusservice';

@Component({
  selector: 'app-list-service',
  templateUrl: './list-service.component.html',
  styleUrls: ['./list-service.component.css']
})
export class ListServiceComponent implements OnInit {
  serviceList: Service[];
  private nameStatus: Statusservice;

  constructor(private serviceService: ServiceService) {
  }

  abc(): void {
    alert('abc');
  }

  deleteServiceById(id: string): void {
    if (confirm('bạn có muốn xóa dịch vụ ' + id + ' ?')) {
      this.serviceService.deleteServiceById(id).subscribe(
        next => this.serviceList = this.serviceList.filter(service => service.id !== id),
        error => console.log(error)
      );
    } else {
    }
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
        this.serviceList = next, console.log(this.serviceList);

      },
      error => {
        console.log(error);
      }
    );
  }

}
