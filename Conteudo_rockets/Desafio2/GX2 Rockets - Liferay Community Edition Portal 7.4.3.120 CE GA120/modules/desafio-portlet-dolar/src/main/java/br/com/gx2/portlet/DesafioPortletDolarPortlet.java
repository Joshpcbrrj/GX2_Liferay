package br.com.gx2.portlet;

import br.com.gx2.constants.DesafioPortletDolarPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

/**
 * @author Josué B. Almeida
 */
@Component(
		property = {
				"com.liferay.portlet.display-category=category.sample",
				"com.liferay.portlet.header-portlet-css=/css/main.css",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.display-name=DesafioPortletDolar",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/view.jsp",
				"javax.portlet.name=" + DesafioPortletDolarPortletKeys.DESAFIOPORTLETDOLAR,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)
public class DesafioPortletDolarPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		String urlString = "http://localhost:8080/o/dollar-api/dollarRate"; // URL do módulo REST corrigida
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuilder content = new StringBuilder();

			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}

			in.close();
			conn.disconnect();

			// Parseia a resposta como JSON
			JSONObject jsonResponse = new JSONObject(content.toString());

			// Verifique se a chave USD_BRL está disponível na resposta
			if (jsonResponse.has("USD_BRL")) {
				double dollarRate = jsonResponse.getDouble("USD_BRL");

				// Atribui a taxa de câmbio ao request como Double
				renderRequest.setAttribute("dollarRate", dollarRate);
			} else {
				renderRequest.setAttribute("dollarRateError", "Erro ao buscar a cotação.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			renderRequest.setAttribute("dollarRateError", "Erro ao buscar a cotação: " + e.getMessage());
		}

		super.doView(renderRequest, renderResponse);
	}
}
