import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Author } from '../author';
import { AuthorService } from '../services/author.service';

@Component({
  selector: 'app-author-details',
  templateUrl: './author-details.component.html',
  styleUrls: ['./author-details.component.scss']
})
export class AuthorDetailsComponent implements OnInit {

  id!: number
  author!: Author
  constructor(private route: ActivatedRoute, private authorService: AuthorService,  private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.author = new Author();
    this.authorService.getAuthorById(this.id).subscribe( data => {
    this.author = data;
    });
  }

  addAuthor(){
    this.router.navigate(['create-author']);
  }
  home(){
    this.router.navigate(['authors']);
  }

}