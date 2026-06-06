import { Component } from '@angular/core';
import { Carousel } from './components/carousel/carousel';
import { OfferCard } from './components/offer-card/offer-card';
import { LoginBox } from './components/login-box/login-box';
import { AdBox } from './components/ad-box/ad-box';
import { CardBestRatedProducts } from './components/card-best-rated-products/card-best-rated-products';
import { RecommendationLogin } from './components/offer-login/recommendation-login';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [Carousel, OfferCard, LoginBox, AdBox, CardBestRatedProducts, RecommendationLogin],
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
  ];

  gamerFestival = [
    { image: 'gamer-festival/pc-fortnite.webp', alt: 'Gamer Festival' },
  ];

  kindle = [
    { image: 'kindle/kindle.png', alt: 'Kindle' },
  ];

  favoritesOfWeek = [
    { image: 'queridinhos/airpods.png', alt: 'Airpods' },
    { image: 'queridinhos/camera.png', alt: 'Camera' },
    { image: 'queridinhos/ipad.png', alt: 'Ipad' },
    { image: 'queridinhos/teclado.png', alt: 'Teclado' },
  ];

  smartHome = [
    { image: 'casa-inteligente/iphone15.avif', alt: 'Iphone 15' },
    { image: 'casa-inteligente/fechadura.png', alt: 'Fechadura' },
    { image: 'casa-inteligente/lampada.png', alt: 'Lampada' },
    { image: 'casa-inteligente/tomada.png', alt: 'Tomada' },
  ];
}
