export class Rol{

    idRol:number=0;
    nombreRol:String='';

    Rol(){
         this.nombreRol='';
         this.idRol=0
    }
    setNombre(nombre:String){
this.nombreRol=nombre;
    }
    setIdRol(idRol:number){
        this.idRol=idRol
    }


}