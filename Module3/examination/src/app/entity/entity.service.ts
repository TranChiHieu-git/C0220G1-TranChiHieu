import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Entity} from './entity';

@Injectable({
  providedIn: 'root'
})
export class EntityService {
  API_ENTITY_URL = 'http://localhost:3000/students';

  constructor(private httpClient: HttpClient) {
  }

  findAllEntityByName(key: string): Observable<Entity[]> {
    return this.httpClient.get<Entity[]>(this.API_ENTITY_URL + '?tenSinhVien_like=' + key);
  }

  findAllEntityByNameTeacher(key: string): Observable<Entity[]> {
    return this.httpClient.get<Entity[]>(this.API_ENTITY_URL + '?giaoVienHuongDan_like=' + key);
  }

  findAllEntity(): Observable<Entity[]> {
    return this.httpClient.get<Entity[]>(this.API_ENTITY_URL);
  }

  findEntityById(id: string): Observable<Entity> {
    return this.httpClient.get<Entity>(this.API_ENTITY_URL + '/' + id);
  }

  update(entity: Partial<Entity>): Observable<Entity> {
    return this.httpClient.patch<Entity>(this.API_ENTITY_URL + '/' + entity.id, entity);
  }

  delete(id: string): Observable<void> {
    return this.httpClient.delete<void>(this.API_ENTITY_URL + '/' + id);
  }
}
