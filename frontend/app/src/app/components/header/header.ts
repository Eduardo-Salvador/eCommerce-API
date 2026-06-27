import { Component, HostListener, ElementRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { NgOptimizedImage } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { MatMenuModule } from '@angular/material/menu';
import { MatBadgeModule } from '@angular/material/badge';
import { RouterLink } from '@angular/router';
import { PopupService } from '../../services/cep/popup.service';
import { SearchBar } from './components/search-bar/search-bar';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    CommonModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    NgOptimizedImage,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatMenuModule,
    MatBadgeModule,
    RouterLink,
    SearchBar
  ],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header {
  address: string = 'Hortolandia - SP 13183250';
  searchTerm = '';
  searchFocused = false;
  protected cartItemCount: number = 4;
  showMenu = false;

  constructor(private popupService: PopupService, private el: ElementRef) {}

  @HostListener('document:mousemove', ['$event'])
  onMouseMove(event: MouseEvent) {
    if (!this.el.nativeElement.contains(event.target as Node)) {
      this.showMenu = false;
    }
  }

  openCepModal() {
    this.popupService.updateCep();
  }

  closeCepModal() {
    this.popupService.closeUpdateCep();
  }

  loginRegister(): void {}

  goToCart(): void {}
}
