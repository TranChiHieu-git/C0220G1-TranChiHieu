export class Accompaniedservice {
  id: string;
  nameAccompaniedService: string;
  cost: string;
  turn: string;
  status: string;

  constructor(id: string, nameAccompaniedService: string, cost: string, turn: string, status: string) {
    this.id = id;
    this.nameAccompaniedService = nameAccompaniedService;
    this.cost = cost;
    this.turn = turn;
    this.status = status;
  }
}
