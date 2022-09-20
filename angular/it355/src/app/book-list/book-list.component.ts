import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../services/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})

export class BookListComponent implements OnInit {

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
    this.router.navigate(['book-details', id]);
  }

  updateBook(id: number){
    this.router.navigate(['update-book', id]);
  }

  deleteBook(id: number){
    this.bookService.deleteById(id).subscribe( data => {
      console.log(data);
      this.getBooks();
    })
  }

  addBook(){
    this.router.navigate(['create-book']);
  }

}
