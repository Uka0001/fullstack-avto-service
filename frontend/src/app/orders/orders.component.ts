import {Component} from '@angular/core';
import {LocalDate} from "js-joda";
import {OrderStatus} from "../model/orderstatus";
import {Decimal} from "decimal.js";
import {Order} from "../model/order";
import {Observable} from "rxjs";
import {OrderService} from "./order.service";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})
export class OrdersComponent {
  order!: Order;
  readonly orders$: Observable<Order[]>
  id: number = 0;
  carId: number = 0;
  masterId: number = 0;
  description: string = 'test';
  dateOfAdoption: LocalDate = LocalDate.now();
  serviceId: number = 0;
  goodId: number = 0;
  status: OrderStatus = OrderStatus.ACCEPTED;
  totalCost: Decimal = Decimal.round(0);
  completionDate: LocalDate = LocalDate.now();
  addedGoodId: number = 0;
  constructor(private orderService: OrderService) {
    this.orders$ = this.orderService.getOrders()
  }

  ngOnInit(): void {
  }

  onUpdateOrder() {
    this.orderService.updateOrder(this.id, {
      carId: this.carId,
      masterId: this.masterId,
      description: this.description,
      dateOfAdoption: this.dateOfAdoption,
      serviceIdList: [this.serviceId],
      goodsIdList: [this.goodId],
      status: this.status,
      totalCost: this.totalCost,
      completionDate: this.completionDate
    }).subscribe((data) => {
      console.log('Order updated successfully');
      console.log(data);
    }, (error) => {
      console.log('Error updating Order', error);
    });
  }

  onUpdateOrderStatus() {
    console.log(this.id, this.status)
    this.orderService.updateOrderStatus(this.id, this.status)
      .subscribe((data) => {
        console.log('Order status updated successfully');
        console.log(data);
      }, (error) => {
        console.log('Error updating Order status', error);
      });
  }

  onAddGoodToOrder() {
    console.log(this.id, this.addedGoodId)
    this.orderService.addGood(this.id, this.status)
      .subscribe((data) => {
        console.log('Order status updated successfully');
        console.log(data);
      }, (error) => {
        console.log('Error updating Order status', error);
      });
  }

  onCreateService() {
    this.orderService.createOrder({
      carId: this.carId,
      masterId: this.masterId,
      description: this.description,
      dateOfAdoption: this.dateOfAdoption,
      serviceIdList: [this.serviceId],
      goodsIdList: [this.goodId],
      status: this.status,
      totalCost: this.totalCost,
      completionDate: this.completionDate
    }).subscribe((data) => {
      console.log('Order created successfully');
      console.log(data);
    }, (error) => {
      console.log('Error updating Order', error);
    });
  }

  onGetOrderCost() {
    this.orderService.getOrderCost(this.id)
      .subscribe((data) => {
        console.log('Owner orders got successfully');
        console.log(data);
      }, (error) => {
        console.log('Error getting owners orders', error);
      });
  }
}
