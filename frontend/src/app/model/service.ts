import Long from "long";
import {Decimal} from "decimal.js";
import {ServiceStatus} from "./serviceStatus";

export interface Service {
  id?: number;
  name: string;
  orderId: number;
  masterId: number;
  price: Decimal;
  status: ServiceStatus;
}
