import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { environment } from '../../environments/environment.development';

@Component({
  selector: 'app-dogs',
  imports: [CommonModule, FormsModule],
  templateUrl: './dogs.component.html',
  styleUrl: './dogs.component.css',
})
export class DogsComponent implements OnInit {
  newDogName: string = '';
  dogs: { name: string }[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.getDogs();
  }

  getDogs() {
    this.http
      .get<{ name: string }[]>(environment.apiUrlB + '/dogs')
      .subscribe((data) => {
        this.dogs = data;
      });
  }

  addDog() {
    if (this.newDogName.trim()) {
      const newDog = { name: this.newDogName };
      this.http
        .post<{ name: string }>(environment.apiUrlB + '/dogs/dog', newDog)
        .subscribe((data) => {
          this.dogs.push(data);
          this.newDogName = '';
        });
    }
  }
}
