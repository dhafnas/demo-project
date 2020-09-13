import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class FeatureRequestsService {

  constructor(private http: HttpClient) { 

  }
  getFeatureRequest() {
    return this.http.get('/demo/v1/feature/requests',{observe:'response',responseType:'json'})
  }
  createFeatureRequest(featureRequest: any) {
    return this.http.post<any>('/demo/v1/feature/requests', featureRequest)
  }
}
