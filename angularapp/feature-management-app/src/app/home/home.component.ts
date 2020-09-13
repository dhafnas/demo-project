import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import { FeatureRequestsService } from '../feature-requests.service'
import {Subject} from 'rxjs';
import {debounceTime} from 'rxjs/operators';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  private _success = new Subject<string>();
  form;
  model: NgbDateStruct;
  //This needs to be fetch from server
  clients = ['Client 1','Client 2','Client 3','Client 4','Client 5'];
  productModules = ['Policies','Billing','Claims','Reports'];
  successMessage='';
  staticAlertClosed = false;
  constructor(private formBuilder: FormBuilder,private featureService:FeatureRequestsService ) { 
    this.form = this.formBuilder.group({
      title: '',
      description: '',
      client: '',
      priority:'',
      productArea:'',
      targetDate:null
    });
  }
  ngOnInit(): void {
    setTimeout(() => this.staticAlertClosed = true, 20000);
    this._success.subscribe(message => this.successMessage = message);
    this._success.pipe(
      debounceTime(5000)
    ).subscribe(() => this.successMessage = '');
  }
  onSubmit(data) {
    this.featureService
              .createFeatureRequest(data)
              .subscribe(response=>{
                this._success.next(`Feature request successfully saved.`);
                this.form.reset();
            })
  }

}
