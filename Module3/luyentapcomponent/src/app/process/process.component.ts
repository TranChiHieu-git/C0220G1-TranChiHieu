import {Component, OnInit} from '@angular/core';
import {delay} from 'rxjs/operators';

@Component({
  selector: 'app-process',
  templateUrl: './process.component.html',
  styleUrls: ['./process.component.css']
})
export class ProcessComponent implements OnInit {
  a = 0;
  width = String(this.a) + '%';

  constructor() {
  }

  thucthi(): void {
    if (this.a === 0) {
      const interval = setInterval(() => {
        this.a += 1;
        if (this.a <= 100) {
          this.width = String(this.a) + '%';
        } else {
          clearInterval(interval);
        }
      }, 100);
    } else {
      this.a = 0;
      this.width = String(this.a) + '%';
      this.thucthi();
    }
  }

  ngOnInit(): void {
  }

}
