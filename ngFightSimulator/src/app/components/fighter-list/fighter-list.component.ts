import { Component, OnInit } from '@angular/core';
import { Fighter } from 'src/app/models/fighter';
import { FighterService } from 'src/app/services/fighter.service';

@Component({
  selector: 'app-fighter-list',
  templateUrl: './fighter-list.component.html',
  styleUrls: ['./fighter-list.component.css']
})
export class FighterListComponent implements OnInit {

  fighters: Fighter[] = [];

  selected: Fighter | null = null;

  constructor(
    private fighterService: FighterService
  ) { }

  ngOnInit(): void {
    this.loadFighters();
  }

  loadFighters(){
    this.fighterService.index().subscribe(
    fighters =>{
      this.fighters = fighters;
    },
    fail =>{
      console.error('load fighter fail');
      console.error(fail);
    }

    );
  }
  displayFighter(fighter: Fighter): void {
    this.selected = fighter;
  }

}
