import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { PensionerDetailsComponent } from './pensioner-details/pensioner-details.component';
import { AuthGaurdService } from './interceptors/auth-gaurd.service';


const routes: Routes = [  
  { path: 'login', component: LoginComponent},
  { path: '', component: LoginComponent,},
  { path: 'home', component: HomepageComponent,canActivate:[AuthGaurdService] },
  { path: 'pensionerDetails', component: PensionerDetailsComponent,canActivate:[AuthGaurdService] }

]; 
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
