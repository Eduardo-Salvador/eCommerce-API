import { Component } from '@angular/core';
import { Carousel } from './components/carousel/carousel';
import { OfferCard } from './components/offer-card/offer-card';
import { LoginBox } from './components/login-box/login-box';
import { AdBox } from './components/ad-box/ad-box';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [Carousel, OfferCard, LoginBox, AdBox],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  offerProducts = [
    { image: 'ofertas-home/iphone17.png', alt: 'iPhone' },
    { image: 'ofertas-home/galaxy26ultra.png', alt: 'Galaxy' },
    { image: 'ofertas-home/fone-jbl.png', alt: 'Fone JBL' },
    { image: 'ofertas-home/ps5.png', alt: 'PS5' },
  ];

  topRatedProducts = [
    { image: 'melhoravaliados-home/dj-music.png', alt: 'DJ' },
    { image: 'melhoravaliados-home/mouse.png', alt: 'Mouse' },
    { image: 'melhoravaliados-home/notebook-dell.avif', alt: 'Notebook' },
    { image: 'melhoravaliados-home/tv-samsung.avif', alt: 'TV' },
  ];

  newProducts = [
    { image: 'descubra/alexa.png', alt: 'Alexa' },
    { image: 'descubra/geladeira.png', alt: 'Geladeira' },
    { image: 'descubra/robo-aspirador.png', alt: 'Robô Aspirador' },
    { image: 'descubra/facas.png', alt: 'Facas' },
  ];

  ad = [
    { image: 'ad/ad.png', alt: 'BBB' },
  ]
}
