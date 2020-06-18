import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css']
})
export class RatingBarComponent implements OnInit {
  rate1: string;
  rate2: string;
  rate3: string;
  rate4: string;
  rate5: string;
  vote = 0;

  constructor() {
  }

  Rate1(): void {
    this.vote = 1;
  }

  Rate2(): void {
    this.vote = 2;
  }

  Rate3(): void {
    this.vote = 3;
  }

  Rate4(): void {
    this.vote = 4;
  }

  Rate5(): void {
    this.vote = 5;
  }

  vote1(): void {
    this.clear();
    this.rate1 = 'darkorange';
  }

  vote2(): void {
    this.clear();
    this.rate1 = 'darkorange';
    this.rate2 = 'darkorange';
  }

  vote3(): void {
    this.clear();
    this.rate1 = 'darkorange';
    this.rate2 = 'darkorange';
    this.rate3 = 'darkorange';
  }

  vote4(): void {
    this.clear();
    this.rate1 = 'darkorange';
    this.rate2 = 'darkorange';
    this.rate3 = 'darkorange';
    this.rate4 = 'darkorange';
  }

  vote5(): void {
    this.clear();
    this.rate1 = 'darkorange';
    this.rate2 = 'darkorange';
    this.rate3 = 'darkorange';
    this.rate4 = 'darkorange';
    this.rate5 = 'darkorange';
  }

  clear(): void {
    this.rate1 = '#d0cbcb';
    this.rate2 = '#d0cbcb';
    this.rate3 = '#d0cbcb';
    this.rate4 = '#d0cbcb';
    this.rate5 = '#d0cbcb';
  }

  ClearRate(): void {

    switch (this.vote) {
      case 1:
        this.clear();
        this.vote1();
        break;
      case 2:
        this.clear();
        this.vote2();
        break;
      case 3:
        this.clear();
        this.vote3();
        break;
      case 4:
        this.clear();
        this.vote4();
        break;
      case 5:
        this.clear();
        this.vote5();
        break;
      default:
        this.clear();
        break;
    }
  }

  ngOnInit(): void {
  }

}
