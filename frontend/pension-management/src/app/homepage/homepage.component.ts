import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Pensioner } from '../Entity/pensioner';
import { PensionerServiceService } from '../services/pensioner-service.service';
import { SharedServiceService } from '../shared/shared-service.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {


  submitted = false;
  registerForm: any;
  errorMsg: any;

  constructor(private router: Router,
    private formBuilder: FormBuilder, private pensionerService: PensionerServiceService,
    private sharedService: SharedServiceService) { }

  ngOnInit() {

    this.registerForm = new FormGroup({
      aadharNo: new FormControl('', Validators.compose([Validators.required, Validators.max(10)]))
    });
  }

  get first(): any {

    return this.registerForm.get('aadharNo');
  }
  onSubmit() {
    let aNo = this.registerForm.get('aadharNo').value;
    console.log(aNo)
    this.pensionerService.findPensionerByAdhar(aNo).subscribe(
      user => {
        if (user != null) {
          console.log(user);
          this.router.navigateByUrl('/pensionerDetails');
          this.sharedService.setUserDetails(user);
          sessionStorage.setItem("user_data", JSON.stringify(user))
        }
        else {

          this.errorMsg = true;
        }
      }, error => {
        console.log(error)
        this.errorMsg = true;
        setTimeout(() => {
          this.errorMsg = false;
        }, 5000);
      })
    this.resetUserForm();

  }

  resetUserForm() {
    this.registerForm.reset();
  }

}


