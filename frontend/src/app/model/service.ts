import Long from "long";
import {Decimal} from "decimal.js";
import {ServiceStatus} from "./serviceStatus";

export interface Service {
  id: Long;
  name: string;
  orderId: Long;
  masterId: Long;
  price: Decimal;
  status: ServiceStatus;
}
