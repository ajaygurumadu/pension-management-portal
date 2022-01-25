import { BankDetails } from "./bank-details";

export class Pensioner {
    id!: number;
    name!: string;
    email!: string;
    dob!: string;
    pan!: string;
    salaryEarned!: string;
    allowances!: string;
    pensionClassification!: string;
    aadharNo!: string; 
    password!: string;
    bankDetails!:BankDetails
    constructor(){}
}
