import Long from "long";
import { LocalDate } from 'js-joda';
import {Decimal} from "decimal.js";
import {OrderStatus} from "./orderstatus";

export interface Order {
  id: Long;
  carId: Long;
  masterId: Long;
  description: string;
  dateOfAdoption: LocalDate;
  serviceIdList: Long[];
  goodsIdList: Long[];
  status: OrderStatus;
  totalCost: Decimal;
  completionDate: LocalDate;
}
