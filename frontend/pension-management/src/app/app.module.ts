import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { HomepageComponent } from './homepage/homepage.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { PensionerDetailsComponent } from './pensioner-details/pensioner-details.component';
import { LoginComponent } from './login/login.component';
import { BasicAuthHtppInterceptorService } from './interceptors/basic-auth-interceptor.service';
import { ErrorInterceptor } from './interceptors/error-interceptor';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomepageComponent,
    PensionerDetailsComponent,
    LoginComponent
    
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers:  [{ provide: HTTP_INTERCEPTORS, useClass: BasicAuthHtppInterceptorService, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
