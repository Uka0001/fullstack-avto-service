import { Component } from '@angular/core';
import {Observable} from "rxjs";
import Long from "long";
import {Master} from "../model/master";
import {MasterService} from "./master.service";
import {Order} from "../model/order";
import {GoodService} from "../goods/good.service";

@Component({
  selector: 'app-masters',
  templateUrl: './masters.component.html',
  styleUrls: ['./masters.component.scss']
})
export class MastersComponent {
  master!: Master;
  readonly masters$: Observable<Master[]>;
  masterId: number = 0;
  masterFullName: string = 'test';
  masterCompletedOrderId: number = 0;

  newMaster: Master = { id: 0, fullName: '', completedOrderIds: [0] };
  constructor( private masterService: MasterService) {
    this.masters$ = this.masterService.getMasters()
  }

  ngOnInit(): void {
  }

  onUpdateMaster() {
    console.log(this.masterId, this.masterFullName, this.masterCompletedOrderId);
    this.masterService.updateMaster(this.masterId, {
      fullName: this.masterFullName,
      completedOrderIds: [] = [this.masterCompletedOrderId]
    }).subscribe((data) => {
      console.log('Master updated successfully');
      console.log(data);
    }, (error) => {
      console.log('Error updating Master', error);
    });
  }

  onCreateMaster() {
    console.log(this.newMaster);
    this.masterService.createMaster({
      fullName: this.masterFullName,
      completedOrderIds: [] = [this.masterCompletedOrderId]
    }).subscribe((data) => {
      console.log('Master created successfully');
      console.log(data)
    }, (error) => {
      console.log('Error creating Master', error);
    });
  }

  onGetMasterOrders() {
    this.masterService.getMastersOrders(this.masterId).subscribe(() => {
      console.log('Master orders got successfully');
    }, (error) => {
      console.log('Error getting masters orders', error);
    });
  }
}
