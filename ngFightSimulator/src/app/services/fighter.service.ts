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

  show(fighterId: number): Observable<Fighter> {
    return this.http.get<Fighter>(this.url + '/' + fighterId).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('TodoService.show(): Error retrieving todo');
      })
    );
  }

  create(fighter: Fighter): Observable<Fighter>{
    fighter.id = 0;
    fighter.name = '';
    fighter.description= '';
    fighter.imageUrl = '';
    return this.http.post<Fighter>(this.url, fighter).pipe();
    catchError((err: any) => {
      console.log(err);
      return throwError('TodoService.create(): ');
    })

  }
}
