import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedServiceService {

  userDetails:any={};
  diableButton:any;
  constructor() { }

  getUserDetails()
  {
    return this.userDetails;
  }
  setUserDetails(userDetails:any={})
  {
    this.userDetails=userDetails;
  }

  getDisableButton()
  {
    return this.diableButton;
  }
  setDisableButton(diableButton:any)
  {
    this.diableButton=diableButton;
  }
}
