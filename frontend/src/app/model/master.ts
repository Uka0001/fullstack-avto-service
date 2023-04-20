import Long from "long";

export interface Master {
  id: Long;
  fullName: string;
  completedOrderId: Long[];
}
