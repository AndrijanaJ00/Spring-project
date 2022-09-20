import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { User } from '../user';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {
  
  users!: User[];

  constructor(private authorService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.getUsers();
  }

  private getUsers(){
    this.authorService.getAllFromUser().subscribe(data => {
      this.users = data;
    });
  }

 
  userDetails(id: number){
    this.router.navigate(['user-details', id]);
  }

  updateUser(id: number){
    this.router.navigate(['update-user', id]);
  }

  deleteUser(id: number){
    this.authorService.deleteById(id).subscribe( data => {
      console.log(data);
      this.getUsers();
    })
  }

  addUser(){
    this.router.navigate(['create-user']);
  }

}
