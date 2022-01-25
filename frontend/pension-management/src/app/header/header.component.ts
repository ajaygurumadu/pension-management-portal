import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthGaurdService } from '../interceptors/auth-gaurd.service';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent{
  userCheck:any;
  logoutDisable: any;
  user: any;

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,
    private authGuard:AuthGaurdService
  ) {
    
  }
  ngOnInit(): void {
    if(this.authenticationService.isUserLoggedIn())
    {
      console.log(this.authenticationService.isUserLoggedIn())
      this.userCheck=true;
    }
    else{
      console.log(this.authenticationService.isUserLoggedIn())
      this.userCheck=false;
    }
  }

  ngOnChanges() : void 
  {
    if(this.authenticationService.isUserLoggedIn())
    {
      console.log(this.authenticationService.isUserLoggedIn())
      this.userCheck=true;
    }
    else{
      console.log(this.authenticationService.isUserLoggedIn())
      this.userCheck=false;
    }
  }
  logout() {
    console.log("Logged Out");
    this.userCheck=false;
    this.authenticationService.logOut();
    
  }

}
