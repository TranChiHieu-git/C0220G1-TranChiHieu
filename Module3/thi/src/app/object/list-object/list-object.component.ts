import {Component, OnInit} from '@angular/core';
import {Object} from '../object';
import {ObjectService} from '../object.service';

@Component({
  selector: 'app-list-object',
  templateUrl: './list-object.component.html',
  styleUrls: ['./list-object.component.css']
})
export class ListObjectComponent implements OnInit {

  // tslint:disable-next-line:ban-types
  productList: Object[] = [];
  abc: Entity;

  constructor(private objectService: ObjectService) {
    this.objectService.findAllObject().subscribe(next => {
      this.productList = next;
    }, error => {
      console.log(error);
    });
  }

  ngOnInit(): void {
  }
}
