import ls from "local-storage";

const EMAIL = "email";
const ACCESS_TOKEN = "access-token";

export default class StorageSerivce {

    static async getAccessToken() {
        return await ls.get(ACCESS_TOKEN);
    }

    static async setAccessToken(accessToken) {
        await ls.set(ACCESS_TOKEN, accessToken);   
    }

    static async removeAccessToken() {
        await ls.remove(ACCESS_TOKEN);
    }

    static async getEmail() {
        return await ls.get(EMAIL);
    }

    static async setEmail(email) {
        await ls.set(EMAIL, email);
    }

    static async removeEmail() {
        await ls.remove(EMAIL);
    }
}