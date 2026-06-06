export interface Review {
  rating: number;
  count: number;
}

export interface Product {
  id: number;
  name: string;
  image: string;
  alt: string;
  price: number;
  oldPrice: number;
  review: Review;
}
