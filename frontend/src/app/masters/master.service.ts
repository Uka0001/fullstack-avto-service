import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import Long from "long";
import {Master} from "../model/master";
import {Order} from "../model/order";
import {Good} from "../model/good";

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

  getMastersOrders(masterId: Long): Observable<Order[]> {
    const url = `${this.apiUrl}${this.masterPrefix}/orders?id=${masterId}`
    return this.httpClient.get<Order[]>(url)
  }

  updateMaster(id: Long, master: Master): Observable<Master> {
    const url = `${this.apiUrl}${this.masterPrefix}/${id}`;
    return this.httpClient.put<Master>(url, master);
  }

  createMaster(master: Master): Observable<Master> {
    const url = `${this.apiUrl}${this.masterPrefix}`;
    return this.httpClient.post<Master>(url, master);
  }
}
