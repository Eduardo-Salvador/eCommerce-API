import { Component } from '@angular/core';

@Component({
  selector: 'app-back-to-init',
  imports: [],
  templateUrl: './back-to-init.html',
  styleUrl: './back-to-init.css',
})
export class BackToInit {
  scrollToTop() {
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }
}
