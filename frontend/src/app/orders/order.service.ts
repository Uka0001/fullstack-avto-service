import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {OrderStatus} from "../model/orderstatus";
import {Observable} from "rxjs";
import {Order} from "../model/order";
import JSJoda from "js-joda";
import {Decimal} from "decimal.js";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private readonly apiUrl = 'http://localhost:8080';
  private readonly orderPrefix = '/orders';

  constructor(private httpClient: HttpClient) { }


  updateOrderStatus(id: number, status: OrderStatus): Observable<Order> {
    const url = `${this.apiUrl}${this.orderPrefix}/${id}/status`;
    return this.httpClient.put<Order>(url, {params: new HttpParams().set('status', `${status}`)});
  }

  addGood(id: number, status: OrderStatus): Observable<Order> {
    const url = `${this.apiUrl}${this.orderPrefix}/${id}/status`;
    return this.httpClient.put<Order>(url, {params: new HttpParams().set('status', `${status}`)});
  }

  createOrder(order: {
    masterId: number;
    dateOfAdoption: JSJoda.LocalDate;
    serviceIdList: number[];
    description: string;
    completionDate: JSJoda.LocalDate;
    goodsIdList: number[];
    totalCost: Decimal;
    carId: number; status: OrderStatus
  }): Observable<Order> {
    const url = `${this.apiUrl}${this.orderPrefix}`;
    return this.httpClient.post<Order>(url, order);
  }

  getOrderCost(id: number): Observable<Order> {
    const url = `${this.apiUrl}${this.orderPrefix}/cost`
    return this.httpClient.get<Order>(url,
      {params: new HttpParams().set('id', `${id}`)})
  }

  getOrders(): Observable<Order[]> {
    return this.httpClient
      .get<Order[]>(`${this.apiUrl}${this.orderPrefix}`)
  }

  updateOrder(id: number, order: {
    masterId: number;
    dateOfAdoption: JSJoda.LocalDate;
    serviceIdList: number[];
    description: string;
    completionDate: JSJoda.LocalDate;
    goodsIdList: number[];
    totalCost: Decimal;
    carId: number;
    status: OrderStatus
  }): Observable<Order> {
    const url = `${this.apiUrl}${this.orderPrefix}/${id}`;
    return this.httpClient.put<Order>(url, order);
  }
}
