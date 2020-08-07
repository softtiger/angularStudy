import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
   public userName:String ='revokeyu';
   password:string ="123";
   login(){
      alert(this.userName+"登陆成功");
   }
   login2(username,password){
      alert(username);
   }
}
