import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from './components/header/header';
import { SubHeader } from './components/sub-header/sub-header';
import { register } from 'swiper/element/bundle';

register();

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Header, SubHeader],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {}
