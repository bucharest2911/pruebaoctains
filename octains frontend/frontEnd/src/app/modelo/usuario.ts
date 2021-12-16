import { Rol } from "./Rol";


export class Usuario {
    idUsuario:number;
    rol:Rol;
    nombreUsuario:String;
    activo:String;

    constructor(){
        this.idUsuario=0;
        this.rol=new Rol();
        this.nombreUsuario="";
        this.activo="";
    }
}