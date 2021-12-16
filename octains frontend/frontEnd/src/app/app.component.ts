import { Component } from '@angular/core';
 
import { Rol } from './modelo/Rol';
import { Usuario } from './modelo/usuario';
import { RolService } from './Service/RolService';
import { UsuarioService } from './Service/UsuarioService';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontEnd';
usuarios:Usuario[]=[];
roles:Rol[]=[]
rol:Rol=new Rol();
rolSeleccionado:Rol=new Rol();
 activo:boolean=false
 usuario:Usuario=new Usuario()

 
 nombreRol:String="";
 
  constructor(private usuarioServicio:UsuarioService,private rolServicio:RolService){
  this.usuario=new Usuario();
 
 this.usuarioServicio.findAll().subscribe(data=> this.usuarios=data  
  
   
  
  )

  this.rolServicio.findAllRol().subscribe(data=>{
    this.roles=data
    console.log(this.roles)
  })
   
  }

   public cambiar():void{
  this.activo=false

   }
   public cargar(id:number):void{
 this.usuarioServicio.findUser(id).subscribe(data=>{
  this.usuario=data
  this.nombreRol=this.usuario.rol.nombreRol
  console.log(this.usuario,this.nombreRol)
  
 
 })
   }
   public saveUser():void{
console.log(this.rolSeleccionado.idRol)
    let usuarioDTO={

      
      "nombreUsuario":this.usuario.nombreUsuario,
      "activo":"S",
      "idRol":this.rolSeleccionado.idRol
    }
     this.usuarioServicio.addUser(usuarioDTO).subscribe(data=>{
       console.log(data)
     })

     
   }

   public displayRol(rol:Rol):void{
console.log(rol)
   } 


   public setRol(rol:Rol){
 console.log(rol.idRol)
   }
   


}
