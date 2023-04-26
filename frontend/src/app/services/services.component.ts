import {Component} from '@angular/core';
import {ServiceService} from "./service.service";
import {Decimal} from "decimal.js";
import {ServiceStatus} from "../model/serviceStatus";
import {Observable} from "rxjs";
import {Service} from "../model/service";

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.scss']
})
export class ServicesComponent {
  service!: Service;
  readonly services$: Observable<Service[]>;
  id: number = 0;
  name: string = 'test';
  orderId: number = 0;
  masterId: number = 0;
  price: Decimal = Decimal.round(0);
  updatedStatus: ServiceStatus = ServiceStatus.NOT_PAID;
  constructor( private serviceService: ServiceService) {
    this.services$ = this.serviceService.getServices()
  }

  ngOnInit(): void {
  }

  onUpdateService() {
    this.serviceService.updateService(this.id, {
      name: this.name,
      orderId: this.orderId,
      masterId: this.masterId,
      price: this.price,
      status: this.updatedStatus,
    }).subscribe((data) => {
      console.log('Owner updated successfully');
      console.log(data);
    }, (error) => {
      console.log('Error updating Owner', error);
    });
  }

  onUpdateServiceStatus() {
    console.log(this.id, this.updatedStatus)
    this.serviceService.updateServiceStatus(this.id, this.updatedStatus)
      .subscribe((data) => {
      console.log('Service status updated successfully');
      console.log(data);
    }, (error) => {
      console.log('Error updating Service status', error);
    });
  }

  onCreateService() {
    this.serviceService.createService({
      name: this.name,
      orderId: this.orderId,
      masterId: this.masterId,
      price: this.price,
      status: this.updatedStatus,
    }).subscribe((data) => {
      console.log('Service created successfully');
      console.log(data);
    }, (error) => {
      console.log('Error updating Service', error);
    });
  }
}
