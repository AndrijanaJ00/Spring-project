import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthorDetailsComponent } from './author-details/author-details.component';
import { AuthorListComponent } from './author-list/author-list.component';
import { BookDetailsComponent } from './book-details/book-details.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookUserComponent } from './book-user/book-user.component';
import { CreateAuthorComponent } from './create-author/create-author.component';
import { CreateBookComponent } from './create-book/create-book.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UpdateAuthorComponent } from './update-author/update-author.component';
import { UpdateBookComponent } from './update-book/update-book.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserListComponent } from './user-list/user-list.component';

const routes: Routes = [
  {path: 'books', component: BookListComponent},
  {path: 'create-book', component: CreateBookComponent},
  {path: '', redirectTo: 'books', pathMatch: 'full'},
  {path: 'update-book/:id', component: UpdateBookComponent},
  {path: 'book-details/:id', component: BookDetailsComponent},
  {path: 'book-user', component: BookUserComponent},

  {path: 'authors', component: AuthorListComponent},
  {path: 'create-author', component: CreateAuthorComponent},
  {path: 'update-author/:id', component: UpdateAuthorComponent},
  {path: 'author-details/:id', component: AuthorDetailsComponent},

  {path: 'users', component: UserListComponent},
  {path: 'create-user', component: CreateUserComponent},
  {path: 'update-user/:id', component: UpdateUserComponent},
  {path: 'user-details/:id', component: UserDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
