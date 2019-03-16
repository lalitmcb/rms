import StorageService from "./StorageService.js";

const axios = require('axios');
const baseUrl = 'http://localhost:8080/';

export class ApiResponseError extends Error {
    constructor(err) {
        super(err.message);
        super.name = "ApiErrResponseError";
        this.response = err.response;
        this.responseError = err.response.data.error;
    }
}

export class ApiService {

    static getAbsoluteURL(endpoint) {
        return baseUrl + endpoint;
    }
    
    static async postWithNoAuth(endpoint, request) {
        return await this.sendNoAuthRequest('POST', endpoint, request);
    }

    static async sendRequest(method, endpoint, body) {
        return await this._sendRequest(method, endpoint, body, true);
    }

    static async sendNoAuthRequest(method, endpoint, body) {
        return await this._sendRequest(method, endpoint, body, false);
    }

    static async _sendRequest(method, endpoint, body, useAuth) {
        console.log("URL to call: " + endpoint);
        const url = this.getAbsoluteURL(endpoint);
        let payload = "";
        let headers = {
            "Accept": "application/json",
            "Content-Type": "application/json"
        };

        if (useAuth) {
            headers["poc-authorization"] = await StorageService.getAccessToken();
        }

        let request = {
            url: url,
            method: method,
            headers: headers,
            data: body
        };

        try {
            payload = await axios(request);
        } catch (err) {
            if (err.response) {
                // The request was made and the server responded with a status code
                // that falls out of the range of 2xx
                console.log("inside api errror");
                throw new ApiResponseError(err);
            } else if (err.request) {
                // The request was made but no response was received
                // Do something meaningful !!
                console.log("No response received.");
                throw err;
            } else {
                // Something happened in setting up the request that triggered an Error
                // Ideally, this should not happen !
                console.log('Error while setting up request', err.message);
                throw err;
            }

        }
        console.log("Payload" + JSON.stringify(payload));

        return payload.data;
    }
}