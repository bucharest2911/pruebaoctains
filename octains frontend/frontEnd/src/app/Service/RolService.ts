import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams, HttpParamsOptions } from '@angular/common/http';
import { Observable } from "rxjs";
import { Rol } from "../modelo/Rol";

@Injectable({
    providedIn:'any'
})
export class RolService{

url:String=`http://localhost:8080/api/octans/rol`
constructor(private http:HttpClient){


}

public findAllRol():Observable<Rol[]>{
    return this.http.get<Rol[]>(`${this.url}/getRols`)
}

}