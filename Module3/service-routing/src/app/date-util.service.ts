import {Injectable} from '@angular/core';
import {
  addMonths,
  addYears,
  differenceInDays,
  differenceInMonths,
  differenceInYears
} from 'date-fns';

@Injectable({
  providedIn: 'root'
})
export class DateUtilService {

  constructor() {
  }

  getDiffToNow(diff: string): string {
    const result: string[] = [];
    const now = new Date();
    let birthday: string[] = diff.split('-');
    // @ts-ignore
    diff = new Date(Number(birthday[2]), Number(birthday[1]), birthday[0]);
    // @ts-ignore
    const years = differenceInYears(now, diff);
    if (years > 0) {
      result.push(`${years} years`);
      // @ts-ignore
      diff = addYears(diff, years);
    }
    // @ts-ignore
    const months = differenceInMonths(now, diff);
    result.push(`${months} months`);
    if (months > 0) {
      // @ts-ignore
      diff = addMonths(diff, months);
    }
    // @ts-ignore
    const days = differenceInDays(now, diff);
    if (days > 0) {
      result.push(`${days} days`);
    }

    return result.join(' ');
  }
}
