import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Fighter } from '../models/fighter';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FighterService {

  private baseUrl = 'http://localhost:8087/';
  private url = this.baseUrl+ 'api/fighters';

  constructor(
    private http: HttpClient
  ) { }

  index(): Observable<Fighter[]> {
    return this.http.get<Fighter[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('TodoService.index(): Error retrieving todo list');
      })
    );
  }
}
