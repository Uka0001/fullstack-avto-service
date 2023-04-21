import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Car} from "../model/car";
import {HttpClient} from "@angular/common/http";
// import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CarService {
  // private readonly apiUrl = environment.apiUrl;
  private readonly apiUrl = 'http://localhost:8080';
  private readonly carPrefix = '/cars';

  constructor(private httpClient: HttpClient) { }

  getCars(): Observable<Car[]> {
    return this.httpClient
      .get<Car[]>(`${this.apiUrl}${this.carPrefix}`)
  }
}
