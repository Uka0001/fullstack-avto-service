import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Master} from "../model/master";
import {Order} from "../model/order";

@Injectable({
  providedIn: 'root'
})
export class MasterService {

  private readonly apiUrl = 'http://localhost:8080';
  private readonly masterPrefix = '/masters';

  constructor(private httpClient: HttpClient) { }

  getMasters(): Observable<Master[]> {
    return this.httpClient
      .get<Master[]>(`${this.apiUrl}${this.masterPrefix}`)
  }

  getMastersOrders(masterId: number): Observable<Order[]> {
    const url = `${this.apiUrl}${this.masterPrefix}/orders`
    return this.httpClient.get<Order[]>(url, {params: new HttpParams().set('masterId', `${masterId}`)})
  }

  getMastersWages(masterId: number): Observable<Order[]> {
    const url = `${this.apiUrl}${this.masterPrefix}/wages`
    return this.httpClient.get<Order[]>(url, {params: new HttpParams().set('masterId', `${masterId}`)})
  }

  updateMaster(id: number, master: Master): Observable<Master> {
    const url = `${this.apiUrl}${this.masterPrefix}/${id}`;
    return this.httpClient.put<Master>(url, master);
  }

  createMaster(master: Master): Observable<Master> {
    const url = `${this.apiUrl}${this.masterPrefix}`;
    return this.httpClient.post<Master>(url, master);
  }
}
