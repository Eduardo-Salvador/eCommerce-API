import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from './components/header/header';
import { SubHeader } from './components/sub-header/sub-header';
import { register } from 'swiper/element/bundle';
import { SubFooter } from './components/sub-footer/sub-footer';
import { Footer } from './components/footer/footer';
import { CepPopup } from './components/header/modals/cep-popup/cep-popup';

register();

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [Header, SubHeader, RouterOutlet, SubFooter, Footer, CepPopup],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {}
