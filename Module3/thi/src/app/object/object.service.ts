import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Object} from './object';

@Injectable({
  providedIn: 'root'
})
export class ObjectService {
  API_OBJECT_URL = 'http://localhost:3000/product';

  constructor(private httpClient: HttpClient) {
  }

  // tslint:disable-next-line:ban-types
  findAllObject(): Observable<Object[]> {
    // tslint:disable-next-line:ban-types
    return this.httpClient.get<Object[]>(this.API_OBJECT_URL);
  }
}
