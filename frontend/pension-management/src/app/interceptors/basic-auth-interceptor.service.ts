import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from '../services/authentication.service';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthHtppInterceptorService implements HttpInterceptor {

  constructor(private authenticationService:AuthenticationService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    console.log(sessionStorage.getItem('token'))
    const user = this.authenticationService.isUserLoggedIn();
    console.log(user);
    const isApiUrl = req.url.startsWith("http://localhost:9191");
    console.log(isApiUrl)
    if (user && isApiUrl) {
      console.log(sessionStorage.getItem('token'))
        req = req.clone({
            setHeaders: { 
                Authorization: `${sessionStorage.getItem('token')}`
            }
        });
    }

    return next.handle(req);

  }
}
