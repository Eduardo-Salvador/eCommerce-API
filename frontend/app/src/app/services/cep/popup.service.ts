import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PopupService {
  openCepPopUp = new BehaviorSubject<boolean>(false);

  updateCep() {
    this.openCepPopUp.next(true);
  }

  closeUpdateCep() {
    this.openCepPopUp.next(false);
  }
}
