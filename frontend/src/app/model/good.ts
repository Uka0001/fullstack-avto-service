import {Decimal} from 'decimal.js';
import Long from "long";

export interface Good {
  id: Long;
  name: string;
  goodCost: Decimal;
  orderId: Long;
 }
