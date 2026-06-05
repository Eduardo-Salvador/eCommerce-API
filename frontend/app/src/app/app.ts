import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from './components/header/header';
import { SubHeader } from './components/sub-header/sub-header';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Header, SubHeader],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('app');
}
