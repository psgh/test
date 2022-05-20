import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Customer } from '../../model/Customer';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-dual-use',
  templateUrl: './dual-use.component.html',
  styleUrls: ['./dual-use.component.css'],
})
export class DualUseComponent implements OnInit {
  phoneNumberPattern = /^\+?\d+$/;
  emailPattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

  @Input() customerData!: Customer;
  @Input() title: String = '';
  @Input() readOnly: boolean = true;
  @Input() showFormButton = 'none';
  @Input() display: boolean = false;

  @Output() closeDialogEvent = new EventEmitter<any>();
  @Output() addCustomerEvent = new EventEmitter<any>();
  @Output() refreshRequest = new EventEmitter();

  maxDate: any;

  constructor(datePipe: DatePipe) {
    const dateFormat = 'yyyy-MM-dd';
    this.maxDate = datePipe.transform(
      new Date().setDate(new Date().getDate() - 1),
      dateFormat
    );
  }

  ngOnInit(): void {}

  private refresh() {
    this.refreshRequest.emit();
  }

  public closeDialog(form: NgForm): void {
    if (this.readOnly === false) {
      this.refresh();
    }
    this.closeDialogEvent.emit();
    setTimeout(() => {
      form.reset();
    }, 100);
  }

  public addCustomer(form: NgForm): void {
    this.addCustomerEvent.emit(form);
  }
}
