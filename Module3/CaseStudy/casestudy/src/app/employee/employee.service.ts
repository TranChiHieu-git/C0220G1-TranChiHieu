import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Employee} from './employee';
import {Part} from './part';
import {Level} from './level';
import {Position} from './position';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  API_POSITION_URL = 'http://localhost:3000/position';
  API_PART_URL = 'http://localhost:3000/part';
  API_LEVEL_URL = 'http://localhost:3000/level';
  API_EMPLOYEE_URL = 'http://localhost:3000/employee';

  constructor(private httpClient: HttpClient) {
  }

  findAllPosition(): Observable<Position[]> {
    return this.httpClient.get<Position[]>(this.API_POSITION_URL);
  }

  findPositionById(id: string): Observable<Position> {
    return this.httpClient.get<Position>(this.API_POSITION_URL + '/' + id);
  }

  findAllPart(): Observable<Part[]> {
    return this.httpClient.get<Part[]>(this.API_PART_URL);
  }

  findPartById(id: string): Observable<Part> {
    return this.httpClient.get<Part>(this.API_PART_URL + '/' + id);
  }

  findAllLevel(): Observable<Level[]> {
    return this.httpClient.get<Level[]>(this.API_LEVEL_URL);
  }

  findLevelById(id: string): Observable<Level> {
    return this.httpClient.get<Level>(this.API_LEVEL_URL + '/' + id);
  }

  findAllEmployee(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(this.API_EMPLOYEE_URL);
  }

  create(employee: Partial<Employee>): Observable<Employee> {
    return this.httpClient.post<Employee>(this.API_EMPLOYEE_URL, employee);
  }

  update(employee: Partial<Employee>): Observable<Employee> {
    return this.httpClient.put<Employee>(this.API_EMPLOYEE_URL + '/' + employee.id, employee);
  }

  deleteEmployeeById(id: string): Observable<void> {
    return this.httpClient.delete<void>(this.API_EMPLOYEE_URL + '/' + id);
  }

  findEmployeeById(id: string): Observable<Employee> {
    return this.httpClient.get<Employee>(this.API_EMPLOYEE_URL + '/' + id);
  }

  findAllEmployeeByName(key: string): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(this.API_EMPLOYEE_URL + '?name_like=' + key);
  }
}
