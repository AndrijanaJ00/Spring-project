import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { User } from '../user';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.scss']
})
export class UserDetailsComponent implements OnInit {

  id!: number
  user!: User
  constructor(private route: ActivatedRoute, private userService: UserService,  private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.user = new User();
    this.userService.getUserById(this.id).subscribe( data => {
    this.user = data;
    });
  }

  addUser(){
    this.router.navigate(['create-user']);
  }
  home(){
    this.router.navigate(['users']);
  }

}