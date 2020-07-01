export class Customer {
  id: string;
  name: string;
  birthday: string;
  identificationCard: string;
  salary: string;
  numberPhone: string;
  email: string;
  address: string;
  idTypeCustomer: string;

  constructor(id: string, name: string, birthday: string, identificationCard: string, salary: string,
              numberPhone: string, email: string, address: string, idTypeCustomer: string) {
    this.id = id;
    this.name = name;
    this.birthday = birthday;
    this.identificationCard = identificationCard;
    this.salary = salary;
    this.numberPhone = numberPhone;
    this.email = email;
    this.address = address;
    this.idTypeCustomer = idTypeCustomer;
  }
}
