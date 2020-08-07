import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = '你好 世界';
  btnClass = "btnClass";
  customInfo = "custom";
  htmlStr = "<span>这是个片段<span>";
  count:number = 0;
  inc(){
     this.count ++;
  }
  changeColor(event):void{
      console.log(event);
      event.srcElement.style.background = 'blue';
  }
}
