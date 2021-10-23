import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FighterListComponent } from './components/fighter-list/fighter-list.component';

const routes: Routes = [
  { path: 'fighter/:id', component: FighterListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
