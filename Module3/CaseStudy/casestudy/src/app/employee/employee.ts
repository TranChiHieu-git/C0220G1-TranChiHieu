export class Employee {
  id: string;
  name: string;
  birthday: string;
  identificationCard: string;
  salary: string;
  numberPhone: string;
  email: string;
  address: string;
  idPos: string;
  idLevel: string;
  idPart: string;

  constructor(id: string, name: string, dayOfBirth: string, identificationCard: string, salary: string,
              numberPhone: string, email: string, address: string, idPos: string, idLevel: string, idPart: string) {
    this.id = id;
    this.name = name;
    this.birthday = dayOfBirth;
    this.identificationCard = identificationCard;
    this.salary = salary;
    this.numberPhone = numberPhone;
    this.email = email;
    this.address = address;
    this.idPos = idPos;
    this.idLevel = idLevel;
    this.idPart = idPart;
  }
}
