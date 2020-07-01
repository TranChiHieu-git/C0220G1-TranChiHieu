import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Typecustomer} from './typecustomer';
import {Customer} from './customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  API_TYPE_CUSTOMER_URL = 'http://localhost:3000/typeCustomer';
  API_CUSTOMER_URL = 'http://localhost:3000/customer';

  constructor(private httpClient: HttpClient) {
  }

  findAllTypeCustomer(): Observable<Typecustomer[]> {
    return this.httpClient.get<Typecustomer[]>(this.API_TYPE_CUSTOMER_URL);
  }

  findTypeCustomerById(id: string): Observable<Typecustomer> {
    return this.httpClient.get<Typecustomer>(this.API_TYPE_CUSTOMER_URL + '/' + id);
  }

  findAllCustomer(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.API_CUSTOMER_URL);
  }

  create(customer: Partial<Customer>): Observable<Customer> {
    return this.httpClient.post<Customer>(this.API_CUSTOMER_URL, customer);
  }

  update(customer: Partial<Customer>): Observable<Customer> {
    return this.httpClient.put<Customer>(this.API_CUSTOMER_URL + '/' + customer.id, customer);
  }

  deleteCustomerById(id: string): Observable<void> {
    return this.httpClient.delete<void>(this.API_CUSTOMER_URL + '/' + id);
  }

  findCustomerById(id: string): Observable<Customer> {
    return this.httpClient.get<Customer>(this.API_CUSTOMER_URL + '/' + id);
  }

  findAllCustomerByName(key: string): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.API_CUSTOMER_URL + '?name_like=' + key);
  }
}
