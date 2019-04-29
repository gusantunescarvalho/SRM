import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgxMaskModule } from 'ngx-mask';
import { CustomerService } from '../service/customer-service.service';
import { Customer } from '../model/customer';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit {

  customer: Customer;

  constructor(private route: ActivatedRoute, private router: Router, private customerService: CustomerService) {
    this.customer = new Customer();
    this.customer.risk = "A";
    this.customer.interest = 0;
  }

  onSubmit() {
    this.customerService.save(this.customer).subscribe(result => this.gotoCustomerList());
  }

  gotoCustomerList() {
    this.router.navigate(['/customer']);
  }

  ngOnInit() {
  }

  onChangeRisk(riskValue:string) {
    if (riskValue == 'B') this.customer.interest = 0;
    if (riskValue == 'B') this.customer.interest = 10;
    if (riskValue == 'C') this.customer.interest = 20;
  }

}
