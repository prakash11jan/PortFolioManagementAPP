import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PortfolioService {
  private  URL:String = 'http://localhost:8091/assets';
  constructor(private httpClient: HttpClient) { }
  getPortFolios(userId:String): Observable<any> {
    console.log('Request is sent!');
        return this.httpClient.get(`${this.URL}/${userId}`);
  }
}
