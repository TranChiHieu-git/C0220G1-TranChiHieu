import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Accompaniedservice} from './accompaniedservice';
import {Contractdetails} from './contractdetails';
import {Contract} from './contract';

@Injectable({
  providedIn: 'root'
})
export class ContractService {
  API_ACCOMPANIED_SERVICE_URL = 'http://localhost:3000/accompaniedService';
  API_CONTRACT_URL = 'http://localhost:3000/contract';
  API_CONTRACT_DETAILS_URL = 'http://localhost:3000/contractdetails';

  constructor(private httpClient: HttpClient) {
  }

  findAllAccompaniedService(): Observable<Accompaniedservice[]> {
    return this.httpClient.get<Accompaniedservice[]>(this.API_ACCOMPANIED_SERVICE_URL);
  }

  findAccompaniedServiceById(id: string): Observable<Accompaniedservice> {
    return this.httpClient.get<Accompaniedservice>(this.API_ACCOMPANIED_SERVICE_URL + '/' + id);
  }

  findAllContractDetail(): Observable<Contractdetails[]> {
    return this.httpClient.get<Contractdetails[]>(this.API_CONTRACT_DETAILS_URL);
  }

  findContractDetailById(id: string): Observable<Contractdetails[]> {
    return this.httpClient.get<Contractdetails[]>(this.API_CONTRACT_DETAILS_URL + '?idContract=' + id);
  }

  findContractDetailByID(id: string): Observable<Contractdetails> {
    return this.httpClient.get<Contractdetails>(this.API_CONTRACT_DETAILS_URL + '?id=' + id);
  }

  findAllAccompaniedServiceById(id: string): Observable<Accompaniedservice[]> {
    return this.httpClient.get<Accompaniedservice[]>(this.API_ACCOMPANIED_SERVICE_URL + '?id=' + id);
  }

  findAllContract(): Observable<Contract[]> {
    return this.httpClient.get<Contract[]>(this.API_CONTRACT_URL);
  }


  updateContractDetails(contractDetails: Partial<Contractdetails>): Observable<Contractdetails> {
    return this.httpClient.put<Contractdetails>(this.API_CONTRACT_DETAILS_URL + '/' + contractDetails.id, contractDetails);
  }

  createContractDetails(contractDetails: Partial<Contractdetails>): Observable<Contractdetails> {
    return this.httpClient.post<Contractdetails>(this.API_CONTRACT_DETAILS_URL, contractDetails);
  }

  create(contract: Partial<Contract>): Observable<Contract> {
    return this.httpClient.post<Contract>(this.API_CONTRACT_URL, contract);
  }

  update(contract: Partial<Contract>): Observable<Contract> {
    return this.httpClient.put<Contract>(this.API_CONTRACT_URL + '/' + contract.id, contract);
  }

  deleteContractById(id: string): Observable<void> {
    return this.httpClient.delete<void>(this.API_CONTRACT_URL + '/' + id);
  }

  deleteContractDetailsById(id: string): Observable<void> {
    return this.httpClient.delete<void>(this.API_CONTRACT_DETAILS_URL + '/' + id);
  }

  findContractById(id: string): Observable<Contract> {
    return this.httpClient.get<Contract>(this.API_CONTRACT_URL + '/' + id);
  }


  findAllContractById(key: string): Observable<Contract[]> {
    return this.httpClient.get<Contract[]>(this.API_CONTRACT_URL + '?id=' + key);
  }
}
