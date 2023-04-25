import { Component } from '@angular/core';
import {Good} from "../model/good";
import {Observable} from "rxjs";
import Long from "long";
import {Decimal} from "decimal.js";
import {GoodService} from "./good.service";

@Component({
  selector: 'app-goods',
  templateUrl: './goods.component.html',
  styleUrls: ['./goods.component.scss']
})
export class GoodsComponent {
  good!: Good;
  readonly goods$: Observable<Good[]>;
  updatedGood: Good = { id: Long.ZERO, name: '', goodCost: Decimal.round(0),  orderId: Long.ZERO};
  newGood: Good = { id: Long.ZERO, name: '', goodCost: Decimal.round(0),  orderId: Long.ZERO };
  constructor(private goodService: GoodService) {
    this.goods$ = this.goodService.getGoods()
  }

  ngOnInit(): void {
  }

  onUpdateGood() {
    const goodId = Long.fromString(this.updatedGood.id.toString());
    this.goodService.updateGood(goodId, this.updatedGood).subscribe(() => {
      console.log('Good updated successfully');
    }, (error) => {
      console.log('Error updating Good', error);
    });
  }

  onCreateGood() {
    this.goodService.createGood(this.newGood).subscribe(() => {
      console.log('Good created successfully');
    }, (error) => {
      console.log('Error creating Good', error);
    });
  }
}
