/* 
 * Copyright 2014, Emanuel Rabina (http://www.ultraq.net.nz/)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nz.net.ultraq.thymeleaf;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A simple servlet that spins up a Thymeleaf template engine, and uses it to
 * serve Thymeleaf templates as requested by the URL.
 * 
 * @author Emanuel Rabina
 */
@WebServlet(
	name = "StandaloneThymeleafServlet",
	initParams = {
		@WebInitParam(
			name = StandaloneThymeleafServlet.INIT_PARAM_PREFIX,
			value = ""),
		@WebInitParam(
			name = StandaloneThymeleafServlet.INIT_PARAM_SUFFIX,
			value = ""),
		@WebInitParam(
			name = StandaloneThymeleafServlet.INIT_PARAM_TEMPLATEMODE,
			value = "HTML5")
	},
	urlPatterns = {
		"*.html"
	}
)
public class StandaloneThymeleafServlet extends HttpServlet {

	public static final String INIT_PARAM_PREFIX       = "prefix";
	public static final String INIT_PARAM_SUFFIX       = "suffix";
	public static final String INIT_PARAM_TEMPLATEMODE = "templateMode";

	private TemplateEngine templateengine;

	/**
	 * Initialize the Thymeleaf template engine.
	 */
	@Override
	public void init() {

		ServletConfig config = this.getServletConfig();

		ServletContextTemplateResolver templateresolver = new ServletContextTemplateResolver();
		templateresolver.setPrefix(config.getInitParameter(INIT_PARAM_PREFIX));
		templateresolver.setSuffix(config.getInitParameter(INIT_PARAM_SUFFIX));
		templateresolver.setTemplateMode(config.getInitParameter(INIT_PARAM_TEMPLATEMODE));
		templateresolver.setCacheable(false);

		templateengine = new TemplateEngine();
		templateengine.setTemplateResolver(templateresolver);
	}

	/**
	 * Find and process a thymeleaf template with the name that matches the URL.
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException {

		String templatepath = request.getRequestURI().substring(
				this.getServletContext().getServletContextName().length() + 2);

		templateengine.process(templatepath,
				new WebContext(request, response, getServletContext()),
				response.getWriter());
	}
}
