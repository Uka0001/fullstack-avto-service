import Long from "long";
import { LocalDate } from 'js-joda';
import {Decimal} from "decimal.js";
import {OrderStatus} from "./orderstatus";

export interface Order {
  id: number;
  carId: number;
  masterId: number;
  description: string;
  dateOfAdoption: LocalDate;
  serviceIdList: number[];
  goodsIdList: number[];
  status: OrderStatus;
  totalCost: Decimal;
  completionDate: LocalDate;
}
