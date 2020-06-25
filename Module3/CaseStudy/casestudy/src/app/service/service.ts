export class Service {
  id: string;
  name: string;
  area: string;
  numberOfFloor: string;
  numberMaxOfPeople: string;
  rent: string;
  idTypeRent: string;
  idTypeService: string;
  status: string;

  constructor(id: string, name: string, area: string, numberOfFloor: string, numberMaxOfPeople: string, rent: string,
              idTypeRent: string, idTypeService: string, status: string) {
    this.id = id;
    this.name = name;
    this.area = area;
    this.numberOfFloor = numberOfFloor;
    this.numberMaxOfPeople = numberMaxOfPeople;
    this.rent = rent;
    this.idTypeRent = idTypeRent;
    this.idTypeService = idTypeService;
    this.status = status;
  }

}
