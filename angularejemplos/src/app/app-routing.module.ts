import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HijoComponent } from './hijo/hijo.component';
import { PadreComponent } from './padre/padre.component';

const hijos = [
  { path: 'hijo/:id/:version', component: HijoComponent }
];

const routes: Routes = [
  { path: 'padre', component:PadreComponent, children: hijos },
  { path: 'padre/:id', component: PadreComponent, children: hijos }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
