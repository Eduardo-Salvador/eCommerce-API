import {Component, Input} from '@angular/core';
import {NgOptimizedImage} from "@angular/common";

@Component({
  selector: 'app-ad-box',
    imports: [
        NgOptimizedImage
    ],
  templateUrl: './ad-box.html',
  styleUrl: './ad-box.css',
})
export class AdBox {
  @Input() title: string = '';
  @Input() ad: { image: string, alt: string }[] = [];
}
