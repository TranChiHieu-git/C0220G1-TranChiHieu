import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Typeservice} from './typeservice';
import {Typerent} from './typerent';
import {Statusservice} from './statusservice';
import {Service} from './service';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  API_TYPE_SERVICE_URL = 'http://localhost:3000/typeService';
  API_TYPE_RENT_URL = 'http://localhost:3000/typeRent';
  API_STATUS_SERVICE_URL = 'http://localhost:3000/statusService';
  API_SERVICE_URL = 'http://localhost:3000/service';


  constructor(private httpClient: HttpClient) {
  }

  findAllTypeService(): Observable<Typeservice[]> {
    return this.httpClient.get<Typeservice[]>(this.API_TYPE_SERVICE_URL);
  }

  findTypeServiceById(id: string): Observable<Typeservice> {
    return this.httpClient.get<Typeservice>(this.API_TYPE_SERVICE_URL + '/' + id);
  }

  findAllTypeRent(): Observable<Typerent[]> {
    return this.httpClient.get<Typerent[]>(this.API_TYPE_RENT_URL);
  }

  findTypeRentById(id: string): Observable<Typerent> {
    return this.httpClient.get<Typerent>(this.API_TYPE_RENT_URL + '/' + id);
  }

  findAllStatus(): Observable<Statusservice[]> {
    return this.httpClient.get<Statusservice[]>(this.API_STATUS_SERVICE_URL);
  }

  findStatusById(id: string): Observable<Statusservice> {
    return this.httpClient.get<Statusservice>(this.API_STATUS_SERVICE_URL + '/' + id);
  }

  findAllService(): Observable<Service[]> {
    return this.httpClient.get<Service[]>(this.API_SERVICE_URL);
  }

  create(service: Partial<Service>): Observable<Service> {
    return this.httpClient.post<Service>(this.API_SERVICE_URL, service);
  }

  deleteServiceById(id: string): Observable<void> {
    return this.httpClient.delete<void>(this.API_SERVICE_URL + '/' + id);
  }
}
