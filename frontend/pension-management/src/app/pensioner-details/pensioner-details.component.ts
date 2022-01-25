import { Component, OnInit } from '@angular/core';
import { SharedServiceService } from '../shared/shared-service.service';
import { FormBuilder, FormGroup, Validators, FormArray, FormControl } from '@angular/forms';
import { PensionerServiceService } from '../services/pensioner-service.service';
import { ConstantPool } from '@angular/compiler';

@Component({
  selector: 'app-pensioner-details',
  templateUrl: './pensioner-details.component.html',
  styleUrls: ['./pensioner-details.component.css']
})
export class PensionerDetailsComponent implements OnInit {
  user: any;
  newForm: any;
  pensionAmount: any;
  bankCharges: any;
  pensionDetail: any = {
    aadharNo: '',
    bankServiceCharge: '',
    pensionAmount: ''
  }
  constructor(private sharedService: SharedServiceService, private pensionService: PensionerServiceService) { }

  ngOnInit(): void {
    this.user = this.sharedService.getUserDetails();
    this.newForm = new FormGroup({
      name: new FormControl({ value: '', disabled: true }, Validators.required),
      aadharNo: new FormControl({ value: '', disabled: true }, Validators.required),
      email: new FormControl({ value: '', disabled: true }, Validators.required),
      dob: new FormControl({ value: '', disabled: true }, Validators.required),
      pan: new FormControl({ value: '', disabled: true }, Validators.required),
      pensionClassification: new FormControl({ value: '', disabled: true }, Validators.required),
      salaryEarned: new FormControl({ value: '', disabled: true }, Validators.required),
      allowances: new FormControl({ value: '', disabled: true }, Validators.required),
      bankName: new FormControl({ value: '', disabled: true }, Validators.required),
      bankAccount: new FormControl({ value: '', disabled: true }, Validators.required),
      sector: new FormControl({ value: '', disabled: true }, Validators.required),
      serviceCharge: new FormControl({ value: '', disabled: true }, Validators.required),
      pensionAmount: new FormControl({ value: '', disabled: true }, Validators.required),
    });
    this.setValuesToForm(this.user);
  }

  setValuesToForm(user: any) {
    this.newForm.setValue({
      name: this.user.pensioner.name,
      aadharNo: this.user.pensioner.aadharNo,
      email: this.user.pensioner.email,
      dob: this.user.pensioner.dob,
      pan: this.user.pensioner.pan,
      pensionClassification: this.user.pensioner.pensionClassification,
      salaryEarned: this.user.pensioner.salaryEarned,
      allowances: this.user.pensioner.allowances,
      bankName: this.user.pensioner.bankDetails.bankName,
      bankAccount: this.user.pensioner.bankDetails.accountNo,
      sector: this.user.pensioner.bankDetails.sector,
      serviceCharge: this.user.pensionDetails.bankServiceCharge,
      pensionAmount: this.user.pensionDetails.pensionAmount
    });

  }

}
