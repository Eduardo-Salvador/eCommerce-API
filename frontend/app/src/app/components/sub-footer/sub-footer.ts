import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { NgOptimizedImage } from '@angular/common';

@Component({
  selector: 'app-sub-footer',
  standalone: true,
  imports: [
    RouterLink,
    NgOptimizedImage
  ],
  templateUrl: './sub-footer.html',
  styleUrl: './sub-footer.css',
})
export class SubFooter {}
