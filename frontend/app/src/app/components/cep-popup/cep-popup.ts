import { Component } from '@angular/core';
import { PopupService } from '../../services/cep/popup.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cep-popup',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cep-popup.html',
  styleUrl: './cep-popup.css',
})
export class CepPopup {
  constructor(public popupService: PopupService) {}
}
