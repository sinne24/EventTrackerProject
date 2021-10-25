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
  newFighter: Fighter | null = new Fighter();
  selected: Fighter | null = null;

  constructor(
    private fighterService: FighterService
  ) { }

  ngOnInit(): void {
    this.loadFighters();
  }

  reloadFighters(): void {
    this.fighterService.index().subscribe(
      fighterList => {
        this.fighters = fighterList;
      },
      fail => {
        console.error('TodoListComponent.reloadTodos(): error getting todo list');
        console.log(fail);
      }
    );
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
    //console.log(fighter);
    console.log(this.selected);
  }

  addFighter(fighter: Fighter) {
    this.fighterService.create(fighter).subscribe(
      newFighter => {
        this.reloadFighters();
        this.newFighter = new Fighter();
      },
      fail => {
        console.error(fail)
      }
    );
  }

}
