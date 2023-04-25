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
  // readonly orders$: Observable<Order[]>;
  masterId: Long = Long.ZERO;

  updatedMaster: Master = { id: Long.ZERO, fullName: '', completedOrderId: [] = [Long.ZERO]};
  newMaster: Master = { id: Long.ZERO, fullName: '', completedOrderId: [] };
  constructor( private masterService: MasterService) {
    this.masters$ = this.masterService.getMasters()
  }

  ngOnInit(): void {
  }

  onUpdateMaster() {
    const masterId = Long.fromString(this.updatedMaster.id.toString());
    this.masterService.updateMaster(masterId, this.updatedMaster).subscribe(() => {
      console.log('Master updated successfully');
    }, (error) => {
      console.log('Error updating Master', error);
    });
  }

  onCreateMaster() {
    this.masterService.createMaster(this.newMaster).subscribe(() => {
      console.log('Master created successfully');
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
