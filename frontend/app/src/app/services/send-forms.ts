import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class SendForms {
  constructor() {
  }

  sendFormsToBackEnd(info: string){
    console.log("sendFormsToBackEnd");
    console.log(info);
  }

}
