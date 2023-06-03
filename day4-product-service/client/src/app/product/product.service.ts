// eslint-disable-next-line @typescript-eslint/consistent-type-imports
import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core'
import { type Product } from './product'
import { type Observable } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  getProductsByText (productText: string): Observable<Product[]> {
    return this.http.get<Product[]>('/products', {
      params: {
        text: productText
      }
    })
  }

  getProductByName (productName: string): Observable<Product> {
    return this.http.get<Product>('/products/' + productName)
  }

  constructor (private readonly http: HttpClient) { }

  getAllProducts (): Observable<Product[]> {
    return this.http.get<Product[]>('/products')
  }

  getWarrantyExpiredProducts (): Observable<Product[]> {
    return this.http.get<Product[]>('/products/warranty/expired')
  }

  addProduct (product: Product): Observable<Product> {
    return this.http.post<Product>(
      '/products',
      product
    )
  }
}
