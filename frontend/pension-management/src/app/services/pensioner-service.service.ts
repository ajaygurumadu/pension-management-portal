import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { Pensioner } from '../Entity/pensioner';
import { PensionDetail } from '../Entity/pension-detail';

@Injectable({
  providedIn: 'root'
})
export class PensionerServiceService {
  private baseUrl = 'http://localhost:9191/pension'; 

  constructor(private http: HttpClient){}

  findPensionerByAdhar(aadharNo:string): Observable<PensionDetail>{
    return this.http.get<PensionDetail>(`${this.baseUrl}/${aadharNo}`)
    .pipe(catchError(this.handleError));
  }
  

  private handleError(httpError: HttpErrorResponse) {
    if (httpError.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', httpError.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${httpError.status}, ` +
        `body was: ${httpError.error}`);
    }
    // Return an observable with a user-facing error message.
    return throwError('Something bad happened; please try again later.');
  }
}

