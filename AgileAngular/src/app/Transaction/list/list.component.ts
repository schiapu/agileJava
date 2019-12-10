import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {ServiceService} from '../../Service/service.service'
import { Transaction } from 'src/app/Model/Transaction';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  transactions:Transaction[];
  constructor(private service:ServiceService, private router:Router) { }

  ngOnInit() {
    this.service.getTransactions().subscribe(data => {
      this.transactions = data;
    })
  }

}
