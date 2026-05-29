import { Component } from '@angular/core';
import { Header } from '../header/header';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [Header],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {}
