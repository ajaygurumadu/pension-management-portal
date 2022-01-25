import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userName: any;
  password: any;
  formData: any;
  returnUrl: any;
  errorMsg: any;

  constructor(private router: Router, private authService: AuthenticationService,
    private route: ActivatedRoute) {
    if (this.authService.isUserLoggedIn()) {
      this.router.navigate(['/home']);
    }
  }

  ngOnInit() {
    this.formData = new FormGroup({
      userName: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    });

    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/login';

  }
  onClickSubmit(data: any) {
    this.userName = data.userName;
    this.password = data.password;

    this.authService.login(this.userName, this.password)
      .subscribe(data => {
        console.log("Login Success: ");
        if (data) {
          this.router.navigate(['/home']);
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
    this.formData.reset();
  }


}
