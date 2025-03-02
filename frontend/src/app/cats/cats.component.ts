import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment.development';
import { Cat } from '../models/cats';

@Component({
  selector: 'app-cats',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './cats.component.html',
  styleUrls: ['./cats.component.css'],
})
export class CatsComponent implements OnInit {
  newCatName: string = '';
  cats: Cat[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.getCats();
  }

  getCats() {
    this.http
      .get<Cat[]>(environment.apiUrlA + '/cats')
      .subscribe((data) => {
        this.cats = data;
      });
  }

  addCat() {
    if (this.newCatName.trim()) {
      const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
      this.http
        .post<Cat>(
          environment.apiUrlA + '/cats/cat',
          new Cat(this.newCatName),
          { headers: headers }
        )
        .subscribe((data) => {
          this.cats.push(data);
          this.newCatName = '';
        });
    }
  }
}
