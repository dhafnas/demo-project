import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListRequestsComponent } from './list-requests/list-requests.component'
import { HomeComponent } from './home/home.component'
const routes: Routes = [ 
  { path: '', component: HomeComponent},
  { path: 'requests', component: ListRequestsComponent} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
