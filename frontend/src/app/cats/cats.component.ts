import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment.development';

@Component({
  selector: 'app-cats',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './cats.component.html',
  styleUrls: ['./cats.component.css'],
})
export class CatsComponent implements OnInit {
  newCatName: string = '';
  cats: { name: string }[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.getCats();
  }

  getCats() {
    this.http
      .get<{ name: string }[]>(environment.apiUrlA + '/cats')
      .subscribe((data) => {
        this.cats = data;
      });
  }

  addCat() {
    if (this.newCatName.trim()) {
      const newCat = { name: this.newCatName };
      this.http
        .post<{ name: string }>(
          environment.apiUrlA + 'https://api.example.com/cats',
          newCat
        )
        .subscribe((data) => {
          this.cats.push(data);
          this.newCatName = '';
        });
    }
  }
}
