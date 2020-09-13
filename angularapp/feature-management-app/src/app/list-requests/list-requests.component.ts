import { Component, OnInit } from '@angular/core';
import { FeatureRequestsService } from '../feature-requests.service'

@Component({
  selector: 'app-list-requests',
  templateUrl: './list-requests.component.html',
  styleUrls: ['./list-requests.component.scss']
})
export class ListRequestsComponent implements OnInit {
  featurerequests : any ;
  constructor(private featureService:FeatureRequestsService) { 

  }

  ngOnInit() {
    this.featureService.getFeatureRequest().subscribe(
      response=> {
        this.featurerequests= response.body;
      }
    );
  }

}
