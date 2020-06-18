import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  fNum = 0;
  sNum = 0;
  result = '0';
  opera = '+';

  constructor() {
  }

  changeOpera(value) {
    this.opera = value;
    this.cal(this.fNum, this.sNum, this.opera);
  }

  changeFNum(value) {
    this.fNum = Number(value);
    this.cal(this.fNum, this.sNum, this.opera);
  }

  changeSNum(value: string) {
    this.sNum = Number(value);
    this.cal(this.fNum, this.sNum, this.opera);
  }

  cal(fnum: number, snum: number, opera: string) {
    switch (opera) {
      case '+':
        this.result = String(fnum + snum);
        break;
      case '-':
        this.result = String(fnum - snum);
        break;
      case '*':
        this.result = String(fnum * snum);
        break;
      case '/':
        if (snum !== 0) {
          this.result = String(fnum / snum);
        } else {
          this.result = 'không thể chia cho 0';
        }
        break;
    }

  }

  ngOnInit(): void {
  }

}
