import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from "rxjs";
import { Usuario } from "../modelo/usuario";
 

@Injectable({
    providedIn: 'root'
})
export class UsuarioService{
 
     url:String=`http://localhost:8080/api/octans/usuario`
    constructor(private http: HttpClient){
        this.http.get('http://localhost:8080/api/octans/usuario/users')
    } 

    public  findAll():Observable<Usuario[]>{
      return     this.http.get<Usuario[]>('http://localhost:8080/api/octans/usuario/users')
    }

    public findUser(id:number):Observable<Usuario>{

       
      return this.http.get<Usuario>(`${this.url}/getUser?idUsuario=${id}`)
    }
    public addUser(usuario:any):Observable<any>{

    return this.http.post(`${this.url}/saveUser`,usuario);
    }
}