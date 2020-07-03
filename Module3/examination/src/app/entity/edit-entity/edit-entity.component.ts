import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {EntityService} from '../entity.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-edit-entity',
  templateUrl: './edit-entity.component.html',
  styleUrls: ['./edit-entity.component.css']
})
export class EditEntityComponent implements OnInit {
  editStudentForm: FormGroup;

  constructor(private fb: FormBuilder, private entityService: EntityService, private router: Router,
              private activedRouter: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.editStudentForm = this.fb.group({
      id: ['', [Validators.required, this.notChangeID.bind(this)]],
      tenSinhVien: ['', [Validators.required,
        Validators.pattern('^[a-zA-Z\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹế]+$')]],
      tenNhom: ['', [Validators.required, Validators.pattern('^(nhóm 1|nhóm 2|nhóm 3)$')]],
      tenDeTai: ['', [Validators.required]],
      giaoVienHuongDan: ['', [Validators.required]],
      email: ['', [Validators.required,
        Validators.pattern('^[a-zA-Z]{1}[a-zA-Z0-9\\_]{1,100}\\@[a-zA-Z]{2,10}\\.[a-zA-Z]{2,10}$')]],
      soDienThoai: ['', [Validators.required, Validators.pattern('^(091|090|092|093|094|095|096|097|098|099|012|016|038|037)[0-9]{7,9}$')]]
    });
    this.activedRouter.paramMap.subscribe((paramMap: ParamMap) => {
      const ID = paramMap.get('id');
      this.entityService.findEntityById(ID).subscribe(
        next => {
          this.editStudentForm.patchValue({
              id: ID,
              tenSinhVien: next.tenSinhVien,
              tenNhom: next.tenNhom,
              tenDeTai: next.tenDeTai,
              giaoVienHuongDan: next.giaoVienHuongDan,
              email: next.email,
              soDienThoai: next.soDienThoai,
            }
          );
        },
        error => {
          console.log(error);
        }
      );
    });
  }

  notChangeID(c: AbstractControl) {
    let id = '';
    const v = c.value;
    this.activedRouter.paramMap.subscribe((paramMap: ParamMap) => {
      id = paramMap.get('id');
    });
    if (id !== v) {
      return {notChangeID: true};
    }
    return null;
  }

  onSubmit() {
    this.entityService.update(this.editStudentForm.value).subscribe(
      next => {
        alert('Bạn đã sửa thành công thông dịch vụ!'),
          this.router.navigate(['/entity/list']);
      },
      error => alert('Sửa thông tin dịch vụ không thành công hãy kiểm tra lại.'),
    );
  }

  onExit() {
    this.router.navigate(['/entity/list']);
  }
}
