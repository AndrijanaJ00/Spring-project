import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../services/book.service';

@Component({
  selector: 'app-book-user',
  templateUrl: './book-user.component.html',
  styleUrls: ['./book-user.component.scss']
})
export class BookUserComponent implements OnInit {

  books!: Book[];

  constructor(private bookService: BookService, private router: Router) { }

  ngOnInit(): void {
    this.getBooks();
  }

  private getBooks(){
    this.bookService.getAllFromBook().subscribe(data => {
      this.books = data;
    });
  }

  bookDetails(id: number){
    this.router.navigate(['book-details-user', id]);
  }

}
