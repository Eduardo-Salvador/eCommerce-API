import { Component, Input } from '@angular/core';
import { NgOptimizedImage } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-offer-card',
  imports: [
    NgOptimizedImage,
    RouterLink
  ],
  templateUrl: './offer-card.html',
  styleUrl: './offer-card.css',
})
export class OfferCard {
  @Input() title: string = '';
  @Input() products: { image: string, alt: string }[] = [];
}
