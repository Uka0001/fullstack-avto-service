// @ts-ignore
import Long from "long";

export interface Car {
  id: Long;
  brand: string;
  model: string;
  year: number;
  number: string;
  ownerId: Long;
}
