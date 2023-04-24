import {Component, OnInit} from '@angular/core';
import {Car} from "../model/car";
import {Observable} from "rxjs";
import {CarService} from "./car.service";
import Long from "long";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.scss']
})
export class CarsComponent implements OnInit {
  car!: Car;
  readonly cars$: Observable<Car[]>;
  updatedCar: Car = { id: Long.ZERO, brand: '', model: '', year: 0, number: '', ownerId: Long.ZERO };
  newCar: Car = { id: Long.ZERO, brand: '', model: '', year: 0, number: '', ownerId: Long.ZERO };
  constructor(private carService: CarService) {
    this.cars$ = this.carService.getCars()
  }

  ngOnInit(): void {
  }

  onUpdateCar() {
    const carId = Long.fromString(this.updatedCar.id.toString());
    this.carService.updateCar(carId, this.updatedCar).subscribe(() => {
      console.log('Car updated successfully');
    }, (error) => {
      console.log('Error updating car', error);
    });
  }

  onCreateCar() {
    this.carService.createCar(this.newCar).subscribe(() => {
      console.log('Car updated successfully');
    }, (error) => {
      console.log('Error updating car', error);
    });
  }
}
