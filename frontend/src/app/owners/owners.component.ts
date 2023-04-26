import { Component } from '@angular/core';
import {Owner} from "../model/owner";
import {Observable} from "rxjs";
import {OwnerService} from "./owner.service";

@Component({
  selector: 'app-owners',
  templateUrl: './owners.component.html',
  styleUrls: ['./owners.component.scss']
})
export class OwnersComponent {
  owner!: Owner;
  readonly owners$: Observable<Owner[]>;
  id: number = 0;
  ownerName: string = 'test';
  carsId: number = 0;
  ordersId: number = 0;

  constructor( private ownerService: OwnerService) {
    this.owners$ = this.ownerService.getOwners()
  }

  ngOnInit(): void {
  }

  onUpdateOwner() {
    this.ownerService.updateOwner(this.id, {
      ownerName: this.ownerName,
      carsIds: [] = [this.carsId],
      ordersIds: [] = [this.ordersId]
    }).subscribe((data) => {
      console.log('Owner updated successfully');
      console.log(data);
    }, (error) => {
      console.log('Error updating Owner', error);
    });
  }

  onCreateOwner() {
    this.ownerService.createOwner({
      ownerName: this.ownerName,
      carsIds: [] = [this.carsId],
      ordersIds: [] = [this.ordersId]
    }).subscribe((data) => {
      console.log('Owner created successfully');
      console.log(data);
    }, (error) => {
      console.log('Error updating Owner', error);
    });
  }

  onGetOwnerOrders() {
    this.ownerService.getOwnersOrders(this.id)
      .subscribe((data) => {
      console.log('Owner orders got successfully');
      console.log(data);
    }, (error) => {
      console.log('Error getting owners orders', error);
    });
  }
}
