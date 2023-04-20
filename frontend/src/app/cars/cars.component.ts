import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Car} from "../model/car";
import {Observable} from "rxjs";
import {CarService} from "./car.service";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.scss']
})
export class CarsComponent implements OnInit {
  readonly cars$: Observable<Car[]>;
  constructor(private carService: CarService) {
    this.cars$ = this.carService.getCars()
  }

  ngOnInit(): void {
  }
}
