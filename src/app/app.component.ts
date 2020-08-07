import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'hello';
  area  = '广东';
  orderStatus = 10;
  famouse:string[] = ["毛泽东","爱因斯坦","终南山"];
  toggle(){
     this.area=='广东'? this.area='湖北':this.area='广东';
  }
  sayHi(name,i){
      alert(name+"排名"+i);
  }
}
