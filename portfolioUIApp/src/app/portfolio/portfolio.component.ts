import { Component, OnInit } from '@angular/core';
import { PortfolioService } from '../portfolio.service';

@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.css']
})
export class PortfolioComponent implements OnInit {
  portfolioService: PortfolioService;
  portFolios: [];
  constructor(portfolioService: PortfolioService) { }

  ngOnInit(): void {
    setInterval(() => {
      this.portfolioService.getPortFolios('1234').subscribe(data => {
        this.portFolios = data;
      }, function(error) {
        console.log("Unable to retrieve portFolios", error);
      });

    }, 600000);
}
