import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Author } from '../author';
import { AuthorService } from '../services/author.service';

@Component({
  selector: 'app-create-author',
  templateUrl: './create-author.component.html',
  styleUrls: ['./create-author.component.scss']
})
export class CreateAuthorComponent implements OnInit {

  author: Author = new Author();

  constructor(private authorService: AuthorService, private router: Router) { }

  ngOnInit(): void {
  }

  save(){
    this.authorService.save(this.author).subscribe (data =>{ console.log(data);
      console.log(data);
      this.goToAuthorList();
    },
    error => console.log(error));
  }

  goToAuthorList(){
    this.router.navigate(['/authors']);
  }

  onSubmit(){
    console.log(this.author);
    this.save();
  }

}
