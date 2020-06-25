import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ExistIdService {
  ids: string[] = ['CO-0000', 'CO-0001', 'CO-0002'];

  constructor() {
  }

  existId1(id: string): boolean {
    console.log(this.ids.find(value => value === id));
    if (this.ids.find(value => value === id) === undefined) {
      return false;
    } else {
      return true;
    }
  }
}
