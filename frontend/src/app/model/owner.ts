import Long from "long";

export interface Owner {
  id: Long;
  ownerName: string;
  carsId: Long[];
  ordersId: Long[];
}
