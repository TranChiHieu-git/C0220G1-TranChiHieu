import {Component, OnInit} from '@angular/core';
import {Entity} from '../entity';
import {EntityService} from '../entity.service';
import {FormBuilder, FormGroup} from '@angular/forms';
import {$} from 'protractor';

@Component({
  selector: 'app-show-entity',
  templateUrl: './show-entity.component.html',
  styleUrls: ['./show-entity.component.css']
})
export class ShowEntityComponent implements OnInit {
  entityList: Entity[] = [];
  p: string | number;
  searchEntityForm: any;

  constructor(private entityService: EntityService, private fb: FormBuilder) {
    this.entityService.findAllEntity().subscribe(next => {
      this.entityList = next;
    }, error => console.log(error));
  }

  ngOnInit(): void {
    this.searchEntityForm = this.fb.group({
      keyword: ['']
    });
  }

  onSearch() {
    if (this.searchEntityForm.value.keyword !== '') {
      this.entityService.findAllEntityByName(this.searchEntityForm.value.keyword).subscribe(
        next => {
          this.entityList = next;
        },
        error => console.log(error)
      );
      this.entityService.findAllEntityByNameTeacher(this.searchEntityForm.value.keyword).subscribe(next => {
        for (const elementOfEntity of next) {
          let flag = true;
          for (const identityList of this.entityList) {
            if (elementOfEntity.id === identityList.id) {
              flag = false;
            }
          }
          if (flag) {
            this.entityList.push(elementOfEntity);
          }
        }
      }, error => {
        console.log(error);
      });
    } else {
      this.entityService.findAllEntity().subscribe(next => {
        this.entityList = next;
      }, error => console.log(error));
    }
  }

  delete(id: string) {
    for (const student of this.entityList) {
      if (student.id === id) {
        if (confirm('Bạn Có muốn xóa sinh viên ' + student.tenSinhVien + ' ra khỏi danh sách ?')) {
          this.entityService.delete(id).subscribe(next => {
            window.location.reload();
          }, error => alert('Xóa không thành công. Vui lòng kiểm tra lại!'));
        }
      }
    }
  }
}
