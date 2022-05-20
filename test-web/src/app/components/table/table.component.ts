import { Component, OnInit } from '@angular/core';
import { Customer } from '../../model/Customer';
import { CustomerService } from '../../services/customer.service';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
})
export class TableComponent implements OnInit {
  customers!: Customer[];
  selectedCustomer!: Customer;
  placeholderCustomer = {} as Customer;

  first = 0;
  rows = 10;

  display: boolean = false;
  readOnly: boolean = false;
  showFormButton: string = 'none';

  title: string = '';
  titleViewing: string = 'Customer information';
  titleAdding: string = 'Enter new Customer information';

  constructor(private customerService: CustomerService) {
    this.placeholderCustomer.name = 'Enter name';
    this.placeholderCustomer.surname = 'Enter surname';
    this.placeholderCustomer.birthdate = 'Enter birthdate in format YYYY-MM-DD';
    this.placeholderCustomer.phoneNumber = 'Enter phone number';
    this.placeholderCustomer.email =
      'Enter email in format you@emailprovider.com';
  }

  ngOnInit(): void {
    this.customerService.getCustomers().subscribe((customers) => {
      this.customers = customers;
    });
  }

  addUser(form: NgForm): void {
    this.customerService.addCustomer(form.value).subscribe(
      (response: Customer) => {},
      (error: HttpErrorResponse) => {
        console.error(error.message);
      }
    );
    this.refresh();
  }

  next() {
    this.first = this.first + this.rows;
  }

  prev() {
    this.first = this.first - this.rows;
  }

  reset() {
    this.first = 0;
  }

  openViewDialog(customer: Customer): void {
    this.selectedCustomer = customer;
    this.title = this.titleViewing;
    this.display = true;
    this.readOnly = true;
  }

  openAddDialog(): void {
    this.selectedCustomer = this.placeholderCustomer;
    this.title = this.titleAdding;
    this.display = true;
    this.readOnly = false;
    this.showFormButton = 'inline';
  }

  closeDialog(): void {
    this.display = false;
    this.showFormButton = 'none';
  }

  refresh(): void {
    this.customerService.getCustomers().subscribe((customers) => {
      this.customers = customers;
    });
  }
}
