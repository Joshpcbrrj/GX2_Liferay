# Desafio Mostra hora utc

<details>
    <summary> Classes estudadas para fazer o desafio:</summary>

Para desenvolver um portlet no Liferay que exiba a data e hora atuais e permita ao usuário configurar o UTC, é fundamental compreender algumas classes e conceitos essenciais. Abaixo, esta a lista dessas classes, acompanhadas de exemplos simples de uso:

1. **`MVCPortlet`**:
    - Esta é uma classe base que simplifica o desenvolvimento de portlets seguindo o padrão MVC (Model-View-Controller). Ela herda da classe `GenericPortlet` e adiciona suporte para ações e navegação entre visualizações.
    
    ```java
    public class MeuPortlet extends MVCPortlet {
        // Métodos e funcionalidades específicos do portlet
    }
    ```
    
<br>

2. **`ThemeDisplay`**:
    - Esta classe fornece informações sobre o contexto da solicitação, incluindo detalhes sobre o usuário logado, a comunidade, o layout e outros aspectos relacionados ao portal.
    
    ```java
    ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
    long userId = themeDisplay.getUserId();
    ```

<br>

3. **`User`**:
    - Representa o usuário no sistema. É usado para obter e atualizar informações relacionadas ao usuário, como preferências e fusos horários.
    
    ```java
    User user = UserLocalServiceUtil.getUser(userId);
    String emailAddress = user.getEmailAddress();
    ```

<br>

4. **`UserLocalServiceUtil`**:
    - Esta classe fornece métodos utilitários para acessar e manipular objetos `User`, utilizados para recuperar e atualizar informações do usuário.
    
    ```java
    User user = UserLocalServiceUtil.getUser(userId);
    ```

<br>

5. **`PortletPreferences`**:
    - Utilizada para armazenar e recuperar preferências específicas do portlet. As preferências são persistentes entre sessões do usuário e reinicializações do portal.
    
    ```java
    PortletPreferences preferences = renderRequest.getPreferences();
    String preferredLanguage = preferences.getValue("preferredLanguage", "en_US");
    ```

<br>

6. **`TimeZoneUtil`**:
    - Esta classe oferece métodos utilitários para lidar com fusos horários. É útil para obter o fuso horário padrão do servidor e converter IDs de fusos horários.
    
    ```java
    TimeZone defaultTimeZone = TimeZoneUtil.getDefault();
    String defaultTimeZoneId = defaultTimeZone.getID();
    ```

<br>

7. **`ZoneId` e `ZonedDateTime`**:
    - Estas são classes da API de data e hora do Java 8, que permitem manipular e formatar datas e horas em fusos horários específicos.
    
    ```java
    ZoneId zoneId = ZoneId.systemDefault();
    ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
    ```

<br>

8. **Java 8 Date/Time API**:
    - A API de data e hora do Java 8 (`java.time`) é usada para manipular datas e horas de forma mais moderna e eficiente.
    - As classes `LocalDateTime`, `ZoneId` e `DateTimeFormatter` são usadas para obter e formatar a data e hora atual de acordo com o fuso horário do usuário.
    
    **Exemplo de manipulação de data e hora em Java 8:**
    
    ```java
    LocalDateTime currentTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedDateTime = currentTime.format(formatter);
    ```

<br>

9. **JSP e Taglibs (`portlet`, `aui`, `c`)**:
    - O JSP é usado para criar a interface do usuário do portlet. As Taglibs como `portlet`, `aui` (AlloyUI) e `c` (JSTL) são utilizadas para integrar funcionalidades específicas do Liferay e Java EE.
    
    ```
    <aui:button type="submit" value="Enviar" />
    ```

</details>

<br>

<details>
    <summary>Passo a passo com imagens de como criar modulo no liferay: </summary>

### Tutorial em imagem:

<img src="/Conteudo_rockets/Desafio1/2/0 - Criação do modulo.jpg" alt="Minha imagem de exemplo"> 
 
<img src="/Conteudo_rockets/Desafio1/2/1 - Criação do modulo passo 1.jpg" alt="Minha imagem de exemplo">

<img src="/Conteudo_rockets/Desafio1/2/2 - Criação do modulo passo 2.jpg" alt="Minha imagem de exemplo">

<img src="/Conteudo_rockets/Desafio1/2/3 - Criação do modulo passo 3.jpg" alt="Minha imagem de exemplo">

<img src="/Conteudo_rockets/Desafio1/2/4 - Fazer o build da classe.jpg" alt="Minha imagem de exemplo">

</details>

<br>

## Código: portlet_simplesPortlet.java

```java
package gx2.com.br.portlet;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

// Classe principal do portlet para exibir o relógio
public class portlet_simplesPortlet extends MVCPortlet {

	// Método chamado ao renderizar a view do portlet
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		// Obtém o contexto da solicitação
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// Obtém o usuário logado
		User user = themeDisplay.getUser();

		// Obtém o ID do fuso horário do usuário
		String utcTimeZoneId = user.getTimeZoneId();
		// Converte o ID do fuso horário para ZoneId
		ZoneId userZoneId = ZoneId.of(utcTimeZoneId);
		// Obtém a data e hora atual no fuso horário do usuário
		LocalDateTime currentTime = LocalDateTime.now(userZoneId);
		// Formata a data e hora atual
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Converte a data e hora formatada para uma string
		String currentTimeString = currentTime.format(formatter);

		// Define o atributo para exibir na view
		renderRequest.setAttribute("currentTime", currentTimeString);

		// Chama a implementação padrão do doView
		super.doView(renderRequest, renderResponse);
	}

	// Método chamado ao processar a ação do portlet
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		// Obtém as preferências do portlet
		PortletPreferences preferences = actionRequest.getPreferences();

		// Obtém o novo valor do fuso horário selecionado pelo usuário
		String userSelectedUTC = ParamUtil.getString(actionRequest, "userSelectedUTC", "");

		// Se um novo fuso horário foi selecionado
		if (!userSelectedUTC.isEmpty()) {
			// Atualiza a preferência de fuso horário do usuário
			preferences.setValue("userTimeZoneId", userSelectedUTC);
			preferences.store();
		}

		// Chama a implementação padrão do processAction
		super.processAction(actionRequest, actionResponse);
	}

```

<br>

## Código: view.jsp

```jsp
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<portlet:defineObjects />

<!-- Define um ID único para o contêiner do portlet -->
<div id="<portlet:namespace />portlet_simplesPortlet">
    <h2>Data e Hora Atual</h2>
    <!-- Exibe a hora atual em Brasília -->
    <p>A hora atual em Brasília é: ${currentDateTime}</p>

    <h3>Alterar UTC</h3>
    <!-- Formulário para selecionar e atualizar o fuso horário -->
    <aui:form action="<portlet:actionURL name='updateUserTimeZone' />" method="post">
        <!-- Dropdown para selecionar o fuso horário -->
        <aui:select name="selectedUTC" label="Fuso Horário">
            <!-- Itera sobre a lista de fusos horários disponíveis -->
            <c:forEach items="${timeZones}" var="timeZone">
                <!-- Define a opção de fusos horários -->
                <aui:option value="${timeZone}" <%= timeZone.equals(timeZoneId) ? "selected" : "" %>>
                    ${timeZone}
                </aui:option>
            </c:forEach>
        </aui:select>
        <!-- Botão para submeter o formulário e atualizar o fuso horário -->
        <aui:button type="submit" value="Atualizar Fuso Horário" />
    </aui:form>
</div>

```

<br>

<br>

[Voltar ao menu desafio 1](/Conteudo_rockets/Desafio1/Desafio1.md)