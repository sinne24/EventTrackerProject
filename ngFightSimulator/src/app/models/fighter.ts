export class Fighter {

  id: number;
  name: string;
  desc: string;
  img: string;

  constructor(
    id: number = 0,
    name: string = '',
    desc: string = '',
    img: string = '',
  ){
    this.id = id;
    this.name = name;
    this.desc = desc;
    this.img = img;
  }
}
