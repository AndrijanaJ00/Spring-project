import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Author } from '../author';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  private baseURL = "http://localhost:8080/authors";

  constructor(private httpClient: HttpClient) { }

  getAllFromAuthor(): Observable<Author[]>{
    return this.httpClient.get<Author[]>(`${this.baseURL}`);
  }

  save(author: Author): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, author);
  }

  getAuthorById(id: number): Observable<Author>{
    return this.httpClient.get<Author>(`${this.baseURL}/${id}`);
  }

  updateAuthor(id: number, author: Author): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, author);
  }

  deleteById(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
