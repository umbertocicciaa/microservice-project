import { CommonModule } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { environment } from '../../environments/environment.development';
import { Dog } from '../models/dogs';

@Component({
  selector: 'app-dogs',
  imports: [CommonModule, FormsModule],
  templateUrl: './dogs.component.html',
  styleUrl: './dogs.component.css',
})
export class DogsComponent implements OnInit {
  newDogName: string = '';
  dogs: Dog [] = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.getDogs();
  }

  getDogs() {
    this.http
      .get<Dog[]>(environment.apiUrlB + '/dogs')
      .subscribe((data) => {
        this.dogs = data;
      });
  }

  addDog() {
    if (this.newDogName.trim()) {
      const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
      this.http
        .post<Dog>(
          environment.apiUrlB + '/dogs/dog',
          new Dog(this.newDogName),
          { headers: headers }
        )
        .subscribe((data) => {
          this.dogs.push(data);
          this.newDogName = '';
        });
    }
  }
}
