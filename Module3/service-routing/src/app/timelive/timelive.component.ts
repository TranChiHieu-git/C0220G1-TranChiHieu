import {Component, OnInit} from '@angular/core';
import {DateUtilService} from "../date-util.service";

@Component({
  selector: 'app-timelive',
  templateUrl: './timelive.component.html',
  styleUrls: ['./timelive.component.css']
})
export class TimeliveComponent implements OnInit {
  output = '';

  constructor(private dateUtilService: DateUtilService) {
  }

  ngOnInit(): void {
  }

  onChange(value) {
    this.output = this.dateUtilService.getDiffToNow(value);
  }
}
