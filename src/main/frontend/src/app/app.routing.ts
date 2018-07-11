import { LoginComponent } from './login/login.component';
import { TaskComponent } from './task/task.component';
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const appRoutes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'task', component: TaskComponent}
//  {path: 'computer/list', component: ComputerListComponent},
//  {path: 'computer/:id', component: ComputerDetailsComponent},
//  {path: 'computer/update/:id', component: EditComputerComponent}
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);