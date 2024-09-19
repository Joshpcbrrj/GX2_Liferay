# Passo a passo para criar a API Dollar (Busca informações do câmbio em tempo real)


## 1 - Criar modulo rest 
- **Nome do módulo:** desafio-api-dollar
- **Nome do pacote:** br.com.gx2
- **Nome da classe:** restApplication

<details>
  <summary>Prints</summary>
  
</details>

<br>

## 2 - Criar conta no site `currencylayer` para obter cotação via API
- [Link do site currencylayer](https://currencylayer.com/)
<details>
  <summary>Prints</summary>
  
</details>

<br>

## 3 - Implementar a classe restApplication para acessar a API currencylayer 

- **Caminho da classe:** modules\desafio-api-dolar\src\main\java\br\com\gx2\application\restApplication.java

<details>
  <summary>Código da classe restApplication.java</summary>

  ```java
package br.com.gx2.application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

// Definimos essa classe como um componente OSGi para ser uma aplicação REST no Liferay
@Component(
    immediate = true,
    property = {
        // Definimos a URL base do nosso endpoint
        JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/dollar-api",
        // Definimos o nome da aplicação REST
        JaxrsWhiteboardConstants.JAX_RS_NAME + "=Dollar-api.Rest"
    },
    service = Application.class
)
public class restApplication extends Application {

    // Chave de acesso à API currencylayer (substitua pela sua chave)
    private static final String ACCESS_KEY = "sua_access_key_aqui";

    // Retorna a instância singleton dessa classe para ser usada nas requisições
    @Override
    public Set<Object> getSingletons() {
        return Collections.<Object>singleton(this);
    }

    // Método que retorna a cotação do dólar para o Real (BRL)
    @GET
    @Path("/dollarRate")
    @Produces("application/json")
    public Response getDollarRate() {
        // Aqui chamamos o método que consulta a API passando "BRL" como moeda de destino
        return getDollarRateForCurrency("BRL");
    }

    // Método que permite consultar a cotação do dólar para qualquer moeda usando um parâmetro de caminho
    @GET
    @Path("/dollarRate/{currency}")
    @Produces("application/json")
    public Response getDollarRateForCurrency(@PathParam("currency") String currency) {
        // Construímos a URL para fazer a requisição à API, passando a chave de acesso e a moeda desejada
        String urlString = "http://api.currencylayer.com/live?access_key=" + ACCESS_KEY + "&currencies=" + currency + "&source=USD&format=1";
        try {
            // Abrimos uma conexão HTTP com a API
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Lemos a resposta da API linha por linha
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Fechamos o buffer e a conexão
            in.close();
            conn.disconnect();

            // Convertemos a resposta da API em um objeto JSON
            JSONObject json = new JSONObject(content.toString());

            // Verificamos se a resposta da API foi bem-sucedida
            if (json.getBoolean("success")) {
                // Extraímos a cotação da moeda solicitada
                double dollarToCurrency = json.getJSONObject("quotes").getDouble("USD" + currency);
                // Retornamos a cotação em formato JSON
                return Response.ok("{\"USD_" + currency + "\": " + dollarToCurrency + "}").build();
            } else {
                // Se houver um erro na resposta da API, retornamos uma mensagem de erro
                return Response.status(500).entity("Error fetching exchange rate: " + json.getString("error")).build();
            }

        } catch (Exception e) {
            // Capturamos qualquer exceção e retornamos uma mensagem de erro
            e.printStackTrace();
            return Response.status(500).entity("Error occurred: " + e.getMessage()).build();
        }
    }
}
```
  
</details>

#### Explicação
- Componentes OSGi e JAX-RS: O código registra a classe restApplication como um serviço REST usando o padrão JAX-RS. A URL base da API será acessível em /o/dollar-api.
  
- Requisição HTTP: O método principal do código abre uma conexão com a API currencylayer, faz uma requisição GET e processa o retorno JSON.
  
- Consulta de Moedas: Dois endpoints são definidos, um para consultar o dólar em relação ao Real (BRL) e outro para qualquer moeda, permitindo flexibilidade na consulta.

<br>
<br>
<br>

[Voltar para a página do projeto](/Conteudo_rockets/Desafio2/GX2%20Rockets%20-%20Liferay%20Community%20Edition%20Portal%207.4.3.120%20CE%20GA120/README.md) <br>

[Voltar inicio](/README.md)