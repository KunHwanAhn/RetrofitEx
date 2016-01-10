# RetrofitEx
Repository for Retrofit Examples

## Project Environment
- Eclipse Mars
- Java 1.7
- Ant 1.9.6
- Ivy 2.4.0

## Used Libraries
- Download Links
- [Retrofit 2.0.0-beta2](http://central.maven.org/maven2/com/squareup/retrofit/retrofit/2.0.0-beta2/retrofit-2.0.0-beta2.jar)
- [OkHttp 2.5.0](http://central.maven.org/maven2/com/squareup/okhttp/okhttp/2.5.0/okhttp-2.5.0.jar)
- [OkIO 1.6.0](http://central.maven.org/maven2/com/squareup/okio/okio/1.6.0/okio-1.6.0.jar)
- [Converter-Gson 2.0.0-beta2](http://central.maven.org/maven2/com/squareup/retrofit/converter-gson/2.0.0-beta2/converter-gson-2.0.0-beta2.jar)
- [Gson 2.5](http://central.maven.org/maven2/com/google/code/gson/gson/2.5/gson-2.5.jar)

## How To Build This Project
1. Download required libraries 
 - If you can use Ant and Ivy
   - Open Terminal and Enter a command **ant resolve** to download required libraries
 - If you can NOT use Ant and Ivy
   - Click the links above this paragraph to download required libraries
- Add the downloaded libraries on Eclipse
- Replace a String **OAUTH2_ACCESS_TOKEN** on the [Main.java](https://github.com/KunHwanAhn/RetrofitEx/blob/github/src/com/ak/sample/retrofit/main/Main.java#L16)
   - To Get OAuth2 Token from [Github](https://https://github.com), Please refer [GithubDeveloper](https://developer.github.com/v3/oauth/)
   - You can get your own **Personal OAuth AccessToken** on [your profile](https://github.com/settings/tokens)
- **Run It**
