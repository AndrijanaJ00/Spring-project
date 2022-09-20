import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Author } from '../author';
import { AuthorService } from '../services/author.service';

@Component({
  selector: 'app-author-list',
  templateUrl: './author-list.component.html',
  styleUrls: ['./author-list.component.scss']
})
export class AuthorListComponent implements OnInit {

  authors!: Author[];

  constructor(private authorService: AuthorService, private router: Router) { }

  ngOnInit(): void {
    this.getAuthors();
  }

  private getAuthors(){
    this.authorService.getAllFromAuthor().subscribe(data => {
      this.authors = data;
    });
  }

 
  authorDetails(id: number){
    this.router.navigate(['author-details', id]);
  }

  updateAuthor(id: number){
    this.router.navigate(['update-author', id]);
  }

  deleteAuthor(id: number){
    this.authorService.deleteById(id).subscribe( data => {
      console.log(data);
      this.getAuthors();
    })
  }

  addAuthor(){
    this.router.navigate(['create-author']);
  }

}
