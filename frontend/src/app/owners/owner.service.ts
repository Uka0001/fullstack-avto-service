import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Master} from "../model/master";
import {Order} from "../model/order";
import {Owner} from "../model/owner";

@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  private readonly apiUrl = 'http://localhost:8080';
  private readonly ownersPrefix = '/owners';

  constructor(private httpClient: HttpClient) { }

  getOwners(): Observable<Owner[]> {
    return this.httpClient
      .get<Owner[]>(`${this.apiUrl}${this.ownersPrefix}`)
  }

  getOwnersOrders(id: number): Observable<Order[]> {
    const url = `${this.apiUrl}${this.ownersPrefix}/${id}/orders`
    return this.httpClient.get<Order[]>(url)
  }

  updateOwner(id: number, owner: Owner): Observable<Owner> {
    const url = `${this.apiUrl}${this.ownersPrefix}/${id}`;
    return this.httpClient.put<Owner>(url, owner);
  }

  createOwner(owner: Owner): Observable<Owner> {
    const url = `${this.apiUrl}${this.ownersPrefix}`;
    return this.httpClient.post<Owner>(url, owner);
  }
}
