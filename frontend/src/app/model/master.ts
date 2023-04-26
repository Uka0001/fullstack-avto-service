import Long from "long";

export interface Master {
  id?: number;
  fullName: string;
  completedOrderIds: number[];
}
