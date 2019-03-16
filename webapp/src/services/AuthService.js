import endpoint from './UrlEndpoints'
import StorageService from "./StorageService";
import {ApiService} from './ApiService';

export default class AuthService {

    static async isAuthenticated(){
        const token = await StorageService.getAccessToken();
        if(token !== null && token.length > 0){
            return true;
        }
        else{
            return false;
        }
    }

    static async logout(){
        await StorageService.removeAccessToken();
    }

    static async login(email, password) {
        const request = {
            "email": email,
            "password": password
        };
        try{
            const resp = await ApiService.postWithNoAuth(endpoint.LOGIN, request);
            await StorageService.setAccessToken(resp.RMSAuthorization)
            await StorageService.setEmail(email)
        }catch(error){
            throw error
        }
    }
}