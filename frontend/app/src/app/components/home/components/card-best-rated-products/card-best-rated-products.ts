import {Component, CUSTOM_ELEMENTS_SCHEMA, Input} from '@angular/core';
import {CommonModule, NgOptimizedImage} from '@angular/common';
import { Product } from '../../../../models/product.model';

@Component({
  selector: 'app-card-best-rated-products',
  standalone: true,
  imports: [CommonModule, NgOptimizedImage],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  templateUrl: './card-best-rated-products.html',
  styleUrl: './card-best-rated-products.css'
})
export class CardBestRatedProducts {
  products: Product[] = [
    {
      id: 1,
      name: 'Apple iPhone 15 Pro 256GB Titânio Natural',
      image: 'avaliados-preco/iphone15.avif',
      alt: 'Iphone 15',
      price: 6999.99,
      oldPrice: 8499.99,
      review: { rating: 4.8, count: 2341 }
    },
    {
      id: 2,
      name: 'Samsung Galaxy S24 Ultra 512GB Preto',
      image: 'avaliados-preco/samsung.png',
      alt: 'Samsung Galaxy S24',
      price: 5799.99,
      oldPrice: 7299.99,
      review: { rating: 4.7, count: 1876 }
    },
    {
      id: 3,
      name: 'Dell Alienware m18 R2 Intel Core i9 RTX 4090',
      image: 'avaliados-preco/dell-alienware.webp',
      alt: 'Dell Alienware m18 R2 Intel Core',
      price: 24999.99,
      oldPrice: 29999.99,
      review: { rating: 4.6, count: 543 }
    },
    {
      id: 4,
      name: 'Sony WH-1000XM5 Headphone Bluetooth Noise Cancelling',
      image: 'avaliados-preco/sony-headphone.avif',
      alt: 'Sony-headphone',
      price: 1899.99,
      oldPrice: 2499.99,
      review: { rating: 4.9, count: 4120 }
    },
    {
      id: 5,
      name: 'LG OLED 55" 4K Smart TV 120Hz',
      image: 'avaliados-preco/smart-tv-lg.png',
      alt: 'LG OLED 55',
      price: 4299.99,
      oldPrice: 5999.99,
      review: { rating: 4.7, count: 987 }
    },
    {
      id: 6,
      name: 'iPad Pro M4 11" 256GB Wi-Fi Space Black',
      image: 'avaliados-preco/ipad.webp',
      alt: 'iPad Pro M4 11',
      price: 8999.99,
      oldPrice: 10499.99,
      review: { rating: 4.8, count: 1203 }
    },
    {
      id: 7,
      name: 'Logitech MX Master 3S Mouse Sem Fio',
      image: 'avaliados-preco/logitech-mouse.avif',
      alt: 'Logitech-mouse',
      price: 699.99,
      oldPrice: 899.99,
      review: { rating: 4.6, count: 3410 }
    },
    {
      id: 8,
      name: 'Samsung 990 Pro SSD NVMe 2TB M.2',
      image: 'avaliados-preco/ssd-samsung.jpg',
      alt: 'Samsung 990 Pro SSD NVMe 2TB M.2',
      price: 899.99,
      oldPrice: 1199.99,
      review: { rating: 4.7, count: 2198 }
    }
  ];

  formatPrice(price: number): string {
    return price.toLocaleString('pt-BR', { minimumFractionDigits: 2 });
  }
}
