import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Car} from "../model/car";
import {HttpClient} from "@angular/common/http";
import Long from "long";

@Injectable({
  providedIn: 'root'
})
export class CarService {
  private readonly apiUrl = 'http://localhost:8080';
  private readonly carPrefix = '/cars';

  constructor(private httpClient: HttpClient) { }

  getCars(): Observable<Car[]> {
    return this.httpClient
      .get<Car[]>(`${this.apiUrl}${this.carPrefix}`)
  }

  updateCar(id: Long, car: Car): Observable<Car> {
    const url = `${this.apiUrl}${this.carPrefix}/${id}`;
    return this.httpClient.put<Car>(url, car);
  }

  createCar(car: Car): Observable<Car> {
    const url = `${this.apiUrl}${this.carPrefix}`;
    return this.httpClient.post<Car>(url, car);
  }
}
