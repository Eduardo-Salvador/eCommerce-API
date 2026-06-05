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
    MatBadgeModule
  ],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header {
  address: string = 'Hortolandia - SP 13183250';
  searchTerm = '';
  protected cartItemCount: number = 4;

  updateCep() {
    console.log("Update Cep");
  }

  loginRegister(): void {

  }

  goToCart():void {}
}
