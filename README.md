
> [!NOTE] 
> O aplicativo estável, pode ser encontrado aqui:
> `app/build/outputs/apk/release/app-release.apk`
> Se preferir, pode acessar https://github.com/Jetrom17/WIG/actions selecionar primeira alterção concluída e baixar o aplicativo no modo debug.

<p align="center">
  <img src="https://i.imgur.com/cwHOf2X.png" width="500" />
</p>

Criei o aplicativo usando [Sketchware Pro](https://sketchware.pro/). Depois enviei para meu PC, fiz algumas alterações, como `license`, `Workflow`, assinatura do aplicativo e compilação do código, sem uso do Android Studio. Você pode está contribuindo pelo Sketchware Pro baixando o arquivo no [Sketchub,in](https://sketchub.in) pelo nome _Where is Git?_ ou acessando diretamente pela web: https://web.sketchub.in/p/27785

## Features:

- [x] Github.io
- [x] PT_BR, EN, AR, HI.
- [ ] Netlify.
- [ ] Vercal.
- [ ] Cloudflare Pages.

## Como funciona?

Onde está o Git? Você pode ter encontrado um site hospedado no Github, mas não conseguiu encontrar o repositório. Este aplicativo automatiza isso para você, decodificando a URL e encontrando o repositório em seu destino. Basta você informar uma url contém USERNAME e nome do REPOSITÓRIO com subdomínio Github.io. Então você será redirecionado para o repositório com código-fonte. Contém 4 idiomas quando inicia o aplicativo; pequena instrução.

> [!IMPORTANT]
> Segue para compilação do código usando Java (17).
> Espero que tenha já configurado em seu ambiente: Gradle e SdkManager.
> ```bash
> ./gradlew build
> ```
