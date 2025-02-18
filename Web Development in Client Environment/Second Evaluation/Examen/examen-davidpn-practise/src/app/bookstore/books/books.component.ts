import { Component } from '@angular/core';
import { BooksService } from '../bookstore.service';
import { Book } from '../../interface/book';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrl: './books.component.css'
})
export class BooksComponent {

  books: Book[] = [];
  private url: string = 'http://localhost:8080/api/games';

  constructor(private miServicio: BooksService, private miHttp: HttpClient) {
  }

  ngOnInit() {
    this.getAll2();
  }

  getAll2() {
    this.getAll().subscribe({
      next: response => {
        this.books = response.data;
        console.log(response);
      },
      error: error => console.log(error.status)
    });
  }

  getAll(): Observable<{ data: Book[], total: number, currentPage: number, pageSize: number, next: string | null, previous: string | null }> {
    return this.miHttp.get<{ data: Book[], total: number, currentPage: number, pageSize: number, next: string | null, previous: string | null }>(this.url);
  }
}
