import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AddingComponent } from "./adding/adding.component";
import { AppComponent } from "./app.component";
import { EmployeeComponent } from "./employee/employee.component";
import { HeaderComponent } from "./header/header.component";
import { HomeComponent } from "./home/home.component";
import { UserComponent } from "./user/user.component";

const appRoutes: Routes = [
    {path:'', component: HomeComponent},
    {path:'user', component: UserComponent},
    {path:'employee', component: EmployeeComponent},
    {path:'adding',component: AddingComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule{

}