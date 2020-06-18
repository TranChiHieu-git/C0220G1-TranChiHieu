import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-countdown',
  templateUrl: './countdown.component.html',
  styleUrls: ['./countdown.component.css']
})
export class CountdownComponent implements OnInit {
  remainingTime = 10;
  intervalId = 0;

  constructor() {
  }

  start(): void {
    this.countDown();
  }

  stop(): void {
    this.clearTimer();
  }

  reset(): void {
    this.clearTimer();
    this.remainingTime = 10;
  }

  countDown() {
    this.intervalId = setInterval(() => {
      if (this.remainingTime === 0) {
        this.clearTimer();
      }
      if (this.remainingTime > 0) {
        this.remainingTime--;
      }

    }, 1000);
  }

  clearTimer() {
    clearInterval(this.intervalId);
  }

  ngOnInit(): void {
  }

}
