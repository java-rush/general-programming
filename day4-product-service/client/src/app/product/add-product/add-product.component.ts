import { Component } from '@angular/core'
import { type Product } from '../product'
// eslint-disable-next-line @typescript-eslint/consistent-type-imports
import { ProductService } from '../product.service'

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent {
  product: Product = {
    id: 0,
    name: '',
    type: '',
    location: '',
    warranty: new Date()
  }

  constructor (private readonly productService: ProductService) { }

  addProduct (): void {
    if (this.validateProduct(this.product)) {
      this.productService.addProduct(this.product)
        .subscribe(response => {
          alert(`Added ${response.name} with id ${response.id}`)
        })
    }
  }

  validateProduct (product: Product): boolean {
    if (product.name.length === 0) {
      alert('Product name can not be empty')
      return false
    }
    if (product.type.length === 0) {
      alert('Product type can not be empty')
      return false
    }
    if (product.location.length === 0) {
      alert('Product location can not be empty')
      return false
    }
    return true
  }
}
