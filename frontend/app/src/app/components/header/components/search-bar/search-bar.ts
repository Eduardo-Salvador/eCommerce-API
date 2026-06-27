import { Component, HostListener, ElementRef, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-search-bar',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './search-bar.html',
  styleUrl: './search-bar.css'
})
export class SearchBar {
  query = '';
  focused = false;

  @Output() focusChange = new EventEmitter<boolean>();

  onFocus() {
    this.focused = true;
    this.focusChange.emit(true);
  }

  onBlur() {
    this.focused = false;
    this.focusChange.emit(false);
  }

  @HostListener('document:click', ['$event'])
  onClickFora(event: MouseEvent) {
    if (!this.el.nativeElement.contains(event.target)) {
      this.focused = false;
      this.focusChange.emit(false);
    }
  }
  constructor(private el: ElementRef) {}
}
