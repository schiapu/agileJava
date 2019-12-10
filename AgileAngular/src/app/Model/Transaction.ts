export class Transaction{
    id:String;
    date:Date;
    amount:number;
    type:String;

    constructor(amount: number, type: String){
        this.amount = amount;
        this.type = type;
    }
}