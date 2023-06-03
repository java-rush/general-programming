import { Component } from '@angular/core'
// eslint-disable-next-line @typescript-eslint/consistent-type-imports
import { ProductService } from './product/product.service'
import { type Product } from './product/product'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Product Warehouse'
  products: Product[] = []
  productName: string = ''
  productText: string = ''

  constructor (private readonly productService: ProductService) {}

  getAllProducts = (): void => {
    this.productService.getAllProducts().subscribe((response) => {
      console.log(response)
      this.products = response
    })
  }

  getProductByName (): void {
    console.log({ productName: this.productName })

    this.productService
      .getProductByName(this.productName)
      .subscribe((product) => {
        this.products = [product]
      })
  }

  getWarrantyExpiredProducts = (): void => {
    this.productService.getWarrantyExpiredProducts().subscribe((response) => {
      console.log(response)
      this.products = response
    })
  }

  getProductsByText = (): void => {
    this.productService
      .getProductsByText(this.productText)
      .subscribe((response) => {
        this.products = response
      })
  }
}
