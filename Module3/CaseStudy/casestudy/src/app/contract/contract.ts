export class Contract {
  id: string;
  idEmployee: string;
  idCustomer: string;
  idService: string;
  dateMakeContract: string;
  dateEndContract: string;
  deposit: string;
  totalAmount: string;

  constructor(id: string, idEmployee: string, idCustomer: string, idService: string, dateMakeContract: string,
              dateEndContract: string, deposit: string, totalAmount: string) {
    this.id = id;
    this.idEmployee = idEmployee;
    this.idCustomer = idCustomer;
    this.idService = idService;
    this.dateMakeContract = dateMakeContract;
    this.dateEndContract = dateEndContract;
    this.deposit = deposit;
    this.totalAmount = totalAmount;
  }
}
