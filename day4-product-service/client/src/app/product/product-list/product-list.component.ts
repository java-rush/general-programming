import { Component, Input } from '@angular/core'
import { type Product } from '../product'

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {
  @Input()
    products: Product[] = []

  get productsAvailable (): boolean {
    return this.products.length > 0
  }
}
