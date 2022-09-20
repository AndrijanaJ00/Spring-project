import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../services/book.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.scss']
})
export class BookDetailsComponent implements OnInit {

  id!: number
  book!: Book
  constructor(private route: ActivatedRoute, private bookService: BookService,  private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.book = new Book();
    this.bookService.getBookById(this.id).subscribe( data => {
      this.book = data;
    });
  }

  addBook(){
    this.router.navigate(['create-book']);
  }
  home(){
    this.router.navigate(['books']);
  }

}
