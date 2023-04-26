import Long from "long";

export interface Owner {
  id?: number;
  ownerName: string;
  carsIds: number[];
  ordersIds: number[];
}
