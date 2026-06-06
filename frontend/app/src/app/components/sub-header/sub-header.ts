import { Component } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-sub-header',
  imports: [MatToolbarModule, RouterLink],
  templateUrl: './sub-header.html',
  styleUrl: './sub-header.css',
})
export class SubHeader {}
