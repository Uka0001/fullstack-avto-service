import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Service} from "../model/service";
import {ServiceStatus} from "../model/serviceStatus";

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  private readonly apiUrl = 'http://localhost:8080';
  private readonly servicePrefix = '/services';

  constructor(private httpClient: HttpClient) { }

  getServices(): Observable<Service[]> {
    return this.httpClient
      .get<Service[]>(`${this.apiUrl}${this.servicePrefix}`)
  }

  updateService(id: number, service: Service): Observable<Service> {
    const url = `${this.apiUrl}${this.servicePrefix}/${id}`;
    return this.httpClient.put<Service>(url, service);
  }

  updateServiceStatus(id: number, serviceStatus: ServiceStatus): Observable<Service> {
    const url = `${this.apiUrl}${this.servicePrefix}/${id}/status`;
    return this.httpClient.put<Service>(url, {params: new HttpParams().set('serviceStatus', `${serviceStatus}`)});
  }

  createService(service: Service): Observable<Service> {
    const url = `${this.apiUrl}${this.servicePrefix}`;
    return this.httpClient.post<Service>(url, service);
  }
}
