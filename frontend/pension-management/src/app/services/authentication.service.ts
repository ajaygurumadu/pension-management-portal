import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";
import { Router } from "@angular/router";
import { SharedServiceService } from "../shared/shared-service.service";


@Injectable({
  providedIn: "root"
})
export class AuthenticationService {
  constructor(private httpClient: HttpClient,private router:Router,private sharedService:SharedServiceService) {}
// Provide username and password for authentication, and once authentication is successful, 
//store JWT token in session
  login(username:any, password:any) {
    return this.httpClient
      .post<any>("http://localhost:9191/authenticate", { username, password })
      .pipe(
        map(userData => {
          sessionStorage.setItem("username", username);
          let tokenStr = userData.jwt;
          console.log(userData.jwt);
          sessionStorage.setItem("token", tokenStr);
          return userData;
        })
      );
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem("username");
    console.log(!(user === null));
      return (!(user === null));
  }

  logOut() {
    sessionStorage.removeItem("username");
    sessionStorage.removeItem("token");
    this.router.navigate(['/login']) 
    return false;
  }
  
}
