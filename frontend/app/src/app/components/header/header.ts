import { Component } from '@angular/core';
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

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    NgOptimizedImage,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatMenuModule,
    MatBadgeModule,
    RouterLink
  ],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header {
  address: string = 'Hortolandia - SP 13183250';
  searchTerm = '';
  protected cartItemCount: number = 4;

  constructor(private popupService: PopupService) {}

  openCepModal() {
    console.log('openCepModal');
    this.popupService.updateCep();
  }

  closeCepModal() {
    this.popupService.closeUpdateCep();
  }

  loginRegister(): void {  }

  goToCart():void {}
}
