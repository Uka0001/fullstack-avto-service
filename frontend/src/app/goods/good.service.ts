import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Good} from "../model/good";
import Long from "long";

@Injectable({
  providedIn: 'root'
})
export class GoodService {

  private readonly apiUrl = 'http://localhost:8080';
  private readonly goodPrefix = '/goods';

  constructor(private httpClient: HttpClient) {
  }

  getGoods(): Observable<Good[]> {
    return this.httpClient
      .get<Good[]>(`${this.apiUrl}${this.goodPrefix}`)
  }

  updateGood(id: Long, good: Good): Observable<Good> {
    const url = `${this.apiUrl}${this.goodPrefix}/${id}`;
    return this.httpClient.put<Good>(url, good);
  }

  createGood(good: Good): Observable<Good> {
    const url = `${this.apiUrl}${this.goodPrefix}`;
    return this.httpClient.post<Good>(url, good);
  }
}
