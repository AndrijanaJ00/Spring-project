import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Author } from '../author';
import { AuthorService } from '../services/author.service';

@Component({
  selector: 'app-update-author',
  templateUrl: './update-author.component.html',
  styleUrls: ['./update-author.component.scss']
})
export class UpdateAuthorComponent implements OnInit {

  id!: number;
  author: Author = new Author();
  constructor(private authorService: AuthorService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.authorService.getAuthorById(this.id).subscribe(data => {
      this.author = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.authorService.updateAuthor(this.id, this.author).subscribe( data =>{
      this.goToAuthorList();
    }
    , error => console.log(error));
  }

  goToAuthorList(){
    this.router.navigate(['/authors']);
  }

}

