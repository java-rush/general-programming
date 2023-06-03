import { NgModule } from '@angular/core'
import { CommonModule } from '@angular/common'
import { ProductListComponent } from './product-list/product-list.component'
import { ProductListItemComponent } from './product-list-item/product-list-item.component'
import { MatCardModule } from '@angular/material/card'
import { MatButtonModule } from '@angular/material/button'
import { AddProductComponent } from './add-product/add-product.component'
import { MatFormFieldModule } from '@angular/material/form-field'
import { MatInputModule } from '@angular/material/input'
import { FormsModule } from '@angular/forms'
import { MatIconModule } from '@angular/material/icon'
import { MatNativeDateModule } from '@angular/material/core'
import { MatDatepickerModule } from '@angular/material/datepicker'

@NgModule({
  declarations: [
    ProductListComponent,
    ProductListItemComponent,
    AddProductComponent
  ],
  imports: [
    CommonModule,
    MatCardModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatIconModule,
    MatNativeDateModule,
    MatDatepickerModule
  ],
  exports: [
    ProductListComponent,
    AddProductComponent
  ]
})
export class ProductModule { }
